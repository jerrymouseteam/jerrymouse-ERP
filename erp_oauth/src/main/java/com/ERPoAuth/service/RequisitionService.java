package com.ERPoAuth.service;

import com.ERPoAuth.model.Requisition;

public interface RequisitionService {

	public Requisition getPreFilledRequisitionFormDetails();

	public void saveRequisition(Requisition requisition);
}