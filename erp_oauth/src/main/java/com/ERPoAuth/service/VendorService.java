package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.Vendor;

public interface VendorService {

	Vendor findByVendorId(long vendorId);

	Vendor findByVendorName(String vendorName);

	void saveVendor(Vendor vendor);

	Vendor updateVendor(Vendor vendor);

	List<Vendor> findAllVendors() throws Exception;

	void deleteVendor(Vendor vendor);

	

}
