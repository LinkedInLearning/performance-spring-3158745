package com.lil.springperformance.api.controller;

import com.lil.springperformance.api.DemoApiApplication;
import com.lil.springperformance.api.domain.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoApiApplication.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public GenericResponse index() {
        return new GenericResponse(-1, "Hello from Demo Api.");
    }

    @GetMapping("/hello-api")
    public GenericResponse sayHello(@RequestParam(name="name", required=false, defaultValue="Learner") String name) {
        logger.debug("Debug message");
        return new GenericResponse(counter.incrementAndGet(), String.format(template, name));
    }

}



