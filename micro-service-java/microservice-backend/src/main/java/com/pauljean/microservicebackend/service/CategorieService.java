package com.pauljean.microservicebackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauljean.microservicebackend.dao.CategorieDao;
import com.pauljean.microservicebackend.entity.CategorieEntity;

@Service
public class CategorieService {

	@Autowired
	private CategorieDao categorieDao;
	
//	get all authors
	public Iterable<CategorieEntity> getAllCategories(){
		return categorieDao.findAll();
	}
	
//	get category by id
	public Optional<CategorieEntity> getCategoryById(final Long id){
		return categorieDao.findById(id);
	}
	
//	save category
	public CategorieEntity saveCategory(CategorieEntity author) {
		CategorieEntity a = categorieDao.save(author);
		return a;
	}
	
	
//	delete category
	public void deleteCategory(final Long id) {
		categorieDao.deleteById(id);
	}
}
