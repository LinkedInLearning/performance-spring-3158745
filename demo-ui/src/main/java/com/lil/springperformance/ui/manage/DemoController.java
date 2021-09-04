package com.lil.springperformance.ui.manage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
