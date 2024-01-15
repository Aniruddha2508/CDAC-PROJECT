package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CartDTO;
import com.app.pojo.Product;
import com.app.services.IProductServices;

@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class ProductController {
	@Autowired
	IProductServices productServices;
	
	@PostMapping("/addproduct")
	ResponseEntity<?>addProduct(@RequestBody Product product, HttpServletRequest request){
		System.out.println("in add");
		return ResponseEntity.ok(productServices.addProduct(product,request.getUserPrincipal().getName()));
	}
	
	@PostMapping("/addtocart")
	ResponseEntity<?>addToCart(@RequestBody CartDTO product, HttpServletRequest request){
		System.out.println("in add");
		productServices.addToCart(product,request.getUserPrincipal().getName());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editproduct")
	ResponseEntity<?>editProduct(@RequestBody Product product, HttpServletRequest request){
		System.out.println("in edit");
		productServices.editProduct(product,request.getUserPrincipal().getName());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("/productremove/{id}")
	void removeProduct(@PathVariable int id, HttpServletRequest request){
		productServices.removeProduct(id) ;
	}
	
	@GetMapping("/allvendorproducts")
	ResponseEntity<?>getProducts(HttpServletRequest request){
		return ResponseEntity.ok(productServices.getProducts(request.getUserPrincipal().getName()));
	}

	@GetMapping("/getproducts/{category}")
	ResponseEntity<?>getFruits(@PathVariable String category, HttpServletRequest request){
		return ResponseEntity.ok(productServices.getProductsByCategory(category));
	}
	
	@GetMapping("/getproduct/{id}")
	ResponseEntity<?>getProduct(@PathVariable int id){
		return ResponseEntity.ok(productServices.getProduct(id));
	}
	@GetMapping("/searchproducts/{name}")
	ResponseEntity<?>searchProduct(@PathVariable String name){
		
		return ResponseEntity.ok(productServices.getProductsByName(name));
	}
}
