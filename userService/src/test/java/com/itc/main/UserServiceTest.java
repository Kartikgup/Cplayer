package com.itc.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.itc.main.entity.Favorites;
import com.itc.main.entity.User;
import com.itc.main.exception.PlayerAlreadyExistsException;
import com.itc.main.exception.PlayerNotFoundException;

import com.itc.main.repository.FavoritesRepository;
import com.itc.main.repository.UserRepository;
import com.itc.main.service.FavoritesService;
import com.itc.main.service.UserService;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)

public class UserServiceTest {
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	/*
	@BeforeEach
	private void setup() {
		MockitoAnnotations.initMocks(this);
	}*/
	
	@Test
	public void getNotNullTest() {
		assertThat(userService).isNotNull();
		assertThat(userRepository).isNotNull();
	}
	
	
	@Test
	public void testsaveProduct() {
		//Get the Object
		 User us= new User();
		  us.setUserId(101);
		  us.setUserName("abc");
		  us.setPassword("abc123");
		  us.setEmail("abc@gmail.com");
		//when , then
		  
		 when(this.userRepository.save(us))
		  .thenReturn(us);
		
		 User p=this.userService.save(us);
		 assertEquals(p.getUserId(), us.getUserId());
		 System.out.println("--SUCCESS SAVE--");
	}
 
	
	@Test
	public void testUserById() {
		User us=new User();
		us.setUserId(101);
		  us.setUserName("abc");
		  us.setPassword("abc123");
		  us.setEmail("abc@gmail.com");
		  
		
		when(this.userRepository.save(us))
		.thenReturn(us);
		
		User p=this.userService.findById(101);
		assertEquals(p.getUserId(), us.getUserId());
		System.out.println("--SUCCESS TEST GET BY ID--");
		
	}
}
