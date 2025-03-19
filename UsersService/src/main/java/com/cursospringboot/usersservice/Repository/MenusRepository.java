package com.cursospringboot.usersservice.Repository;

import com.cursospringboot.usersservice.Entities.MenusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenusRepository extends JpaRepository<MenusEntity, Long> {

    List<MenusEntity> findByIdCategoria(Long categoria);
}
