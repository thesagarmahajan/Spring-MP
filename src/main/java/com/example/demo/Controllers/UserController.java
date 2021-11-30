package com.example.demo.Controllers;

import java.util.ArrayList;

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

@RestController
@RequestMapping("user")
public class UserController {
	
	private ArrayList<User> people = new ArrayList<>();
	
	/*// Using form-data in postman tool catching seperate params in seperate variable
	@PostMapping("add")
	public String createUser(@RequestParam("name") String fullname, @RequestParam("phone") String phoneno) {
		return "full name = "+fullname+"\nphone = "+phoneno;
	}*/
	
	@PostMapping("add")
	public User createUser(@RequestBody User newuser) {
		User userToUpdateUser = new User(newuser.getName(), newuser.getEmail(), newuser.getPhone(),newuser.getAddress());
		this.people.add(userToUpdateUser);
		return userToUpdateUser;
	}
	
	@GetMapping("all")
	public ArrayList<User> getAllUser(){
		return this.people;
	}
	
	@GetMapping("details/{id}")
	public User getDetails(@PathVariable("id") int id) {
		for (User user : people) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	
	@DeleteMapping("delete/{id}")
	public Boolean deleteUser(@PathVariable("id") int id) {
		for (User user : people) {
			if(user.getId()==id) {
				return people.remove(user);
			}
		}
		return false;
	}
	
	@PutMapping("update")
	public Boolean updateUser(@RequestBody User newUser) {
		
		for (User user : people) {
			if(user.getId()==newUser.getId()) {
				user.setName(newUser.getName());
				user.setEmail(newUser.getEmail());
				user.setPhone(newUser.getPhone());
				user.setAddress(newUser.getAddress());
				return true;
			}
		}
		
		return false;
	}
}

// http://localhost:8080/user/add
