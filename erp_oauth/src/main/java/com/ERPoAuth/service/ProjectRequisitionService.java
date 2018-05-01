package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.ProjectRequisition;



public interface ProjectRequisitionService {

	ProjectRequisition findByProjectRequisitionId(long projectRequisitionId);

	ProjectRequisition findByProjectRequisitionName(String projectRequisitionName);

	void saveProjectRequisition(ProjectRequisition projectRequisition);

	ProjectRequisition updateProjectRequisition(ProjectRequisition projectRequisition);

	List<ProjectRequisition> findAllProjectRequisitions();

	void deleteProjectRequisition(ProjectRequisition projectRequisition);
}
