package com.jerrymouse.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jerrymouse.dao.UserDAO;
import com.jerrymouse.entity.ChallanDetails;
import com.jerrymouse.entity.EmpDetails;
import com.jerrymouse.entity.EmpLogin;
import com.jerrymouse.entity.EmployeeProjectJoin;
import com.jerrymouse.entity.MatRequi;
import com.jerrymouse.entity.Project;
import com.jerrymouse.entity.PurOrder;

public class UserDAOImpl implements UserDAO {
	// Injected database connection:
	@PersistenceContext
	private EntityManager em;

	public EmpLogin find(String username) {
		EmpLogin emp = null;
		try {
			Query query = em
					.createQuery("select empLogin from EmpLogin empLogin where empLogin.userNm = ?1");
			query.setParameter(1, username);
			emp = (EmpLogin) query.getSingleResult();
		} catch (NoResultException noResult) {
			emp = null;
		}
		return emp;
	}

	public EmpLogin findUsingEmpEmail(String empEmail) {
		EmpLogin emp = null;
		try {
			Query query = em
					.createQuery("select empDetails from EmpDetails empDetails where empDetails.empEmail = ?1");
			query.setParameter(1, empEmail);
			EmpDetails empDetails = (EmpDetails) query.getSingleResult();
			emp = empDetails.getEmpLogin();
		} catch (NoResultException noResult) {
			emp = null;
		}
		return emp;
	}

	public void persist(EmpLogin empLogin) {
		em.persist(empLogin);
	}

	public void update(EmpLogin empLogin) {

		System.out.println("size is : "
				+ empLogin.getEmpDetails().getEmployeeProjectJoins().size());
		for (EmployeeProjectJoin empProj : empLogin.getEmpDetails()
				.getEmployeeProjectJoins()) {
			System.out.println("shouls not get this" + empProj.getId());
		}
		em.merge(empLogin);

	}

	public Integer getSequenceValue(String seqName) {
		Query query = em.createNativeQuery("select sequence(?1) from dual");
		query.setParameter(1, seqName);
		return (Integer) query.getSingleResult();
	}

	public List<EmpDetails> searchUser(String name) {
		Query query = em
				.createQuery("select empDetails from EmpDetails empDetails where empDetails.firstNm like :name or empDetails.lastNm like :name or empDetails.midNm like :name");
		query.setParameter("name", "%" + name + "%");
		return query.getResultList();
	}

	public List<Project> getProjectList() {
		Query query = em.createQuery("select project from Project project");
		return (List<Project>) query.getResultList();
	}

	public Project getProject(String projectname, String projectSectName)
			throws NoResultException {
		Query query = em
				.createQuery("select project from Project project where project.projNm=:projectNm and project.projSect=:projectSectNm");
		query.setParameter("projectNm", projectname);
		query.setParameter("projectSectNm", projectSectName);
		return (Project) query.getSingleResult();
	}

	public void removeEmployeeProjectJoin(
			EmployeeProjectJoin employeeProjectJoin) {
		System.out.println("am ia ble to delete this : " + employeeProjectJoin);
		System.out.println(employeeProjectJoin.getProject());
		System.out.println(employeeProjectJoin.getEmpDetails());
		em.remove(employeeProjectJoin);

	}

	public void updateProject(Project project) {

		System.out.println("size is : "
				+ project.getEmployeeProjectJoins().size());
		for (EmployeeProjectJoin employeeProjectJoin : project
				.getEmployeeProjectJoins()) {
			System.out.println(employeeProjectJoin.getId());
		}
		em.merge(project);

	}

	public void addProject(Project project) {

		System.out.println("size is : " + project.getProjNm()
				+ project.getProjSect());

		em.persist(project);

	}

	public void addChallanDetails(ChallanDetails challanDetails) {

		em.persist(challanDetails);

	}

	public void deleteEmployee(EmpLogin employeeLogin) {

		em.remove(employeeLogin);

	}

	public EmpDetails findEmployeeByEmailId(String employeeEmail) {
		try {
			Query query = em
					.createQuery("select empDetails from EmpDetails empDetails where empDetails.empEmail = :email");
			query.setParameter("email", employeeEmail);
			return (EmpDetails) query.getSingleResult();
		} catch (NoResultException resultExc) {
			return null;
		}
	}

	public MatRequi findMatRequi(Long reqNo) {
		return em.find(MatRequi.class, reqNo);
	}

	public ChallanDetails findChallan(String challanNo) {
		return em.find(ChallanDetails.class, challanNo);
	}

	public void updateChallanDetails(ChallanDetails challanDetails) {
		em.merge(challanDetails);
	}

	public MatRequi updateMatRequi(MatRequi matRequi) {
		return em.merge(matRequi);
	}

	public void deleteMatRequi(MatRequi matRequi) {
		em.remove(matRequi);
	}

	public PurOrder findPurOrder(Long poNo) {
		return em.find(PurOrder.class, poNo);
	}

	public List<String> findEmployeeUserName(String userName) {
		Query query = em
				.createQuery("select empLogin from EmpLogin empLogin where empLogin.userNm like :name");
		query.setParameter("name", "%" + userName + "%");
		return query.getResultList();
	}
}
