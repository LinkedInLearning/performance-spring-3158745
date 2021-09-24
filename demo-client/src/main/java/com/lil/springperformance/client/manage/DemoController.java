package com.lil.springperformance.client.manage;

import com.lil.springperformance.client.domain.DemoPayload;
//import com.lil.springperformance.client.repository.DeviceRepository;
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

    //@Autowired
    //DeviceRepository deviceRepo;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index() {
        return "Greetings from ClientDemo Application!";
    }


    //@RequestMapping("/getAllItems")
    //@ResponseBody
    //public List<Device> getAllItems(){
        //return deviceRepo.getAllDevices();
    //}

    @RequestMapping("/getServiceCall")
    @ResponseBody
    public String getServiceCall(){
        //return args -> {
            restTemplate.getForObject(
                    "https://quoters.apps.pcfone.io/api/random", DemoPayload.class);
            logger.info("what a hack");
        //}
        return "did it?";

    }

}
