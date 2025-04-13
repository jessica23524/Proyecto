package com.cursospringboot.usersservice.User.Repository;


import com.cursospringboot.usersservice.User.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findByEmail(String email);

}