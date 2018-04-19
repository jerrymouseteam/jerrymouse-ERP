package com.ERPoAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.AddressDao;
import com.ERPoAuth.model.Address;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao dao;

	@Override
	public Address findByAddressId(long addressId) {
		// TODO Auto-generated method stub
		return dao.findByAddressId(addressId);
	}

	@Override
	public void saveAddress(Address address) {
		// TODO Auto-generated method stub
		dao.saveAddress(address);
	}

	@Override
	public Address updateAddress(Address address) {
		// TODO Auto-generated method stub
		return dao.updateAddress(address);
	}

	@Override
	public void deleteAddress(Address address) {
		// TODO Auto-generated method stub
		dao.deleteAddress(address);
	}

}
