package com.ERPoAuth.dao;

import java.util.List;

import com.ERPoAuth.model.Vendor;
import com.ERPoAuth.model.VendorBankProfile;

public interface VendorBankProfileDao {

	VendorBankProfile findByvendorBankProfileId(long vendorBankProfileId);

	void saveVendorBankProfile(VendorBankProfile vendorBankProfile);

	VendorBankProfile updateVendorBankProfile(VendorBankProfile vendorBankProfile);

	List<VendorBankProfile> findAllVendorBankProfiles();

	void deleteVendorBankProfile(VendorBankProfile vendorBankProfile);

}
