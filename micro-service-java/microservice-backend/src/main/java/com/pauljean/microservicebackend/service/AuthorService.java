package com.pauljean.microservicebackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauljean.microservicebackend.dao.AuthorDao;
import com.pauljean.microservicebackend.entity.AuthorEntity;

@Service
public class AuthorService {

	@Autowired
	private AuthorDao authorDao;
	
//	get all authors
	public Iterable<AuthorEntity> getAllAuthors(){
		return authorDao.findAll();
	}
	
//	get author by id
	public Optional<AuthorEntity> getAuthorById(final Long id){
		return authorDao.findById(id);
	}
	
//	save author
	public AuthorEntity saveAuthor(AuthorEntity author) {
		AuthorEntity a = authorDao.save(author);
		return a;
	}
	
	
//	delete author
	public void deleteAuthor(final Long id) {
		authorDao.deleteById(id);
	}
}
