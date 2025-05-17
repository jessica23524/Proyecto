package com.cursospringboot.viandaApp.Order.Services;

import com.cursospringboot.viandaApp.Order.Entity.OrdersEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersServices {
    List<OrdersEntity> findAllOrders();
    List<OrdersEntity> getOrderByIdPedido(long categoriaId);
}


