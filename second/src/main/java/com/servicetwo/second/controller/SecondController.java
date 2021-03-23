package com.servicetwo.second.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servicetwo.second.domain.Employee;

@RestController
@RequestMapping("/second")
public class SecondController {
	@GetMapping("/employee/{name}")
	public Employee getEmployee(@PathVariable("name") String name) {
		return getEmployees(name);
		
	}
	@GetMapping("/employee/byNameAndAge")
	public Employee getEmployeebyNameAndAge(@RequestParam(value="name") String name,@RequestParam(value="age") int age) {
		return getEmployeesByNameAndAge(name,age);
	}
	
	private Employee getEmployees(String name){
		List<Employee> list= new ArrayList<>();
		list.add(new Employee("venkat", 10));
		list.add(new Employee("srini", 20));
		list.add(new Employee("raju", 30));
		list.add(new Employee("bonu", 25));
		list.add(new Employee("venkat", 25));
		return list.stream().filter(e->e.getName().equals(name)).findAny().get();
		
		
	}
	private Employee getEmployeesByNameAndAge(String name,int age){
		List<Employee> list= new ArrayList<>();
		list.add(new Employee("venkat", 10));
		list.add(new Employee("srini", 20));
		list.add(new Employee("raju", 30));
		list.add(new Employee("bonu", 25));
		list.add(new Employee("venkat", 25));
		return list.stream().filter(e->e.getName().equals(name)).filter(e->e.getAge()==age).findAny().get();
		
		
	}

}
