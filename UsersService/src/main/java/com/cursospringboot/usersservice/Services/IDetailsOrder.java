package com.cursospringboot.usersservice.Services;

import com.cursospringboot.usersservice.Entities.DetailsOrder;

import java.util.List;

public interface IDetailsOrder {
    List<DetailsOrder> getAllDetailsOrder();
    List<DetailsOrder> getDetailsByOrderId(Long categoryId);
}
