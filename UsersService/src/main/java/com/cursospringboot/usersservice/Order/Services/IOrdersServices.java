package com.cursospringboot.usersservice.Order.Services;

import com.cursospringboot.usersservice.Order.Entity.OrdersEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersServices {
    List<OrdersEntity> findAllOrders();
    List<OrdersEntity> getOrderByIdPedido(long categoriaId);
}


