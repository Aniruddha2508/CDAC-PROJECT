package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Product;
import com.app.services.IProductServices;
import com.app.services.IUserServices;

@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class UserController {
	@Autowired
	IUserServices userServices;
	

	
	@GetMapping("/getinfo")
	ResponseEntity<?>getUser(HttpServletRequest request){
		return ResponseEntity.ok(userServices.getUser(request.getUserPrincipal().getName()));
	}
	@GetMapping("/userlist")
	ResponseEntity<?>getUsers(HttpServletRequest request){
		return ResponseEntity.ok(userServices.getUsers());
	}
}
