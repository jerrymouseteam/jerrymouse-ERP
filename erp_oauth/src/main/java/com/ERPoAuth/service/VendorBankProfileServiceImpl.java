package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.BankDao;
import com.ERPoAuth.dao.ProjectDao;
import com.ERPoAuth.dao.VendorBankProfileDao;
import com.ERPoAuth.dao.VendorDao;
import com.ERPoAuth.dao.VendorTypeDao;
import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;
import com.ERPoAuth.model.Vendor;
import com.ERPoAuth.model.VendorBankProfile;
import com.ERPoAuth.model.VendorType;

@Service("vendorBankProfileService")
@Transactional
public class VendorBankProfileServiceImpl implements VendorBankProfileService {

	@Autowired
	private VendorBankProfileDao dao;

	

	@Override
	public void saveVendorBankProfile(VendorBankProfile vendorBankProfile) {
		dao.saveVendorBankProfile(vendorBankProfile);

	}

	@Override
	public VendorBankProfile updateVendorBankProfile(VendorBankProfile vendorBankProfile) {
		// TODO Auto-generated method stub
		return dao.updateVendorBankProfile(vendorBankProfile);
	}

	@Override
	public List<VendorBankProfile> findAllVendorBankProfiles() {
		// TODO Auto-generated method stub
		return dao.findAllVendorBankProfiles();
	}

	@Override
	public void deleteVendorBankProfile(VendorBankProfile vendorBankProfile) {
		// TODO Auto-generated method stub
		dao.deleteVendorBankProfile(vendorBankProfile);

	}

	@Override
	public VendorBankProfile findByVendorBankProfileId(long VendorBankProfileId) {
		return dao.findByvendorBankProfileId(VendorBankProfileId);
	}

}
