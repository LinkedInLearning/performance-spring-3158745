package com.lil.springperformance.client.controller;

import com.lil.springperformance.client.domain.CpuLoader;
import com.lil.springperformance.client.domain.DemoPayload;
import com.lil.springperformance.client.repository.DeviceRepository;
import com.lil.springperformance.client.domain.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);
    
    private final String QUOTER_API = "https://quoters.apps.pcfone.io/api/random";

    private final String DEMO_API = "http://localhost:9092";

    @Autowired
    private DeviceRepository deviceRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CpuLoader tracer;

    @GetMapping("/")
    public String index() {
        return "Hello from Demo Client.";
    }

    @GetMapping("/err")
    public String err() {
         return "Oops";
    }

    @RequestMapping("/oops")
    public void handleRequest() {
        throw new RuntimeException("test exception");
    }

    @GetMapping("/monitor")
    public String monitor() {
        tracer.expensiveCalculation(10000);
        return "Check Logs";
    }

    @GetMapping("/query")
    public String getQuery() {
        return deviceRepo.getDevice(1).toString();
    }

    @GetMapping("/quoter")
    public String getQuoter() {
        Quote quote = restTemplate.getForObject(
                QUOTER_API, Quote.class);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }
        return quote.toString();
    }

    @GetMapping("/longwait")
    public String getLongwait() {
        DemoPayload payload = restTemplate.getForObject(
                DEMO_API + "/hello-long-wait", DemoPayload.class);
        return payload.toString();
    }

    @GetMapping("/devices")
    public String getDevices() {
        DemoPayload payload = restTemplate.getForObject(
                DEMO_API + "/devices", DemoPayload.class);
        return payload.toString();
    }

}
