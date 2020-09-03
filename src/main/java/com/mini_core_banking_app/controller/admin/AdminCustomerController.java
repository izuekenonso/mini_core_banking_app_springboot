package com.mini_core_banking_app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mini_core_banking_app.model.Customer;
import com.mini_core_banking_app.service.CustomerService;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminCustomerController {

	@Autowired
    private CustomerService customerService;
	
	
	@RequestMapping("/admin/customer/index")
	public String viewAllCustomers(Model model) {
	    List<Customer> listCustomers = customerService.listAll();
	    model.addAttribute("listCustomers", listCustomers);
	     
	    return "admin/customer/index";
	}
	
	@RequestMapping("/admin/customer/add")
	public String addCustomers(Model model) {
	    Customer customer = new Customer();
	    model.addAttribute("customer", customer);
	     
	    return "admin/customer/add";
	}
	
	@PostMapping("/admin/customer/add_new_account")
	public String addNewAccount(@ModelAttribute("customer") Customer customer) {
		
		customerService.save(customer);
		return "redirect:/admin/customer/add?success";
	}
	
	
	@RequestMapping(value="/admin/customer", method=RequestMethod.GET)
//	@ResponseBody
	public String findAccount(@RequestParam("accountNumber") String accountNumber, Model model) {
		
		Customer customer = customerService.getCustomerByAccountNumber(accountNumber);
		model.addAttribute("customer", customer);

		if (customer == null) {
			return "redirect:/admin/home?no_data_found";
		}
		
		return "admin/customer/account";
	}
}
