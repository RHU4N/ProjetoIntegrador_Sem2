package com.example.cultMap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Telefone")
public class PhoneModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String ddd;
	private String numero;
	
	
	
	public String getDdd() {
		return ddd;
	}



	public void setDdd(String ddd) {
		this.ddd = ddd;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public Integer getId() {
		return id;
	}



	public PhoneModel() {
		// TODO Auto-generated constructor stub
	}
}
