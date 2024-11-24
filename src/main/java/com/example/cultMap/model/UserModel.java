package com.example.cultMap.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	@OneToOne
	private PhoneModel IDPhone;
	
	@OneToOne
	private SignModel IDSignUser;
	
	private String CPF;
	private Date DTNascimento;
	
	public Integer getID() {
		return ID;
	}
	
	public PhoneModel getIDPhone() {
		return IDPhone;
	}

	public void setIDPhone(PhoneModel iDPhone) {
		IDPhone = iDPhone;
	}


	public SignModel getIDSignUser() {
		return IDSignUser;
	}

	public void setIDSignUser(SignModel iDSignUser) {
		IDSignUser = iDSignUser;
	}

	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cpf) {
		CPF = cpf;
	}

	public Date getDTNascimento() {
		return DTNascimento;
	}
	public void setDTNascimento(Date dTNascimento) {
		DTNascimento = dTNascimento;
	}

	
	public UserModel() {}
}
