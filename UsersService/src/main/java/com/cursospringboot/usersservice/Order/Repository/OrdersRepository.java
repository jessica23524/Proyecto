package com.cursospringboot.usersservice.Order.Repository;

import com.cursospringboot.usersservice.Order.Entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

    List<OrdersEntity> findByIdPedido(long categoriaId);
}
