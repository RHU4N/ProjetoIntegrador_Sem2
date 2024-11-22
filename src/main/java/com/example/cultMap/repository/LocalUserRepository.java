package com.example.cultMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.UserLocModel;

public interface LocalUserRepository extends JpaRepository<UserLocModel, Integer> {

}
