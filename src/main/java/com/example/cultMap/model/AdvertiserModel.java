package com.example.cultMap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Anunciante")
public class AdvertiserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	@OneToOne
	private PhoneModel IDPhone;
	
	@OneToOne
	private SignModel IDSignAdv;
	
	private String CNPJ;
	
	public Integer getID() {
		return ID;
	}
	
	public PhoneModel getIDPhone() {
		return IDPhone;
	}

	public void setIDPhone(PhoneModel iDPhone) {
		IDPhone = iDPhone;
	}

	public SignModel getIDSignAdv() {
		return IDSignAdv;
	}

	public void setIDSignAdv(SignModel iDSignAdv) {
		IDSignAdv = iDSignAdv;
	}

	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	
	public AdvertiserModel() {
		// TODO Auto-generated constructor stub
	}
}
