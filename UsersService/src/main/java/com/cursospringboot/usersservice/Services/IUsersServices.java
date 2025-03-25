package com.cursospringboot.usersservice.Services;

import com.cursospringboot.usersservice.Entities.UsersEntity;


import java.util.List;
import java.util.Optional;

public interface IUsersServices {
    List<UsersEntity> obtenerTodosLosUsuarios();
    Optional<UsersEntity> getUserById(long id);
}


