package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalApplication {
	public static final Logger logger = LoggerFactory.getLogger(FinalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FinalApplication.class, args);
		logger.info("Test");
	}

}
