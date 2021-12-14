package com.example.demo.Controllers;

import java.net.URI;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Pojo.User;
import com.example.demo.Pojo.UserView;
import com.example.demo.Services.UserService;
import com.example.demo.Services.UserServiceJPA;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserServiceJPA us;
	
	//UserService us;
	
	/*// Using form-data in postman tool catching seperate params in seperate variable
	@PostMapping("add")
	public String createUser(@RequestParam("name") String fullname, @RequestParam("phone") String phoneno) {
		return "full name = "+fullname+"\nphone = "+phoneno;
	}*/
	
	@PostMapping("add")
	public ResponseEntity createUser(@RequestBody User newuser) {
		User createdUser = this.us.createUserService(newuser);
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("user/add").toUriString());
		return ResponseEntity.created(uri).body(createdUser);
	}
	
	@GetMapping("all")
	public ResponseEntity<List<User>>  getAllUser(){
		List<User> allUsers = this.us.getAllUsersService();
		if(allUsers.size()>0) {
			return ResponseEntity.ok(allUsers);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("view/all")
	public List<UserView> getAllUserView(){
		return this.us.getAllUsersViewService();
	}
	
	@GetMapping("view/details/{email}")
	public UserView getUserByEmail(@PathVariable String email){
		return this.us.getUserViewByEmail(email);
	}
	
	@GetMapping("details/{id}")
	public ResponseEntity getDetails(@PathVariable("id") int id) {
		Optional<User> foundUser  = this.us.getDetailsService(id);
		if(foundUser.isPresent()) {
			return ResponseEntity.ok(foundUser);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	
	@DeleteMapping("delete/{id}")
	public int deleteUser(@PathVariable("id") int id) {
		return this.us.deleteUserService(id);
	}
	
	@PutMapping("update/{id}")
	public User updateUser(@RequestBody User u, @PathVariable("id") int id) {
		return this.us.updateUserServer(u, id);
	}
	
	
}

// http://localhost:8080/user/add
