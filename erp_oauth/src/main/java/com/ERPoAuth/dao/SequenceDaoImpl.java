package com.ERPoAuth.dao;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Project;

@Repository("sequenceDao")
public class SequenceDaoImpl extends AbstractDao<Integer, Project> implements
		SequenceDao {

	final static Logger logger = Logger.getLogger(SequenceDaoImpl.class);

	@Override
	public Integer getSequenceValue(String seqName) {
		SQLQuery query = getSession().createSQLQuery(
				"select sequence(:name) from dual");
		query.setParameter("name", seqName);
		return (Integer) query.uniqueResult();
	}

}
