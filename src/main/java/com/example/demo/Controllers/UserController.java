package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Pojo.User;

@RestController
@RequestMapping("user")
public class UserController {
	
	/*// Using form-data in postman tool catching seperate params in seperate variable
	@PostMapping("add")
	public String createUser(@RequestParam("name") String fullname, @RequestParam("phone") String phoneno) {
		return "full name = "+fullname+"\nphone = "+phoneno;
	}*/
	
	@PostMapping("add")
	public String createUser(@RequestBody User newuser) {
		return newuser.getName();
	}
	
}

// http://localhost:8080/user/add
