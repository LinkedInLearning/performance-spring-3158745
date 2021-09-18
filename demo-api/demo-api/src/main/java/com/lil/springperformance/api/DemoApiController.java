package com.lil.springperformance.api;

import com.lil.springperformance.api.domain.GenericResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoApiController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public GenericResponse index() {
        return new GenericResponse(-1, "Hello from Demo Api.");
    }

    @GetMapping("/error")
    public GenericResponse error() {
        return new GenericResponse(-1, "Error from Demo Api.");
    }

    @GetMapping("/hello-api")
    public GenericResponse sayHello(@RequestParam(name="name", required=false, defaultValue="Learner") String name) {
        return new GenericResponse(counter.incrementAndGet(), String.format(template, name));
    }

}



