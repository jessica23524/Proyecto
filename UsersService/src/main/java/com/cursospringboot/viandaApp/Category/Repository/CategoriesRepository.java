package com.cursospringboot.viandaApp.Category.Repository;

import com.cursospringboot.viandaApp.Category.Entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CategoriesRepository extends JpaRepository <CategoriesEntity, Long> {


}
