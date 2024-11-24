package com.example.cultMap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cultMap.model.AdModel;
import com.example.cultMap.model.AdvertiserModel;
import com.example.cultMap.model.SignModel;
import com.example.cultMap.repository.AdvertiserRepository;
import com.example.cultMap.service.AdService;
import com.example.cultMap.service.SignService;


@RestController
@RequestMapping("/task")
public class AdController {
	
	@Autowired
	public AdService aS;
	@Autowired
	public SignService sS;
	@Autowired
	public AdvertiserRepository advR;

	@PostMapping
	public ResponseEntity<AdModel> create(@RequestBody AdModel task,
			@RequestHeader(name="token",required = true)String token){
		Boolean isValid = sS.validate(token);
		if(isValid) {
			AdvertiserModel user = advR.findBySignID(sS.toUser(token));
			task.setIDAdviser(user);
			AdModel save = aS.save(task);
			return ResponseEntity.ok(save);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<AdModel>> findAll(@RequestHeader(name="token",required = true)String token) {
		Boolean isValid = sS.validate(token);
		if(isValid) {
			SignModel user = sS.toUser(token);
			List<AdModel> list = aS.findByUserId(user.getID());
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	

	
	@PutMapping("/{id}")
	public ResponseEntity<AdModel> update(@RequestHeader(name = "token",required = true) String token,
			@RequestBody AdModel task){
		Boolean isValid = sS.validate(token);
		if(isValid) {
			AdModel saved = aS.update(task);
			return ResponseEntity.ok(saved);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<AdModel>> search(@RequestParam(name = "q") String query
			,@RequestHeader(name= "token", required = true) String token){
		Boolean isValid = sS.validate(token);
		if(isValid) {
			SignModel user = sS.toUser(token);
			List<AdModel> list = aS.search(query, user);
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<List<AdModel>> findByCategoryId(@PathVariable(name = "id") Integer categoryId,
			@RequestHeader(name = "token", required = true) String token) {
		Boolean isValid = sS.validate(token);
		if (isValid) {
			SignModel user = sS.toUser(token);
			List<AdModel> list = aS.findByCategoryId(categoryId, user.getID());
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	
}