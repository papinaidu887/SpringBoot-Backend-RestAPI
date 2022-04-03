package com.medhansh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication {
	
	public static void add2()
	{
		System.out.println("static method...................");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
		
		
		System.out.println(" The entry point of spring boot main method...........");
		
		System.out.println("the entry of first methos is main method.......");
		
		System.out.println("hiiiiiiiiiiiiiiiiiiiii");
	}

}
