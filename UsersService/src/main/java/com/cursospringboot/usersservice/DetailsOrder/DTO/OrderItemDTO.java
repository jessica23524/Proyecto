package com.cursospringboot.usersservice.DetailsOrder.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDTO {
    private Long menuId;
    private Integer quantity;
    private Double priceUnit;
}
