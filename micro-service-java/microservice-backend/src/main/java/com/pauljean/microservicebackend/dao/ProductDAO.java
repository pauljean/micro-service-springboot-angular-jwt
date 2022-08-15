package com.pauljean.microservicebackend.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pauljean.microservicebackend.entity.ProductEntity;

@Repository
public interface ProductDAO extends JpaRepository<ProductEntity, Long>{

	@Query(value = "SELECT p.*"
			+ "FROM products p, authors a"
			+ "WHERE p.authors_id = a.id"
			+ "AND a.FirstName = ?1", nativeQuery=true)
	public List<ProductEntity> getByAuthor(String author);
	
	
//	get by title and author
	@Query(value = "SELECT p.*"
			+ "FROM products p, authors a"
			+ "WHERE p.authors_id = a.id"
			+ "AND p.name = ?1"
			+ "AND a.FirstName = ?2", nativeQuery=true)
	public List<ProductEntity> getByTitleAndAuthor(String title, String author);
	
}
