package com.lil.springperformance.client.manage;

import com.lil.springperformance.client.domain.DemoPayload;
//import com.lil.springperformance.client.repository.DeviceRepository;
import com.lil.springperformance.client.domain.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);
    
    private final String GET_OF_API = "https://quoters.apps.pcfone.io/api/random";

    //@Autowired
    //DeviceRepository deviceRepo;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index() {
        return "Hello from Demo Client.";
    }


    //@RequestMapping("/getAllItems")
    //@ResponseBody
    //public List<Device> getAllItems(){
        //return deviceRepo.getAllDevices();
    //}

    @GetMapping("/quoter")
    public String getQuoter() {
        Quote quote = restTemplate.getForObject(
                GET_OF_API, Quote.class);
        logger.info(quote.toString());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }
        return quote.toString();
    }

    @GetMapping("/longwait")
    public String getLongwait() {
        DemoPayload payload = restTemplate.getForObject(
                "http://localhost:9092/hello-long-wait", DemoPayload.class);
        logger.info(payload.toString());
        return payload.toString();
    }

}
