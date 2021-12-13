package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Pojo.UserView;

public interface UserViewDao extends JpaRepository<UserView, Integer>{
	
//	JPQL:
	@Query("SELECT u FROM UserView u WHERE u.user_email=?1")
//	SQL: SELECT * FROM table_name WHERE column_name='some email';
	public UserView findByEmail(String email);
}
