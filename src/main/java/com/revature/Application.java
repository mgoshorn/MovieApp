package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		System.out.println(System.getenv("CB_DB_ROLE"));
		System.out.println(System.getenv("CB_DB_PASS"));
		System.out.println(System.getenv("CB_DB_URL"));

		SpringApplication.run(Application.class, args);
	}
}
