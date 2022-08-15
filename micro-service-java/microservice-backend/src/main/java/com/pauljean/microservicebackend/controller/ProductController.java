package com.pauljean.microservicebackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauljean.microservicebackend.entity.ProductEntity;
import com.pauljean.microservicebackend.service.ProductService;

@RestController
@RequestMapping("bookstore/v1")
@CrossOrigin()
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping("products")
	public Iterable<ProductEntity> getAllProducts(){
		return productservice.getAllProducts();
	}
	
//	get product by id
	@GetMapping("product/{productID}")
	public Optional<ProductEntity> getAllProductById(final Long id){
		return productservice.getProductById(id);
	}

	// update 
	@PutMapping("product/{id}/")
	public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity product){
		return productservice.update(id,product);
	}
	
//	get product by title
	@GetMapping("product/{title}")
	public List<ProductEntity> getByTitle(String name){
		return productservice.getByTitle(name);
	}
	
//	get product by author
	@GetMapping("product/{autor}")
	public List<ProductEntity> getByAuthor(String name){
		return productservice.getByAuthor(name);
	}
	
//	get product by title and author
	@GetMapping("product/{title}/{author}/")
	public List<ProductEntity> getByTitleAndAuthor(String title, String author){
		return productservice.getByTitleAndAuthor(title,author);
	}
//	created new product
	@PostMapping("create/product")
	public ProductEntity createdNewProduct(ProductEntity product){
		return productservice.createdProduct(product);
	}
	
//	destroy product
	@DeleteMapping("/product/{productId}")
	public void destroyProduct(final Long id) {
		productservice.deletedProduct(id);
	}
}
