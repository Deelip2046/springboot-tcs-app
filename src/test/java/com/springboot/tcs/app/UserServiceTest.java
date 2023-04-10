package com.springboot.tcs.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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
