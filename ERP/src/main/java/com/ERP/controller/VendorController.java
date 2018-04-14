package com.ERP.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ERP.constants.ErpConstants;
import com.ERP.constants.Test;
import com.ERP.model.Address;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Project;
import com.ERP.model.Vendor;
import com.ERP.model.VendorType;
import com.ERP.model.VendorTypeForm;
import com.ERP.util.Utilities;

@Controller
@RequestMapping("/")
@SessionAttributes({ "roles", "getVendorTypes","getEditVendorsListDetails"})
public class VendorController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	Utilities u = new com.ERP.util.Utilities();

	private List<VendorTypeForm> vendorTypes = null;

	@RequestMapping(value = { "/registerVendor" }, method = RequestMethod.GET)
	public String registerVendor(ModelMap model) {

		Vendor vendor = new Vendor();

		/// vendorType/message

		System.out.println("registerVendor");
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("success", "");

		return "registerVendor";
	}

	@RequestMapping(value = { "/createVendor" }, method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendorForm") Vendor vendor, BindingResult result, ModelMap model,
			@ModelAttribute("getVendorTypes") List<VendorType> vendorTypes) {

		
		for (VendorType vt : vendorTypes) {
			if (vt.getVendorType_id() == vendor.getVendorTypeId()) {
				
				vendor.setVendor_type(vt);
				break;
			}
		}

		try {

			

			AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Object> request = new HttpEntity<Object>(vendor, getHeaders());
			try {
				ResponseEntity<Vendor> response = restTemplate.postForEntity(
						ErpConstants.VENDOR_CREATE + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
						request, Vendor.class);
			} catch (HttpClientErrorException excep) {

			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		vendor = new Vendor();
		System.out.println("registerVendor");
		model.addAttribute("vendorForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("success", "");

		return "registerVendor";
	}

	@RequestMapping(value = { "/getVendors" }, method = RequestMethod.GET)
	public String getVendors(@ModelAttribute("vendorForm") Vendor vendor, BindingResult result, ModelMap model) {

		

		List<Vendor> vendorList = null;

		try {

			AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			try {
				ResponseEntity<List> response = restTemplate.exchange(
						ErpConstants.VENDOR_GET_ALL + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
						HttpMethod.GET, request, List.class);
				List<LinkedHashMap<String, Object>> vendorMap = (List<LinkedHashMap<String, Object>>) response
						.getBody();

				
				if (vendorMap != null) {
					vendorList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : vendorMap) {

						vendor = new Vendor();
						vendor.setVendor_id(((Integer) linkedHashMap.get("vendor_id")).longValue());
						vendor.setVendor_name((String) linkedHashMap.get("vendor_name"));
						vendor.setVendor_nickName((String) linkedHashMap.get("vendor_nickName"));
						vendor.setVendor_gst_number((String) linkedHashMap.get("vendor_gst_number"));
						vendor.setServiceRendered_GoodsSupplied(
								(String) linkedHashMap.get("serviceRendered_GoodsSupplied"));
						vendor.setContact_person_name((String) linkedHashMap.get("contact_person_name"));
						vendor.setContact_person_email((String) linkedHashMap.get("contact_person_email"));
						vendor.setContact_person_mobile((String) linkedHashMap.get("contact_person_mobile"));
						vendor.setContact_person_alternate_phone_no(
								(String) linkedHashMap.get("contact_person_alternate_phone_no"));
						vendor.setBank_account_number((String) linkedHashMap.get("bank_account_number"));
						vendor.setBank_branch_ifsc((String) linkedHashMap.get("bank_branch_ifsc"));
						vendor.setBank_name((String) linkedHashMap.get("bank_name"));
						vendor.setBank_branch_name((String) linkedHashMap.get("bank_branch_name"));
						vendor.setVendor_name((String) linkedHashMap.get("vendor_name"));
						try {
							LinkedHashMap<String, Object> vendorTypeMap = (LinkedHashMap<String, Object>) linkedHashMap
									.get("vendor_type");

							VendorType vendorType = new VendorType();
							vendorType.setVendorType_id(((Integer) vendorTypeMap.get("vendorType_id")).longValue());
							vendorType.setVendorType_name((String) vendorTypeMap.get("vendorType_name"));
							vendor.setVendor_type(vendorType);
							LinkedHashMap<String, Object> addressMap = (LinkedHashMap<String, Object>) linkedHashMap
									.get("address");
							Address address = new Address();
							address.setAddress_id(((Integer) addressMap.get("address_id")).longValue());
							address.setAddres_line1((String) addressMap.get("addres_line1"));
							address.setAddres_line2((String) addressMap.get("addres_line2"));
							address.setAddres_line3((String) addressMap.get("addres_line3"));
							address.setCity((String) addressMap.get("city"));
							address.setCountry((String) addressMap.get("country"));
							address.setState((String) addressMap.get("state"));
							address.setZipcode((String) addressMap.get("zipcode"));
							vendor.setAddress(address);

						} catch (Exception e) {
							e.printStackTrace();
						}

						vendorList.add(vendor);

						System.out.println(vendorList);
					}

				} else {
					System.out.println("No user exist----------");
				}

			} catch (Exception excep) {
				excep.printStackTrace();
			}

		} catch (HttpClientErrorException excep) {
			excep.printStackTrace();
		}

		model.addAttribute("getEditVendorsListDetails", vendorList);
		model.addAttribute("editVendorStage", "getVendorList");
		model.addAttribute("loggedinuser", u.getPrincipal());
		return "getVendors";
	}

	@Transactional
	@RequestMapping(value = { "/editVendorDetails/{vendorId}" }, method = RequestMethod.GET)
	public String editVendorDetails(@PathVariable Long vendorId, ModelMap model,@ModelAttribute("getEditVendorsListDetails") List<Vendor> vendors) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		
		Vendor vendor = null;

		
		for (Vendor v : vendors) {
			if (v.getVendor_id() == vendorId) {
				
				vendor=v;
				break;
			}
		}
		
		model.addAttribute("vendorForm", vendor);

		model.addAttribute("editVendorStage", "editVendorDetails");
		return "getVendors";
	}

	@RequestMapping(value = { "/updateVendorDetails" }, method = RequestMethod.POST)
	public String updateVendorDetails(ModelMap model, @ModelAttribute("vendorForm") Vendor vendor,@ModelAttribute("getVendorTypes") List<VendorType> vendorTypes) {

		System.out.println("\nTesting updateUserProjectDetails API---------- Vendor :: " + vendor);
		
		for (VendorType vt : vendorTypes) {
			if (vt.getVendorType_id() == vendor.getVendorTypeId()) {
				
				vendor.setVendor_type(vt);
				break;
			}
		}
		
		try {


			AuthTokenInfo tokenInfo = sendTokenRequest();
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Object> request = new HttpEntity<Object>(vendor,
					getHeaders());
			try {
				restTemplate.put(ErpConstants.VENDOR_UPDATE + ErpConstants.QPM_ACCESS_TOKEN
						+ tokenInfo.getAccess_token(), request, Vendor.class);
			} catch (HttpClientErrorException excep) {
				excep.printStackTrace();
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		model.addAttribute("loggedinuser", u.getPrincipal());
		return "redirect:/getVendors";
	}

	@RequestMapping(value = { "/getVendorDetails/{vendorId}" }, method = RequestMethod.GET)
	public String getVendorDetails(@PathVariable Long vendorId, ModelMap model,@ModelAttribute("getEditVendorsListDetails") List<Vendor> vendors) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		

		Vendor vendor = null;
		
		for (Vendor v : vendors) {
			if (v.getVendor_id() == vendorId) {
				
				vendor=v;
				break;
			}
		}

		model.addAttribute("vendorForm", vendor);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("editVendorStage", "getVendorDetails");
		return "getVendors";
	}

	/*
	 * @RequestMapping(value = "/getBankBranch", method = RequestMethod.GET)
	 * public @ResponseBody List<BankBranch> getBankBranch(@RequestParam(value =
	 * "bankId", required = true) Long bankId) {
	 * 
	 * System.out.println("*************** finding branches for bankId " +
	 * bankId);
	 * 
	 * 
	 * List<BankBranch> bankBranchList = null;
	 * 
	 * 
	 * try {
	 * 
	 * AuthTokenInfo tokenInfo = sendTokenRequest();
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * 
	 * HttpEntity<String> request = new HttpEntity<String>(getHeaders()); try {
	 * ResponseEntity<List> response = restTemplate.exchange(
	 * ErpConstants.BANK_BRANCH_FIND_USING_BANK_ID+bankId+
	 * ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
	 * HttpMethod.GET, request, List.class); List<LinkedHashMap<String, Object>>
	 * bankBranchMap = (List<LinkedHashMap<String, Object>>) response.getBody();
	 * if (bankBranchMap != null) {
	 * 
	 * System.out.println(">>>>>>>>>>> getBankBranch -- bankBranchMap " +
	 * bankBranchMap); bankBranchList = new ArrayList<>();
	 * 
	 * for (LinkedHashMap<String, Object> linkedHashMap : bankBranchMap) {
	 * 
	 * BankBranch bankBranch = new BankBranch(); Integer i = (Integer)
	 * linkedHashMap.get("bank_branch_id");
	 * bankBranch.setBank_branch_id(i.longValue());
	 * bankBranch.setBranch_name((String) linkedHashMap.get("branch_name"));
	 * bankBranch.setBranch_ifsc((String) linkedHashMap.get("branch_ifsc"));
	 * 
	 * 
	 * bankBranchList.add(bankBranch); }
	 * 
	 * System.out.println(">>>>>>> Test.getBankBranchList2(bankId) "
	 * +Test.getBankBranchList2(bankId)); System.out.println(
	 * ">>>>>>>>> bankBranchList "+bankBranchList);
	 * 
	 * 
	 * } else { System.out.println("No user exist----------"); }
	 * 
	 * } catch (Exception excep) { excep.printStackTrace(); }
	 * 
	 * } catch (HttpClientErrorException excep) { excep.printStackTrace(); }
	 * 
	 * 
	 * return bankBranchList; }
	 */

	/*
	 * @ModelAttribute("getBanks") public List<Bank> getBanks() {
	 * 
	 * List<Bank> bankList = null;
	 * 
	 * try {
	 * 
	 * AuthTokenInfo tokenInfo = sendTokenRequest();
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * 
	 * HttpEntity<String> request = new HttpEntity<String>(getHeaders()); try {
	 * ResponseEntity<List> response = restTemplate.exchange(
	 * ErpConstants.BANK_GET_ALL + ErpConstants.QPM_ACCESS_TOKEN +
	 * tokenInfo.getAccess_token(), HttpMethod.GET, request, List.class);
	 * List<LinkedHashMap<String, Object>> bankMap = (List<LinkedHashMap<String,
	 * Object>>) response.getBody(); if (bankMap != null) {
	 * 
	 * System.out.println("####################### " + bankMap); bankList = new
	 * ArrayList<>();
	 * 
	 * for (LinkedHashMap<String, Object> linkedHashMap : bankMap) {
	 * 
	 * Bank bank = new Bank(); Integer i = (Integer)
	 * linkedHashMap.get("bank_id"); bank.setBank_id(i.longValue());
	 * bank.setBank_name((String) linkedHashMap.get("bank_name"));
	 * 
	 * bankList.add(bank); }
	 * 
	 * System.out.println("Test.getBankList() :: "+Test.getBankList());
	 * System.out.println("bankList :: "+bankList);
	 * 
	 * 
	 * 
	 * } else { System.out.println("No user exist----------"); }
	 * 
	 * } catch (Exception excep) { excep.printStackTrace(); }
	 * 
	 * } catch (HttpClientErrorException excep) { excep.printStackTrace(); }
	 * 
	 * // ====================================
	 * 
	 * //return Test.getBankList(); return bankList; }
	 */

	/*
	 * @ModelAttribute("getBankBranches") public List<BankBranch>
	 * getBankBranches() {
	 * 
	 * 
	 * 
	 * return Test.getBankBranchList(); }
	 */

	@ModelAttribute("getVendorTypes")
	public List<VendorType> getVendorTypes() {
		List<VendorType> vendorTypeList = null;

		try {

			AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			try {
				ResponseEntity<List> response = restTemplate.exchange(
						ErpConstants.VENDOR_TYPE_GET_ALL + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
						HttpMethod.GET, request, List.class);
				List<LinkedHashMap<String, Object>> vendorTypeMap = (List<LinkedHashMap<String, Object>>) response
						.getBody();

				
				if (vendorTypeMap != null) {
					vendorTypeList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : vendorTypeMap) {

						VendorType vendorType = new VendorType();
						Integer i = (Integer) linkedHashMap.get("vendorType_id");

						Long l = i.longValue();
						vendorType.setVendorType_id(l);
						vendorType.setVendorType_name((String) linkedHashMap.get("vendorType_name"));
						vendorTypeList.add(vendorType);
					}

				} else {
					System.out.println("No user exist----------");
				}

			} catch (Exception excep) {
				excep.printStackTrace();
			}

		} catch (HttpClientErrorException excep) {
			excep.printStackTrace();
		}

		// ====================================

		// return Test.getVendorTypeList();
		return vendorTypeList;
	}

	@ModelAttribute("getEditVendorsListDetails")
	public List<Vendor> getVendors() {

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

			System.out.println("************************* map " + map);
			if (map != null) {
				tokenInfo = new AuthTokenInfo();
				tokenInfo.setAccess_token((String) map.get("access_token"));
				tokenInfo.setToken_type((String) map.get("token_type"));
				tokenInfo.setRefresh_token((String) map.get("refresh_token"));
				tokenInfo.setExpires_in((Integer) map.get("expires_in"));
				tokenInfo.setScope((String) map.get("scope"));
				System.out.println("################# " + tokenInfo);
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
