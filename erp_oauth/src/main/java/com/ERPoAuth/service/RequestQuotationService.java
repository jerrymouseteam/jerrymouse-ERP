package com.ERPoAuth.service;

import java.sql.SQLException;
import java.util.List;

import com.ERPoAuth.model.RequestQuotation;
import com.ERPoAuth.model.RequestQuotationWithProcedure;

public interface RequestQuotationService {

	RequestQuotation findByRequestQuotationId(long requestQuotationId);

	

	void saveRequestQuotation(RequestQuotation requestQuotation);

	RequestQuotation updateRequestQuotation(RequestQuotation requestQuotation);

	List<RequestQuotation> findAllRequestQuotations() throws Exception;

	void deleteRequestQuotation(RequestQuotation requestQuotation);

	public void createQuotationWithProc(RequestQuotationWithProcedure requestQuotationWithProcedure) throws SQLException;

}
