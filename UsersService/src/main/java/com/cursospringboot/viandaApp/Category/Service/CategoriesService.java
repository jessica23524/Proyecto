package com.cursospringboot.viandaApp.Category.Service;

import com.cursospringboot.viandaApp.Category.Entity.CategoriesEntity;
import com.cursospringboot.viandaApp.Category.Repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

    public CategoriesEntity actualizarCategoria(Long id, Map<String, Object> camposActualizados) {
        CategoriesEntity categoria = categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Class<?> clazz = categoria.getClass();
        camposActualizados.forEach((key, value) -> {
            try {
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);

                // Actualización del nombre
                if (field.getName().equals("nombre") && value instanceof String) {
                    field.set(categoria, value);
                }
                // Si tienes más campos, puedes seguir agregando validaciones aquí...

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Error actualizando el campo: " + key, e);
            }
        });

        return categoriesRepository.save(categoria);
    }
}
