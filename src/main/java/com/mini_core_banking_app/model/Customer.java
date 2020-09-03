package com.mini_core_banking_app.model;

import javax.persistence.UniqueConstraint;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "customers", uniqueConstraints = { @UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "accountNumber") } )
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String accountNumber;
	private double accountBalance;
	
	
	public Customer() {

	}


	public Customer(String firstName, String lastName, String email, String accountNumber, double accountBalance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	
}
