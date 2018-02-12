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

import com.ERPoAuth.model.BankBranch;
import com.ERPoAuth.model.Vendor;
import com.ERPoAuth.service.BankBranchService;

@RestController
public class BankBranchRestController {

	@Autowired
	BankBranchService bankBranchService;

	@RequestMapping(value = "/bankBranch/create/", method = RequestMethod.POST)
	public ResponseEntity<BankBranch> createBankBranch(@RequestBody BankBranch bankBranch,
			UriComponentsBuilder ucBuilder) {

		try {
			bankBranchService.saveBranch(bankBranch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<BankBranch>(bankBranch, HttpStatus.OK);
	}

	@RequestMapping(value = "/bankBranch/{bankBranchId}", method = RequestMethod.PUT)
	public ResponseEntity<BankBranch> updateBankBranch(@PathVariable("bankBranchId") Long bankBranchId,
			@RequestBody BankBranch bankBranch) {
		System.out.println("Updating User " + bankBranchId);

		BankBranch mergedBankBranch = bankBranchService.updateBranch(bankBranch);
		return new ResponseEntity<BankBranch>(mergedBankBranch, HttpStatus.OK);
	}

	@RequestMapping(value = "/bankBranch/{ifsc}", method = RequestMethod.DELETE)
	public ResponseEntity<BankBranch> deleteBankBranch(@PathVariable String ifsc) {
		System.out.println("Fetching & Deleting User with ssoId " + ifsc);

		BankBranch bankBranch = bankBranchService.findByIfsc(ifsc);
		if (bankBranch == null) {
			System.out.println("Unable to delete. User with vendorTypeId " + bankBranch + " not found");
			return new ResponseEntity<BankBranch>(HttpStatus.NOT_FOUND);
		}

		bankBranchService.deleteBankBranch(bankBranch.getBank_branch_id());
		return new ResponseEntity<BankBranch>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/bankBranch/{ifsc}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<BankBranch> getBankBranch(@PathVariable("ifsc") String ifsc) {
		System.out.println("Fetching User with id " + ifsc);
		BankBranch bankBranch = bankBranchService.findByIfsc(ifsc);
		if (bankBranch == null) {
			System.out.println("User with id " + bankBranch + " not found");
			return new ResponseEntity<BankBranch>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BankBranch>(bankBranch, HttpStatus.OK);
	}
	
	

	
}
