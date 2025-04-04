package com.cursospringboot.usersservice.Services;

import com.cursospringboot.usersservice.Entities.OrdersEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersServices {
    List<OrdersEntity> findAllOrders();
    List<OrdersEntity> getOrderByIdPedido(long categoriaId);
}


