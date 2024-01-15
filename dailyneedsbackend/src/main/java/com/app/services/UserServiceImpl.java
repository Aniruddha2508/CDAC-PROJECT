package com.app.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserDao;
import com.app.pojo.User;


@Service
@Transactional
public class UserServiceImpl implements IUserServices{


	@Autowired
	private UserDao userDao;
	
	@Autowired
	private  EmailSenderService mailservice;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User registerUser(User user) throws SQLException {
		user.setPassword(encoder.encode(user.getPassword()));	
		 return userDao.save(user);
	}

	@Override
	public Optional<User> getUser(String email) {
		return userDao.findByEmail(email);
	}
	@Override
	public int validateEmailAndGenearateOtp(String email) {
		int randomNumber;
		System.out.println("in serv");
		if (userDao.findByEmail(email).isPresent()) {
			randomNumber = (int) (Math.random() * 9999);
			if (randomNumber <= 1000) {
				randomNumber = randomNumber + 1000;
			}
			mailservice.sendMail(email,"OTP password Reset",String.valueOf(randomNumber));
			return randomNumber;
		}
		else {
			return -1;
		}
	}
	@Override
	public boolean changePassword(String email, String password) {
		User u=userDao.findByEmail(email).orElseThrow();
		u.setPassword(encoder.encode(password));
		if(userDao.save(u)!=null)
			return true;
		return false;
	}

	@Override
	public List<User> getUsers(){
		
		return userDao.findAll();
	}


}
