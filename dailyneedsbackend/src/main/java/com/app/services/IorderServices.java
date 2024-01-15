package com.app.services;

import java.util.List;

import com.app.pojo.Cart;
import com.app.pojo.Order;
import com.app.pojo.User;



public interface IorderServices {

	void Transaction(Order order,String email);
	boolean checkQuantity(Order order,String email);
	List<Order> getOrders(String string);
	void changeQuantity(Order order ,String email);
	//List<Order> myOrder(User user);

}
