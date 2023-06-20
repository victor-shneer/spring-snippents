package com.carmel.springSnippents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringMultithreadingApplication {

	static Logger logger = LoggerFactory.getLogger(SpringMultithreadingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringMultithreadingApplication.class, args);
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter username");

		String userName = myObj.nextLine();  // Read user input
		System.out.println("Username is: " + userName);  // Output user input

	}

}
