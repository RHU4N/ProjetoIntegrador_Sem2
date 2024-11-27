package com.example.cultMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.AdvertiserModel;
import com.example.cultMap.model.SignModel;

public interface AdvertiserRepository extends JpaRepository<AdvertiserModel, Integer>{

	AdvertiserModel findByIdSignAdv(SignModel user);

}
