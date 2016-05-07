package com.hklh8.higou.service.impl;

import com.hklh8.higou.dao.UserDAO;
import com.hklh8.higou.entity.User;
import com.hklh8.higou.service.UserService;
import com.hklh8.higou.util.HigouUtil;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Override
	public void register(User user) {
		user.setId(HigouUtil.getId());
		user.setRegTime(HigouUtil.getNow());
		user.setRole("u");
		userDAO.addUser(user);
	}

	@Override
	public User login(String name, String password) {
		return userDAO.getUserByNameAndPassword(name, password);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean isExist(String name) {
		int num = userDAO.getNumByName(name);
		return num!=0;
	}

	@Override
	public void updateAvatar(String id, String avatar) {
		userDAO.updateAvatar(id, avatar);	
	}

}
