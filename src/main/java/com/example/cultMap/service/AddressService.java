package com.example.cultMap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cultMap.model.AddressModel;
import com.example.cultMap.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository aR;
	
	public AddressModel save(String bairro, String logradouro, Integer numero, String cidade, String estado, String pais) {
		
		AddressModel aM = new AddressModel();
		aM.setBairro(bairro);
		aM.setCidade(cidade);
		aM.setEstado(estado);
		aM.setLogradouro(logradouro);
		aM.setNumero(numero);
		aM.setPais(pais);
		AddressModel saved = aR.save(aM);
		return saved;
	}
	
	public List<AddressModel> findAll() {
		List<AddressModel> list = new ArrayList<AddressModel>();
		aR.findAll().iterator().forEachRemaining(list::add);
		return list;		
	}
}
