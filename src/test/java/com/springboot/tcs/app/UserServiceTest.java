package com.springboot.tcs.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
		@Mock
		private UserRepository userRepository;
		@InjectMocks
		private UserService userService;
		@Test
		public void signinUser()throws Exception{
			User user = new User();
			user.setId(1L);
		    user.setEmail("deelip@test.com");
			user.setPassword("deelip123");
			when(userRepository.findByEmailAndPassword("deelip@test.com", "deelip123")).thenReturn(user);
			User result =userService.signinUser("deelip@test.com" ,"deelip123");
			assertNotNull(result);
			assertEquals(user, result);			
		}
	}
	
	


