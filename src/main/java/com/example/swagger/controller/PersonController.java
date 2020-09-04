package com.example.swagger.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.common.bean.Person;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@ApiOperation(value = "Response the variable name from query string")
	@GetMapping(value = "/name")
	public String showNameQueryString(@RequestParam("name") String name) {
		return "Your name is " + name;
	}

	@ApiOperation(
		value = "Response the variable name from path variable",
		notes = "This API will create text with 'name' parameter"
	)
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Return your name successful"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Exception!!")
		})
	@GetMapping(value = "/name/{name}")
	public String showName(@PathVariable String name) {
		return "Your name is " + name;
	}

	@ApiOperation(value = "Response the person object from request body")
	@PostMapping(value = "/show/person")
	public Person showPerson(@RequestBody Person person) {
		person.setFirstName("Your name is " + person.getFirstName());
		return person;
	}

}
