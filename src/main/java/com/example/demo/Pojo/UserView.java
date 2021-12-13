package com.example.demo.Pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "userview")
public class UserView {
	
	@Id
	private int uid;
	
	private String user_name, user_email, user_phone, user_address;

	public int getUid() {
		return uid;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

}
