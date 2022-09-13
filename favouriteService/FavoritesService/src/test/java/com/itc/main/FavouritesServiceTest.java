package com.itc.main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.itc.main.entity.Favorites;
import com.itc.main.exception.PlayerAlreadyExistsException;
import com.itc.main.exception.PlayerNotFoundException;

import com.itc.main.repository.FavoritesRepository;

import com.itc.main.service.FavoritesService;


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
public class FavouritesServiceTest {
	@InjectMocks
	private FavoritesService favService;
//	Service service= new Service();
	
	@Mock
	private FavoritesRepository favRepository;
	
	@Test
	public void getNotNullTest() {
		assertThat(favService).isNotNull();
		assertThat(favRepository).isNotNull();
	}
	
	@Test
	public void testsavePlayer() throws PlayerAlreadyExistsException {
		
		 Favorites pro= new Favorites();
		  pro.setFavId(1);
		  pro.setName("Sachin");
		  pro.setRun(30000);
		  pro.setTeam("India");
		  pro.setUserId(101);
	
		  
		 when(this.favRepository.save(pro))
		  .thenReturn(pro);
		
		 boolean isSave=this.favService.saveFavorites(pro);
		 assertEquals(isSave,true);
		 System.out.println("--SUCCESS SAVE Player--");
	}
	

	@Test
	public void testFavPlayer() {
		List<Favorites> list=new ArrayList();
		list.add(new Favorites(1,"Sachin",30000,"India",101));
		
		when(this.favRepository.findAll())
		.thenReturn(list);
		
		List<Favorites> list1=this.favService.getAllFavorites();
		
		assertEquals(list1.size(), list.size());
		System.out.println("--SUCCESS TEST GET ALL Player--");
		
	}
	@Test
	public void testPlayerByName() {
		 
		  Favorites pro= new Favorites();
		  pro.setFavId(1);
		  pro.setName("Sachin");
		  pro.setRun(30000);
		  pro.setTeam("India");
		  pro.setUserId(101);
		  
		  when(this.favRepository.getFavoritesByName(anyString()))
		  .thenReturn(pro);
		  
		  Favorites e=this.favService.getFavoritesByName("Sachin");
		  
		  assertEquals(e.getName(), pro.getName());
		  System.out.println("--SUCCESS TEST--");
		
	}

	@Test
	public void testgetFavouritesById() {
		 
		  Favorites pro= new Favorites();
		  pro.setFavId(1);
		  pro.setName("Sachin");
		  pro.setRun(30000);
		  pro.setTeam("India");
		  pro.setUserId(101);
		  
		  when(this.favRepository.save(pro))
		  .thenReturn(pro);
		  
		  Favorites e=this.favService.getFavouritesById(1);
		  
		  assertEquals(e.getFavId(), pro.getFavId());
		  System.out.println("--SUCCESS TEST--");
		
	}

		
	}

