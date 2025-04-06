package com.cursospringboot.usersservice.Menu.Service;

import com.cursospringboot.usersservice.Menu.Entity.Menu;
import com.cursospringboot.usersservice.Menu.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusServices implements IMenuServices {

    @Autowired
    private MenuRepository menusRepository;

    @Override
    public List<Menu> getAllMenus(){
        return menusRepository.findAll();
    }

    @Override
    public List<Menu> getMenusByCategory(Long categoryId) {
        return menusRepository.findByIdCategoria(categoryId);
    }

    @Override
    public Menu createMenus(Menu menu) {
        return menusRepository.save(menu);
    }
}
