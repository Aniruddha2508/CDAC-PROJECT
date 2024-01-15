package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthenticationResponse;
import com.app.dto.LoginDTO;
import com.app.jwt_utils.JwtUtils;

import com.app.pojo.User;
import com.app.services.IUserServices;
@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class MainController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private IUserServices userServices;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	



	@PostMapping("/register")
	public ResponseEntity<?> userRegistration(@RequestBody User request) {
		try {
		System.out.println("in user reg " + request);
//		return ResponseEntity.ok(userServices.registerUser(request));
		User u=userServices.registerUser(request);
		if(u!=null)
			return new ResponseEntity<>(u,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO request) {
		System.out.println("in auth " + request);
		try {
			Authentication authenticate = authManager.authenticate
			(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));			
			System.out.println("auth success " + authenticate);
			return ResponseEntity.ok(new AuthenticationResponse(jwtUtils.generateJwtToken(authenticate),authenticate.getAuthorities().toString()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("User authentication Failed", e);
		}
	}

//	
	@GetMapping("/generateotp/{email}")
	public ResponseEntity<?> generateOtp(@PathVariable String email){
		System.out.println("incc");
		int randomNumber=userServices.validateEmailAndGenearateOtp(email);
		System.out.println(randomNumber);
		if(randomNumber!=-1)
		return ResponseEntity.ok(randomNumber);
		else
			return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
	@PutMapping("/changepassword")
	public ResponseEntity<?> changePassword(@RequestBody LoginDTO credentials ){
		if(userServices.changePassword(credentials.getEmail(),credentials.getPassword()))
		return ResponseEntity.ok("password chaange successfully");
		else
			return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
}
