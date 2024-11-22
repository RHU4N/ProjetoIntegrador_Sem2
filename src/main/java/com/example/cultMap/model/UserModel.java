package com.example.cultMap.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	private Integer IDPhone;
	private String Nome;
	private String Email;
	private String CPF;
	private String Senha;
	private Date DTNascimento;
	
	public Integer getID() {
		return ID;
	}
	public Integer getIDPhone() {
		return IDPhone;
	}
	public void setIDPhone(Integer iDPhone) {
		IDPhone = iDPhone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cpf) {
		CPF = cpf;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public Date getDTNascimento() {
		return DTNascimento;
	}
	public void setDTNascimento(Date dTNascimento) {
		DTNascimento = dTNascimento;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public UserModel() {}
}
