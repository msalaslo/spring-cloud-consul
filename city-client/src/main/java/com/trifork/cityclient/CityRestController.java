package com.trifork.cityclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/city")
public class CityRestController {

  RestTemplate restTemplate = new RestTemplate();
  @Autowired
	org.springframework.cloud.client.discovery.DiscoveryClient client;

  @GetMapping("/capital")
  public String[] capital() {
	  org.springframework.cloud.client.ServiceInstance serviceInstance =
			  client.getInstances("city-service")
			        .stream()
			        .findFirst()
			        .orElseThrow(() -> new RuntimeException("city-service not found"));
    //String url = "http://localhost:8080/rest/city/capital";
	  String url = serviceInstance.getUri().toString() + "/city/capital";
    return restTemplate.getForObject(url, String[].class);
  }
}