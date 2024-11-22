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
	private Integer ID;
	
	private String DDD;
	private String Numero;
	
	public Integer getID() {
		return ID;
	}
	public String getDDD() {
		return DDD;
	}
	public void setDDD(String dDD) {
		DDD = dDD;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String number) {
		Numero = number;
	}
	
	public PhoneModel() {
		// TODO Auto-generated constructor stub
	}
}
