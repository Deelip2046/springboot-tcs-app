package com.springboot.tcs.app;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void registerUser(User user) throws Exception{
		if (user.getEmail()==null || user.getEmail().isEmpty()
				|| user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new Exception("Username or password policy failed");
		}
		userRepository.save(user);
		
	}
	public User signinUser(String email, String password) throws Exception {
		User user = userRepository.findByEmailAndPassword(email, password);
		if(user==null) {
			throw new Exception("Username or Password Incorrect");
		}
		return user;
	}
	
}


