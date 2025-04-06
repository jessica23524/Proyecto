package com.cursospringboot.usersservice.Order.Controller;

import com.cursospringboot.usersservice.Order.Entity.OrdersEntity;
import com.cursospringboot.usersservice.Order.Services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}



