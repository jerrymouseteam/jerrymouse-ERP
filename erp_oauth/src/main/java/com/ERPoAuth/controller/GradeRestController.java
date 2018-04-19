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

import com.ERPoAuth.model.Grade;
import com.ERPoAuth.service.GradeService;





@RestController
public class GradeRestController {

	@Autowired
	GradeService gradeService;

	@RequestMapping(value = "/grade/list", method = RequestMethod.GET)
	public ResponseEntity<List<Grade>> getAllGrades() {
	
		
		
	
		System.out.println("================= GradeRestController - getAllGrades ====================");
		List<Grade> GradeList = gradeService.findAllGrades();
		System.out.println("================= GradeRestController - getAllGrades - GradeList : "+GradeList);
		if (GradeList.isEmpty()) {
			return new ResponseEntity<List<Grade>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Grade>>(GradeList, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/grade/create/", method = RequestMethod.POST)
	public ResponseEntity<Grade> createGrade(@RequestBody Grade Grade,
			UriComponentsBuilder ucBuilder) {

		try {
			gradeService.saveGrade(Grade);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Grade>(Grade, HttpStatus.OK);
	}

	@RequestMapping(value = "/grade/{gradeId}", method = RequestMethod.PUT)
	public ResponseEntity<Grade> updateGrade(@PathVariable("gradeId") Long gradeId,
			@RequestBody Grade Grade) {
		System.out.println("Updating User " + gradeId);

		Grade mergedGrade = gradeService.updateGrade(Grade);
		return new ResponseEntity<Grade>(mergedGrade, HttpStatus.OK);
	}

	@RequestMapping(value = "/grade/{gradeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Grade> deleteGrade(@PathVariable Long gradeId) {
		System.out.println("Fetching & Deleting User with ssoId " + gradeId);

		Grade Grade = gradeService.findByGradeId(gradeId);
		if (Grade == null) {
			System.out.println("Unable to delete. User with gradeId " + gradeId + " not found");
			return new ResponseEntity<Grade>(HttpStatus.NOT_FOUND);
		}

		gradeService.deleteGrade(Grade);
		return new ResponseEntity<Grade>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/grade/{gradeId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Grade> getUser(@PathVariable("gradeId") Long gradeId) {
		System.out.println("Fetching User with id " + gradeId);
		Grade Grade = gradeService.findByGradeId(gradeId);
		if (Grade == null) {
			System.out.println("User with id " + gradeId + " not found");
			return new ResponseEntity<Grade>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Grade>(Grade, HttpStatus.OK);
	}
	
	
}
