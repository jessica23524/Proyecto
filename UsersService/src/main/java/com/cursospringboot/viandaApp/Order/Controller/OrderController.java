package com.cursospringboot.viandaApp.Order.Controller;

import com.cursospringboot.viandaApp.Order.DTO.OrderRequestDTO;
import com.cursospringboot.viandaApp.Order.DTO.UpdateStatusDTO;
import com.cursospringboot.viandaApp.Order.Entity.OrdersEntity;
import com.cursospringboot.viandaApp.Order.Services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrdersServices ordersService;

    @GetMapping("/all")
    public List<OrdersEntity> getAllOrders() {
        return ordersService.findAllOrders();
    }
    @GetMapping("id/{orderId}")
    public List<OrdersEntity> getOrderById(@PathVariable Long orderId) {
        return  ordersService.getOrderByIdPedido(orderId);
    }

    @PostMapping("/create")
    public ResponseEntity<OrdersEntity> createOrder(@RequestBody OrderRequestDTO dto) {
        OrdersEntity order = ordersService.createOrderFromDTO(dto);
        return ResponseEntity.ok(order);
    }
//actualizacion del estado
    @PutMapping("/status/{id}")
    public ResponseEntity<OrdersEntity> updateOrderStatus(
            @PathVariable("id") Long orderId,
            @RequestBody UpdateStatusDTO statusDTO) {
        OrdersEntity updatedOrder = ordersService.updateOrderStatus(orderId, statusDTO.getStatus());
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        boolean deleted = ordersService.deleteOrderById(id);
        if (deleted) {
            return ResponseEntity.ok("Orden eliminada exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



