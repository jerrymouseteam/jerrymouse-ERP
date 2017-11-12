package com.ERPoAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ERPoAuth.model.Requisition;
import com.ERPoAuth.service.RequisitionService;

@RestController
public class RequisitionRestController {

	@Autowired
	RequisitionService requisitionService; // Service which will do all data

	// retrieval/manipulation work

	// -------------------Retrieve All
	// Projects--------------------------------------------------------

	@RequestMapping(value = "/requisitionAuth/addRequisition", method = RequestMethod.GET)
	public ResponseEntity<Requisition> getPreFilledRequisitionFormDetails() {
		Requisition requisition = requisitionService
				.getPreFilledRequisitionFormDetails();
		System.out.println(" Pre filled data " + requisition);

		return new ResponseEntity<Requisition>(requisition, HttpStatus.OK);
	}

	@RequestMapping(value = "/requisitionAuth/addRequisition/", method = RequestMethod.POST)
	public ResponseEntity<Requisition> createRequisition(
			@RequestBody Requisition requisition) {
		System.out.println("Creating Requisition " + requisition);

		try {
			requisitionService.saveRequisition(requisition);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Requisition>(requisition, HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/requisitionAuth/list/", method =
	 * RequestMethod.GET) public ResponseEntity<List<Project>> listAllprojects()
	 * { List<Project> Projects = requisitionService.findAllRequisition();
	 * System.out.println(" Projects in web service " + Projects); if
	 * (Projects.isEmpty()) { return new
	 * ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT); } return new
	 * ResponseEntity<List<Project>>(Projects, HttpStatus.OK); }
	 */

}