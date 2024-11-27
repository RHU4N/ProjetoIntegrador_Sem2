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
	private Integer id;
	
	@OneToOne
	private PhoneModel idPhone;
	
	@OneToOne
	private SignModel idSignUser;
	
	private String cpf;
	private Date dtNascimento;
	
	

	
	public PhoneModel getIdPhone() {
		return idPhone;
	}




	public void setIdPhone(PhoneModel idPhone) {
		this.idPhone = idPhone;
	}




	public SignModel getIdSignUser() {
		return idSignUser;
	}




	public void setIdSignUser(SignModel idSignUser) {
		this.idSignUser = idSignUser;
	}




	public String getCpf() {
		return cpf;
	}




	public void setCpf(String cpf) {
		this.cpf = cpf;
	}




	public Date getDtNascimento() {
		return dtNascimento;
	}




	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}




	public Integer getId() {
		return id;
	}




	public UserModel() {}
}
