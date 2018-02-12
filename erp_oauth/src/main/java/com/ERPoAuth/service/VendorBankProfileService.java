package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.VendorBankProfile;

public interface VendorBankProfileService {

	VendorBankProfile findByVendorBankProfileId(long VendorBankProfileId);

	void saveVendorBankProfile(VendorBankProfile vendorBankProfile);

	VendorBankProfile updateVendorBankProfile(VendorBankProfile vendorBankProfile);

	List<VendorBankProfile> findAllVendorBankProfiles();

	void deleteVendorBankProfile(VendorBankProfile vendorBankProfile);

	

}
