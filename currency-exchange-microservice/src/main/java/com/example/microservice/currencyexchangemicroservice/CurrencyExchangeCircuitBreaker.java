package com.example.microservice.currencyexchangemicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CurrencyExchangeCircuitBreaker {
	
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeCircuitBreaker.class);
	
	
	@GetMapping("sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
	public String sampleApi() {

		logger.info("sample api running");
		
		ResponseEntity<String> forEntity = new RestTemplate()
				.getForEntity("http://localhost:8080/dummy", String.class);
		return forEntity.getBody();
	}
	
	public String hardCodedResponse(Exception ex)
	{
		return "fallback-response";
	}

}
