package com.example.cultMap.model;


import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Anuncio")
public class AdModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private AdvertiserModel idAdvertiser;
	
	@ManyToOne
	private CategoryModel idCategory;
	
	@OneToOne
	private AddressModel idAddress;
	
	private String titulo;
	private String descricao;
	private Timestamp dtCriacao;
	private Timestamp dtLimite;
	public AdvertiserModel getIdAdvertiser() {
		return idAdvertiser;
	}
	public void setIdAdvertiser(AdvertiserModel idAdvertiser) {
		this.idAdvertiser = idAdvertiser;
	}
	public CategoryModel getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(CategoryModel idCategory) {
		this.idCategory = idCategory;
	}
	public AddressModel getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(AddressModel idAddress) {
		this.idAddress = idAddress;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Timestamp getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(Timestamp dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	public Timestamp getDtLimite() {
		return dtLimite;
	}
	public void setDtLimite(Timestamp dtLimite) {
		this.dtLimite = dtLimite;
	}
	public Integer getId() {
		return id;
	}
	
	public AdModel() {
		// TODO Auto-generated constructor stub
	}
}
