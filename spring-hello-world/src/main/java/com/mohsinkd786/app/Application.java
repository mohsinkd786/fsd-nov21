package com.mohsinkd786.app;

import com.mohsinkd786.controller.UserController;
import com.mohsinkd786.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
		"com.mohsinkd786.controller",
		"com.mohsinkd786.service"} )
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		//UserController userController = new UserController();
		//userController
	}

//	@Bean
//	public UserService userService(){
//		return new UserService();
//	}
}

/*
* Problem 1: Give me a Spring Boot Application with apis to support Calculator Operations such as :
* 			a. Addition
* 			b. Subtraction
* 			c. Multiplication
* 			d. Division
* 			e. Power
* 			f. Square Root
*
*
* Note : Keep the uri's as clean as possible
*
* */
