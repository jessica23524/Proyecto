package com.cursospringboot.viandaApp.Category.Service;

import com.cursospringboot.viandaApp.Category.Entity.CategoriesEntity;

import java.util.List;
import java.util.Map;

public interface ICategoriesServices {
    List<CategoriesEntity> getAllCategories();
    CategoriesEntity create (CategoriesEntity categorie);
    CategoriesEntity actualizarCategoria(Long id, Map<String, Object> camposActualizados);
}
