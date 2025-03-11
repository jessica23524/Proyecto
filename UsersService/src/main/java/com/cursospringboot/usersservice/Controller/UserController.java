package com.cursospringboot.usersservice.Controller;

import com.cursospringboot.usersservice.Entities.UsersEntity;

import com.cursospringboot.usersservice.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<UsersEntity> getUsers() {
        return usersService.obtenerTodosLosUsuarios();
    }

}
