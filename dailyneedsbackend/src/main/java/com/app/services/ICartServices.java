package com.app.services;

import java.util.List;

import com.app.pojo.Cart;

public interface ICartServices {
	public List<Cart> getCartProducts(String name);

	public void removeCartProduct(int id);

	public void increaseQuantity(int id);

	public void decreaseQuantity(int id);
}
