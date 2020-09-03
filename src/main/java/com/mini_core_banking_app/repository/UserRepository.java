package com.mini_core_banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mini_core_banking_app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}