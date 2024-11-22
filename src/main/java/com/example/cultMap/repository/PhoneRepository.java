package com.example.cultMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.PhoneModel;


public interface PhoneRepository extends JpaRepository<PhoneModel, Integer> {

}
