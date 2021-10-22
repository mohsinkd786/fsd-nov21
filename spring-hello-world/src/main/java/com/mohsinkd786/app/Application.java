package com.mohsinkd786.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mohsinkd786.controller")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
