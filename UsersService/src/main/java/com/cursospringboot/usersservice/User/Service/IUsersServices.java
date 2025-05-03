package com.cursospringboot.usersservice.User.Service;

import com.cursospringboot.usersservice.User.Entity.UsersEntity;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUsersServices {
    List<UsersEntity> getAllUsers();

    UsersEntity getUserByMail(String email);

    Optional<UsersEntity> getUserById(long id);

    /*  CREAR USUARIO */
    UsersEntity createUser(UsersEntity user);
    /* ACTUALIZAR USUARIO */
    UsersEntity updateUser(Long userId , Map<String, Object> userUpdate);

    /* ELIMINAR USUARIO */

    boolean deleteUser(Long userId);

}



