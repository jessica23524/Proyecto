package com.cursospringboot.viandaApp.Order.DTO;

import com.cursospringboot.viandaApp.Order.Entity.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStatusDTO {
    private Status status;
}