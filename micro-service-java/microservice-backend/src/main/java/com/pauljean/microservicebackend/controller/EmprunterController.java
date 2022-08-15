package com.pauljean.microservicebackend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauljean.microservicebackend.entity.EmprunterEntity;
import com.pauljean.microservicebackend.entity.ProductEntity;
import com.pauljean.microservicebackend.service.EmprunterService;

@RestController
@RequestMapping("bookManagement/v1")
@CrossOrigin(origins="*")
public class EmprunterController {
	
	@Autowired
	private EmprunterService emprunterService;
	
//	get all product borrow by current user
	@GetMapping("borrow/products/{userId}")
	public Iterable<ProductEntity> getAllProductBorrowByCurrentUser(@PathVariable Long userId){
		return emprunterService.getAllProductBorrowByCurrentUser(userId);
	}
	
//	get borrow by id
	@GetMapping("borrow/product/{productId}")
	public Optional<ProductEntity> findBorrowById(final Long borrowId){
		return emprunterService.findBorrowById(borrowId);
	}
	
//	restituer la reservation
	@PutMapping("borrow/{id}")
	public EmprunterEntity restituerBorrow(@PathVariable final Long id, EmprunterEntity emprunt) {
		return emprunterService.restituerBorrow(id, emprunt);
	}
	
//	annuler la reservation
	@DeleteMapping("borrow/{borrowId}")
	public void annulerReservation(final long id) {
		emprunterService.annulerReservation(id);
	}
	
//	make reservation
	@PostMapping("borrow/{userId}/product/{productId}")
	public EmprunterEntity emprunter(@PathVariable final Long userId,@PathVariable final Long productId) {
		return ;
	}
	
	
	
}
