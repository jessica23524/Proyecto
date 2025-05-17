package com.cursospringboot.viandaApp.Order.Repository;

import com.cursospringboot.viandaApp.Order.Entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

    List<OrdersEntity> findByOrderId(long categoriaId);
}
