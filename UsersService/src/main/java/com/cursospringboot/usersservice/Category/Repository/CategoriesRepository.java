package com.cursospringboot.usersservice.Category.Repository;

import com.cursospringboot.usersservice.Category.Entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CategoriesRepository extends JpaRepository <CategoriesEntity, Long> {


}
