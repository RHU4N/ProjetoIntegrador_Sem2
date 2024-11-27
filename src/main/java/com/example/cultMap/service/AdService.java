package com.example.cultMap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cultMap.model.AdModel;
import com.example.cultMap.model.AdvertiserModel;
import com.example.cultMap.model.CategoryModel;
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
		Optional<AdModel> found = aR.findById(ad.getId());
		
		found.get().setTitulo(ad.getTitulo());
		found.get().setDescricao(ad.getDescricao());
		found.get().setIdAdvertiser(ad.getIdAdvertiser());
		found.get().setDtCriacao(ad.getDtCriacao());
		found.get().setDtLimite(ad.getDtLimite());
		found.get().setIdCategory(ad.getIdCategory());
		found.get().setIdAddress(ad.getIdAddress());
		
		return aR.save(found.get());
	}

	public List<AdModel> findByUserId(AdvertiserModel id) {
		return aR.findByIdAdvertiser(id);
	}

	public List<AdModel> search(String query) {
		return  aR.searchByDescricaoContainsIgnoreCase(query);
	}

	public List<AdModel> findByCategoryId(CategoryModel category, Integer userId) {
		return aR.findByIdCategory(category);
	}


}