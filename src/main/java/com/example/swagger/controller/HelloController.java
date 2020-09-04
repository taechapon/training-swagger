package com.example.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

	@RequestMapping("/hello-world")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/hi")
	public String hi() {
		return "Hi!!";
	}

}
