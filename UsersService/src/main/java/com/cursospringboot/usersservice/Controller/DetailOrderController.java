package com.cursospringboot.usersservice.Controller;

import com.cursospringboot.usersservice.Entities.DetailsOrder;
import com.cursospringboot.usersservice.Services.DetailsOrderServices;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/details_order")
public class DetailOrderController {
    @Autowired
    DetailsOrderServices detailsOrderServices;

    @GetMapping("/id/{orderId}")
    @JsonIgnore
    public List<DetailsOrder> getOrderById(@PathVariable Long orderId){
        return detailsOrderServices.getDetailsByOrderId(orderId);
    }
}
