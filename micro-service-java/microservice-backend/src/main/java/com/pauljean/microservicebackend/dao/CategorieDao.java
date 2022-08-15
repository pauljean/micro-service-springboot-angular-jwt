package com.pauljean.microservicebackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauljean.microservicebackend.entity.CategorieEntity;

@Repository
public interface CategorieDao extends JpaRepository<CategorieEntity, Long>{

}
