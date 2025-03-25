package com.cursospringboot.usersservice.Controller;

import com.cursospringboot.usersservice.Entities.UsersEntity;

import com.cursospringboot.usersservice.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UsersService usersService;
    // Trae todos los usuarios
    @GetMapping
    public List<UsersEntity> getUsers() {
        return usersService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/id/{idUser}")
    public Optional<UsersEntity> getUserById(@PathVariable Long idUser) {
        return usersService.getUserById(idUser);
    }

}
//comentario