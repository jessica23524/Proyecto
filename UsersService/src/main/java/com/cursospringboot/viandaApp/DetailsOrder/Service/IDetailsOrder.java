package com.cursospringboot.viandaApp.DetailsOrder.Service;

import com.cursospringboot.viandaApp.DetailsOrder.Entity.DetailsOrder;

import java.util.List;

public interface IDetailsOrder {
    List<DetailsOrder> getAllDetailsOrder();
    List<DetailsOrder> getDetailsByOrderId(Long categoryId);
}
