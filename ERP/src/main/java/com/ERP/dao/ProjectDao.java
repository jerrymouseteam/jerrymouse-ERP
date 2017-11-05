package com.ERP.dao;

import java.util.List;

import com.ERP.model.Project;


public interface ProjectDao {

	Project findByProjectid(int projectId);
	
	Project findByProjectname(String projectName);
	
	void save(Project Project);
	
	void closeProject(String projectName);
	
	List<Project> findAllProjects();

}

