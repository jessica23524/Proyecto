package com.cursospringboot.viandaApp.User.Repository;


import com.cursospringboot.viandaApp.User.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findByEmail(String email);

    Optional<UsersEntity> findByIdUsuario(Long idUsuario);
}