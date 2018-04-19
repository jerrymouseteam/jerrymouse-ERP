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

import com.ERPoAuth.model.Unit;
import com.ERPoAuth.service.UnitService;





@RestController
public class UnitRestController {

	@Autowired
	UnitService unitService;

	@RequestMapping(value = "/unit/list", method = RequestMethod.GET)
	public ResponseEntity<List<Unit>> getAllUnits() {
	
		
		
	
		System.out.println("================= UnitRestController - getAllUnits ====================");
		List<Unit> UnitList = unitService.findAllUnits();
		System.out.println("================= UnitRestController - getAllUnits - UnitList : "+UnitList);
		if (UnitList.isEmpty()) {
			return new ResponseEntity<List<Unit>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Unit>>(UnitList, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/unit/create/", method = RequestMethod.POST)
	public ResponseEntity<Unit> createUnit(@RequestBody Unit Unit,
			UriComponentsBuilder ucBuilder) {

		try {
			unitService.saveUnit(Unit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Unit>(Unit, HttpStatus.OK);
	}

	@RequestMapping(value = "/unit/{unitId}", method = RequestMethod.PUT)
	public ResponseEntity<Unit> updateUnit(@PathVariable("unitId") Long unitId,
			@RequestBody Unit Unit) {
		System.out.println("Updating User " + unitId);

		Unit mergedUnit = unitService.updateUnit(Unit);
		return new ResponseEntity<Unit>(mergedUnit, HttpStatus.OK);
	}

	@RequestMapping(value = "/unit/{unitId}", method = RequestMethod.DELETE)
	public ResponseEntity<Unit> deleteUnit(@PathVariable Long unitId) {
		System.out.println("Fetching & Deleting User with ssoId " + unitId);

		Unit Unit = unitService.findByUnitId(unitId);
		if (Unit == null) {
			System.out.println("Unable to delete. User with unitId " + unitId + " not found");
			return new ResponseEntity<Unit>(HttpStatus.NOT_FOUND);
		}

		unitService.deleteUnit(Unit);
		return new ResponseEntity<Unit>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/unit/{unitId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Unit> getUser(@PathVariable("unitId") Long unitId) {
		System.out.println("Fetching User with id " + unitId);
		Unit Unit = unitService.findByUnitId(unitId);
		if (Unit == null) {
			System.out.println("User with id " + unitId + " not found");
			return new ResponseEntity<Unit>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Unit>(Unit, HttpStatus.OK);
	}
	
	
}
