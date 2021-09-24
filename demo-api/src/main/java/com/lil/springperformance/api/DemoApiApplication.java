package com.lil.springperformance.api;

import com.lil.springperformance.api.domain.DemoProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApiApplication {

	private static Logger logger = LoggerFactory.getLogger(DemoApiApplication.class);

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/application.xml", DemoApiApplication.class);
		DemoProperties props = (DemoProperties) context.getBean("appProperties");
		DemoApiApplication demoApplication = new DemoApiApplication();
		SpringApplication.run(DemoApiApplication.class, args);
		logger.info("Open this application in your browser at http://localhost:" + props.getRuntimeProperties().getProperty("server.port", ""));
		context.close();
	}

	/*
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://quoters.apps.pcfone.io/api/random", Quote.class);
			logger.info(quote.toString());
		};
	}
	*/
}
