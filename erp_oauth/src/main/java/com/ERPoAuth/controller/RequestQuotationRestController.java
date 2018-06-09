package com.ERPoAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ERPoAuth.model.RequestQuotation;
import com.ERPoAuth.model.RequestQuotationWithProcedure;
import com.ERPoAuth.service.RequestQuotationService;

@RestController
public class RequestQuotationRestController {

	@Autowired
	RequestQuotationService requestQuotationService;

	@RequestMapping(value = "/requestQuotation/requestQuotationWithProcedure/", method = RequestMethod.POST)
	public ResponseEntity<RequestQuotationWithProcedure> createVendor(
			@RequestBody RequestQuotationWithProcedure requestQuotationWithProcedure, UriComponentsBuilder ucBuilder) {

		try {
			requestQuotationService.createQuotationWithProc(requestQuotationWithProcedure);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<RequestQuotationWithProcedure>(requestQuotationWithProcedure, HttpStatus.OK);
	}

	@RequestMapping(value = "/requestQuotation/list", method = RequestMethod.GET)
	public ResponseEntity<List<RequestQuotation>> listAllRequestQuotations() throws Exception {
		List<RequestQuotation> requestQuotations = requestQuotationService.findAllRequestQuotations();
		System.out.println(" Users in web service " + requestQuotations);
		if (requestQuotations.isEmpty()) {
			return new ResponseEntity<List<RequestQuotation>>(HttpStatus.NO_CONTENT);
		}
		System.out.println("$$$ RequestQuotationRestController - requestQuotations"+requestQuotations);
		return new ResponseEntity<List<RequestQuotation>>(requestQuotations, HttpStatus.OK);
	}

}
