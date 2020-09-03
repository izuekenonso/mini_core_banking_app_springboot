package com.mini_core_banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mini_core_banking_app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
