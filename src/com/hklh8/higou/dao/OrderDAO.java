package com.hklh8.higou.dao;

import java.util.List;
import java.util.Map;

import com.hklh8.higou.entity.Order;

public interface OrderDAO {
	public void addOrder(Order order);
	
	public List<Order> getOrders();
	
	public Order getOrderById(String id);
	
	public List<Order> getOrdersByUserPage(Map<String, Object> params);
	
	public int getOrderNum(String userId);
}
