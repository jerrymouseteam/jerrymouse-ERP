package com.ERP.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ERP.constants.ErpConstants;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.User;
import com.ERP.model.Vendor;
import com.ERP.util.Utilities;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class PurchaseOrderController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping(value = { "/createPurchaseOrder" }, method = RequestMethod.GET)
	public String createPurchaseOrder(ModelMap model) {

		Vendor vendor = new Vendor();

		System.out.println("createPurchaseOrder");
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());
		model.addAttribute("success", "");

		return "createPurchaseOrder";
	}

	

	@RequestMapping(value = { "/getPurchaseOrders" }, method = RequestMethod.GET)
	public String getPurchaseOrders(@ModelAttribute("vendorForm") User user, BindingResult result, ModelMap model) {

		System.out.println("\nTesting getPurchaseOrders API----------");

		model.addAttribute("editUserStage", "editUserList");
		model.addAttribute("editUserList", true);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());
		return "getPurchaseOrders";
	}

}
