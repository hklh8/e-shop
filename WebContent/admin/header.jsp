<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="logo">
	<a href=""><img src="images/admin/logo.png" width="303" height="43" /></a>
</div>
<p>
	<a href="user_logout">退出管理</a> <a href="<%=request.getContextPath() %>/admin/">后台首页</a> <a href="" target='_blank'>商城首页</a>
	<span>您好 <label class='bold'>${user.name}</label>，当前身份 <label
		class='bold'>超级管理员</label></span>
</p>