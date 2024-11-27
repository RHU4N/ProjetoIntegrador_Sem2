package com.example.cultMap.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cultMap.model.AdvertiserModel;
import com.example.cultMap.model.PhoneModel;
import com.example.cultMap.model.SignModel;
import com.example.cultMap.model.TokenModel;
import com.example.cultMap.model.UserModel;
import com.example.cultMap.repository.AdvertiserRepository;
import com.example.cultMap.repository.PhoneRepository;
import com.example.cultMap.repository.SignRepository;
import com.example.cultMap.repository.TokenRepository;
import com.example.cultMap.repository.UserRepository;

@Service
public class SignService {
	
	private Integer TOKEN_TTL = 3000;
	
	@Autowired
	private UserRepository uR;
	@Autowired
	private AdvertiserRepository aR;
	@Autowired
	private SignRepository sR;
	@Autowired
	private PhoneRepository pR;
	@Autowired
	private TokenRepository tR;
	
	private String generateHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[]  digest = md.digest();
			return toHex(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	private String toHex(byte[] digest) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digest.length; i++) {
			sb.append(Integer.toString(digest[i]& 0xff + 0x100, 16).substring(1));
		}
		
		return sb.toString();
	}

	public void signUp(String nome, String email, String senha, String tipo, String cpf, Date dtNascimento, String ddd, String numero, String cnpj) throws Exception {
		SignModel sign = new SignModel();
		PhoneModel phone = new PhoneModel();
		
		sign.setNome(nome);
		sign.setSenha(generateHash(senha));
		sign.setEmail(email);
		
		phone.setDdd(ddd);
		phone.setNumero(numero);
		
		Optional<SignModel> userExisting = sR.findByEmail(email);
		
		if(userExisting.isPresent()) {
			throw new Exception("Email já existe");
		}else {
			sR.save(sign);
			pR.save(phone);
			
			if(tipo.equals("a")) {
				System.out.println(tipo);
				AdvertiserModel aM = new AdvertiserModel();
				aM.setCnpj(cnpj);
				aM.setIdSignAdv(sR.findById(sign.getId()).get());
				aM.setIdPhone(pR.findById(phone.getId()).get());
				
				aR.save(aM);
			}else if(tipo.equals("u")) {
				UserModel uM = new UserModel();
				uM.setCpf(cpf);
				uM.setDtNascimento(dtNascimento);
				uM.setIdSignUser(sR.findById(sign.getId()).get());
				uM.setIdPhone(pR.findById(phone.getId()).get());
				
				uR.save(uM);
			}
			
		}
	}
	
	public TokenModel login(String email, String senha) {
		SignModel sign = new SignModel();
		
		sign.setEmail(email);
		sign.setSenha(generateHash(senha));
		
		Optional<SignModel> user = sR.findByEmail(email);
		
		if(user.isPresent() && user.get().getSenha().equals(sign.getSenha())) {
			TokenModel token = new TokenModel();
			token.setUser(user.get());
			token.setToken(UUID.randomUUID().toString());
			token.setExpirationTime(Instant.now().plusSeconds(TOKEN_TTL).toEpochMilli());
			tR.save(token);
			return token;
		}
		
		return null;
	}
	
	public void signout(String token) {
		Optional<TokenModel> found = tR.findByToken(token);
		found.ifPresent(t ->{
			t.setExpirationTime(Instant.now().toEpochMilli());
			tR.save(t);
		});
		
		
	}
	
	public Boolean validate(String token) {
		Optional<TokenModel> found = tR.findByToken(token);
		return found.isPresent()&&found.get().getExpirationTime()>Instant.now().toEpochMilli();

	}
	
	public SignModel toUser(String token) {
		Optional<TokenModel> found = tR.findByToken(token);

			return found.isPresent() ? found.get().getUser() : null;
	}
	
	
}
