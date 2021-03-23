package com.firstservice.serviceone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.firstservice.serviceone.domain.Employee;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient webClient;
	@GetMapping("/getEmployee/{name}")
	public Employee getEmployee(@PathVariable("name") String name) {
		/*
		 * ResponseEntity<Employee> response = restTemplate.exchange(
		 * "http://localhost:8081/second/employee/{name}", HttpMethod.GET, null,
		 * Employee.class, name ); return response.getBody();
		 */
		
		return webClient.get().uri("employee/{name}",name).accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
				.retrieve().bodyToMono(Employee.class).block();
	}
	@GetMapping("/employee/byNameAndAge")
	public Employee getEmployeeBynameAndAge(@RequestParam(value="name")String name,@RequestParam(value="age") int age) {
		String uriVal=UriComponentsBuilder.fromUriString("employee/byNameAndAge").queryParam("name", name).queryParam("age", age).toUriString();
		return webClient.get().uri(uriVal).retrieve().bodyToMono(Employee.class).block();
		
	}
	
	

}
