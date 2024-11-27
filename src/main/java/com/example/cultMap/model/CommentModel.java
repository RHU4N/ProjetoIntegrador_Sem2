package com.example.cultMap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comentario")
public class CommentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private UserModel idUser;
	
	@OneToOne
	private AdModel idAd;
	
	private String comentario;
	
	
	
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



	public String getComentario() {
		return comentario;
	}



	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	public Integer getId() {
		return id;
	}



	public CommentModel() {
		// TODO Auto-generated constructor stub
	}
}
