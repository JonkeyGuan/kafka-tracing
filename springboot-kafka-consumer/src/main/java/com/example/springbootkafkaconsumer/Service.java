package com.example.springbootkafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Service {
 
    private final Logger logger = LoggerFactory.getLogger(Application.class);
    
    @Autowired
	private RestTemplate restTemplate;

	@Value("${rest.url}")
	private String restURL;

	@KafkaListener(id = "MyGroup", topics = "MyTopic")
	public void receive(ConsumerRecord<String, String> record) {
		logger.info("received message: {}", record.value());

		String response = restTemplate.getForObject(restURL + "/" + record.value(), String.class);
		logger.info("response message: {}", response);
	}

}
