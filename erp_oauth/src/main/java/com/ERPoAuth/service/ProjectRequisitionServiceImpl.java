package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.ProjectRequisitionDao;
import com.ERPoAuth.model.ProjectRequisition;

@Service("ProjectRequisitionService")
@Transactional
public class ProjectRequisitionServiceImpl implements ProjectRequisitionService {

	@Autowired
	private ProjectRequisitionDao dao;

	@Override
	public ProjectRequisition findByProjectRequisitionId(long projectRequisitionId) {
		// TODO Auto-generated method stub
		return dao.findProjectRequisitionById(projectRequisitionId);
	}

	@Override
	public ProjectRequisition findByProjectRequisitionName(String projectRequisitionName) {
		// TODO Auto-generated method stub
		return dao.findProjectRequisitionByName(projectRequisitionName);
	}

	@Override
	public void saveProjectRequisition(ProjectRequisition projectRequisition) {
		// TODO Auto-generated method stub

		dao.saveProjectRequisition(projectRequisition);

	}

	@Override
	public ProjectRequisition updateProjectRequisition(ProjectRequisition projectRequisition) {
		// TODO Auto-generated method stub
		return dao.updateProjectRequisition(projectRequisition);
	}

	@Override
	public List<ProjectRequisition> findAllProjectRequisitions() {

		return dao.findAllProjectRequisitions();
	}

	@Override
	public void deleteProjectRequisition(ProjectRequisition projectRequisition) {
		// TODO Auto-generated method stub
		dao.deleteProjectRequisition(projectRequisition);
	}

}
