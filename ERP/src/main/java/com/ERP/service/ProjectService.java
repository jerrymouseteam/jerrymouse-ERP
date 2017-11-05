package com.ERP.service;

import java.util.List;

import com.ERP.model.Project;
import com.ERP.model.User;


public interface ProjectService {
	
	Project findByProjectId(int projectId);
	
	Project findByProjectname(String projectName);
	
	void saveProject(Project project);
	
	void updateProject(Project project);
	
	void closeProject(String projectName);

	List<Project> findAllProjectss(); 
	
	

}