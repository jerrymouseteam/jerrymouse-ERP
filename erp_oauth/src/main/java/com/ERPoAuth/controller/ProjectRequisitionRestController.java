package com.ERPoAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ERPoAuth.model.ProjectRequisition;
import com.ERPoAuth.service.ProjectRequisitionService;





@RestController
public class ProjectRequisitionRestController {

	@Autowired
	ProjectRequisitionService projectRequisitionService;

	@RequestMapping(value = "/projectRequisition/list", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectRequisition>> getAllProjectRequisitions() {
	
		
		
	
		System.out.println("================= ProjectRequisitionRestController - getAllProjectRequisitions ====================");
		List<ProjectRequisition> ProjectRequisitionList = projectRequisitionService.findAllProjectRequisitions();
		System.out.println("==> ================= ProjectRequisitionRestController - getAllProjectRequisitions - ProjectRequisitionList : "+ProjectRequisitionList);
		if (ProjectRequisitionList.isEmpty()) {
			return new ResponseEntity<List<ProjectRequisition>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ProjectRequisition>>(ProjectRequisitionList, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/projectRequisition/create/", method = RequestMethod.POST)
	public ResponseEntity<ProjectRequisition> createProjectRequisition(@RequestBody ProjectRequisition projectRequisition,
			UriComponentsBuilder ucBuilder) {

		try {
			/*System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			List<ProjectRequisition> ProjectRequisitionList = projectRequisitionService.findAllProjectRequisitions();
			System.out.println("==> ================= ProjectRequisitionRestController - getAllProjectRequisitions - ProjectRequisitionList : "+ProjectRequisitionList);
			*/
			System.out.println("### ProjectRequisitionRestController - createProjectRequisition "+projectRequisition);
			projectRequisitionService.saveProjectRequisition(projectRequisition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ProjectRequisition>(projectRequisition, HttpStatus.OK);
	}

	@RequestMapping(value = "/projectRequisition/update/", method = RequestMethod.PUT)
	public ResponseEntity<ProjectRequisition> updateProjectRequisition(
			@RequestBody ProjectRequisition projectRequisition) {
		System.out.println("Updating updateProjectRequisition " + projectRequisition);

		ProjectRequisition mergedProjectRequisition = projectRequisitionService.updateProjectRequisition(projectRequisition);
		return new ResponseEntity<ProjectRequisition>(mergedProjectRequisition, HttpStatus.OK);
	}

	@RequestMapping(value = "/projectRequisition/{projectRequisitionId}", method = RequestMethod.DELETE)
	public ResponseEntity<ProjectRequisition> deleteProjectRequisition(@PathVariable("projectRequisitionId") Long projectRequisitionId) {
		System.out.println("Fetching & Deleting User with ssoId " + projectRequisitionId);

		ProjectRequisition ProjectRequisition = projectRequisitionService.findByProjectRequisitionId(projectRequisitionId);
		if (ProjectRequisition == null) {
			System.out.println("Unable to delete. User with ProjectRequisitionId " + projectRequisitionId + " not found");
			return new ResponseEntity<ProjectRequisition>(HttpStatus.NOT_FOUND);
		}

		projectRequisitionService.deleteProjectRequisition(ProjectRequisition);
		return new ResponseEntity<ProjectRequisition>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/projectRequisition/{ProjectRequisitionId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ProjectRequisition> getUser(@PathVariable("ProjectRequisitionId") Long ProjectRequisitionId) {
		System.out.println("Fetching User with id " + ProjectRequisitionId);
		ProjectRequisition ProjectRequisition = projectRequisitionService.findByProjectRequisitionId(ProjectRequisitionId);
		if (ProjectRequisition == null) {
			System.out.println("User with id " + ProjectRequisitionId + " not found");
			return new ResponseEntity<ProjectRequisition>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProjectRequisition>(ProjectRequisition, HttpStatus.OK);
	}
	
	
}
