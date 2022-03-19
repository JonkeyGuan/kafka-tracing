package com.example.springbootkafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;

@SpringBootApplication
public class Application {

	@Bean
    public Tracer tracer() {
        String jaegerServiceName = System.getenv("JAEGER_SERVICE_NAME");
        if (jaegerServiceName == null) {
            jaegerServiceName = "myself";
        }
        return Configuration.fromEnv(jaegerServiceName).getTracer();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
