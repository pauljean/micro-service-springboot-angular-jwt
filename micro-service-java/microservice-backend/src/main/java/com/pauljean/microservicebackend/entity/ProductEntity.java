package com.pauljean.microservicebackend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Products")
public class ProductEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private String price;
	
	@Column(columnDefinition="TEXT")
	private String presentation;
	
	@Column(name="Image")
	private String Image;
	
	@Column(name="createdDateAndTime")
	private LocalDateTime createdDateAndTime;
	
	@Column(name="updatedDateAndTime")
	private LocalDateTime updatedDateAndTime;
	
	@Column(name="status")
	private String status;
	
	@ManyToMany(mappedBy="borrowProduct")
	private Set<BorrowEntity> borrow = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="authors_id", nullable=false)
	private AuthorEntity author;
	
	@ManyToOne
	@JoinColumn(name="categories_id", nullable=false)
	private CategorieEntity category;

	public ProductEntity(String name, String price, String presentation, String image, LocalDateTime createdDateAndTime,
			LocalDateTime updatedDateAndTime, String status, Set<BorrowEntity> borrow, AuthorEntity author,
			CategorieEntity category) {
		super();
		this.name = name;
		this.price = price;
		this.presentation = presentation;
		Image = image;
		this.createdDateAndTime = createdDateAndTime;
		this.updatedDateAndTime = updatedDateAndTime;
		this.status = status;
		this.borrow = borrow;
		this.author = author;
		this.category = category;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public LocalDateTime getCreatedDateAndTime() {
		return createdDateAndTime;
	}

	public void setCreatedDateAndTime(LocalDateTime createdDateAndTime) {
		this.createdDateAndTime = createdDateAndTime;
	}

	public LocalDateTime getUpdatedDateAndTime() {
		return updatedDateAndTime;
	}

	public void setUpdatedDateAndTime(LocalDateTime updatedDateAndTime) {
		this.updatedDateAndTime = updatedDateAndTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<BorrowEntity> getBorrow() {
		return borrow;
	}

	public void setBorrow(Set<BorrowEntity> borrow) {
		this.borrow = borrow;
	}

	public AuthorEntity getAuthor() {
		return author;
	}

	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}

	public CategorieEntity getCategory() {
		return category;
	}

	public void setCategory(CategorieEntity category) {
		this.category = category;
	}

}
