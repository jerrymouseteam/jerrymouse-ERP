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
import com.ERPoAuth.model.VendorBankProfile;
import com.ERPoAuth.service.VendorBankProfileService;

@RestController
public class VendorBankProfileRestController {

	@Autowired
	VendorBankProfileService vendorBankProfileService;

	@RequestMapping(value = "/vendorBankProfile/create/", method = RequestMethod.POST)
	public ResponseEntity<VendorBankProfile> createVendorBankProfile(@RequestBody VendorBankProfile vendorBankProfile, UriComponentsBuilder ucBuilder) {

		try {
			vendorBankProfileService.saveVendorBankProfile(vendorBankProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<VendorBankProfile>(vendorBankProfile, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendorBankProfile/{vendorBankProfileId}", method = RequestMethod.PUT)
	public ResponseEntity<VendorBankProfile> updateVendorBankProfile(@PathVariable("vendorBankProfileId") Long vendorBankProfileId, @RequestBody VendorBankProfile vendorBankProfile) {
		System.out.println("Updating User " + vendorBankProfileId);

		VendorBankProfile mergedVendorBankProfile = vendorBankProfileService.updateVendorBankProfile(vendorBankProfile);
		return new ResponseEntity<VendorBankProfile>(mergedVendorBankProfile, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendorBankProfile/{vendorBankProfileId}", method = RequestMethod.DELETE)
	public ResponseEntity<VendorBankProfile> deleteVendorBankProfile(@PathVariable Long vendorBankProfileId) {
		System.out.println("Fetching & Deleting User with ssoId " + vendorBankProfileId);

		VendorBankProfile vendorBankProfile = vendorBankProfileService.findByVendorBankProfileId(vendorBankProfileId);
		if (vendorBankProfile == null) {
			System.out.println("Unable to delete. User with vendorTypeId " + vendorBankProfile + " not found");
			return new ResponseEntity<VendorBankProfile>(HttpStatus.NOT_FOUND);
		}

		vendorBankProfileService.deleteVendorBankProfile(vendorBankProfile);
		return new ResponseEntity<VendorBankProfile>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/vendorBankProfile/{vendorBankProfileId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<VendorBankProfile> getVendor(@PathVariable("vendorBankProfileId") Long vendorBankProfileId) {
		System.out.println("Fetching User with id " + vendorBankProfileId);
		VendorBankProfile vendorBankProfile = vendorBankProfileService.findByVendorBankProfileId(vendorBankProfileId);
		if (vendorBankProfile == null) {
			System.out.println("User with id " + vendorBankProfile + " not found");
			return new ResponseEntity<VendorBankProfile>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<VendorBankProfile>(vendorBankProfile, HttpStatus.OK);
	}

	@RequestMapping(value = "/vendorBankProfile/list", method = RequestMethod.GET)
	public ResponseEntity<List<VendorBankProfile>> listAllVendors() {
		List<VendorBankProfile> vendorBankProfiles = vendorBankProfileService.findAllVendorBankProfiles();
		System.out.println(" Users in web service " + vendorBankProfiles);
		if (vendorBankProfiles.isEmpty()) {
			return new ResponseEntity<List<VendorBankProfile>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<VendorBankProfile>>(vendorBankProfiles, HttpStatus.OK);
	}

}
