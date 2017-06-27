package com.hrd.smey.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hrd.smey.model.User;
import com.hrd.smey.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	private UserRepository userrepository;
	@Autowired
	public UserServiceImpl(UserRepository userrepository) {
		this.userrepository=userrepository;
	}
	@Override
	public List<User> listdata() {
		
		return userrepository.listdata();
	}
	@Override
	public boolean save(User user) {
		String user_hash=UUID.randomUUID().toString();
		user.setUser_hash(user_hash);
		return userrepository.save(user);
	}
	@Override
	public boolean delete(String user_hash) {
		
		return userrepository.delete(user_hash);
	}
	@Override
	public boolean update(User user) {
	
		return userrepository.update(user);
	}
	@Override
	public User findOne(String user_hash) {
		
		return userrepository.findOne(user_hash);
	}

	@Override
	public int countmale() {
		return userrepository.countmale();
	}

	@Override
	public int countfemale() {
		
		return userrepository.countfemale();
	}
	




	
}
