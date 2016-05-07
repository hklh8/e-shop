package com.hklh8.higou.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hklh8.higou.dao.OrderDAO;
import com.hklh8.higou.dao.OrderDetailDAO;
import com.hklh8.higou.entity.Goods;
import com.hklh8.higou.entity.Order;
import com.hklh8.higou.entity.OrderDetail;
import com.hklh8.higou.entity.PageBean;
import com.hklh8.higou.service.OrderService;
import com.hklh8.higou.util.HigouUtil;

public class OrderServiceImpl implements OrderService {
	
	private OrderDAO orderDAO;
	private OrderDetailDAO orderDetailDAO;
	
	@Override
	public void addOrder(Order order, List<OrderDetail> orderDetails) {
		order.setId(HigouUtil.getId());
		order.setOrderTime(new Date());
		order.setStatus("1");
		
		orderDAO.addOrder(order);
		
		for (OrderDetail orderDetail : orderDetails) {
			orderDetail.setId(HigouUtil.getId());
			orderDetail.setOrderId(order.getId());
			orderDetailDAO.addOrderDetail(orderDetail);
		}
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public OrderDetailDAO getOrderDetailDAO() {
		return orderDetailDAO;
	}

	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}

	@Override
	public List<Order> getOrders() {
		return orderDAO.getOrders();
	}

	@Override
	public Order getOrderById(String id) {
		return orderDAO.getOrderById(id);
	}

//	@Override
//	public List<Order> getOrdersByUserId(String userId) {
//		return orderDAO.getOrdersByUserId(userId);
//	}

	@Override
	public PageBean<Order> getOrderByPage(int page,String userId, Order order) {
		int pageSize = 3;
		int startNum = (page-1)*pageSize;
		PageBean<Order> pageBean = new PageBean<>();
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("page", page);
		params.put("pageSize", pageSize);
		params.put("order", order);
		params.put("startNum", startNum);
		
		List<Order> data = orderDAO.getOrdersByUserPage(params);
		
		pageBean.setData(data);
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		pageBean.setActualPageSize(data.size());
		int totalNum = orderDAO.getOrderNum(userId);
		pageBean.setTotalNum(totalNum);
		int totalPage = (totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

}
