package com.example.cultMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.AddressModel;

public interface AddressRepository extends JpaRepository<AddressModel, Integer>{

}
