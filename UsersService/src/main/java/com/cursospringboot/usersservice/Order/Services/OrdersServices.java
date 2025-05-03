package com.cursospringboot.usersservice.Order.Services;

import com.cursospringboot.usersservice.DetailsOrder.Entity.DetailsOrder;
import com.cursospringboot.usersservice.DetailsOrder.Repository.DetailsOrderRepository;
import com.cursospringboot.usersservice.Menu.Repository.MenuRepository;
import com.cursospringboot.usersservice.Order.DTO.OrderRequestDTO;
import com.cursospringboot.usersservice.Order.Entity.OrdersEntity;
import com.cursospringboot.usersservice.Order.Entity.Status;
import com.cursospringboot.usersservice.Order.Repository.OrdersRepository;
import com.cursospringboot.usersservice.User.Entity.UsersEntity;
import com.cursospringboot.usersservice.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrdersServices implements IOrdersServices {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<OrdersEntity> findAllOrders(){
        return ordersRepository.findAll();
    }

    @Override
    public List<OrdersEntity> getOrderByIdPedido(long categoriaId) {
        return ordersRepository.findByOrderId(categoriaId);
    }

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private DetailsOrderRepository detailsOrderRepository;

    @Autowired
    private MenuRepository menuRepository; // si los detalles se asocian a un menú/producto

    public OrdersEntity createOrderFromDTO(OrderRequestDTO dto) {
        UsersEntity customer = usersRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        OrdersEntity order = new OrdersEntity();
        order.setAddress(dto.getAddress());
        order.setCustomer(customer);
        order.setPaymentMethod(dto.getPaymentMethod());
        order.setState(dto.getState());
        order.setTotal(dto.getTotal());

        OrdersEntity savedOrder = ordersRepository.save(order);

        // Guardamos los detalles
        for (OrderRequestDTO.OrderDetailDTO detailDTO : dto.getDetallesPedido()) {
            DetailsOrder detail = new DetailsOrder();
            detail.setOrder(savedOrder);
            detail.setQuantity(detailDTO.getQuantity());
            detail.setPriceUnit(detailDTO.getPrice());

            detail.setMenu(menuRepository.findById(detailDTO.getMenuId())
                    .orElseThrow(() -> new RuntimeException("Menú no encontrado")));

            detailsOrderRepository.save(detail);
        }

        return savedOrder;
    }

    public OrdersEntity updateOrderStatus(Long orderId, Status newStatus) {
        Optional<OrdersEntity> optionalOrder = ordersRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            OrdersEntity order = optionalOrder.get();
            order.setState(newStatus);
            return ordersRepository.save(order);
        } else {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
    }


    public boolean deleteOrderById(Long orderId) {
        return ordersRepository.findById(orderId).map(order -> {
            ordersRepository.delete(order);
            return true;
        }).orElse(false);
    }

}
