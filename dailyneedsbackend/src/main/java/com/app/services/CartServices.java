package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CartDao;
import com.app.dao.UserDao;
import com.app.pojo.Cart;
import com.app.pojo.User;

@Service
@Transactional
public class CartServices implements ICartServices {

	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDao cartDao;
	@Override
	public List<Cart> getCartProducts(String name) {
		User u= userDao.findByEmail(name).orElseThrow();
		return cartDao.findByUser(u);
	}
	@Override
	public void removeCartProduct(int id) {
		cartDao.deleteById(id);
		
	}
	@Override
	public void increaseQuantity(int id) {
		Cart cart=cartDao.getById(id);
		cart.setQuantity(cart.getQuantity()+1);
		cartDao.save(cart);
	}
	@Override
	public void decreaseQuantity(int id) {
		Cart cart=cartDao.getById(id);
		cart.setQuantity(cart.getQuantity()-1);
		cartDao.save(cart);
	}


	

}
