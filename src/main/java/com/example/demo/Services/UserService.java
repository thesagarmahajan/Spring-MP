package com.example.demo.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Pojo.User;

@Service
public class UserService {
	
	private ArrayList<User> people = new ArrayList<>();
	
	public User createUserService(User newuser) {
		User userToCreate = new User(newuser.getName(), newuser.getEmail(), newuser.getPhone(),newuser.getAddress());
		this.people.add(userToCreate);
		return userToCreate;
	}
	
	public ArrayList<User> getAllUsersService() {
		return this.people;
	}
	
	public User getDetailsService(int id) {
		for (User user : people) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public Boolean deleteUserService(int id) {
		for (User user : people) {
			if(user.getId()==id) {
				return people.remove(user);
			}
		}
		return false;
	}
	
	public Boolean updateUserService(@RequestBody User newUser) {
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
