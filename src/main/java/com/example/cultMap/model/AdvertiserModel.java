package com.example.cultMap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Anunciante")
public class AdvertiserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	private Integer IDPhone;
	private String Nome;
	private String CNPJ;
	private String Email;
	private String Senha;
	
	public Integer getID() {
		return ID;
	}
	public Integer getIDPhone() {
		return IDPhone;
	}
	public void setIDPhone(Integer iDPhone) {
		IDPhone = iDPhone;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public AdvertiserModel() {
		// TODO Auto-generated constructor stub
	}
}
