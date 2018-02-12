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

import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;
import com.ERPoAuth.model.Project;
import com.ERPoAuth.model.User;
import com.ERPoAuth.service.BankBranchService;
import com.ERPoAuth.service.BankService;

@RestController
public class BankRestController {

	@Autowired
	BankService bankService;

	

	@RequestMapping(value = "/bank/list", method = RequestMethod.GET)
	public ResponseEntity<List<Bank>> getAllBanks() {
		List<Bank> bankList = bankService.findAllBanks();

		if (bankList.isEmpty()) {
			return new ResponseEntity<List<Bank>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Bank>>(bankList, HttpStatus.OK);
	}

	@RequestMapping(value = "/bank/create/", method = RequestMethod.POST)
	public ResponseEntity<Bank> createBank(@RequestBody Bank bank, UriComponentsBuilder ucBuilder) {
		System.out.println("@@@@@@@@@@@@ BankRestController - createBank - Bank : " + bank.getBank_name());
		System.out.println("Creating Bank " + bank);
		try {
			bankService.saveBank(bank);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Bank>(bank, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/bank/{bankId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Bank> getBankId(
			@PathVariable("bankId") Long bankId) {
		System.out.println("Fetching Project with id " + bankId);
		Bank bank = bankService.findByBankId(bankId);
		if (bank == null) {
			System.out.println("bank with projectId " + bankId
					+ " not found");
			return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Bank>(bank, HttpStatus.OK);
	}*/
	
	

	@RequestMapping(value = "/bank/{bankId}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bank> getBankIdInfo(
			@PathVariable("bankId") Long bankId) {
		System.out.println("Fetching User with id " + bankId);
		Bank bank = bankService.findByBankId(bankId);
		System.out.println("========================================================================");
		if (bank == null) {
			
			System.out.println("User with id " + bankId + " not found");
			return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
		}
		List<BankBranch> list=bank.getBank_branches();
		for(BankBranch b: list)
		{
			System.out.println("=>>>>>>>>>>>>>>>>> "+b.getBank_branch_id());
		}
		
		
		    /*List<Entity> entityList = entityManager.findAll();

		    List<JSONObject> entities = new ArrayList<JSONObject>();
		    for (Entity n : entityList) {
		        JSONObject Entity = new JSONObject();
		        entity.put("id", n.getId());
		        entity.put("address", n.getAddress());
		        entities.add(entity);
		    }
		    return new ResponseEntity<Object>(entities, HttpStatus.OK);*/
		
		return new ResponseEntity<Bank>(bank, HttpStatus.OK);
	}
	
}
