package com.cursospringboot.usersservice.Services;

import com.cursospringboot.usersservice.Entities.UsersEntity;


import java.util.List;

public interface IUsersServices {
    List<UsersEntity> obtenerTodosLosUsuarios();
}


