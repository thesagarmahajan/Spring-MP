package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Pojo.User;
import com.example.demo.Pojo.UserView;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserViewDao;

@Service
public class UserServiceJPA {
	
	UserDao ud;
	UserViewDao uvd;
	
	@Autowired
	public UserServiceJPA(UserDao ud, UserViewDao uvd) {
		super();
		this.ud = ud;
		this.uvd = uvd;
	}

	public User createUserService(User newuser) {
		return this.ud.save(newuser);
	}
	
	public List<User> getAllUsersService() {
		return this.ud.findAll();
	}
	
	public List<UserView> getAllUsersViewService() {
		return this.uvd.findAll();
	}
	
	public UserView getUserViewByEmail(String email) {
		return this.uvd.findByEmail(email);
	}
	
	public Optional<User> getDetailsService(int id) {
		return this.ud.findById(id);
	}
	
	public int deleteUserService(int id) {
		try {
			this.ud.deleteById(id);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public User updateUserServer(User uToUpdate, int id) {
		Optional<User> foundUser = this.ud.findById(id);
		if (foundUser.isPresent()) {
			User oldUser = foundUser.get();
			oldUser.setName(uToUpdate.getName());
			oldUser.setEmail(uToUpdate.getEmail());
			oldUser.setPhone(uToUpdate.getPhone());
			oldUser.setAddress(uToUpdate.getAddress());
			return this.ud.save(oldUser);
		}
		else {
			return null;
		}
	}
	
}
