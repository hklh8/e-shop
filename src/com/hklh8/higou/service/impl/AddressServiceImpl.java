package com.hklh8.higou.service.impl;

import java.util.List;

import com.hklh8.higou.dao.AddressDAO;
import com.hklh8.higou.entity.Address;
import com.hklh8.higou.service.AddressService;
import com.hklh8.higou.util.HigouUtil;

public class AddressServiceImpl implements AddressService {

	private AddressDAO addressDAO;
	
	@Override
	public void addAddress(Address address) {
		address.setId(HigouUtil.getId());
		if(address.getIsDefault()==null){
			address.setIsDefault("2");
		}else{
			addressDAO.setNotDefault(address.getUserId());
		}
		addressDAO.addAddress(address);
	}

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	@Override
	public List<Address> getAddress(String userId) {
		return addressDAO.getAddress(userId);
	}

	@Override
	public void setDefault(Address address) {
		addressDAO.setNotDefault(address.getUserId());
		if(address.getIsDefault().equals("1")){
			addressDAO.setDefault(address.getId());
		}
	}

}
