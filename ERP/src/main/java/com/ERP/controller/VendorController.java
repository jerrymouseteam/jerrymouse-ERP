package com.ERP.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ERP.constants.Test;
import com.ERP.constants.UserStatus;
import com.ERP.model.Bank;
import com.ERP.model.BankBranch;
import com.ERP.model.Project;
import com.ERP.model.User;
import com.ERP.model.Vendor;
import com.ERP.model.VendorType;
import com.ERP.util.Utilities;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class VendorController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	Utilities u=	new com.ERP.util.Utilities();

	@RequestMapping(value = { "/registerVendor" }, method = RequestMethod.GET)
	public String registerVendor(ModelMap model) {

		Vendor vendor = new Vendor();

		System.out.println("registerVendor");
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("success", "");

		return "registerVendor";
	}
	
	@RequestMapping(value = { "/createVendor" }, method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendorForm") Vendor vendor, BindingResult result, ModelMap model) {
		
		System.out.println(vendor.getVendorTypeId());
		System.out.println("========= saveVendor "+vendor);
		
		vendor=new Vendor();
		System.out.println("registerVendor");
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("success", "");

		return "registerVendor";
	}

	@RequestMapping(value = { "/getVendors" }, method = RequestMethod.GET)
	public String getVendors(@ModelAttribute("vendorForm") Vendor vendor, BindingResult result, ModelMap model) {

		System.out.println("\nTesting getVendors API----------");

		model.addAttribute("editVendorStage", "getVendorList");
		model.addAttribute("loggedinuser", u.getPrincipal());
		return "getVendors";
	}
	
	
	
	
	@Transactional
	@RequestMapping(value = { "/editVendorDetails/{vendorId}" }, method = RequestMethod.GET)
	public String editVendorDetails(@PathVariable Long vendorId, ModelMap model) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting editVendorDetails API---------- vendorId :: " + vendorId);
		
		Vendor vendor=null;
		if(vendorId ==1)
		{
			 vendor=Test.getVendor1();
		}
		else
		{

			 vendor=Test.getVendor2();
			
		}

		

		
		model.addAttribute("vendorForm", vendor);
	
		model.addAttribute("editVendorStage", "editVendorDetails");
		return "getVendors";
	}
	
	@RequestMapping(value = { "/updateVendorDetails" }, method = RequestMethod.POST)
	public String updateVendorDetails(ModelMap model, @ModelAttribute("vendorForm") Vendor vendor) {

		System.out.println("\nTesting updateUserProjectDetails API---------- Vendor :: " + vendor);

		//model.addAttribute("vendorForm", vendor);
		//model.addAttribute("ssoId", 1);
		//model.addAttribute("editVendorStage", "getVendorList");
		model.addAttribute("loggedinuser", u.getPrincipal());
		return "redirect:/getVendors";
	}
	
	
	@RequestMapping(value = { "/getVendorDetails/{vendorId}" }, method = RequestMethod.GET)
	public String getVendorDetails(@PathVariable Long vendorId, ModelMap model) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting getVendorDetails API---------- vendorId :: " + vendorId);
		
		Vendor vendor=null;
		if(vendorId ==1)
		{
			 vendor=Test.getVendor1();
		}
		else
		{

			 vendor=Test.getVendor2();
			
		}

		

		
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("editVendorStage", "getVendorDetails");
		return "getVendors";
	}

	
	@RequestMapping(value = "/getBankBranch", method = RequestMethod.GET)
	public @ResponseBody
	List<BankBranch> citiesForState(
			@RequestParam(value = "bankId", required = true) Long bankId) {
		
		System.out.println("*************** finding cities for bankId " + bankId);
		return Test.getBankBranchList2(bankId);
	}
	
	@ModelAttribute("getBanks")
	public List<Bank> getBanks() {

		return Test.getBankList();
	}

	@ModelAttribute("getBankBranches")
	public List<BankBranch> getBankBranches() {

		return Test.getBankBranchList();
	}
	
	@ModelAttribute("getVendorTypes")
	public List<VendorType> getVendorTypes() {

		return Test.getVendorTypeList();
	}
	
	@ModelAttribute("getEditVendorsListDetails")
	public List<Vendor> getVendors() {

		return Test.getVendorList();
	}

}
