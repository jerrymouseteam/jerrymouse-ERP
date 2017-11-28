package com.ERPoAuth.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Project;

@Repository("projectDao")
public class ProjectDaoImpl extends AbstractDao<Integer, Project> implements
		ProjectDao {

	final static Logger logger = Logger.getLogger(ProjectDaoImpl.class);

	public Project findByProjectid(int projectId) {
		Project project = getByKey(projectId);
		if (project != null) {
			return project;
		}
		return null;
	}

	public Project findByProjectname(String projectName) {
		logger.info("ProjectName : {}" + projectName);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("projectName", projectName));
		Project project = (Project) crit.uniqueResult();
		if (project != null) {
			return project;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Project> findAllProjects() {
		Criteria criteria = createEntityCriteria().addOrder(
				Order.asc("projectName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.
		List<Project> projects = (List<Project>) criteria.list();
		return projects;
	}

	public void save(Project project) {
		persist(project);
	}

	public void closeProject(String projectName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("projectName", projectName));
		Project project = (Project) crit.uniqueResult();
		delete(project);
	}

	@Override
	public List<Project> findClosedProjects() {
		Calendar cl = Calendar.getInstance();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Criteria criteria = createEntityCriteria().addOrder(
				Order.asc("projectName")).add(
				Restrictions.lt("endDate", cl.getTime()));

		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.
		List<Project> projects = (List<Project>) criteria.list();
		return projects;
	}

	@Override
	public Project updateProject(Project project) {
		return merge(project);
	}

}
