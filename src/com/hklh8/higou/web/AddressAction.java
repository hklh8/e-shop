package com.hklh8.higou.web;

import java.util.List;

import com.hklh8.higou.entity.Address;
import com.hklh8.higou.entity.User;
import com.hklh8.higou.service.AddressService;
import com.opensymphony.xwork2.ActionContext;

public class AddressAction {
	private Address address;
	private AddressService addressService;
	
	public String add(){
		String userId = ((User)ActionContext.getContext().getSession().get("user")).getId();
		address.setUserId(userId);
		addressService.addAddress(address);
		return "oprsuc";
	}
	
	private List<Address> addresses;
	public String list(){
		String userId = ((User)ActionContext.getContext().getSession().get("user")).getId();
		addresses = addressService.getAddress(userId);
		return "list";
	}
	
	public String setDefault(){
		String userId = ((User)ActionContext.getContext().getSession().get("user")).getId();
		address.setUserId(userId);
		addressService.setDefault(address);
		return "oprsuc";
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
}
