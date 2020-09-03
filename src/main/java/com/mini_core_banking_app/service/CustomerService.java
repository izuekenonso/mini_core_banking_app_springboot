package com.mini_core_banking_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini_core_banking_app.model.Customer;
import com.mini_core_banking_app.model.User;
import com.mini_core_banking_app.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;
     
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }
     
    public void save(Customer customer) {
    	customerRepository.save(customer);
    }
     
    public Customer get(long id) {
        return customerRepository.findById(id).get();
    }
     
    public void delete(long id) {
        customerRepository.deleteById(id);
    }
    
    public Customer getCustomerByAccountNumber(String accountNumber) {
    	Customer customer = customerRepository.findByAccountNumber(accountNumber);
    	return customer;
    }
}
