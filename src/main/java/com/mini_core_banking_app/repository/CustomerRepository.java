package com.mini_core_banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mini_core_banking_app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	 
//	@Query("SELECT c.accountNumber FROM customers c where c.accountNumber = :accountNumber") 
	Customer findByAccountNumber(String accountNumber);
}
