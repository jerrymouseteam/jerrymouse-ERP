package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.VendorDao;
import com.ERPoAuth.model.Vendor;

@Service("vendorService")
@Transactional
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorDao dao;

	@Override
	public Vendor findByVendorId(long vendorId) {
		// TODO Auto-generated method stub
		return dao.findByVendorId(vendorId);
	}

	@Override
	public Vendor findByVendorName(String vendorName) {
		// TODO Auto-generated method stub
		return dao.findByVendorName(vendorName);
	}

	@Override
	public void saveVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		dao.saveVendor(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return dao.updateVendor(vendor);
	}

	@Override
	public List<Vendor> findAllVendors() {
		// TODO Auto-generated method stub
		return dao.findAllVendors();
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		dao.deleteVendor(vendor);
	}

	
}
