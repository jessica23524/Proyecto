package com.cursospringboot.usersservice.Services;

import com.cursospringboot.usersservice.Entities.UsersEntity;
import com.cursospringboot.usersservice.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UsersEntity> obtenerTodosLosUsuarios() {
        return userRepository.findAll();
    }
}





