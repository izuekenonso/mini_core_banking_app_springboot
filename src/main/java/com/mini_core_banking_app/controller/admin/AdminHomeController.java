package com.mini_core_banking_app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomeController {

	
	@GetMapping
	@RequestMapping("/admin/home")
	public String adminhome() {
		return "admin/home";
	}
	
}
