package com.example.cultMap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.AdModel;
import com.example.cultMap.model.SignModel;

public interface AdRepository extends JpaRepository<AdModel, Integer>{

	List<AdModel> searchByDescriptionStartingWithIgnoreCaseAndAdvertiser(String query, SignModel user);

	List<AdModel> findByAdvertiserId(Integer id);

	List<AdModel> findByCategory(Integer categoryId, Integer userId);

}
