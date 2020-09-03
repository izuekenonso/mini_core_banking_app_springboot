package com.mini_core_banking_app.model;

import javax.persistence.UniqueConstraint;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "customers", uniqueConstraints = { @UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "account_number") } )
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String account_number;
	private String account_balance;
	
	
	public Customer() {

	}


	public Customer(String firstname, String lastname, String email, String account_number, String account_balance) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.account_number = account_number;
		this.account_balance = account_balance;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAccount_number() {
		return account_number;
	}


	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}


	public String getAccount_balance() {
		return account_balance;
	}


	public void setAccount_balance(String account_balance) {
		this.account_balance = account_balance;
	}
	
	
	
}
