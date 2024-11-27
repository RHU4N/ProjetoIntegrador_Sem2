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
	private Integer id;
	
	@OneToOne
	private PhoneModel idPhone;
	
	@OneToOne
	private SignModel idSignAdv;
	
	private String cnpj;
	

	
	public PhoneModel getIdPhone() {
		return idPhone;
	}




	public void setIdPhone(PhoneModel idPhone) {
		this.idPhone = idPhone;
	}




	public SignModel getIdSignAdv() {
		return idSignAdv;
	}




	public void setIdSignAdv(SignModel idSignAdv) {
		this.idSignAdv = idSignAdv;
	}




	public String getCnpj() {
		return cnpj;
	}




	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}




	public Integer getId() {
		return id;
	}




	public AdvertiserModel() {
		// TODO Auto-generated constructor stub
	}
}
