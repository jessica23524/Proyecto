package com.cursospringboot.usersservice.Order.DTO;

import com.cursospringboot.usersservice.DetailsOrder.DTO.OrderItemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private Long userId;
    private String address;
    private Double total;
    private String paymentMethod;
    private List<OrderItemDTO> items;


}

