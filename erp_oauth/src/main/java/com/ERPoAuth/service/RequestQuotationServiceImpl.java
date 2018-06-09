package com.ERPoAuth.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.RequestQuotationDao;
import com.ERPoAuth.dao.VendorDao;
import com.ERPoAuth.model.RequestQuotation;
import com.ERPoAuth.model.RequestQuotationWithProcedure;
import com.ERPoAuth.model.Vendor;

@Service("requestQuotationService")
@Transactional
public class RequestQuotationServiceImpl implements RequestQuotationService {

	@Autowired
	private RequestQuotationDao requestQuotationDao;

	

	@Override
	public RequestQuotation findByRequestQuotationId(long requestQuotationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRequestQuotation(RequestQuotation requestQuotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RequestQuotation updateRequestQuotation(RequestQuotation requestQuotation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestQuotation> findAllRequestQuotations() throws Exception {
		
		return requestQuotationDao.findAllRequestQuotations();
	}

	@Override
	public void deleteRequestQuotation(RequestQuotation requestQuotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createQuotationWithProc(RequestQuotationWithProcedure requestQuotationWithProcedure)
			throws SQLException {
		requestQuotationDao.createQuotationWithProc(requestQuotationWithProcedure);
		
	}

	
}
