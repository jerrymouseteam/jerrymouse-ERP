package com.ERPoAuth.dao;

import java.util.List;

import com.ERPoAuth.model.ProjectRequisition;

public interface ProjectRequisitionDao {

	ProjectRequisition findProjectRequisitionById(long projectRequisitionId);

	ProjectRequisition findProjectRequisitionByName(String projectRequisitionName);

	void saveProjectRequisition(ProjectRequisition projectRequisition);

	ProjectRequisition updateProjectRequisition(ProjectRequisition projectRequisition);

	List<ProjectRequisition> findAllProjectRequisitions();

	void deleteProjectRequisition(ProjectRequisition projectRequisition);

	

}
