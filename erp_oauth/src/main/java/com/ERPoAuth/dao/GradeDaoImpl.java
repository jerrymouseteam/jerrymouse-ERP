package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Grade;
import com.ERPoAuth.model.Item;

@Repository("gradeDao")
public class GradeDaoImpl extends AbstractDao<Long, Grade> implements GradeDao {

	final static Logger logger = Logger.getLogger(GradeDaoImpl.class);

	@Override
	public Grade findGradeById(long gradeId) {
		Grade grade = getByKey(gradeId);
		if (grade != null) {
			return grade;
		}
		return null;
	}

	@Override
	public Grade findGradeByName(String gradeName) {
		logger.info("findGradeByName : {}" + gradeName);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("gradeName", gradeName));
		Grade grade = (Grade) crit.uniqueResult();
		if (grade != null) {
			return grade;
		}
		return null;
	}

	@Override
	public void saveGrade(Grade grade) {
		Long l = saveEntity(grade);

	}

	@Override
	public Grade updateGrade(Grade grade) {
		return merge(grade);
	}

	@Override
	public List<Grade> findAllGrades() {
		
		Criteria criteria = createEntityCriteriaOpenSession();
		criteria.addOrder(Order.asc("gradeName"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(50);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.

		List<Grade> grades = (List<Grade>) criteria.list();
		return grades;
	}

	@Override
	public void deleteGrade(Grade grade) {
		delete(grade);

	}

}
