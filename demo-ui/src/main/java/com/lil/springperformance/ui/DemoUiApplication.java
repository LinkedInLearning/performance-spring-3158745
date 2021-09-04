package com.lil.springperformance.ui;

import java.util.Arrays;

import com.lil.springperformance.ui.domain.DemoProperties;
import com.lil.springperformance.ui.manage.DemoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoUiApplication {

	private static Logger logger = LoggerFactory.getLogger(DemoUiApplication.class);

	private static DemoManager demoManager;

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/application.xml", DemoUiApplication.class);
		DemoProperties props = (DemoProperties) context.getBean("appProperties");
		DemoUiApplication demoApplication = new DemoUiApplication();
		SpringApplication.run(DemoUiApplication.class, args);
		logger.info("Open this application in your browser at http://localhost:" + props.getRuntimeProperties().getProperty("server.port", ""));
		context.close();
		demoManager = new DemoManager(props);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			System.out.println("Hello from CommandLine runner.");
			String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				//System.out.println(beanName);
			}
		};
	}

}
