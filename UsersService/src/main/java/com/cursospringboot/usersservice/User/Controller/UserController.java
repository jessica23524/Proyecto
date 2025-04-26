package com.cursospringboot.usersservice.User.Controller;

import com.cursospringboot.usersservice.User.Entity.UsersEntity;


import com.cursospringboot.usersservice.User.Repository.UserRepository;
import com.cursospringboot.usersservice.User.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UsersService usersService;
    // Trae todos los usuarios
    @GetMapping
    public List<UsersEntity> getUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/id/{idUser}")
    public Optional<UsersEntity> getUserById(@PathVariable Long idUser) {
        return usersService.getUserById(idUser);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UsersEntity user) {
        if (usersService.getUserByMail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ingresado ya éxiste");
        }

        UsersEntity userCreate = usersService.createUser(user);
        return ResponseEntity.status(201).body(userCreate);

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        System.out.println(email);
        UsersEntity user = usersService.getUserByMail(email);

        if (user == null || !user.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
        return ResponseEntity.ok(user);
    }

    // ACTUALIZAR USUARIO
    @PatchMapping("/update/{id}")
    public ResponseEntity<UsersEntity> actualizarParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> camposActualizados) {

        UsersEntity usuarioActualizado = usersService.updateUser(id, camposActualizados);
        return ResponseEntity.ok(usuarioActualizado);
    }

}
//comentario