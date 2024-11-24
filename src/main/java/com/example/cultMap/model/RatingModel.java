package com.example.cultMap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Avaliacao")
public class RatingModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	@OneToOne
	private UserModel IDUser;
	
	@OneToOne
	private AdModel IDAd;
	
	private String Avaliacao;
	private Integer Estrelas;
	
	public Integer getID() {
		return ID;
	}
	
	public UserModel getIDUser() {
		return IDUser;
	}

	public void setIDUser(UserModel iDUser) {
		IDUser = iDUser;
	}

	public AdModel getIDAd() {
		return IDAd;
	}

	public void setIDAd(AdModel iDAd) {
		IDAd = iDAd;
	}

	public String getAvaliacao() {
		return Avaliacao;
	}
	public void setAvaliacao(String avaliacao) {
		Avaliacao = avaliacao;
	}
	public Integer getEstrelas() {
		return Estrelas;
	}
	public void setEstrelas(Integer estrelas) {
		Estrelas = estrelas;
	}
	
	public RatingModel() {
		// TODO Auto-generated constructor stub
	}
}
