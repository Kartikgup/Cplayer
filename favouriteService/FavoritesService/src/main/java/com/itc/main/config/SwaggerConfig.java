package com.itc.main.config;



import java.util.Collections;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableWebMvc
@Configuration
@EnableSwagger2
//@EnableAutoConfiguration
public class SwaggerConfig{

	 @Bean
	 public Docket api() {
	     return new Docket(DocumentationType.SWAGGER_2)
	         .select()
	         .apis(RequestHandlerSelectors.any())
	         .paths(PathSelectors.any())
	         .build()
	         .pathMapping("/");
	 }
				
	
//	private ApiInfo apiinfo() {
//		// TODO Auto-generated method stub
//		return new ApiInfo("Cplayer App", 
//				"This is my first Microservice Application", 
//				"Swagger 1.0v", 
//				"http://localhost:9003/api/players", 
//				new Contact("Cplayer","http://localhost:9003/api/players","CPLAYER@GMAIL.COM"), 
//				"Apache 2.0", 
//				"https://www.apache.org", Collections.emptyList());
//	}

}
