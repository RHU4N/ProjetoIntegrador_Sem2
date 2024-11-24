package com.example.cultMap.model;


import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Anuncio")
public class AdModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	@OneToOne
	private AdvertiserModel IDAdvertiser;
	
	@OneToMany
	private Integer IDCategory;
	
	@OneToOne
	private Integer IDAddress;
	
	private String Titulo;
	private String Descricao;
	private Timestamp DTCriacao;
	private Timestamp DTLimite;
	
	public Integer getID() {
		return ID;
	}

	public AdvertiserModel getIDAdviser() {
		return IDAdvertiser;
	}

	public void setIDAdviser(AdvertiserModel iDAdviser) {
		IDAdvertiser = iDAdviser;
	}
	
	public Integer getIDCategory() {
		return IDCategory;
	}

	public void setIDCategory(Integer iDCategory) {
		IDCategory = iDCategory;
	}



	public Integer getIDAddress() {
		return IDAddress;
	}



	public void setIDAddress(Integer iDAddress) {
		IDAddress = iDAddress;
	}



	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Timestamp getDTCriacao() {
		return DTCriacao;
	}
	public void setDTCriacao(Timestamp dTCriacao) {
		DTCriacao = dTCriacao;
	}
	public Timestamp getDTLimite() {
		return DTLimite;
	}
	public void setDTLimite(Timestamp dTLimite) {
		DTLimite = dTLimite;
	}
	
	public AdModel() {
		// TODO Auto-generated constructor stub
	}
}
