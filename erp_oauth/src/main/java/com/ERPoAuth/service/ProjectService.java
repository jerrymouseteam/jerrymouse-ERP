package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.Project;

public interface ProjectService {

	Project findByProjectId(int projectId);

	Project findByProjectname(String projectName);

	void saveProject(Project project);

	void updateProject(Project project);

	void closeProject(String projectName);

	List<Project> findAllProjectss();

	List<Project> findClosedProjectss();

}