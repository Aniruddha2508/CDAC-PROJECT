package com.app.controller;


import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.*;

import com.app.pojo.Order;
import com.app.services.IUserServices;
import com.app.services.IorderServices;

@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class PaymentController {
	
	@Autowired
	IorderServices orderServices;
	
	@Autowired
	IUserServices userServices;
	

	@PostMapping("/payment")
	public String Payment(@RequestBody Order order,HttpServletRequest request) {
		System.out.println("outsite payment");
		try {
			System.out.println(orderServices.checkQuantity(order,request.getUserPrincipal().getName()));
			if(orderServices.checkQuantity(order,request.getUserPrincipal().getName())) {
		System.out.println(order);
		RazorpayClient  client= new RazorpayClient("rzp_test_DGMZ4HkcUP9PIr","VXnQCrajq6tx0EQoG8AN8KlG");
		JSONObject ob=new JSONObject();
		ob.put("amount", Double.parseDouble(order.getTotalAmount().toString())*100);
		ob.put("currency", "INR");
		ob.put("receipt", "txn_12345");
		com.razorpay.Order create = client.Orders.create(ob);
		return create.toString();
			}
			System.out.println("insuffiecient");
			return "Insufficient Quantity";
		}catch (RazorpayException e) {
			return "bad_Request";
		}
	}
	
	@PostMapping("/storeorder")
	public void storePaymentDetails(@RequestBody Order order ,HttpServletRequest request) {
		order.setUser(userServices.getUser(request.getUserPrincipal().getName()).orElseThrow());
		System.out.println(" new order "+order);
		orderServices.Transaction(order,request.getUserPrincipal().getName());
	}
}
