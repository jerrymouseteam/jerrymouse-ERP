package com.jerrymouse.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jerrymouse.entity.ChallanDetails;
import com.jerrymouse.entity.EmpDetails;
import com.jerrymouse.entity.EmpLogin;
import com.jerrymouse.entity.EmployeeProjectJoin;
import com.jerrymouse.entity.MatRequi;
import com.jerrymouse.entity.Project;
import com.jerrymouse.entity.PurOrder;

@Component
public interface UserDAO {

	public EmpLogin find(String username);

	public EmpLogin findUsingEmpEmail(String empEmail);

	public void persist(EmpLogin empLogin);

	public void update(EmpLogin empLogin);

	public void addProject(Project project);

	public void addChallanDetails(ChallanDetails challanDetails);

	public void updateChallanDetails(ChallanDetails challanDetails);

	public void updateProject(Project project);

	public void removeEmployeeProjectJoin(
			EmployeeProjectJoin employeeProjectJoin);

	public Integer getSequenceValue(String seqName);

	public List<EmpDetails> searchUser(String name);

	public List<Project> getProjectList();

	public Project getProject(String projectname, String projectSectName);

	public void deleteEmployee(EmpLogin employeeLogin);

	public EmpDetails findEmployeeByEmailId(String employeeEmail);

	public PurOrder findPurOrder(Long poNo);

	public MatRequi findMatRequi(Long reqNo);

	public ChallanDetails findChallan(String challanNo);

	public MatRequi updateMatRequi(MatRequi matRequi);

	public void deleteMatRequi(MatRequi matRequi);

	public List<String> findEmployeeUserName(String userName);
}
