package com.ERPoAuth.dao;

import java.util.List;

import com.ERPoAuth.model.VendorType;

public interface VendorTypeDao {

	VendorType findByVendorTypeId(long bankId);

	VendorType findByVendorTypeName(String bankName);

	void saveVendorType(VendorType bank);

	VendorType updateVendorType(VendorType bank);

	List<VendorType> findAllVendorTypes();

	void deleteVendorType(VendorType vendorType);

	

}
