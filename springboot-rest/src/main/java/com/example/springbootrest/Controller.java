package com.example.springbootrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Logger log = LoggerFactory.getLogger(Application.class);

    @GetMapping("/message/{message}")
    public String publishMessage(@PathVariable("message") final String message) {

        log.info("Received message: {}", message);

        return String.format("Received message: '%s'.", message);
    }

}
