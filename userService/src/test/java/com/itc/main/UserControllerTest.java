package com.itc.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itc.main.controller.WelcomController;
import com.itc.main.entity.User;
import com.itc.main.service.UserService;

@WebMvcTest(value = WelcomController.class)

public class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	 @MockBean
	 private UserService userService;

	 @Test
	 public void testNotNull() {
		 assertNotNull(userService);
		 assertNotNull(mvc);
	 }
	 
	 @Test
	 public void save() throws Exception {
		 User us=new User();
		 us.setUserId(101);
		 us.setUserName("RAJU");
		 us.setEmail("RAJU@GMAIL.COM");
		 us.setPassword("abc123");
		 
		 when(this.userService.save(Mockito.any(User.class)))
		 .thenReturn(us);
		 
		 String uri="/api/save";
		 String expected=this.mapToJson(us);
		
		 RequestBuilder rb= MockMvcRequestBuilders
		 .post(uri)
		  .accept(org.springframework.http.MediaType.APPLICATION_JSON)
		  .content(expected)
		  .contentType(org.springframework.http.MediaType.APPLICATION_JSON);
		 
		MvcResult mv=mvc.perform(rb).andReturn();
		String outputJson = mv.getResponse().getContentAsString();
		
		assertThat(outputJson).isEqualTo(expected);
		
		 
		 
		 
	 }

//	 @Test
//	 public void testGetUserById() throws Exception {
//		 User us=new User();
//	 us.setUserId(101);
//	 us.setUserName("RAJU");
//	 us.setEmail("RAJU@GMAIL.COM");
//	 us.setPassword("abc123");
//		
//		 
//		 when(this.userService.getUserById(Mockito.anyInt()))
//		 .thenReturn(us);
//		 
//		 String URI="/api/user/1";
//		 
//		 RequestBuilder rb= MockMvcRequestBuilders
//				 .get(URI)
//				 .accept(org.springframework.http.MediaType.APPLICATION_JSON);
//		 MvcResult mr=mvc.perform(rb).andReturn();
//		 
//		 String expected=this.mapToJson(us);
//		 String actual=mr.getResponse().getContentAsString();
//		 assertThat(actual).isEqualTo(expected);
//		 
//		 
//		 
//	 }
	private String mapToJson(User us) throws JsonProcessingException {
		 ObjectMapper om=new ObjectMapper();
		 String s = om.writeValueAsString(us);
		 
		return s;
	}
	

}
