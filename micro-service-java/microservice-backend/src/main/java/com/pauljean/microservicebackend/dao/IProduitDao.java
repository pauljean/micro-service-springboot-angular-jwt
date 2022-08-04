package com.pauljean.microservicebackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauljean.microservicebackend.entity.Produit;

@Repository
public interface IProduitDao extends JpaRepository<Produit, Integer> {

	List<Produit> findAll();

}
