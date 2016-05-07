package com.hklh8.higou.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.hklh8.higou.entity.User;
import com.hklh8.higou.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	
	private UserService userService;
	private User user;
	private File avatar;
	private String avatarFileName;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String reg(){
		userService.register(user);
		return "regsuc";
	}
	
	public String login(){
		User u = userService.login(user.getName(), user.getPassword());
		if(u==null){
			return "loginfail";
		}else{
			Map<String,Object> m = ActionContext.getContext().getSession();
			m.put("user", u);
			return "loginsuc";
		
		}
	}
	
	private String captcha;
	private String msg;
	public String adminLogin(){
		String vcode = ActionContext.getContext().getSession().get("vcode").toString();
		if(!vcode.equalsIgnoreCase(captcha)){
			msg = "验证码错误！";
			return "adminlogin";
		}
		User u = userService.login(user.getName(), user.getPassword());
		if(u==null){
			msg="用户名或密码错误！";
			return "adminlogin";
		}
		if(!u.getRole().equals("a")){
			msg = "权限不足！";
			return "adminlogin";
		}
		Map<String,Object> m = ActionContext.getContext().getSession();
		m.put("user", u);
		return "adminindex";
	}
	
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
	
	public String uploadAvatar(){
		String userId = ((User)ActionContext.getContext().getSession().get("user")).getId();
		String dir = ServletActionContext.getServletContext().getRealPath("/useravatars");
		String suffix = "";
		if(avatar!=null){
			suffix = avatarFileName.substring(avatarFileName.lastIndexOf("."));
			File savaFile = new File(new File(dir),userId+suffix);
			if(!savaFile.getParentFile().exists()){
				savaFile.getParentFile().mkdir();
			}
			try {
				FileUtil.copyFile(avatar, savaFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		userService.updateAvatar(userId, "useravatars/"+userId+suffix);
		((User)ActionContext.getContext().getSession().get("user")).setAvatar("useravatars/"+userId+suffix);
		return "usercenter";
	}
	
	public void isExist(){
		boolean isExist = userService.isExist(user.getName());
		try {
			PrintWriter w=ServletActionContext.getResponse().getWriter();
			w.print(isExist);
			w.flush();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getAvatar() {
		return avatar;
	}

	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}

	public String getAvatarFileName() {
		return avatarFileName;
	}

	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
