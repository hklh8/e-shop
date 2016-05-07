package com.hklh8.higou.service;

import java.util.List;

import com.hklh8.higou.entity.Address;

public interface AddressService {
	public void addAddress(Address address);
	
	public List<Address> getAddress(String userId);
	
	public void setDefault(Address address);
}
