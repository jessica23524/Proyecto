package com.cursospringboot.usersservice.Category.Service;

import com.cursospringboot.usersservice.Category.Entity.CategoriesEntity;
import com.cursospringboot.usersservice.Category.Repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService implements ICategoriesServices {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<CategoriesEntity> getAllCategories() {
        return categoriesRepository.findAll();

    }

    public CategoriesEntity create(CategoriesEntity categorie) {
        return categoriesRepository.save(categorie);
    }

}
