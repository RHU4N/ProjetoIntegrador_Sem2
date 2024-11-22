package com.example.cultMap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cultMap.model.CommentModel;

public interface CommentRepository extends JpaRepository<CommentModel, Integer>{

}
