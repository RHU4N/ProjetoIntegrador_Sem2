package com.example.cultMap.model;

import java.security.Timestamp;

import org.springframework.data.geo.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LocalizacaoUsuario")
public class UserLocModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private UserModel idUser;
	
	private Point coordenadas;
	private Timestamp dtRegistro;
	
	
	
	public UserModel getIdUser() {
		return idUser;
	}



	public void setIdUser(UserModel idUser) {
		this.idUser = idUser;
	}



	public Point getCoordenadas() {
		return coordenadas;
	}



	public void setCoordenadas(Point coordenadas) {
		this.coordenadas = coordenadas;
	}



	public Timestamp getDtRegistro() {
		return dtRegistro;
	}



	public void setDtRegistro(Timestamp dtRegistro) {
		this.dtRegistro = dtRegistro;
	}



	public Integer getId() {
		return id;
	}



	public UserLocModel() {
		// TODO Auto-generated constructor stub
	}
	
}
