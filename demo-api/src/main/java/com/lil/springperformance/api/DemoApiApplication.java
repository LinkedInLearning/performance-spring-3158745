package com.lil.springperformance.api;

import com.lil.springperformance.api.domain.DemoProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApiApplication {

	private static Logger logger = LoggerFactory.getLogger(DemoApiApplication.class);

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/application.xml", DemoApiApplication.class);
		DemoProperties props = (DemoProperties) context.getBean("appProperties");
		SpringApplication demoApplication = new SpringApplication(DemoApiApplication.class);
		FlightRecorderApplicationStartup frs = new FlightRecorderApplicationStartup();
		demoApplication.setApplicationStartup(frs);
		demoApplication.run(args);
		logger.info("Open this application in your browser at http://localhost:" + props.getRuntimeProperties().getProperty("server.port", ""));
		context.close();
	}

}
