package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Pojo.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
