package com.lil.springperformance.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApiApplication {

	private static Logger logger = LoggerFactory.getLogger(DemoApiApplication.class);

	public static void main(String[] args) {
		DemoApiApplication demoApplication = new DemoApiApplication();
		SpringApplication.run(DemoApiApplication.class, args);
		logger.info("Open this application in your browser at http://localhost:?");
	}

}
