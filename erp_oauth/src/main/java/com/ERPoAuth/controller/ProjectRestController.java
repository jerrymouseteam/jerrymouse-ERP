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

import com.ERPoAuth.model.Project;
import com.ERPoAuth.service.ProjectService;

@RestController
public class ProjectRestController {

	@Autowired
	ProjectService projectService; // Service which will do all data
									// retrieval/manipulation work

	// -------------------Retrieve All
	// Projects--------------------------------------------------------

	@RequestMapping(value = "/project/list", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> listAllprojects() {
		List<Project> projectList = projectService.findAllProjectss();
		// System.out.println(" Projects in web service " + projectList);
		if (projectList.isEmpty()) {
			return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Project>>(projectList, HttpStatus.OK);
	}

	@RequestMapping(value = "/project/closed/", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> listAllClosedprojects() {
		List<Project> Projects = projectService.findClosedProjectss();
		System.out.println(" Projects in web service " + Projects);
		if (Projects.isEmpty()) {
			return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Project>>(Projects, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Project--------------------------------------------------------

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Project> getProjectUsingId(
			@PathVariable("projectId") Integer projectId) {
		System.out.println("Fetching Project with id " + projectId);
		Project Project = projectService.findByProjectId(projectId);
		if (Project == null) {
			System.out.println("Project with projectId " + projectId
					+ " not found");
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Project>(Project, HttpStatus.OK);
	}

	@RequestMapping(value = "/project/projectName/{projectName}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Project> getByProjectname(
			@PathVariable String projectName) {
		System.out.println("Fetching Project with projectName " + projectName);
		Project Project = projectService.findByProjectname(projectName);
		if (Project == null) {
			System.out.println("Project with projectName " + projectName
					+ " not found");
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Project>(Project, HttpStatus.OK);
	}

	// -------------------Create a
	// Project--------------------------------------------------------

	@RequestMapping(value = "/project/create/", method = RequestMethod.POST)
	public ResponseEntity<Project> createProject(@RequestBody Project project,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Project " + project);

		if (projectService.findByProjectname(project.getProjectName()) != null) {
			System.out.println("A Project with name "
					+ project.getProjectName() + " already exist");
			return new ResponseEntity<Project>(HttpStatus.CONFLICT);
		}
		try {
			projectService.saveProject(project);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setLocation(ucBuilder
		 * .path("/Project/{id}").buildAndExpand(Project.getId()).toUri());
		 */
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}

	// ------------------- Update a Project
	// --------------------------------------------------------

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.PUT)
	public ResponseEntity<Project> updateProject(
			@PathVariable("projectId") Integer projectId,
			@RequestBody Project project) {
		System.out.println("Updating Project with Id : " + projectId);

		if (projectService.findByProjectId(projectId) == null) {
			System.out.println("Project with id " + projectId + " not found");
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}

		Project assosiatedProject = projectService.updateProject(project);
		return new ResponseEntity<Project>(assosiatedProject, HttpStatus.OK);
	}

	// ------------------- Delete a Project
	// --------------------------------------------------------

	@RequestMapping(value = "/Project/delete/{projectId}", method = RequestMethod.POST)
	public ResponseEntity<Project> closeProject(@PathVariable String projectName) {
		System.out.println("Fetching & Closing Project with projectName "
				+ projectName);

		Project project = projectService.findByProjectname(projectName);
		if (project == null) {
			System.out.println("Unable to close. Project with projectId "
					+ projectName + " not found");
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}

		projectService.closeProject(projectName);
		return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
	}

}