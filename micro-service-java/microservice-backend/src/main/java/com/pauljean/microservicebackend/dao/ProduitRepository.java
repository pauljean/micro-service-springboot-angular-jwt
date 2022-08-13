package com.pauljean.microservicebackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pauljean.microservicebackend.entity.Produit;

//@Repository
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

	//List<Produit> findAll();
    public List<Produit> findByDisponible(boolean disponible);
    public Produit findByNom(String nom);


}