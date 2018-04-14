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

import com.ERPoAuth.model.VendorType;
import com.ERPoAuth.model.VendorTypeForm;
import com.ERPoAuth.service.VendorTypeService;





@RestController
public class VendorTypeRestController {

	@Autowired
	VendorTypeService vendorTypeService;

	@RequestMapping(value = "/vendorType/list", method = RequestMethod.GET)
	public ResponseEntity<List<VendorType>> getAllVendorTypes() {
	
		
		
	
		System.out.println("================= VendorTypeRestController - getAllVendorTypes ====================");
		List<VendorType> vendorTypeList = vendorTypeService.findAllVendorTypes();
		System.out.println("================= VendorTypeRestController - getAllVendorTypes - vendorTypeList : "+vendorTypeList);
		if (vendorTypeList.isEmpty()) {
			return new ResponseEntity<List<VendorType>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<VendorType>>(vendorTypeList, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/vendorType/create/", method = RequestMethod.POST)
	public ResponseEntity<VendorType> createVendorType(@RequestBody VendorType vendorType,
			UriComponentsBuilder ucBuilder) {

		try {
			vendorTypeService.saveVendorType(vendorType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<VendorType>(vendorType, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendorType/{vendorTypeId}", method = RequestMethod.PUT)
	public ResponseEntity<VendorType> updateVendorType(@PathVariable("vendorTypeId") Long vendorTypeId,
			@RequestBody VendorType vendorType) {
		System.out.println("Updating User " + vendorTypeId);

		VendorType mergedvendorType = vendorTypeService.updateVendorType(vendorType);
		return new ResponseEntity<VendorType>(mergedvendorType, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendorType/{vendorTypeId}", method = RequestMethod.DELETE)
	public ResponseEntity<VendorType> deleteVendorType(@PathVariable Long vendorTypeId) {
		System.out.println("Fetching & Deleting User with ssoId " + vendorTypeId);

		VendorType vendorType = vendorTypeService.findByVendorTypeId(vendorTypeId);
		if (vendorType == null) {
			System.out.println("Unable to delete. User with vendorTypeId " + vendorTypeId + " not found");
			return new ResponseEntity<VendorType>(HttpStatus.NOT_FOUND);
		}

		vendorTypeService.deleteVendorType(vendorType);
		return new ResponseEntity<VendorType>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/vendorType/{vendorTypeId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<VendorType> getUser(@PathVariable("vendorTypeId") Long vendorTypeId) {
		System.out.println("Fetching User with id " + vendorTypeId);
		VendorType vendorType = vendorTypeService.findByVendorTypeId(vendorTypeId);
		if (vendorType == null) {
			System.out.println("User with id " + vendorTypeId + " not found");
			return new ResponseEntity<VendorType>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<VendorType>(vendorType, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/vendorType/message", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> getVendorTypeMessage() {
		System.out.println("================= VendorTypeRestController - getVendorTypeMessage ====================");
	
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
}
