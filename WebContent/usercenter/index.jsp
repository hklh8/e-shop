<%@page import="java.util.List"%>
<%@page import="com.hklh8.higou.entity.PageBean" import="com.hklh8.higou.entity.Order"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
<base href="${base}/" />
<title>个人中心_${site}</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
<link rel="stylesheet" type="text/css" href="css/index.css" />
<jsp:include page="../base.jsp" />
</head>
<body class="index">
	<div class="ucenter container">
		<jsp:include page="../header.jsp" />
		<jsp:include page="../navbar.jsp" />
		<jsp:include page="../search.jsp" />
		<div class="position">
			您当前的位置： <a href="">首页</a> » <a href="">我的账户</a>
		</div>
		<div class="wrapper clearfix">
			<jsp:include page="left.jsp" />
			<div class="main f_r">

				<div class="userinfo_bar">
					<b class="f14">您好，${sessionScope.user.name} 欢迎回来!</b>
				</div>
				<div class="box clearfix">
					<h3>用户信息</h3>
					<dl class="userinfo_box">
						<dt>
							<a class="ico"><img id="user_ico_img" src="${sessionScope.user.avatar eq null ? 'images/front/user_ico.gif':sessionScope.user.avatar}" width="100"
								height="100" alt="" /></a> <a
								class="blue" href="usercenter/user_avatar.jsp">修改头像</a>
						</dt>
						<dd>
							<table width="100%" cellpadding="0" cellspacing="0">
								<col width="350px" />
								<tr>
									<td>你的订单交易总数量：<b class="red2">${pageBean.totalNum} 笔</b>&nbsp;&nbsp;&nbsp;<a
										class="blue" href="order_userList">进入订单列表</a></td>
								</tr>
								<%
									PageBean<Order> pageBean = (PageBean<Order>)request.getAttribute("pageBean");
									List<Order> orders = pageBean.getData();
									int TotalConsumption = 0;
									for(Order order:orders){
										TotalConsumption+=order.getTotalMoney();
									}
									request.setAttribute("TotalConsumption", TotalConsumption);
								%>
								<tr>
									<td>总消费额：<b class="red2">￥${TotalConsumption}</b></td>
									
								</tr>
								<tr>
									<td>预存款余额：<b class="red2">￥${sessionScope.user.money}</b></td>
								</tr>
							</table>

							<div class="stat">
								<span>待付款订单：<label>(<b class="red2">0</b>)</label></span> 
								<span>待确认收货：<label>(<b class="red2">0</b>)</label></span>
							</div>
						</dd>
					</dl>
				</div>
				<h3 class="bg">我的订单</h3>
				<div class="box m_10">
					<table class="list_table" width="100%" cellpadding="0"
						cellspacing="0">
						<col width="140px" />
						<tr>
							<th>订单编号</th>
							<th>下单日期</th>
							<th>收货人</th>
							<th>支付方式</th>
							<th>总金额</th>
							<th>订单状态</th>
						</tr>
						<c:forEach items="${pageBean.data}" var="order">
						<tr>
							<td><a href="usercenter/order_view.jsp">${order.id}</a></td>
							<td><fmt:formatDate value="${order.orderTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${order.address.accept}</td>
							<td>${order.payType}</td>
							<td>￥${order.totalMoney}</td>
							<td><b class="orange">
								<c:if test="${order.status eq 1}">未付款</c:if>
								<c:if test="${order.status eq 2}">已付款</c:if>
								<c:if test="${order.status eq 3}">未发货</c:if>
								<c:if test="${order.status eq 4}">已发货</c:if>
								<c:if test="${order.status eq 5}">已完成</c:if>
							</b></td>
						</tr>
						</c:forEach>
						<!-- <tr>
							<td><a href="">20140712113941350735</a></td>
							<td>2014-07-12 11:39:41</td>
							<td>张三</td>
							<td>预存款支付</td>
							<td>￥1020.00</td>
							<td><b class="green">已完成</b></td>
						</tr>
						<tr>
							<td><a href="">20140712104153228540</a></td>
							<td>2014-07-12 10:41:53</td>
							<td>李四</td>
							<td>支付宝</td>
							<td>￥6018.00</td>
							<td><b class="orange">已取消</b></td>
						</tr> -->

						<tfoot>
							<tr>
								<td colspan="6" class="t_r"><a class="blue" href="order_userList">更多订单&gt;&gt;</a></td>
							</tr>
						</tfoot>
					</table>
				</div>
				
			</div>
		</div>
		<jsp:include page="../help.jsp" />
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>
