package com.cursospringboot.viandaApp.User.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
}