package com.pauljean.microservicebackend.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pauljean.microservicebackend.entity.EmprunterEntity;
import com.pauljean.microservicebackend.entity.ProductEntity;

@Repository
public interface EmprunterDao extends JpaRepository<EmprunterEntity, Long>{
	
//	Make reservation
	@Query(value="INSERT INTO user_products(dateEmprunt,dateRetour,user_id,product_id)"
			+ "VALUE(?,?,?,?)", nativeQuery=true)
	public void processReservaton();
	
//	get all products borrow by current user
	@Query(value="SELECT p.* FROM products p, users u, user_products up"
			+ "WHERE p.id = ip.product_id AND u.id = up.user_id"
			+ "AND u.id = ?", nativeQuery=true)
	public Iterable<ProductEntity> getAllProductBorrowByCurrentUser(Long userId);
	
//	get borrow product by id
	@Query(value="SELECT p.* FROM products p, users u, user_products up"
			+ "WHERE p.id = ip.product_id AND u.id = up.user_id"
			+ "AND up.id = ?", nativeQuery=true)
	public Optional<ProductEntity> findBorrowById(final Long borrowId);
	

}
