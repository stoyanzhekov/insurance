package com.insurance.service;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insurance.entity.User;
import com.insurance.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		UserServiceImpl.class
})
public class UserServiceTest {

	@Inject
	private UserService userService;

	@Test
	public void isUserExistTest() {
		
		boolean result = userService.isUserExist("1234");
		assertFalse(result);
		
		User user = new User();
		user.setID("1234");
		user.setFirstName("John");
		
		userService.saveUser(user);
		
		assertEquals(true, userService.isUserExist("1234"));
		
	}
	
	@Test
	public void saveUserTest() {
				
		User user = new User();
		user.setID("1234");
		user.setFirstName("John");
		
		userService.saveUser(user);
		
		assertEquals(true, userService.isUserExist("1234"));
		assertEquals("John", userService.getUser("1234").getFirstName());
		
	}
}
