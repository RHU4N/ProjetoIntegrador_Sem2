package com.example.cultMap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cultMap.model.AdModel;
import com.example.cultMap.model.SignModel;
import com.example.cultMap.repository.AdRepository;

@Service
public class AdService {
	@Autowired
	private AdRepository aR;
	
	public AdModel save(AdModel ad) {
		return aR.save(ad);
	}
	
	public List<AdModel> findALL(){
		List<AdModel> list = new ArrayList<AdModel>();
		aR.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	public void delete(Integer id) {
		aR.deleteById(id);
	}
	
	public AdModel update(AdModel ad) {
		Optional<AdModel> found = aR.findById(ad.getID());
		
		found.get().setTitulo(ad.getTitulo());
		found.get().setDescricao(ad.getDescricao());
		found.get().setIDAdviser(ad.getIDAdviser());
		found.get().setDTCriacao(ad.getDTCriacao());
		found.get().setDTLimite(ad.getDTLimite());
		found.get().setIDCategory(ad.getIDCategory());
		found.get().setIDAddress(ad.getIDAddress());
		
		return aR.save(found.get());
	}

	public List<AdModel> findByUserId(Integer id) {
		return aR.findByAdvertiserId(id);
	}

	public List<AdModel> search(String query, SignModel user) {
		return  aR.searchByDescriptionStartingWithIgnoreCaseAndAdvertiser(query, user);
	}

	public List<AdModel> findByCategoryId(Integer categoryId, Integer userId) {
		return aR.findByCategory(categoryId, userId);
	}


}