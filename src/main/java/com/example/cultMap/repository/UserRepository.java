package com.example.cultMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
