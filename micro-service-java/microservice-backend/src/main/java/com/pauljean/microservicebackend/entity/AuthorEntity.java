package com.pauljean.microservicebackend.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="authors")
public class AuthorEntity implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long Id;
  
  @Column(name="FirstName")
  private String FirstName;
  
  @Column(name="LastName")
  private String LastName;
  
  @Column(name="Country")
  private String Country;
  
  @Column(columnDefinition="TEXT")
  private String Presentation;
  
  @OneToMany(mappedBy="products")
  private Set<ProductEntity> products;
  
  public AuthorEntity() {}
  
  public AuthorEntity(String firstName, String lastName, String country, String presentation,
		  Set<ProductEntity> products) {
	  super();
	  FirstName = firstName;
	  LastName = lastName;
	  Country = country;
	  Presentation = presentation;
	  this.products = products;
  }

  public Long getId() {
	  return Id;
  }

  public void setId(Long id) {
	  Id = id;
  }

  public String getFirstName() {
	  return FirstName;
  }

  public void setFirstName(String firstName) {
	  FirstName = firstName;
  }

  public String getLastName() {
	  return LastName;
  }

  public void setLastName(String lastName) {
	  LastName = lastName;
  }

  public String getCountry() {
	  return Country;
  }

  public void setCountry(String country) {
	  Country = country;
  }

  public String getPresentation() {
	  return Presentation;
  }

  public void setPresentation(String presentation) {
	  Presentation = presentation;
  }

  public Set<ProductEntity> getProducts() {
	  return products;
  }

  public void setProducts(Set<ProductEntity> products) {
	  this.products = products;
  }
  
  

   
  
}
