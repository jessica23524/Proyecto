package com.cursospringboot.viandaApp.Order.DTO;

import com.cursospringboot.viandaApp.Order.Entity.PaymentMethod;
import com.cursospringboot.viandaApp.Order.Entity.Status;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private Status state;
    private PaymentMethod paymentMethod;
    private Double total;
    private String address;
    private Long customerId;

    private List<OrderDetailDTO> detallesPedido;

    @Data
    public static class OrderDetailDTO {
        private Long menuId;
        private Integer quantity;
        private Double price;
    }
}