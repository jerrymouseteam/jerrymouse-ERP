package com.ERPoAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.RequisitionDao;
import com.ERPoAuth.dao.SequenceDao;
import com.ERPoAuth.model.Requisition;

@Service("requisitionService")
@Transactional
public class RequisitionServiceImpl implements RequisitionService {

	@Autowired
	private RequisitionDao requisitionDao;

	@Autowired
	private SequenceDao sequenceDao;

	@Override
	public Requisition getPreFilledRequisitionFormDetails() {
		Requisition requisition = new Requisition();
		requisition.setReqNo(sequenceDao.getSequenceValue("requisition_seq")
				.longValue());
		return requisition;
	}

	@Override
	public void saveRequisition(Requisition requisition) {
		requisitionDao.save(requisition);
	}
}
