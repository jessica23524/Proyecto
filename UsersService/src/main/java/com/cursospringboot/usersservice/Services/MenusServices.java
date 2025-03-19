package com.cursospringboot.usersservice.Services;

import com.cursospringboot.usersservice.Entities.MenusEntity;
import com.cursospringboot.usersservice.Repository.MenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusServices implements IMenuServices {

    @Autowired
    private MenusRepository menusRepository;

    @Override
    public List<MenusEntity> getAllMenus(){
        return menusRepository.findAll();
    }

    @Override
    public List<MenusEntity> getMenusByCategory(Long categoryId) {
        return menusRepository.findByIdCategoria(categoryId);
    }
}
