package com.example.cultMap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cultMap.model.AddressModel;
import com.example.cultMap.service.AddressService;

class Endereco{
	
	private String bairro; 
	private String logradouro; 
	private Integer numero;
	private String cidade;
	private String estado; 
	private String pais;
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
}

@RestController
@RequestMapping("/address")
public class AddressController {
	
	
	
	@Autowired
	private AddressService aS;
	
	@PostMapping
	public ResponseEntity<AddressModel> create(@RequestBody Endereco end){
		
		String bairro = end.getBairro(); 
		String logradouro = end.getLogradouro();
		Integer numero = end.getNumero();
		String cidade = end.getCidade();
		String estado = end.getEstado();
		String pais = end.getPais();
		return ResponseEntity.ok(aS.save(bairro, logradouro, numero, cidade, estado, pais));
	}
	
	@GetMapping
	public ResponseEntity<List<AddressModel>> findAll(){
		return ResponseEntity.ok(aS.findAll());
	}
}
