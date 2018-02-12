package com.ERPoAuth.dao;

import com.ERPoAuth.model.Address;

public interface AddressDao {

	Address findByAddressId(long addressId);

	//Vendor findByVendorName(String vendorName);

	void saveAddress(Address address);

	Address updateAddress(Address address);

	//List<Vendor> findAllVendors();

	void deleteAddress(Address address);

	

}
