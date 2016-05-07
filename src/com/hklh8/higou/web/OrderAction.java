package com.hklh8.higou.web;

import java.util.List;

import com.hklh8.higou.entity.Address;
import com.hklh8.higou.entity.Goods;
import com.hklh8.higou.entity.Order;
import com.hklh8.higou.entity.OrderDetail;
import com.hklh8.higou.entity.PageBean;
import com.hklh8.higou.entity.User;
import com.hklh8.higou.service.AddressService;
import com.hklh8.higou.service.GoodsService;
import com.hklh8.higou.service.OrderService;
import com.opensymphony.xwork2.ActionContext;

public class OrderAction {
	private AddressService addressService;
	private GoodsService goodsService;
	private List<Address> addresses;
	private List<OrderDetail> orderDetails;
	
	public String add(){
		String userId = ((User)ActionContext.getContext().getSession().get("user")).getId();
		addresses=addressService.getAddress(userId);
		
		for (OrderDetail orderDetail : orderDetails) {
			orderDetail.setGoods(goodsService.getGoodsById(orderDetail.getGoodsId()));
		}
		return "add";
	}
	
	
	private Order order;
	private OrderService orderService;
	public String submit(){
		String userId = ((User)ActionContext.getContext().getSession().get("user")).getId();
		order.setUserId(userId);
		orderService.addOrder(order, orderDetails);
		return "submit";
	}
	
	private List<Order> orders;
	public String list(){
		orders = orderService.getOrders();
		return "list";
	}
	
	private PageBean<Order> pageBean;
	private int page;
	public String userList(){
		String userId = ((User)ActionContext.getContext().getSession().get("user")).getId();
		if (page == 0) {
			page = 1;
		}
		pageBean = orderService.getOrderByPage(page, userId, order);
		return "userList";
	}
	
	public String view(){
		order = orderService.getOrderById(order.getId());
		return "view";
	}
	
	public AddressService getAddressService() {
		return addressService;
	}
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public GoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean<Order> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<Order> pageBean) {
		this.pageBean = pageBean;
	}
}
