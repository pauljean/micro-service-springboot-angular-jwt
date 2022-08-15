package com.pauljean.microservicebackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pauljean.microservicebackend.dao.AuthorDao;
import com.pauljean.microservicebackend.dao.ProductDAO;
import com.pauljean.microservicebackend.entity.AuthorEntity;
import com.pauljean.microservicebackend.entity.ProductEntity;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productdao;
	
	@Autowired
	private AuthorDao authordao;
	
//	get all products
	public Iterable<ProductEntity> getAllProducts(){
		return productdao.findAll();
	}
	
//	get product by id
	public Optional<ProductEntity> getProductById(final Long id){
		return productdao.findById(id);
	}
	
//	create new product
	public ProductEntity createdProduct(ProductEntity product) {
		ProductEntity p = productdao.save(product);
		return p;
	}
	
//	find by title
	public List<ProductEntity> getByTitle(String name){
		List<ProductEntity> products = new ArrayList<>();
		for (ProductEntity product : productdao.findAll()) {
			if (product.getName().toLowerCase().contains(name.toLowerCase())) {
				products.add(product);
			}
		}
		return products;
	}
	// update product
	public ProductEntity update(@PathVariable Long id, @RequestBody ProductEntity product){
		product.setId(id);
		return productdao.save(product);
	}
	
//	get product by title
   public List<ProductEntity> getByAuthor(String author){
		 return productdao.getByAuthor(author);
	}
   
//   get product  by title and author
   public List<ProductEntity> getByTitleAndAuthor(String title, String author){
	   return productdao.getByTitleAndAuthor(title, author);
   }
//	delete product
	public void deletedProduct(final Long id) {
		productdao.deleteById(id);
	}

	public ProductDAO getProductdao() {
		return productdao;
	}

	public void setProductdao(ProductDAO productdao) {
		this.productdao = productdao;
	}
}
