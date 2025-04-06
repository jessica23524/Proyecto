package com.cursospringboot.usersservice.DetailsOrder.Service;

import com.cursospringboot.usersservice.DetailsOrder.Entity.DetailsOrder;

import java.util.List;

public interface IDetailsOrder {
    List<DetailsOrder> getAllDetailsOrder();
    List<DetailsOrder> getDetailsByOrderId(Long categoryId);
}
