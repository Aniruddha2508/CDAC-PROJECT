package com.app.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.app.pojo.User;

public interface IUserServices {
	public User registerUser(User user) throws SQLException;

	public Optional<User> getUser(String email);

	int validateEmailAndGenearateOtp(String email);

	boolean changePassword(String email, String password);
	
	//public List<User> getUsers();

	public List<User> getUsers();

	
}
