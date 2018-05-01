package com.ERPoAuth.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.ProjectRequisition;
import com.ERPoAuth.model.RequisitionItem;

@Repository("ProjectRequisitionDao")
public class ProjectRequisitionDaoImpl extends AbstractDao<Long, ProjectRequisition> implements ProjectRequisitionDao {

	final static Logger logger = Logger.getLogger(ProjectRequisitionDaoImpl.class);

	@Override
	public ProjectRequisition findProjectRequisitionById(long projectRequisitionId) {
		ProjectRequisition ProjectRequisition = getByKey(projectRequisitionId);
		if (ProjectRequisition != null) {
			return ProjectRequisition;
		}
		return null;
	}

	@Override
	public ProjectRequisition findProjectRequisitionByName(String projectRequisitionName) {
		logger.info("findProjectRequisitionByName : {}" + projectRequisitionName);
		Criteria crit = createEntityCriteria();
		// crit.add(Restrictions.eq("ProjectRequisitionName",
		// projectRequisitionName));
		ProjectRequisition ProjectRequisition = (ProjectRequisition) crit.uniqueResult();
		if (ProjectRequisition != null) {
			return ProjectRequisition;
		}
		return null;
	}

	@Override
	public void saveProjectRequisition(ProjectRequisition projectRequisition) {

		System.out.println("**************** saveProjectRequisition  projectRequisition" + projectRequisition);
		// Long l = saveEntity(projectRequisition);
		Session session = getOpenSession();
		Transaction tx = session.beginTransaction();
		Long id = null;
		try {

			List<RequisitionItem> lst=new ArrayList<>();
			//ProjectRequisition pr = new ProjectRequisition();
			projectRequisition.setProject(projectRequisition.getProject());
			//projectRequisition.setRequisitionCreatedDate(new Date());
			projectRequisition.setRequisitionUpdatedDate(new Date());
			
			System.out.println("pr.getRequisitionItems().size() "+projectRequisition.getRequisitionItems());

			if(projectRequisition.getRequisitionItems().size() > 0)
			{

				for (RequisitionItem r : projectRequisition.getRequisitionItems()) {
					r.setProjectRequisition(projectRequisition);
					lst.add(r);
				}
			}
			projectRequisition.setRequisitionItems(lst);
			

			id = (Long) session.save(projectRequisition);
			System.out.println("**************** Save Return Id " + id);
			tx.commit();
		} catch (Exception e) {
			
			tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}

	}

	@Override
	public ProjectRequisition updateProjectRequisition(ProjectRequisition projectRequisition) {
		
		System.out.println("**************** saveProjectRequisition  projectRequisition" + projectRequisition);
		// Long l = saveEntity(projectRequisition);
		Session session = getOpenSession();
		Transaction tx = session.beginTransaction();
		Long id = null;
		try {

			List<RequisitionItem> lst=new ArrayList<>();
			//ProjectRequisition pr = new ProjectRequisition();
			projectRequisition.setProject(projectRequisition.getProject());
			//projectRequisition.setRequisitionCreatedDate(new Date());
			projectRequisition.setRequisitionUpdatedDate(new Date());
			
			System.out.println("pr.getRequisitionItems().size() "+projectRequisition.getRequisitionItems());

			if(projectRequisition.getRequisitionItems().size() > 0)
			{

				for (RequisitionItem r : projectRequisition.getRequisitionItems()) {
					if(r.isChecked())
					{
						r.setProjectRequisition(projectRequisition);
						lst.add(r);
					}
					else
					{
						session.delete(r);
					}
					
				}
			}
			projectRequisition.setRequisitionItems(lst);
			

			 session.saveOrUpdate(projectRequisition);
			
			tx.commit();
		} catch (Exception e) {
			
			tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}
		return projectRequisition;
	}

	@Override
	public List<ProjectRequisition> findAllProjectRequisitions() {
		List<ProjectRequisition> projectRequisitions = null;
		try {
			Criteria criteria = createEntityCriteriaOpenSession();
			// criteria.addOrder(Order.asc("ProjectRequisitionName"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(50);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To
																			// avoid
																			// duplicates.

			projectRequisitions = (List<ProjectRequisition>) criteria.list();
			for (ProjectRequisition projectRequisition : projectRequisitions) {
				System.out.println("$$$ findAllProjectRequisitions : " + projectRequisition);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return projectRequisitions;
	}

	@Override
	public void deleteProjectRequisition(ProjectRequisition projectRequisition) {
		delete(projectRequisition);

	}

}
