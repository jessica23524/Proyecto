package com.cursospringboot.usersservice.Menu.Repository;

import com.cursospringboot.usersservice.Menu.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByIdCategoria(Long categoria);
}
