package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.BankDao;
import com.ERPoAuth.dao.ProjectDao;
import com.ERPoAuth.dao.VendorTypeDao;
import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;
import com.ERPoAuth.model.VendorType;

@Service("vendorTypeService")
@Transactional
public class VendorTypeServiceImpl implements VendorTypeService {

	@Autowired
	private VendorTypeDao dao;

	@Override
	public VendorType findByVendorTypeId(long vendorTypeId) {
		// TODO Auto-generated method stub
		return dao.findByVendorTypeId(vendorTypeId);
	}

	@Override
	public VendorType findByVendorTypeName(String bankName) {
		// TODO Auto-generated method stub
		return dao.findByVendorTypeName(bankName);
	}

	@Override
	public void saveVendorType(VendorType bank) {
		// TODO Auto-generated method stub
		
		dao.saveVendorType(bank);
		
	}

	@Override
	public VendorType updateVendorType(VendorType bank) {
		// TODO Auto-generated method stub
		return dao.updateVendorType(bank);
	}

	@Override
	public List<VendorType> findAllVendorTypes() {
		// TODO Auto-generated method stub
		return dao.findAllVendorTypes();
	}

	@Override
	public void deleteVendorType(VendorType vendorType) {
		// TODO Auto-generated method stub
		dao.deleteVendorType(vendorType);
	}

	
	



}
