package com.ERPoAuth.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Requisition;

@Repository("requisitionDao")
public class RequisitionDaoImpl extends AbstractDao<Integer, Requisition>
		implements RequisitionDao {

	final static Logger logger = Logger.getLogger(RequisitionDaoImpl.class);

	@Override
	public void save(Requisition requisition) {
		persist(requisition);

	}

}
