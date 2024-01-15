package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Order;
import com.app.pojo.User;

public interface OrderDao extends JpaRepository<Order, Integer> {

	List<Order> findByUser(User user);

}
