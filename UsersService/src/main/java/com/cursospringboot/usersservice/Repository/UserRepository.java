package com.cursospringboot.usersservice.Repository;


import com.cursospringboot.usersservice.Entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

}
//comentario repositorio