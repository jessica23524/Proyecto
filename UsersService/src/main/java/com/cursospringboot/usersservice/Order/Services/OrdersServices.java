package com.cursospringboot.usersservice.Order.Services;

import com.cursospringboot.usersservice.Order.Entity.OrdersEntity;
import com.cursospringboot.usersservice.Order.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
        return ordersRepository.findByIdPedido(categoriaId);
    }

}
