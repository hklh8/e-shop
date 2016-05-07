package com.hklh8.higou.service;

import java.util.List;

import com.hklh8.higou.entity.Goods;
import com.hklh8.higou.entity.Order;
import com.hklh8.higou.entity.OrderDetail;
import com.hklh8.higou.entity.PageBean;

public interface OrderService {
	public void addOrder(Order order,List<OrderDetail> orderDetails);
	
	public List<Order> getOrders();
	
	public Order getOrderById(String id);
	
	//public List<Order> getOrdersByUserId(String userId);
	
	public PageBean<Order> getOrderByPage(int page,String userId, Order order);
}
