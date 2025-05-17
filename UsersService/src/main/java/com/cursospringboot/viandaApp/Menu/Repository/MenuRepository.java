package com.cursospringboot.viandaApp.Menu.Repository;

import com.cursospringboot.viandaApp.Menu.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByIdCategoria(Long categoria);
}
