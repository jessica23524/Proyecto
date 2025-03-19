package com.cursospringboot.usersservice.Repository;

import com.cursospringboot.usersservice.Entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CategoriesRepository extends JpaRepository <CategoriesEntity, Long> {


}
