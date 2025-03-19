package com.cursospringboot.usersservice.Services;

import com.cursospringboot.usersservice.Entities.CategoriesEntity;
import com.cursospringboot.usersservice.Repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService implements ICategoriesServices {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<CategoriesEntity> getAllCategories(){
        return categoriesRepository.findAll();
    }

}
