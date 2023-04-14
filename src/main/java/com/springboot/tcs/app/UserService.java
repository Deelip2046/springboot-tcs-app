package com.springboot.tcs.app;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void registerUser(User user) throws CustomException{
		if (user.getEmail()==null || user.getEmail().isEmpty()
				|| user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new CustomException("Username or password policy failed");
		}
		try {
			userRepository.save(user);
			
		}catch(Exception e) {
			throw new CustomException("user registration failed");
		}
		
	
		
	}
	public User signinUser(String email, String password) throws CustomException {
		User user = userRepository.findByEmailAndPassword(email, password);
		if(user==null) {
			throw new CustomException("Username or Password Incorrect");
		}
		return user;
	}
	
	}
	



