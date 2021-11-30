package com.example.demo.Pojo;

public class User {
	private int id;
	private static int idCounter = 0;
	private String name, phone, email, address;

	public User(String name, String phone, String email, String address) {
		super();
		User.idCounter = User.idCounter + 1;
		this.id = User.idCounter;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		System.out.println("Constructor-1-"+this.id);
	}
	
	public User() {
		super();
	}
	
	public User(int id,String name, String phone, String email, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		System.out.println("Constructor-2");
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ "]";
	}

	
	
	
}
