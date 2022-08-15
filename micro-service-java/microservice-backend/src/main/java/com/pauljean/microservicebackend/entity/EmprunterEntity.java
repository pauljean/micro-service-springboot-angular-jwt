package com.pauljean.microservicebackend.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class EmprunterEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="dateEmprunt")
	private LocalDateTime dateEmprunt;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="dateRetour")
	private LocalDate dateRetour;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_products", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<ProductEntity> borrowProduct = new HashSet<>();
	
	public EmprunterEntity() {}

	public EmprunterEntity(LocalDateTime dateEmprunt, LocalDate dateRetour, boolean status) {
		super();
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		this.status = status;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDateTime getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(LocalDateTime dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Set<ProductEntity> getBorrowProduct() {
		return borrowProduct;
	}

	public void setBorrowProduct(Set<ProductEntity> borrowProduct) {
		this.borrowProduct = borrowProduct;
	}
	
	
	public void emprunter(ProductEntity product) {
		borrowProduct.add(product);
	}
	
	
}
