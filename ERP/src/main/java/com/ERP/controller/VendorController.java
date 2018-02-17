package com.ERP.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ERP.constants.Test;
import com.ERP.model.Bank;
import com.ERP.model.BankBranch;
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

	@RequestMapping(value = { "/registerVendor" }, method = RequestMethod.GET)
	public String registerVendor(ModelMap model) {

		Vendor vendor = new Vendor();

		System.out.println("registerVendor");
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());
		model.addAttribute("success", "");

		return "registerVendor";
	}
	
	@RequestMapping(value = { "/createVendor" }, method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendorForm") Vendor vendor, BindingResult result, ModelMap model) {
		
		System.out.println("========= saveVendor "+vendor);

		vendor = new Vendor();

		System.out.println("registerVendor");
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());
		model.addAttribute("success", "");

		return "registerVendor";
	}

	@RequestMapping(value = { "/getVendors" }, method = RequestMethod.GET)
	public String getVendors(@ModelAttribute("vendorForm") User user, BindingResult result, ModelMap model) {

		System.out.println("\nTesting getVendors API----------");

		model.addAttribute("editUserStage", "editUserList");
		model.addAttribute("editUserList", true);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());
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

}
