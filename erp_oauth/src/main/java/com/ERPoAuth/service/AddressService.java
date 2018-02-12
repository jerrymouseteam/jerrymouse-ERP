package com.ERPoAuth.service;

import com.ERPoAuth.model.Address;

public interface AddressService {

	Address findByAddressId(long addressId);

	//Vendor findByVendorName(String vendorName);

	void saveAddress(Address address);

	Address updateAddress(Address address);

	//List<Vendor> findAllVendors();

	void deleteAddress(Address address);

	

}
