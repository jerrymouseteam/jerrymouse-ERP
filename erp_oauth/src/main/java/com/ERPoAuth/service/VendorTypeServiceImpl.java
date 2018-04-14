package com.ERPoAuth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.VendorTypeDao;
import com.ERPoAuth.model.VendorType;
import com.ERPoAuth.model.VendorTypeForm;



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
		
		/*System.out.println("================= VendorTypeServiceImpl - findAllVendorTypes ====================");
		List<VendorType> VendorTypeList=dao.findAllVendorTypes();
		List<VendorTypeForm> vendorTypeFormList=new ArrayList<>();
		for(VendorType v:VendorTypeList)
		{
			System.out.println("================= VendorTypeServiceImpl - findAllVendorTypes ==================== VendorType : "+v);
			VendorTypeForm vendorTypeForm=new VendorTypeForm();
			vendorTypeForm.setVendorTypeId(v.getId());
			vendorTypeForm.setVendorTypeName(v.getName());
			vendorTypeFormList.add(vendorTypeForm);
		}*/
		return dao.findAllVendorTypes();
	}

	@Override
	public void deleteVendorType(VendorType vendorType) {
		// TODO Auto-generated method stub
		dao.deleteVendorType(vendorType);
	}

	
	



}
