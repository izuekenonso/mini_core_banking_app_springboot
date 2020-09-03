package com.mini_core_banking_app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mini_core_banking_app.dto.UserRegistrationDto;
import com.mini_core_banking_app.model.User;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}
