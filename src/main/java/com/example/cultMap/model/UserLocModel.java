package com.example.cultMap.model;

import java.security.Timestamp;

import org.springframework.data.geo.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LocalizacaoUsuario")
public class UserLocModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	private Integer IDUser;
	private Point Coordenadas;
	private Timestamp DTRegistro;
	
	public Integer getID() {
		return ID;
	}
	public Integer getIDUser() {
		return IDUser;
	}
	public void setIDUser(Integer iDUser) {
		IDUser = iDUser;
	}
	public Point getCoordenadas() {
		return Coordenadas;
	}
	public void setCoordenadas(Point coordenadas) {
		Coordenadas = coordenadas;
	}
	public Timestamp getDTRegistro() {
		return DTRegistro;
	}
	public void setDTRegistro(Timestamp dTRegistro) {
		DTRegistro = dTRegistro;
	}
	
	public UserLocModel() {
		// TODO Auto-generated constructor stub
	}
	
}
