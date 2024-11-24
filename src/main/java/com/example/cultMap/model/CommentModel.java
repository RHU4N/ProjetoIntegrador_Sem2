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
	private Integer ID;
	
	@OneToOne
	private UserModel IDUser;
	
	@OneToOne
	private AdModel IDAd;
	
	private String Comentario;
	
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



	public String getComentario() {
		return Comentario;
	}
	public void setComentario(String comentario) {
		Comentario = comentario;
	}
	
	public CommentModel() {
		// TODO Auto-generated constructor stub
	}
}
