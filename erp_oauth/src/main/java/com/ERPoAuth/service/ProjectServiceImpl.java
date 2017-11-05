package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.ProjectDao;
import com.ERPoAuth.model.Project;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao dao;

	public Project findByProjectId(int projectId) {
		return dao.findByProjectid(projectId);
	}

	public Project findByProjectname(String projectName) {
		Project project = dao.findByProjectname(projectName);
		return project;
	}

	public void saveProject(Project project) {
		dao.save(project);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateProject(Project project) {
		Project entity = dao.findByProjectid(project.getProject_id());
		if (entity != null) {
			// please add setter methods here :)

		}
	}

	public void closeProject(String projectName) {
		dao.closeProject(projectName);
	}

	public List<Project> findAllProjectss() {
		return dao.findAllProjects();
	}

	@Override
	public List<Project> findClosedProjectss() {
		return dao.findClosedProjects();
	}

}
