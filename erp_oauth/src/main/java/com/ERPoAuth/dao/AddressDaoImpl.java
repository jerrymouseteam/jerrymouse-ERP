package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Address;
import com.ERPoAuth.model.Vendor;

@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao<Long, Address> implements AddressDao {

	final static Logger logger = Logger.getLogger(AddressDaoImpl.class);

	@Override
	public Address findByAddressId(long addressId) {
		Address address = getByKey(addressId);
		if (address != null) {
			return address;
		}
		return null;
	}

	

	@Override
	public void saveAddress(Address address) {
		persist(address);

	}

	@Override
	public Address updateAddress(Address address) {
		return merge(address);
	}

	
	@Override
	public void deleteAddress(Address address) {
		// TODO Auto-generated method stub
		delete(address);
	}

}
