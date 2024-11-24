package com.example.cultMap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Token")
public class TokenModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JsonIgnore
	private SignModel user;
	private String token;
	private Long expirationTime;
	
	//Constructors
	public TokenModel() {
		// TODO Auto-generated constructor stub
	}
	
	public TokenModel(Integer id, SignModel user, String token, Long expirationTime) {
		super();
		this.id = id;
		this.user = user;
		this.token = token;
		this.expirationTime = expirationTime;
	}
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SignModel getUser() {
		return user;
	}
	public void setUser(SignModel signModel) {
		this.user = signModel;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Long expirationTime) {
		this.expirationTime = expirationTime;
	}	
}
