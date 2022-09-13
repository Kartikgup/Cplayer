package com.itc.main;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itc.main.controller.FavoritesController;
import com.itc.main.entity.Favorites;
import com.itc.main.exception.PlayerAlreadyExistsException;
import com.itc.main.service.FavoritesService;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(value = FavoritesController.class)
//@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc

public class FavouriteControllerTest {


	@Autowired
	private MockMvc mvc;
	 @MockBean
	 private FavoritesService favService;
	
	 @Test
	 public void testNotNull() {
		 assertNotNull(favService);
		 assertNotNull(mvc);
	 }
	 
//	 @Test
//	 public  void savePlayer() throws Exception  {
//		 Favorites pro=new Favorites();
//		 pro.setFavId(1);
//		 pro.setName("Rahul");
//		 pro.setRun( 3000);
//		 pro.setTeam("India");
//		 pro.setUserId(101);
//		 
//		 when(this.favService.saveFavorites(Mockito.any(Favorites.class)))
//		 .thenReturn(true);
//		 
//		 String uri="/api/save";
//		 String expected=this.mapToJson(pro);
//		
//		 RequestBuilder rb= MockMvcRequestBuilders
//		 .post(uri)
//		  .accept(org.springframework.http.MediaType.APPLICATION_JSON)
//		  .content(expected)
//		  .contentType(org.springframework.http.MediaType.APPLICATION_JSON);
//		 
//		MvcResult mv=mvc.perform(rb).andReturn();
//		String outputJson = mv.getResponse().getContentAsString();
//		
//		assertThat(outputJson).isEqualTo(expected);
//		
//		 
//	 }
//	 
//	 
//	 @Test
//	 public void testGetPlayertByName() throws Exception {
//		 Player pro=new Player();
//		 pro.setPid(1);
//		 pro.setName("Sachin");
//		 pro.setRun((long) 30000);
//		 pro.setTeam("India");
//		 
//		when(this.favService.getPlayerByName(Mockito.anyString()))
//		 .thenReturn(pro); 
//		 
//		 String URI="/api/player/Sachin";
//		 
//		 RequestBuilder rb= MockMvcRequestBuilders
//				 .get(URI)
//				 .accept(org.springframework.http.MediaType.APPLICATION_JSON);
//		 MvcResult mr=mvc.perform(rb).andReturn();
//		 
//		 String expected=this.mapToJson(pro);
//		 String actual=mr.getResponse().getContentAsString();
//		 assertThat(actual).isEqualTo(expected);
//	 }
//	 
//	
//	 
//	 @Test
//	 public Boolean testDeletePlayertById() throws Exception {
//		 Player pro=new Player();
//		 pro.setPid(1);
//		 pro.setName("Sachin");
//		 pro.setRun((long) 30000);
//		 pro.setTeam("India");
//		 
//		when(this.favService.deletePlayerById(Mockito.anyInt()))
//		 .thenReturn(true); 
//		 
//		 String URI="/api/player/1";
//		 
//		 RequestBuilder rb= MockMvcRequestBuilders
//				 .get(URI)
//				 .accept(org.springframework.http.MediaType.APPLICATION_JSON);
//		 MvcResult mr=mvc.perform(rb).andReturn();
//		 
//		 String expected=this.mapToJson(pro);
//		 String actual=mr.getResponse().getContentAsString();
//		 assertThat(actual).isEqualTo(expected);
//		return true;
//	 }
	 
	 private String mapToJson(Favorites pro) throws JsonProcessingException {
		 ObjectMapper om=new ObjectMapper();
		 String s = om.writeValueAsString(pro);
		 
		return s;
	}
}
