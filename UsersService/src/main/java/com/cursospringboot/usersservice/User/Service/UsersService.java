package com.cursospringboot.usersservice.User.Service;

import com.cursospringboot.usersservice.User.Entity.UsersEntity;
import com.cursospringboot.usersservice.User.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements IUsersServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UsersEntity getUserByMail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<UsersEntity> getUserById(long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public UsersEntity createUser(UsersEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UsersEntity updateUser(UsersEntity user) {
        return null;
    }


}





