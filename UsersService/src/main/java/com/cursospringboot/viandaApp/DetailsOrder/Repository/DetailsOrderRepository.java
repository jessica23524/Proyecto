package com.cursospringboot.viandaApp.DetailsOrder.Repository;

import com.cursospringboot.viandaApp.DetailsOrder.Entity.DetailsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsOrderRepository extends JpaRepository<DetailsOrder, Long> {

    List<DetailsOrder> getDetailsOrdersByDetailsOrderId(Long orderId);
}
