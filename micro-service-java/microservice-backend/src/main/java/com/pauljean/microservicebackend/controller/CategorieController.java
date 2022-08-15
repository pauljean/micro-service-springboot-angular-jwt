package com.pauljean.microservicebackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauljean.microservicebackend.entity.CategorieEntity;
import com.pauljean.microservicebackend.service.CategorieService;

@RestController
@RequestMapping("booksManagement/v1/")
@CrossOrigin
public class CategorieController {
	@Autowired
	private CategorieService CategorieService;
	
//	get all authors
	@GetMapping("/categories")
	public Iterable<CategorieEntity> getAllCategories(){
		return CategorieService.getAllCategories();
	}
	
//	get all author by id
	@GetMapping("/category/{categoryId}/")
	public Optional<CategorieEntity> getCategoryById(final Long id){
		return CategorieService.getCategoryById(id);
	}
	
//	create new author
	@PostMapping("add/category")
	public CategorieEntity saveAuthor(CategorieEntity category) {
		CategorieEntity author = CategorieService.saveCategory(category);
		return author;
	}
	
//	delete author
	@DeleteMapping("/destroy-category/{categoryId}/")
	public void destroyAuthor(final Long id) {
		CategorieService.deleteCategory(id);
	}
}
