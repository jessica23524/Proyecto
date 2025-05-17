package com.cursospringboot.viandaApp.DetailsOrder.Service;

import com.cursospringboot.viandaApp.DetailsOrder.Entity.DetailsOrder;
import com.cursospringboot.viandaApp.DetailsOrder.Repository.DetailsOrderRepository;
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
