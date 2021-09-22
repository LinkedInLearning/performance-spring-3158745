package com.lil.springperformance.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.BDDAssertions.then;
import java.util.Map;

@SpringBootTest
class DemoApiApplicationTests {

	@Value("${server.port}")
	private int port;

	//@Autowired
	//private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
		assert(true);
	}

	/*
	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.port + "/hello-api", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	*/

}

