package com.hrd.smey.service;

import java.util.List;

import com.hrd.smey.model.User;

public interface UserService {
	List<User> listdata();
	public int countmale();
	public int countfemale();
	public boolean save(User user);
	public boolean delete(String user_hash);
	public boolean update(User user);
	public User findOne(String user_hash);

}
