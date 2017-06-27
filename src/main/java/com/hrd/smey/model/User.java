package com.hrd.smey.model;

public class User {
	private int id;
	private String name;
	private String gender;
	private int age;
	private String email;
	private String user_hash;
	public User(){
		super();
	}
	
	public User(int id, String name, String gender, int age, String email, String user_hash) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.user_hash = user_hash;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_hash() {
		return user_hash;
	}
	public void setUser_hash(String user_hash) {
		this.user_hash = user_hash;
	}
	
}
