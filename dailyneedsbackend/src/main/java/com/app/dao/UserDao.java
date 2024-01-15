package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Product;
import com.app.pojo.User;

public interface UserDao extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String username);
	

}
