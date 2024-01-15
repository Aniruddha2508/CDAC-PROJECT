package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CartDao;
import com.app.dao.ProductDao;
import com.app.dao.UserDao;
import com.app.dto.CartDTO;
import com.app.pojo.Cart;
import com.app.pojo.Category;
import com.app.pojo.Product;
import com.app.pojo.User;

@Service
@Transactional
public class ProductServicesImpl implements IProductServices{

	@Autowired
	ProductDao productDao;
	@Autowired
	CartDao cartDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public Product addProduct(Product product,String email) {
		User u=userDao.findByEmail(email).orElseThrow();
		product.setUser(u);
		return productDao.save(product); 
	}

	@Override
	public List<Product> getProducts(String email) {
		User u=userDao.findByEmail(email).orElseThrow();
		return productDao.findByUser(u);
		
	}

	@Override
	public void removeProduct(int id) {
		productDao.deleteById(id);
	}

	@Override
	public Product getProduct(int id) {	
//		System.out.println(productDao.findById(id));
		return productDao.findById(id).orElseThrow();
	}


	@Override
	public List<Product> getProductsByCategory(String category) {
		return productDao.findByCategory(Category.valueOf(category.toUpperCase()));
		
	}

	@Override
	public void editProduct(Product product, String email) {
		User u=userDao.findByEmail(email).orElseThrow();
		product.setUser(u);
		productDao.save(product);
	}

	@Override
	public void addToCart(CartDTO product, String name) {
		Product p=getProduct(product.getProductId());
		User u= userDao.findByEmail(name).orElseThrow();
		productDao.save(p);
		Cart c=new Cart(p.getId(),p.getName(),p.getImageUrl(),product.getQuantity(),p.getRate(), u);
		cartDao.save(c);
	}

	@Override
	public List<Product> getProductsByName(String name) {		
		return productDao.findByName("%"+name+"%");
	}

	

}
