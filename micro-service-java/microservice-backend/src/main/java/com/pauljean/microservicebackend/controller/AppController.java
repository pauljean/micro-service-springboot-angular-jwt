package com.pauljean.microservicebackend.controller;

import java.util.List;

import com.pauljean.microservicebackend.service.ProduitServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pauljean.microservicebackend.dao.ProduitRepository;
import com.pauljean.microservicebackend.entity.Produit;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/backend")
public class AppController {

	@Autowired
	ProduitServiceImpl produitServiceImpl;
	private Logger log = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private ProduitRepository produitRepository;

	@RequestMapping("/hello")
	public ResponseEntity<String> helloWorld() {

		return new ResponseEntity<String>("hello micro service", HttpStatus.OK);

	}

	@RequestMapping("/homes")
	public ResponseEntity<String> home() {

		log.info("micro service inside home bakend !!!");


		return new ResponseEntity<String>("welcome home", HttpStatus.OK);

	}
	
	
	@RequestMapping(value ="/produits",method = RequestMethod.GET)
	public ResponseEntity<List<Produit>> produits() {

		log.info("liste des produits !!!");

		List<Produit> produits = produitRepository.findAll();

		log.info("list produits {} : ", produits);

		return new ResponseEntity<List<Produit>>(produits, HttpStatus.OK);

	}

	@RequestMapping(value = "/produitsDisponibles",method = RequestMethod.GET)
	public ResponseEntity<List<Produit>> produitsDisponible(){

		log.info("produits disponibles");
		List<Produit> produits= produitServiceImpl.livresDisponible();
		log.info("list produits {} : ", produits);
		return new ResponseEntity<List<Produit>>(produits,HttpStatus.OK);
	}
	@RequestMapping(value = "/emprunterProduits/{nom}",method = RequestMethod.GET)
	public ResponseEntity<Produit> emprunterProduit(@PathVariable(name = "nom")String nom)
	{
		log.info("emprunter un produit");
		Produit produit= produitServiceImpl.emprunterLivre(nom);
		log.info(" produit emprunter {} : ", produit);
		return new ResponseEntity<Produit>(produit,HttpStatus.OK);
	}
	@RequestMapping(value = "/restituerProduits/{nom}",method = RequestMethod.GET)
	public ResponseEntity<Produit> restituerProduit(@PathVariable(name = "nom")String nom)
	{
		log.info("restituer un produit");
		Produit produit= produitServiceImpl.restituerLivre(nom);
		log.info(" produit restituer {} : ", produit);
		return new ResponseEntity<Produit>(produit,HttpStatus.OK);
	}

	@RequestMapping(value = "/ajouterProduits",method = RequestMethod.POST)
	public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit p)
	{
		log.info("ajouter un produit");
		Produit produit= produitServiceImpl.ajouterLivre(p);
		log.info(" produit ajouter {} : ", p);
		return new ResponseEntity<Produit>(produit,HttpStatus.OK);
	}
	@RequestMapping(value = "/produitsEmpruntes",method = RequestMethod.GET)
	public  ResponseEntity<List<Produit>> produitsEmprunte(){

		log.info("produits empruntes");
		List<Produit> produits= produitServiceImpl.livresEmprunter();
		log.info(" Listes produit {} : ", produits);
		return new ResponseEntity<List<Produit>>(produits,HttpStatus.OK);

	}




	//la liste des users ne se trouvent dans se service
	/*@RequestMapping("/users")
	public ResponseEntity<List<Produit>> users() {

		log.info("micro service inside home bakend !!!");

		List<Produit> produits = iProduitDao.findAll();

		log.info("list produits {} : ", produits);

		return new ResponseEntity<List<Produit>>(produits, HttpStatus.OK);

	}*/


}
