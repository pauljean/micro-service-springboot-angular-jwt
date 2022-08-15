package com.pauljean.microservicebackend.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class CategorieEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;

	@Column(name="Name")
	private String Name;
	
	@OneToMany(mappedBy="products")
	private Set<ProductEntity> products;
	
	public CategorieEntity() {}

	public CategorieEntity(String name, Set<ProductEntity> products) {
		super();
		Name = name;
		this.products = products;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Set<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}
	
	
}
