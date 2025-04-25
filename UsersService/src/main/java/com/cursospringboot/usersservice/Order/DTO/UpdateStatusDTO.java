package com.cursospringboot.usersservice.Order.DTO;

import com.cursospringboot.usersservice.Order.Entity.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStatusDTO {
    private Status status;
}