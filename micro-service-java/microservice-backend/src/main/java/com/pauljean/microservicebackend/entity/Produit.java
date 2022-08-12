package com.pauljean.microservicebackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(max = 100)
	private String nom;
	@Size(max = 100)
	private String categorie;
	private Double prix;
	@Value("${some.key:true}")
	private boolean disponible; //si le livre est encore disponible ou pas
	@Value("${some.key:false}")
	private boolean special; // pour distinguer si le livre est special ou pas et peut etre emprunter par un visiteur ou un abonne

}
