package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Cart;
import com.app.pojo.User;

public interface CartDao extends JpaRepository<Cart, Integer> {
List<Cart> findByUser(User user);

}
