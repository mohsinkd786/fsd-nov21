package com.mohsinkd786;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}


/**
 * Problem 1: An Organization has multiple Projects it works upon, & different employees work on those projects,
 * calculate the total revenue for the projects , & enlist new employees in a projects , if need be.
 *
 *
 * Note : Revenue for the company = Total Billables for all the projects (we can take some assumptions there).
 *		: Profit = Total Revenue - Total Project Cost
 *					(Project Cost will be calculated based upon the salary of employees + 10% miscl. expenses)
 * Calculate :
 * 	1. total revenue for the company
 * 	2. total profit for the company
 * */
