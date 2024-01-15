package com.app.services;

import java.util.List;

import com.app.dto.CartDTO;
import com.app.pojo.Product;

public interface IProductServices {
	Product addProduct(Product product, String email);

	List<Product> getProducts(String email);

	void removeProduct(int id);

	Product getProduct(int id);

	List<Product> getProductsByCategory(String category);

	void editProduct(Product product,String email);

	void addToCart(CartDTO product, String name);

	List<Product> getProductsByName(String name);

}
