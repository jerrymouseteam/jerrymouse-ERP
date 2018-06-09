package com.ERP.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ERP.constants.ErpConstants;
import com.ERP.model.Address;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.KeyValueMapper;
import com.ERP.model.QuotationRequisition;
import com.ERP.model.QuotationVendor;
import com.ERP.model.RequestQuotation;
import com.ERP.model.RequestQuotationWithProcedure;
import com.ERP.model.User;
import com.ERP.model.Vendor;
import com.ERP.model.VendorDTO;
import com.ERP.model.VendorType;
import com.ERP.util.Utilities;
import com.ERP.model.ProjectRequisition;

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
	public String getQuotations(@ModelAttribute("quotationForm") User user, BindingResult result, ModelMap model) {

		VendorDTO vendor = new VendorDTO();

		System.out.println("getQuotations");
		model.addAttribute("quotationForm", vendor);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());
		model.addAttribute("success", "");

		return "getQuotations";
	}

	@RequestMapping(value = { "/requestQuotation" }, method = RequestMethod.GET)
	// public String requestQuotation(@ModelAttribute("requestQuotationForm")
	// RequestQuotation requestQuotation,
	// BindingResult result, ModelMap model) {
	public String requestQuotation(@ModelAttribute("requestQuotationForm") RequestQuotation requestQuotation,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.setProperty("file.encoding", "UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8;");
		System.out.println("\nTesting requestQuotation API----------");
		List<QuotationRequisition> list = getRequisitionsList();
		List<QuotationVendor> list2 = getQuotationVendors();
		requestQuotation.setQuotationRequisitions(list);
		requestQuotation.setQuotationVendors(list2);

		model.addAttribute("editUserStage", "editUserList");
		// model.addAttribute("getRequisitionsListForQuotation", list);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());
		return "requestQuotation";
	}

	@RequestMapping(value = { "/requestQuotation2" }, method = RequestMethod.POST)
	public String createQuotation(@ModelAttribute("requestQuotationForm") RequestQuotation requestQuotation,
			BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.setProperty("file.encoding", "UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8;");

		System.out.println("############# requestQuotation2 ####################");
		System.out.println("\nTesting createQuotation API---------- requestQuotation : " + requestQuotation);

		System.out.println("createQuotation - getVendors2()" + requestQuotation.getQuotationVendors());
		System.out
				.println("createQuotation - getQuotationRequisitions()" + requestQuotation.getQuotationRequisitions());

		StringBuilder quotationVendorNames = new StringBuilder();
		Long quotationVendorTotalCount = 0l;
		List<QuotationVendor> quotationVendors = requestQuotation.getQuotationVendors();
		for (QuotationVendor quotationVendor : quotationVendors) {
			if (quotationVendor.isQuotationVendorChecked()) {
				quotationVendorNames.append(quotationVendor.getVendorName()).append("||");
				quotationVendorTotalCount++;
			}
		}

		System.out.println("quotationVendorNames " + quotationVendorNames);
		System.out.println("quotationVendorTotalCount " + quotationVendorTotalCount);

		List<QuotationRequisition> quotationRequisition = requestQuotation.getQuotationRequisitions();
		for (QuotationRequisition quotationRequisition2 : quotationRequisition) {

			if (quotationRequisition2.isChecked()) {
				try {

					RequestQuotationWithProcedure requestQuotationWithProcedure = new RequestQuotationWithProcedure();

					requestQuotationWithProcedure.setRequisitionId(quotationRequisition2.getRequisitionId());
					requestQuotationWithProcedure.setLastDateOfRFQSubmission(requestQuotation.getLastSubmissinRFQ());
					requestQuotationWithProcedure.setRequestQuotationDeliveryDate(requestQuotation.getDeliveryDate());
					requestQuotationWithProcedure.setRequestQuotationComments(requestQuotation.getComment());

					AuthTokenInfo tokenInfo = sendTokenRequest();

					RestTemplate restTemplate = new RestTemplate();
					HttpEntity<Object> request2 = new HttpEntity<Object>(requestQuotationWithProcedure, getHeaders());
					try {
						ResponseEntity<RequestQuotationWithProcedure> response2 = restTemplate
								.postForEntity(
										ErpConstants.REQUESTQUOTATION_CREATE_PROC + ErpConstants.QPM_ACCESS_TOKEN
												+ tokenInfo.getAccess_token(),
										request2, RequestQuotationWithProcedure.class);
					} catch (HttpClientErrorException excep) {

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		model.addAttribute("editUserStage", "editUserList");
		model.addAttribute("editUserList", true);
		model.addAttribute("loggedinuser", new Utilities().getPrincipal());

		System.out.println("############# requestQuotation2 ####################");
		return "redirect:/requestQuotation";
	}

	// @ModelAttribute("getRequisitionsListForQuotation")
	// public List<Requisition> getRequisitionsList() {
	// return Test.getRequisitions();
	// }
	//
	@ModelAttribute("getVendorNameList")
	public List<String> getVendorNameList() {
		List<String> vList = new ArrayList<>();
		vList.add("ABC Enterprise");
		vList.add("XYZ Enterprise");
		return vList;
	}

	@ModelAttribute("getRequisitionsListForQuotation")
	public List<QuotationRequisition> getRequisitionsList() {

		System.out.println("########################## getRequisitionsList #################################");

		List<QuotationRequisition> quotationRequisitionList = null;

		try {

			AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			try {
				ResponseEntity<List> response = restTemplate.exchange(ErpConstants.PROJECTREQUISITION_GET_ALL
						+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request,
						List.class);
				List<LinkedHashMap<String, Object>> projectRequisitionMap = (List<LinkedHashMap<String, Object>>) response
						.getBody();

				if (projectRequisitionMap != null) {

					quotationRequisitionList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : projectRequisitionMap) {

						QuotationRequisition quotationRequisition = new QuotationRequisition();
						System.out.println("linkedHashMap.get(requisitionId) " + linkedHashMap.get("requisitionId"));
						System.out.println("linkedHashMap.get(requisitionCreatedDate) "
								+ linkedHashMap.get("requisitionCreatedDate"));
						System.out.println("linkedHashMap.get(requisitionUpdatedDate) "
								+ linkedHashMap.get("requisitionUpdatedDate"));
						System.out.println("linkedHashMap.get(requisitionRequestedBY) "
								+ linkedHashMap.get("requisitionRequestedBY"));
						System.out.println("linkedHashMap.get(requisitionDateOfGeneration) "
								+ linkedHashMap.get("requisitionDateOfGeneration"));
						System.out.println(
								"linkedHashMap.get(requisitionStatus) " + linkedHashMap.get("requisitionStatus"));
						Integer i = (Integer) linkedHashMap.get("requisitionId");

						quotationRequisition.setRequisitionId(i.longValue());

						quotationRequisition.setRequisitionStatus((String) linkedHashMap.get("requisitionStatus"));
						quotationRequisition
								.setRequisitionJustification((String) linkedHashMap.get("requisitionJustification"));
						quotationRequisition.setRequisitionDateOfGeneration(
								(String) linkedHashMap.get("requisitionDateOfGeneration"));
						quotationRequisition.setRequisitionExpectedDelivery(
								(String) linkedHashMap.get("requisitionExpectedDelivery"));
						quotationRequisition
								.setRequisitionRequestedBY((String) linkedHashMap.get("requisitionRequestedBY"));

						LinkedHashMap<String, Object> projectMap = (LinkedHashMap<String, Object>) linkedHashMap
								.get("project");

						// Project project = new Project();

						// project.setProject_id(((Integer)
						// projectMap.get("project_id")));
						System.out.println("projectMap.get(project_id)).longValue() " + projectMap.get("project_id"));
						System.out.println("projectMap.get(projectName)).longValue() " + projectMap.get("projectName"));

						quotationRequisition.setProjectId(((Integer) projectMap.get("project_id")));
						quotationRequisition.setProjectName((String) projectMap.get("projectName"));

						quotationRequisition.setChecked(false);

						quotationRequisitionList.add(quotationRequisition);
					}

					System.out.println("==> QUOTATION REQUISITION CONTROLLER : quotationRequisitionList : "
							+ quotationRequisitionList);

				} else {
					System.out.println("No Item exist----------");
				}

			} catch (Exception excep) {
				excep.printStackTrace();
			}

		} catch (HttpClientErrorException excep) {
			excep.printStackTrace();
		}

		System.out.println("########################## getRequisitionsList #################################  ");

		// return Test.getRequisitions();
		// return projectRequisitionList;
		return quotationRequisitionList;
	}

	@ModelAttribute("getVendors")
	public List<Vendor> getVendors() {

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

						Vendor vendor = new Vendor();
						vendor.setVendor_id(((Integer) linkedHashMap.get("vendor_id")).longValue());
						vendor.setVendor_name((String) linkedHashMap.get("vendor_name"));

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

		System.out.println("getVendors " + vendorList);
		return vendorList;
	}

	@ModelAttribute("getQuotationVendors")
	public List<QuotationVendor> getQuotationVendors() {

		List<QuotationVendor> quotationVendorList = null;

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
					quotationVendorList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : vendorMap) {

						QuotationVendor vendor = new QuotationVendor();
						vendor.setVendorId(((Integer) linkedHashMap.get("vendor_id")).longValue());
						vendor.setVendorName((String) linkedHashMap.get("vendor_name"));
						vendor.setQuotationVendorChecked(false);

						quotationVendorList.add(vendor);

						System.out.println(quotationVendorList);
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

		System.out.println("getVendors " + quotationVendorList);
		return quotationVendorList;
	}

	@ModelAttribute("getVendors2")
	public List<KeyValueMapper> getVendors2() {

		List<KeyValueMapper> keyValueMapperList = null;

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
					keyValueMapperList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : vendorMap) {

						KeyValueMapper keyValueMapper = new KeyValueMapper();
						keyValueMapper.setKey(((Integer) linkedHashMap.get("vendor_id")).longValue());
						keyValueMapper.setValue((String) linkedHashMap.get("vendor_name"));

						keyValueMapperList.add(keyValueMapper);

						System.out.println(keyValueMapperList);
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

		System.out.println("getVendors " + keyValueMapperList);
		return keyValueMapperList;
	}

	@RequestMapping(value = { "/getRequestQuotations" }, method = RequestMethod.GET)
	public String getVendors(@ModelAttribute("requestQuotationForm") RequestQuotation requestQuotation, BindingResult result, ModelMap model) {

		List<RequestQuotation> requestQuotationList = null;

		try {

			AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			try {
				ResponseEntity<List> response = restTemplate.exchange(ErpConstants.REQUESTQUOTATION_GET_ALL
						+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request,
						List.class);
				List<LinkedHashMap<String, Object>> requestQuotationMap = (List<LinkedHashMap<String, Object>>) response
						.getBody();

				if (requestQuotationMap != null) {
					requestQuotationList = new ArrayList<>();
					
					

					for (LinkedHashMap<String, Object> linkedHashMap : requestQuotationMap) {
						System.out.println("$$$$$$ RQUESTQUOTATION LIST $$$$$$$$$");
						 Set<String> key1s = linkedHashMap.keySet();
					        for(String k:key1s){
					            System.out.println("$$$$$$ MAPKey1 -- "+k+" -- MAPValue1 -- "+linkedHashMap.get(k));
					        }
						RequestQuotation rq=new RequestQuotation();
						System.out.println(
								"requestQuotationId" + ((Integer) linkedHashMap.get("requestQuotationId")).longValue());
						rq.setRequestQuotationId(((Integer) linkedHashMap.get("requestQuotationId")).longValue());
						System.out.println("requestQuotationDeliveryDate"
								+ (String) linkedHashMap.get("requestQuotationDeliveryDate"));
						
						System.out.println(
								"lastDateOfRFQSubmission" + (String) linkedHashMap.get("lastDateOfRFQSubmission"));
						System.out.println(
								"requestQuotationStatus" + (String) linkedHashMap.get("requestQuotationStatus"));
						rq.setRequestQuotationStatus((String) linkedHashMap.get("requestQuotationStatus"));
						System.out.println("comments" + (String) linkedHashMap.get("comments"));
						rq.setComments((String) linkedHashMap.get("comments"));

						try {
							LinkedHashMap<String, Object> projectRequisitionMap = (LinkedHashMap<String, Object>) linkedHashMap
									.get("projectRequisition");
							
							
							  Set<String> keys = projectRequisitionMap.keySet();
						        for(String k:keys){
						            System.out.println("$$$$$$ MAPKey2 -- "+k+" -- MAPValue2 -- "+projectRequisitionMap.get(k));
						        }
							//System.out.println(
								//	"requisitionId" + ((Integer) projectRequisitionMap.get("requisitionId")).longValue());
							//ProjectRequisition p=new ProjectRequisition();
						//	p.setRequisitionId(((Integer) projectRequisitionMap.get("requisitionId")).longValue());
							//rq.setProjectRequisition(p);

						} catch (Exception e) {
							e.printStackTrace();
						}

						requestQuotationList.add(rq);

						System.out.println(requestQuotationList);
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

		model.addAttribute("getEditRequestQuotationDetails", requestQuotationList);
		model.addAttribute("editVendorStage", "getVendorList");
		//model.addAttribute("loggedinuser", u.getPrincipal());
		return "editRequestQuotation";
	}

	private static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
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

}
