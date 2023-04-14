package com.springboot.tcs.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user) throws Exception{
		try {
			userService.registerUser(user);
			return ResponseEntity.ok("Register Sucessful");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		}
	@PostMapping("/signin")
	public ResponseEntity<Object> signinUser(@RequestBody User user){
		try {
			User authenticatedUser = userService.signinUser(user.getEmail(),user.getPassword());
			String jwtToken =jwtUtil.generateToken(authenticatedUser);
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Authentication sucessful");
			response.put("token", jwtToken);
			response.put("id", authenticatedUser.getId());
			return ResponseEntity.ok(response);
		}catch (Exception e) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Username or Password Incorrect");
			return ResponseEntity.badRequest().body(response);
		}
	}
	}
	


