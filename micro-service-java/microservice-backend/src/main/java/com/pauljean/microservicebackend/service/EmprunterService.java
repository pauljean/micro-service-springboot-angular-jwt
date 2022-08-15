package com.pauljean.microservicebackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pauljean.microservicebackend.dao.EmprunterDao;
import com.pauljean.microservicebackend.entity.EmprunterEntity;
import com.pauljean.microservicebackend.entity.ProductEntity;

@Service
public class EmprunterService {

	@Autowired
	private EmprunterDao emprunterDao;
	
//	get products borrow by current user
	public Iterable<ProductEntity> getAllProductBorrowByCurrentUser(Long userId){
		return emprunterDao.getAllProductBorrowByCurrentUser(userId);
	}
//	get borrow product by id
	public Optional<ProductEntity> findBorrowById(final Long borrowId){
		return emprunterDao.findBorrowById(borrowId);
	}
//	restitue la reservation
	public EmprunterEntity restituerBorrow(final Long id, EmprunterEntity emprunt){
		emprunt.setStatus(true);
		return emprunterDao.save(emprunt);
	}
	
//	annuler une reservation
	public void annulerReservation(final long id) {
		emprunterDao.deleteById(id);
	}
//	make reservation
	public void processReservation(final Long userId, final Long productId) {
		 
	}
}