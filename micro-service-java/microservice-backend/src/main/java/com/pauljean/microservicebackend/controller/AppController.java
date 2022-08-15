package com.pauljean.microservicebackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauljean.microservicebackend.dao.IProduitDao;
import com.pauljean.microservicebackend.entity.Produit;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/backend")
public class AppController {

	private Logger log = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private IProduitDao iProduitDao;

	@RequestMapping("/hello")
	public ResponseEntity<String> helloWorld() {

		return new ResponseEntity<String>("hello micro service", HttpStatus.OK);

	}

	@RequestMapping("/home")
	public ResponseEntity<String> home() {

		log.info("micro service inside home bakend !!!");


		return new ResponseEntity<String>("welcome home", HttpStatus.OK);

	}
	
	
	@RequestMapping("/produits")
	public ResponseEntity<List<Produit>> produits() {

		log.info("micro service inside home bakend !!!");

		List<Produit> produits = iProduitDao.findAll();

		log.info("list produits {} : ", produits);

		return new ResponseEntity<List<Produit>>(produits, HttpStatus.OK);

	}
	
	@RequestMapping("/users")
	public ResponseEntity<List<Produit>> users() {

		log.info("micro service inside home bakend !!!");

		List<Produit> produits = iProduitDao.findAll();

		log.info("list produits {} : ", produits);

		return new ResponseEntity<List<Produit>>(produits, HttpStatus.OK);

	}


}
