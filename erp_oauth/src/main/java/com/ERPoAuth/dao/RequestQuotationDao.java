package com.ERPoAuth.dao;

import java.sql.SQLException;
import java.util.List;

import com.ERPoAuth.model.RequestQuotation;
import com.ERPoAuth.model.RequestQuotationWithProcedure;
import com.ERPoAuth.model.Vendor;

public interface RequestQuotationDao {

	Vendor findByRequestQuotationId(long requestQuotationId);

	

	void saveRequestQuotation(RequestQuotation requestQuotation);

	RequestQuotation updateVendor(RequestQuotation requestQuotation);

	List<RequestQuotation> findAllRequestQuotations() throws Exception;

	void deleteRequestQuotation(RequestQuotation requestQuotation);
	
	public void createQuotationWithProc(RequestQuotationWithProcedure requestQuotationWithProcedure) throws SQLException;

	

}
