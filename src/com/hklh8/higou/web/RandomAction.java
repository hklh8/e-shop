package com.hklh8.higou.web;

import java.io.ByteArrayInputStream;

import com.hklh8.higou.util.RandomNumUtil;
import com.opensymphony.xwork2.ActionContext;

public class RandomAction {
	private ByteArrayInputStream inputStream;
	
	public String execute(){
		RandomNumUtil util = RandomNumUtil.Instance();
		inputStream = util.getImage();
		ActionContext.getContext().getSession().put("vcode", util.getString());
		return "success";
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
}
