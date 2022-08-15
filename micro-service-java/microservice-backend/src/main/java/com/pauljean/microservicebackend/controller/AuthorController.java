package com.pauljean.microservicebackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauljean.microservicebackend.entity.AuthorEntity;
import com.pauljean.microservicebackend.service.AuthorService;

@RestController
@RequestMapping("booksManagement/v1/")
@CrossOrigin
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
//	get all authors
	@GetMapping("/authors")
	public Iterable<AuthorEntity> getAllAuthors(){
		return authorService.getAllAuthors();
	}
	
//	get all author by id
	@GetMapping("/author/{authorId}/")
	public Optional<AuthorEntity> getAuthorById(final Long id){
		return authorService.getAuthorById(id);
	}
	
//	create new author
	@PostMapping("add/author")
	public AuthorEntity saveAuthor(AuthorEntity a) {
		AuthorEntity author = authorService.saveAuthor(a);
		return author;
	}
	
//	delete author
	@DeleteMapping("/destroy-author/{authorId}/")
	public void destroyAuthor(final Long id) {
		authorService.deleteAuthor(id);
	}
}
