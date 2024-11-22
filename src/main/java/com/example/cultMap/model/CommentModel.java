package com.example.cultMap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comentario")
public class CommentModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	private Integer IDUser;
	private Integer IDAd;
	private String Comentario;
	
	public Integer getID() {
		return ID;
	}
	public Integer getIDUser() {
		return IDUser;
	}
	public void setIDUser(Integer iDUser) {
		IDUser = iDUser;
	}
	public Integer getIDAd() {
		return IDAd;
	}
	public void setIDAd(Integer iDAd) {
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
