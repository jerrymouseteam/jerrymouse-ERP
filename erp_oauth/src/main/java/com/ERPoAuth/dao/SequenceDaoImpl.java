package com.ERPoAuth.dao;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Project;

@Repository("sequenceDao")
public class SequenceDaoImpl extends AbstractDao<Integer, Project> implements
		SequenceDao {

	final static Logger logger = Logger.getLogger(SequenceDaoImpl.class);

	@Override
	public Integer getSequenceValue(String seqName) {
		Query query = (Query) getSession().createSQLQuery(
				"select sequence(?1) from dual");
		query.setParameter(1, seqName);
		return (Integer) query.getSingleResult();
	}

}
