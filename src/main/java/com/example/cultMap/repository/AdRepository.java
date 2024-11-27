package com.example.cultMap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.AdModel;
import com.example.cultMap.model.AdvertiserModel;
import com.example.cultMap.model.CategoryModel;

public interface AdRepository extends JpaRepository<AdModel, Integer>{

	List<AdModel> searchByDescricaoStartingWithIgnoreCase(String query);

	List<AdModel> findByIdAdvertiser(AdvertiserModel id);

	List<AdModel> findByIdCategory(CategoryModel category );

}
