package com.example.cultMap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cultMap.model.CategoryModel;
import com.example.cultMap.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryModel save(String category) {
		CategoryModel cat = new CategoryModel();
		cat.setCategoria(category);
		
		CategoryModel saved = categoryRepository.save(cat);
		return saved;
	}
	
	public List<CategoryModel> findAll() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		categoryRepository.findAll().iterator().forEachRemaining(list::add);
		return list;		
	}
}
