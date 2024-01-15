package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.CartServices;
import com.app.services.ICartServices;

@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class CartController {
	@Autowired
	ICartServices cartServices;
	
	@GetMapping("/getcartproducts")
	ResponseEntity<?>getCartProducts(HttpServletRequest request){
		return ResponseEntity.ok(cartServices.getCartProducts(request.getUserPrincipal().getName()));
	}
	
	@DeleteMapping("/productremovefromcart/{id}")
	ResponseEntity<?>removeFromCart(@PathVariable int id){
		cartServices.removeCartProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("/increasequantity/{id}")
	ResponseEntity<?>increaseQuantity(@PathVariable int id){
		cartServices.increaseQuantity(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("/decreasequantity/{id}")
	ResponseEntity<?>decreaseQuantity(@PathVariable int id){
		cartServices.decreaseQuantity(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
