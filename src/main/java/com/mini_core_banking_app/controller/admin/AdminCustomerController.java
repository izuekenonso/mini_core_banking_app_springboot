package com.mini_core_banking_app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mini_core_banking_app.model.Customer;
import com.mini_core_banking_app.service.CustomerService;

@Controller
public class AdminCustomerController {

	@Autowired
    private CustomerService customerService;
	
	
	@RequestMapping("/admin/customer/index")
	public String adminviewcustomers(Model model) {
	    List<Customer> listCustomers = customerService.listAll();
	    model.addAttribute("listCustomers", listCustomers);
	     
	    return "admin/customer/index";
	}
}
