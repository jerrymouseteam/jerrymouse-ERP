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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ERP.constants.ErpConstants;
import com.ERP.constants.Test;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Bank;
import com.ERP.model.BankBranch;
import com.ERP.model.VendorDTO;
import com.ERP.model.VendorType;
import com.ERP.util.Utilities;
import com.ERP.util.VendorApiHandler;

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

		VendorDTO vendor = new VendorDTO();

		System.out.println("registerVendor");
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("success", "");

		return "registerVendor";
	}
	
	@RequestMapping(value = { "/createVendor" }, method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendorForm") VendorDTO vendor, BindingResult result, ModelMap model) {
		
		System.out.println(vendor.getVendorTypeId());
		System.out.println("========= saveVendor "+vendor);
		System.out.println("##########################################################################");
		VendorApiHandler vendorApiHandler = new VendorApiHandler();
		ResponseEntity<VendorDTO> responseVendor=vendorApiHandler.save(sendTokenRequest(), vendor);
	//	System.out.println("@@@@@@@@@@@ responseVendor : "+responseVendor.getBody().getVendor_name());
		System.out.println("##########################################################################");
		
		vendor=new VendorDTO();
		System.out.println("registerVendor");
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("success", "");

		return "registerVendor";
	}

	@RequestMapping(value = { "/getVendors" }, method = RequestMethod.GET)
	public String getVendors(@ModelAttribute("vendorForm") VendorDTO vendor, BindingResult result, ModelMap model) {

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
		
		VendorDTO vendor=null;
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
	public String updateVendorDetails(ModelMap model, @ModelAttribute("vendorForm") VendorDTO vendor) {

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
		
		VendorDTO vendor=null;
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
	List<BankBranch> getBankBranch(
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
	public List<VendorDTO> getVendors() {

		return Test.getVendorList();
	}
	
	
	/*
	 * Send a POST request [on /oauth/token] to get an access-token, which will
	 * then be send with each request.
	 */
	@SuppressWarnings({ "unchecked" })
	private static AuthTokenInfo sendTokenRequest() {
		AuthTokenInfo tokenInfo = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders h = getHeadersWithClientCredentials();
			HttpEntity<String> request = new HttpEntity<String>(h);
			ResponseEntity<Object> response = restTemplate.exchange(
					ErpConstants.AUTH_SERVER_URI + ErpConstants.QPM_PASSWORD_GRANT, HttpMethod.POST, request,
					Object.class);
			LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();

			System.out.println("************************* map "+map);
			if (map != null) {
				tokenInfo = new AuthTokenInfo();
				tokenInfo.setAccess_token((String) map.get("access_token"));
				tokenInfo.setToken_type((String) map.get("token_type"));
				tokenInfo.setRefresh_token((String) map.get("refresh_token"));
				tokenInfo.setExpires_in((Integer) map.get("expires_in"));
				tokenInfo.setScope((String) map.get("scope"));
				System.out.println("################# "+tokenInfo);
				// System.out.println("access_token
				// ="+map.get("access_token")+",
				// token_type="+map.get("token_type")+",
				// refresh_token="+map.get("refresh_token")
				// +", expires_in="+map.get("expires_in")+",
				// scope="+map.get("scope"));;
			} else {
				System.out.println("############# No user exist----------");

			}
			return tokenInfo;
		} catch (final HttpClientErrorException e) {
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
			e.printStackTrace();
		}
		return tokenInfo;
	}
	
	/*
	 * Add HTTP Authorization header, using Basic-Authentication to send
	 * client-credentials.
	 */
	private static HttpHeaders getHeadersWithClientCredentials() {
		String plainClientCredentials = "my-trusted-client:secret";
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));

		HttpHeaders headers = getHeaders();
		headers.add("Authorization", "Basic " + base64ClientCredentials);
		return headers;
	}
	
	/*
	 * Prepare HTTP Headers.
	 */
	private static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}


}
