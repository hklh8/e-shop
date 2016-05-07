package com.hklh8.higou.service;

import com.hklh8.higou.entity.User;

public interface UserService {
	public void register(User user);
	
	public User login(String name,String password);
	
	public boolean isExist(String name);
	
	public void updateAvatar(String id,String avatar);
}
