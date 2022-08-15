package com.pauljean.microservicebackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pauljean.microservicebackend.entity.AuthorEntity;

@Repository
public interface AuthorDao extends JpaRepository<AuthorEntity, Long>{

}
