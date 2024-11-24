package com.example.cultMap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.TokenModel;

public interface TokenRepository extends JpaRepository<TokenModel, Integer>{

	Optional<TokenModel> findByToken(String token);

}
