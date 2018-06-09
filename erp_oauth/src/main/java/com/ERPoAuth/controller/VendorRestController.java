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

import com.ERPoAuth.model.Vendor;
import com.ERPoAuth.service.VendorService;

@RestController
public class VendorRestController {

	@Autowired
	VendorService vendorService;

	@RequestMapping(value = "/vendor/create/", method = RequestMethod.POST)
	public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor, UriComponentsBuilder ucBuilder) {
		
		try {
			vendorService.saveVendor(vendor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
	}
	@RequestMapping(value = "/vendor/create2/", method = RequestMethod.POST)
	public ResponseEntity<Vendor> createVendor2(@RequestBody Vendor vendor, UriComponentsBuilder ucBuilder) {
		
		

		try {
			vendorService.saveVendor(vendor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendor/update/", method = RequestMethod.PUT)
	public ResponseEntity<Vendor> updateVendor( @RequestBody Vendor vendor) {
		System.out.println("### RESTCONTROLLER updateVendor "+vendor);

		Vendor mergedVendor = vendorService.updateVendor(vendor);
		return new ResponseEntity<Vendor>(mergedVendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.DELETE)
	public ResponseEntity<Vendor> deleteVendor(@PathVariable Long vendorId) {
		System.out.println("Fetching & Deleting User with ssoId " + vendorId);

		Vendor vendor = vendorService.findByVendorId(vendorId);
		if (vendor == null) {
			System.out.println("Unable to delete. User with vendorTypeId " + vendor + " not found");
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}

		vendorService.deleteVendor(vendor);
		return new ResponseEntity<Vendor>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/vendor/{vendorId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Vendor> getVendor(@PathVariable("vendorId") Long vendorId) {
		System.out.println("Fetching User with id " + vendorId);
		Vendor vendor = vendorService.findByVendorId(vendorId);
		if (vendor == null) {
			System.out.println("User with id " + vendorId + " not found");
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vendor>(vendor, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendor/list", method = RequestMethod.GET)
	public ResponseEntity<List<Vendor>> listAllVendors() throws Exception {
		List<Vendor> vendors = vendorService.findAllVendors();
		System.out.println(" Users in web service " + vendors);
		if (vendors.isEmpty()) {
			return new ResponseEntity<List<Vendor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Vendor>>(vendors, HttpStatus.OK);
	}

}
