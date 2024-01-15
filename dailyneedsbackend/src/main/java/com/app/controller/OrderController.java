package com.app.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.IorderServices;

@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class OrderController {
	@Autowired
	IorderServices orderServices;
	
	@GetMapping("/getorders")
	public ResponseEntity<?>getOrders(HttpServletRequest request){
		return new ResponseEntity<>(orderServices.getOrders(request.getUserPrincipal().getName())
				 ,HttpStatus.OK);
	}
//	@GetMapping("/userlist")
//	ResponseEntity<?>getUsers(HttpServletRequest request){
//		return ResponseEntity.ok(orderServices.myOrder(reques.equals(User user)));
//	}
//	@GetMapping("/getcartproducts")
//	ResponseEntity<?>getCartProducts(HttpServletRequest request){
//		return ResponseEntity.ok(cartServices.getCartProducts(request.getUserPrincipal().getName()));
//	}
	
	
}
