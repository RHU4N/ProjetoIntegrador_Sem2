package com.example.cultMap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.SignModel;

public interface SignRepository extends JpaRepository<SignModel, Integer> {

	public Optional<SignModel> findByEmail(String email);

}
