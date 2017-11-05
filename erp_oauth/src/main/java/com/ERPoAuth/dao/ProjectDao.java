package com.ERPoAuth.dao;

import java.util.List;

import com.ERPoAuth.model.Project;


public interface ProjectDao {

	Project findByProjectid(int projectId);
	
	Project findByProjectname(String projectName);
	
	void save(Project Project);
	
	void closeProject(String projectName);
	
	List<Project> findAllProjects();

	List<Project> findClosedProjects();

}

