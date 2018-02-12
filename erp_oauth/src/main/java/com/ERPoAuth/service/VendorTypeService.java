package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;
import com.ERPoAuth.model.VendorType;

public interface VendorTypeService {

	VendorType findByVendorTypeId(long bankId);

	VendorType findByVendorTypeName(String bankName);

	void saveVendorType(VendorType bank);

	VendorType updateVendorType(VendorType bank);

	List<VendorType> findAllVendorTypes();

	void deleteVendorType(VendorType vendorType);
}
