package com.example.cultMap.controller;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cultMap.model.TokenModel;
import com.example.cultMap.service.SignService;

class Pessoa {
	private String nome;
	private String email;
	private String senha;
	private String tipo;
	private String cpf;
	private Date dtNascimento;
	private String ddd;
	private String numero;
	private String cnpj;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}


@RestController
@RequestMapping("/auth")
public class SignController {
	
	
	
	@Autowired
	private SignService sS;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> signUp(@RequestBody Pessoa user){
		
		String nome = user.getNome();
		String email = user.getEmail();
		String senha = user.getSenha();
		String tipo = user.getTipo();
		String cpf = user.getCpf();
		Date dtNascimento = user.getDtNascimento();
		String ddd = user.getDdd();
		String numero = user.getNumero();
		String cnpj = user.getCnpj();	
		
		try {
			sS.signUp(nome, email, senha, tipo, cpf, dtNascimento, ddd, numero, cnpj);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();			
		}
		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenModel> login(@RequestBody Map<String, String> user){
		TokenModel token = sS.login(user.get("email"), user.get("senha"));
		if(token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	@PostMapping("/sair")
	public ResponseEntity<TokenModel> signout(@RequestHeader String token){
		sS.signout(token);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	@PostMapping("/check")
	public ResponseEntity<?> check(@RequestHeader String token){
		Boolean isValid = sS.validate(token);

		return (isValid) ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

	}
		

}

