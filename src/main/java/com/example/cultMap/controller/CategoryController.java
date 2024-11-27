package com.example.cultMap.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cultMap.model.CategoryModel;
import com.example.cultMap.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryModel> create(@RequestBody String category){
		String cat = category;
		return ResponseEntity.ok(categoryService.save(cat));
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryModel>> findAll(){
		return ResponseEntity.ok(categoryService.findAll());
	}
}
