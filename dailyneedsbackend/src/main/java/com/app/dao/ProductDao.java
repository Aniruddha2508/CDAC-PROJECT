package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Category;
import com.app.pojo.Product;
import com.app.pojo.User;

public interface ProductDao extends JpaRepository<Product, Integer> {
	List<Product> findByUser(User user);
	List<Product> findByCategory(Category category);
	
	@Query(value = "select p from Product p where name LIKE ?1")
	List<Product> findByName(String name);
}
