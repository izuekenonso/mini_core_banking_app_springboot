package com.mini_core_banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini_core_banking_app.model.Customer;
import com.mini_core_banking_app.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	 
}

