package com.cursospringboot.usersservice.Repository;

import com.cursospringboot.usersservice.Entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

    List<OrdersEntity> findByIdPedido(long categoriaId);
}
