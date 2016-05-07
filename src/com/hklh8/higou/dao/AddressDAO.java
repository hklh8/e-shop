package com.hklh8.higou.dao;

import java.util.List;

import com.hklh8.higou.entity.Address;

public interface AddressDAO {
	
	public void addAddress(Address address);
	
	public List<Address> getAddress(String userId);
	
	public void setDefault(String id);
	
	public void setNotDefault(String userId);
}
