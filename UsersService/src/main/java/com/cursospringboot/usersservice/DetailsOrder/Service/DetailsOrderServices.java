package com.cursospringboot.usersservice.DetailsOrder.Service;

import com.cursospringboot.usersservice.DetailsOrder.Entity.DetailsOrder;
import com.cursospringboot.usersservice.DetailsOrder.Repository.DetailsOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsOrderServices implements IDetailsOrder {
    @Autowired
    DetailsOrderRepository detailsOrderRepository;

    @Override
    public List<DetailsOrder> getAllDetailsOrder() {
        return detailsOrderRepository.findAll();
    }

    @Override
    public List<DetailsOrder>  getDetailsByOrderId( Long orderId){
        return detailsOrderRepository.getDetailsOrdersByDetailsOrderId(orderId);
    }

}
