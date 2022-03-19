package com.example.springbootkafkaproducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Logger log = LoggerFactory.getLogger(Application.class);

    private static final String TOPIC = "MyTopic";

    @Autowired
    KafkaTemplate<String, String> kafka;

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message") final String message) {

        kafka.send(TOPIC, message);

        log.info("sent message: {}", message);

        return String.format("Published '%s' Successfully.", message);
    }

}
