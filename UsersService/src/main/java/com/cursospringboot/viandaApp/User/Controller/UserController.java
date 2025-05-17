package com.cursospringboot.viandaApp.User.Controller;

import com.cursospringboot.viandaApp.User.DTO.LoginDTO;
import com.cursospringboot.viandaApp.User.DTO.UserRequestDTO;
import com.cursospringboot.viandaApp.User.DTO.UserResponseDTO;
import com.cursospringboot.viandaApp.User.Entity.UsersEntity;


import com.cursospringboot.viandaApp.User.Service.UsersService;
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
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequest) {
        UserResponseDTO loginResponse = usersService.login(userRequest.getEmail(), userRequest.getPassword());
        return ResponseEntity.ok(loginResponse);
    }

    // ACTUALIZAR USUARIO
    @PatchMapping("/update/{id}")
    public ResponseEntity<UsersEntity> actualizarParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> camposActualizados) {

        UsersEntity usuarioActualizado = usersService.updateUser(id, camposActualizados);
        return ResponseEntity.ok(usuarioActualizado);
    }
    // ELIMINAR USUARIO

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = usersService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
