package com.mini_core_banking_app.service;

import com.mini_core_banking_app.dto.UserRegistrationDto;
import com.mini_core_banking_app.model.User;

public interface UserService {
	User save(UserRegistrationDto registrationDto);
}
