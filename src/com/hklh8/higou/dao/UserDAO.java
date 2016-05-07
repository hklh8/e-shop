package com.hklh8.higou.dao;

import com.hklh8.higou.entity.User;

public interface UserDAO {
	public void addUser(User user);
	
	public User getUserByNameAndPassword(String name,String password);
	
	public void updateAvatar(String id,String avatar);
	
	public int getNumByName(String name);
}
