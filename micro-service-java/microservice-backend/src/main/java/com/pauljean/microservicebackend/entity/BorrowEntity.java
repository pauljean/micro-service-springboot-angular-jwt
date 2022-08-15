package com.pauljean.microservicebackend.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
//@Table(name="BorrowBooks")
public class BorrowEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="BorrowDateAndTime")
	private LocalDate BorrowDateAndTime;
	
	@ManyToMany
	@JoinTable(name = "borrow_products", 
	joinColumns = @JoinColumn(name = "borrow_id"), 
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<ProductEntity> borrowProduct = new HashSet<>();
	
	@Column(name="BackDate")
	private Date BackDate;
	
	@Column(name="restituer")
	private boolean restituer;

	public BorrowEntity(ProductEntity product,LocalDate borrowDateAndTime, Date backDate, boolean restituer) {
		super();
		BorrowDateAndTime = borrowDateAndTime;
		BackDate = backDate;
		this.restituer = restituer;
		 
	}
	
	public LocalDate getBorrowDateAndTime() {
		return BorrowDateAndTime;
	}

	public void setBorrowDateAndTime(LocalDate borrowDateAndTime) {
		BorrowDateAndTime = borrowDateAndTime;
	}

	public Date getBackDate() {
		return BackDate;
	}

	public void setBackDate(Date backDate) {
		BackDate = backDate;
	}

	public boolean isRestituer() {
		return restituer;
	}

	public void setRestituer(boolean restituer) {
		this.restituer = restituer;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Set<ProductEntity> getBorrowProduct() {
		return borrowProduct;
	}

	public void setBorrowProduct(Set<ProductEntity> borrowProduct) {
		this.borrowProduct = borrowProduct;
	}
}
