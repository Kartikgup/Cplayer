package com.itc.main;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itc.main.entity.Favorites;
import com.itc.main.repository.FavoritesRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FavouriteRespositoryTest {


	@Autowired
	FavoritesRepository favRepository;

	@Test
	@Order(1)
	public void testNotNull() {
		assertNotNull(favRepository);
	}
	
//	
	@Test
	@Order(2)
	public void savePlayerTest() {
		Favorites pro=new Favorites(1,"Dhoni", 13213, "Ind",101);
		Favorites p=this.favRepository.save(pro);
		assertEquals(p.getFavId(),pro.getFavId());
		System.out.println("--SUCCESS SAVE  TEST--");
		
	}
//	
//
	@Test
	@Order(3)
	public void getFavoritesByIdTest() {
		Favorites pro=new Favorites(1,"Sachin", 15000, "India",101);
		Optional<Favorites> p=this.favRepository.findById(1);
		
		if(p.isPresent()) {
			Favorites pro1 = p.get();
			assertEquals(pro.getFavId(), 1);
			System.out.println("--SUCCESS GET BY ID TEST--");
			
		}
	}
		
	   @Test
	   @Order(4)
		public void getAllFavoritesTest() {
			List<Favorites> list=new ArrayList();
			list.add(new Favorites(4,"RAJU",30000,"Ind",101));
			
			int s=this.favRepository.findAll().size();
			
			assertEquals(list.size(), s);
			System.out.println("--SUCCESS GET ALL EMPLOYEE--");
			
			
		}
		

	
}

