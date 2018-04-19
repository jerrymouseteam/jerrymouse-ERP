package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Unit;

@Repository("unitDao")
public class UnitDaoImpl extends AbstractDao<Long, Unit> implements UnitDao {

	final static Logger logger = Logger.getLogger(UnitDaoImpl.class);

	@Override
	public Unit findUnitById(long unitId) {
		Unit unit = getByKey(unitId);
		if (unit != null) {
			return unit;
		}
		return null;
	}

	@Override
	public Unit findUnitByName(String unitName) {
		logger.info("findUnitByName : {}" + unitName);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("unitName", unitName));
		Unit unit = (Unit) crit.uniqueResult();
		if (unit != null) {
			return unit;
		}
		return null;
	}

	@Override
	public void saveUnit(Unit unit) {
		Long l = saveEntity(unit);

	}

	@Override
	public Unit updateUnit(Unit unit) {
		return merge(unit);
	}

	@Override
	public List<Unit> findAllUnits() {
		
		Criteria criteria = createEntityCriteriaOpenSession();
		criteria.addOrder(Order.asc("unitName"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(50);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.

		List<Unit> units = (List<Unit>) criteria.list();
		return units;
	}

	@Override
	public void deleteUnit(Unit unit) {
		delete(unit);

	}

}
