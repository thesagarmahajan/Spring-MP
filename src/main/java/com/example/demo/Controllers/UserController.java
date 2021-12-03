package com.example.demo.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Pojo.User;
import com.example.demo.Services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService us;
	
	/*// Using form-data in postman tool catching seperate params in seperate variable
	@PostMapping("add")
	public String createUser(@RequestParam("name") String fullname, @RequestParam("phone") String phoneno) {
		return "full name = "+fullname+"\nphone = "+phoneno;
	}*/
	
	@PostMapping("add")
	public User createUser(@RequestBody User newuser) {
		return this.us.createUserService(newuser);
	}
	
	@GetMapping("all")
	public ArrayList<User> getAllUser(){
		return this.us.getAllUsersService();
	}
	
	@GetMapping("details/{id}")
	public User getDetails(@PathVariable("id") int id) {
		return us.getDetailsService(id);
	}
	
	@DeleteMapping("delete/{id}")
	public Boolean deleteUser(@PathVariable("id") int id) {
		return this.us.deleteUserService(id);
	}
	
	@PutMapping("update")
	public Boolean updateUser(@RequestBody User newUser) {	
		return this.us.updateUserService(newUser);
	}
}

// http://localhost:8080/user/add
