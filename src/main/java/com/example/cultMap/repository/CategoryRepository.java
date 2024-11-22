package com.example.cultMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Integer>{

}
