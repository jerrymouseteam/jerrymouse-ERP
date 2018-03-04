package com.ERP.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ERP.model.User;
import com.ERP.model.VendorDTO;
import com.ERP.util.Utilities;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class QuatationController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping(value = { "/getQuotations" }, method = RequestMethod.GET)
	public String getQuotations(ModelMap model) {

		VendorDTO vendor = new VendorDTO();

		System.out.println("getQuotations");
		model.addAttribute("quotationForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());
		model.addAttribute("success", "");

		return "getQuotations";
	}

	

	@RequestMapping(value = { "/requestQuotation" }, method = RequestMethod.GET)
	public String requestQuotation(@ModelAttribute("vendorForm") User user, BindingResult result, ModelMap model) {

		System.out.println("\nTesting requestQuotation API----------");

		model.addAttribute("editUserStage", "editUserList");
		model.addAttribute("editUserList", true);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());
		return "requestQuotation";
	}

}
