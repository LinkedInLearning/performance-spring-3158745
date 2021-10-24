package com.lil.springperformance.api.controller;

import com.lil.springperformance.api.DemoApiApplication;
import com.lil.springperformance.api.domain.Device;
import com.lil.springperformance.api.domain.GenericResponse;
import com.lil.springperformance.api.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DemoController {


    @Resource(name = "deviceService")
    private DeviceService deviceService;

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

    @GetMapping("/hello-long-wait")
    public GenericResponse sayHelloLong(@RequestParam(name="name", required=false, defaultValue="Learner") String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }
        return new GenericResponse(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/devices")
    public GenericResponse getDevices() {
        deviceService.getAllDevices();
        return new GenericResponse(counter.incrementAndGet(), "Hello. Check api logs.");
    }

}



