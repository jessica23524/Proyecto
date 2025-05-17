package com.cursospringboot.viandaApp.User.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private  String rol;
    private String token;
}


