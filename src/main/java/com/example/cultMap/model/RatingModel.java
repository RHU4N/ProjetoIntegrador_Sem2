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
	private Integer id;
	
	@OneToOne
	private UserModel idUser;
	
	@OneToOne
	private AdModel idAd;
	
	private String avaliacao;
	private Integer estrelas;
	
	
	
	public UserModel getIdUser() {
		return idUser;
	}



	public void setIdUser(UserModel idUser) {
		this.idUser = idUser;
	}



	public AdModel getIdAd() {
		return idAd;
	}



	public void setIdAd(AdModel idAd) {
		this.idAd = idAd;
	}



	public String getAvaliacao() {
		return avaliacao;
	}



	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}



	public Integer getEstrelas() {
		return estrelas;
	}



	public void setEstrelas(Integer estrelas) {
		this.estrelas = estrelas;
	}



	public Integer getId() {
		return id;
	}



	public RatingModel() {
		// TODO Auto-generated constructor stub
	}
}
