package com.cursospringboot.usersservice.Repository;

import com.cursospringboot.usersservice.Entities.DetailsOrder;
import com.cursospringboot.usersservice.Entities.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsOrderRepository extends JpaRepository<DetailsOrder, Long> {

    List<DetailsOrder> getDetailsOrdersByDetailsOrderId(Long orderId);
}
