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

import com.ERPoAuth.model.Address;
import com.ERPoAuth.model.VendorType;
import com.ERPoAuth.service.AddressService;

@RestController
public class AddressRestController {

	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/address/create/", method = RequestMethod.POST)
	public ResponseEntity<Address> createVendorType(@RequestBody Address address, UriComponentsBuilder ucBuilder) {

		try {
			addressService.saveAddress(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	@RequestMapping(value = "/address/{addressId}", method = RequestMethod.PUT)
	public ResponseEntity<Address> updateAddress(@PathVariable("addressId") Long addressId,
			@RequestBody Address address) {
		System.out.println("Updating User " + addressId);

		Address mergedAddress = addressService.updateAddress(address);
		return new ResponseEntity<Address>(mergedAddress, HttpStatus.OK);
	}

	@RequestMapping(value = "/address/{addressId}", method = RequestMethod.DELETE)
	public ResponseEntity<Address> deleteAddress(@PathVariable Long addressId) {
		System.out.println("Fetching & Deleting User with ssoId " + addressId);

		Address address = addressService.findByAddressId(addressId);
		if (address == null) {
			System.out.println("Unable to delete. User with vendorTypeId " + address + " not found");
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}

		addressService.deleteAddress(address);
		return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/address/{addressId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Address> getAddress(@PathVariable("addressId") Long addressId) {
		System.out.println("Fetching User with id " + addressId);
		Address address = addressService.findByAddressId(addressId);
		if (address == null) {
			System.out.println("User with id " + addressId + " not found");
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}
}
