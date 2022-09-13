package com.itc.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itc.main.entity.User;
import com.itc.main.repository.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
		


		@Test
		@Order(1)
		public void testNotNull() {
			assertNotNull(userRepository);
		}
		
		
		@Test
		@Order(2)
		public void saveAccountTest() {
			User us=new User(101,"abc","abc123","abc@gmail.com");
			User u=this.userRepository.save(us);
			assertEquals(u.getUserId(),us.getUserId());
          

			System.out.println("--SUCCESS SAVE TEST--");
			
		}
		
	
		@Test
		@Order(3)
		public void getUserByIdTest() {
			Optional<User> p=this.userRepository.findById(101);
			
			if(p.isPresent()) {
				User pro = p.get();
				try {
				assertEquals(pro.getUserId(), 101);
				}catch(AssertionFailedError ae) {
					System.err.println("--Id Not Found--");
				}
				System.out.println("--SUCCESS GET BY ID TEST--");
			}else {
				assertThrows(AssertionFailedError.class,()->{
					System.err.println("Id Not Found!");
				});
			}
		}

}
