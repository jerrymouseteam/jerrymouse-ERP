package com.ERP.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
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
import com.ERP.constants.GradeType;
import com.ERP.constants.GradeUnitVo;
import com.ERP.constants.MaterialType;
import com.ERP.constants.Test;
import com.ERP.constants.UnitType;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Grade;
import com.ERP.model.Item;
import com.ERP.model.Project;
import com.ERP.model.Requisition;
import com.ERP.model.RequisitionItem;
import com.ERP.model.Unit;
import com.ERP.model.User;
import com.ERP.service.UserProfileService;
import com.ERP.util.AuthTokenAccess;
import com.ERP.util.Utilities;

@Controller
@RequestMapping("/")
@SessionAttributes({ "roles", "getItemsList2"})
public class RequisitionController {

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	RestTemplate restTemplate;
	
	Utilities u= new com.ERP.util.Utilities();

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/addrequisition" }, method = RequestMethod.GET)
	public String newProject(ModelMap model) {
		AuthTokenInfo tokenInfo = AuthTokenAccess.sendTokenRequest();

		Requisition requisition = null;
		HttpEntity<String> request = new HttpEntity<String>(
				AuthTokenAccess.getHeaders());
		try {
			ResponseEntity<Requisition> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI
							+ "/requisitionAuth/addRequisition"
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, Requisition.class);
			requisition = response.getBody();
		} catch (Exception excep) {
			excep.printStackTrace();
		}

		System.out.println(requisition);
		model.addAttribute("requistionForm", requisition);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());

		Map<String, GradeUnitVo> itemTypeMap = new HashMap<String, GradeUnitVo>();

		GradeUnitVo aggregateVo = new GradeUnitVo();
		aggregateVo.getGradeType().add(GradeType.M1.getGradeType());
		aggregateVo.getGradeType().add(GradeType.M2.getGradeType());
		aggregateVo.getUnitType().add(UnitType.brass.getUnitType());
		itemTypeMap.put(MaterialType.Aggregates.getMaterialType(), aggregateVo);

		GradeUnitVo blocksVo = new GradeUnitVo();
		aggregateVo.getGradeType().add(GradeType.inch4.getGradeType());
		aggregateVo.getGradeType().add(GradeType.inch6.getGradeType());
		aggregateVo.getGradeType().add(GradeType.inch9.getGradeType());
		aggregateVo.getUnitType().add(UnitType.nos.getUnitType());
		itemTypeMap.put(MaterialType.Blocks.getMaterialType(), blocksVo);

		GradeUnitVo cementVo = new GradeUnitVo();
		aggregateVo.getGradeType().add(GradeType.PPC.getGradeType());
		aggregateVo.getGradeType().add(GradeType.OPC33.getGradeType());
		aggregateVo.getGradeType().add(GradeType.OPC43.getGradeType());
		aggregateVo.getGradeType().add(GradeType.OPC53.getGradeType());
		aggregateVo.getUnitType().add(UnitType.bags.getUnitType());
		itemTypeMap.put(MaterialType.Cement.getMaterialType(), cementVo);

		GradeUnitVo conventionalVo = new GradeUnitVo();
		aggregateVo.getGradeType().add(GradeType.N_A.getGradeType());
		aggregateVo.getUnitType().add(UnitType.sqm.getUnitType());
		itemTypeMap.put(MaterialType.ConventionalShuttering.getMaterialType(),
				conventionalVo);

		GradeUnitVo mivanVo = new GradeUnitVo();
		aggregateVo.getGradeType().add(GradeType.N_A.getGradeType());
		aggregateVo.getUnitType().add(UnitType.sqm.getUnitType());
		itemTypeMap
				.put(MaterialType.MivanShuttering.getMaterialType(), mivanVo);

		GradeUnitVo rmcVo = new GradeUnitVo();
		aggregateVo.getGradeType().add(GradeType.M20.getGradeType());
		aggregateVo.getGradeType().add(GradeType.M25.getGradeType());
		aggregateVo.getGradeType().add(GradeType.M30.getGradeType());
		aggregateVo.getGradeType().add(GradeType.M35.getGradeType());
		aggregateVo.getGradeType().add(GradeType.M40.getGradeType());
		aggregateVo.getGradeType().add(GradeType.M45.getGradeType());
		aggregateVo.getGradeType().add(GradeType.M50.getGradeType());
		aggregateVo.getUnitType().add(UnitType.cum.getUnitType());
		itemTypeMap.put(MaterialType.RMC.getMaterialType(), rmcVo);

		GradeUnitVo sandVo = new GradeUnitVo();
		aggregateVo.getGradeType().add(GradeType.N_A.getGradeType());
		aggregateVo.getUnitType().add(UnitType.brass.getUnitType());
		itemTypeMap.put(MaterialType.Sand.getMaterialType(), sandVo);

		GradeUnitVo steelVo = new GradeUnitVo();
		aggregateVo.getGradeType().add(
				GradeType.FE415.getGradeType() + " "
						+ GradeType.d6mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE415.getGradeType() + " "
						+ GradeType.d8mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE415.getGradeType() + " "
						+ GradeType.d12mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE415.getGradeType() + " "
						+ GradeType.d16mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE415.getGradeType() + " "
						+ GradeType.d20mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE415.getGradeType() + " "
						+ GradeType.d25mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE415.getGradeType() + " "
						+ GradeType.d30mm.getGradeType());

		aggregateVo.getGradeType().add(
				GradeType.FE500.getGradeType() + " "
						+ GradeType.d6mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE500.getGradeType() + " "
						+ GradeType.d8mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE500.getGradeType() + " "
						+ GradeType.d12mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE500.getGradeType() + " "
						+ GradeType.d16mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE500.getGradeType() + " "
						+ GradeType.d20mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE500.getGradeType() + " "
						+ GradeType.d25mm.getGradeType());
		aggregateVo.getGradeType().add(
				GradeType.FE500.getGradeType() + " "
						+ GradeType.d30mm.getGradeType());
		aggregateVo.getUnitType().add(UnitType.Mt.getUnitType());
		itemTypeMap.put(MaterialType.Steel.getMaterialType(), steelVo);

		model.addAttribute("itemTypeMap", itemTypeMap);

		/**
		 * TODO : Also need to check how exactly update for gradetype and unit
		 * will take place.
		 */

		HttpEntity<String> requestUser = new HttpEntity<String>(
				AuthTokenAccess.getHeaders());
		User user = null;
		String userName = getPrincipal();
		try {
			ResponseEntity<User> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI + "/user/ssoid/" + userName
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					requestUser, User.class);
			user = response.getBody();
		} catch (Exception excep) {
			excep.printStackTrace();
		}
		model.addAttribute("user", user);
		return "raisedRequistion";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/addrequisition" }, method = RequestMethod.POST)
	public String createRequisition(
			@ModelAttribute("requistionForm") Requisition requistion,
			BindingResult result, ModelMap model) {
		//AuthTokenInfo tokenInfo = AuthTokenAccess.sendTokenRequest();
		
		System.out.println("==========================================");
		
		System.out.println("Requisition : "+requistion);
		
		System.out.println("==========================================");
		

	/*	if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addObject("error", result.getAllErrors());
			model.setViewName("raisedRequistion");
			return model;
		}*/

	/*	HttpEntity<Object> request = new HttpEntity<Object>(requistionForm,
				AuthTokenAccess.getHeaders());
		try {
			restTemplate.postForEntity(
					ErpConstants.REST_SERVICE_URI
							+ "/requisitionAuth/addRequisition/"
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), request,
					Requisition.class);
		} catch (HttpClientErrorException excep) {

			excep.printStackTrace();

		}*/
	
		
		

		return "raisedRequistion";
	}

	/**
	 * This method will list all existing projects.
	 */
	/*
	 * @RequestMapping(value = "/listproject", method = RequestMethod.GET,
	 * produces = "application/json") public @ResponseBody List<Requisition>
	 * listRequisition(ModelMap model) { AuthTokenInfo tokenInfo =
	 * AuthTokenAccess.sendTokenRequest(); List<Requisition> requisitionList =
	 * null;
	 * 
	 * HttpEntity<String> request = new HttpEntity<String>(
	 * AuthTokenAccess.getHeaders()); try { ResponseEntity<List> response =
	 * restTemplate.exchange( ErpConstants.REST_SERVICE_URI +
	 * "/requisitionAuth/list/" + ErpConstants.QPM_ACCESS_TOKEN +
	 * tokenInfo.getAccess_token(), HttpMethod.GET, request, List.class);
	 * requisitionList = (List<Requisition>) response.getBody(); if
	 * (!requisitionList.isEmpty()) {
	 * 
	 * model.addAttribute("loggedinuser", getPrincipal()); } else {
	 * System.out.println("List is empty ----------"); }
	 * 
	 * } catch (Exception excep) { excep.printStackTrace(); }
	 * 
	 * return requisitionList; }
	 */

	/* Requistion Controller */

	@RequestMapping(value = { "/raisedRequistion" }, method = RequestMethod.GET)
	public String raisedRequistion(
			@ModelAttribute("requistionForm") Requisition requistion,
			BindingResult result, ModelMap model) {

		System.out
				.println("*********** INSIDE raisedRequistion *******************8");
		
		
		model.addAttribute("editRequisitionStage", "getRequisitionList");

		return "raisedRequistion";

	}
	

	@RequestMapping(value = { "/editRequisitionDetails/{reqNo}" }, method = RequestMethod.GET)
	public String editRequisitionDetails(@PathVariable Long reqNo, ModelMap model) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting editRequisitionDetails API---------- reqNo :: " + reqNo);
		
		Requisition requisition=null;
		if(reqNo ==1)
		{
			requisition=Test.getRequisition1();
		}
		else
		{

			requisition=Test.getRequisition2();
			
		}

		

		
		model.addAttribute("requistionForm", requisition);
	
		model.addAttribute("editRequisitionStage", "editRequisitionDetails");
		return "editRequistion";
	}
	
	@RequestMapping(value = { "/updateRequisitionDetails" }, method = RequestMethod.POST)
	public String updateMyData(ModelMap model, @ModelAttribute("requistionForm") Requisition requisition) {

		System.out.println("\nTesting updateMyData API---------- Requisition :: " + requisition);

	
		//model.addAttribute("loggedinuser", u.getPrincipal());
		return "redirect:/editRequistion";
	}
	
	
	@RequestMapping(value = { "/getRequisitionDetails/{reqNo}" }, method = RequestMethod.GET)
	public String getRequisitionDetails(@PathVariable Long reqNo, ModelMap model) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting getRequisitionDetails API---------- reqNo :: " + reqNo);
		
		Requisition requisition=null;
		if(reqNo ==1)
		{
			requisition=Test.getRequisition1();
		}
		else
		{

			requisition=Test.getRequisition2();
			
		}


		

		
		model.addAttribute("requistionForm", requisition);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("editRequisitionStage", "getRequisitionDetails");
		return "editRequistion";
	}
	
	

	@RequestMapping(value = { "/editRequistion" }, method = RequestMethod.GET)
	public String editRequistion(
			@ModelAttribute("requistionForm") Requisition requistion,
			BindingResult result, ModelMap model) {

		System.out
				.println("*********** INSIDE editRequistion *******************8");
		 requistion=null;

		model.addAttribute("editRequisitionStage", "getRequisitionList");
		return "editRequistion";

	}

	@RequestMapping(value = { "/deleteRequistion" }, method = RequestMethod.GET)
	public String deleteRequistion(
			@ModelAttribute("requistionForm") Requisition requistion,
			BindingResult result, ModelMap model) {

		System.out
				.println("*********** INSIDE raisedRequistion *******************8");

		return "deleteRequistion";

	}
	
	
	@RequestMapping(value = "/getGradesForItems", method = RequestMethod.GET)
	public @ResponseBody
	List<String> getGradesForItems(
			@RequestParam(value = "bankId", required = true) String itemName) {
		
		System.out.println("*************** finding getGradesForItems for itemName " + itemName);
		return Test.getGradesForItems(itemName);
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	@ModelAttribute("getProjectsList")
	public List<Project> getProjectsList()
	{
		return Test.getProjectListDetails();
	}

	@ModelAttribute("getEditRequisitionListDetails")
	public List<Requisition> getEditRequisitionListDetails() {

		Project p1 = new Project();
		p1.setProjectName("Suchi Heights");
		p1.setSubDivisionName("Private Sector");
		p1.setStartDate(new Date());
		p1.setEndDate(new Date());
		p1.setProjectAddress("");
		p1.setRemarks("");
		p1.setContactPersonName("John");
		p1.setContactPersonEmail("");
		p1.setContactPersonEmail("");
		p1.setProjectClientName("Lodha");
		p1.setProjectClientPhone("");
		p1.setProjectClientEmail("");
		p1.setStructuralName("");
		p1.setStructuralPhone("");
		p1.setStructuralEmail("");

		Project p2 = new Project();
		p2.setProjectName("Raheja Heights");
		p2.setSubDivisionName("Private Sector");
		p2.setStartDate(new Date());
		p2.setEndDate(new Date());
		p2.setProjectAddress("");
		p2.setRemarks("");
		p2.setContactPersonName("Harshad");
		p2.setContactPersonEmail("");
		p2.setContactPersonEmail("");
		p2.setProjectClientName("Raheja");
		p2.setProjectClientPhone("");
		p2.setProjectClientEmail("");
		p2.setStructuralName("");
		p2.setStructuralPhone("");
		p2.setStructuralEmail("");

		List<Requisition> requisitionList = new ArrayList<>();

		Requisition r1 = new Requisition();
		r1.setProject(p1);
		r1.setRequestedBy("John");
		r1.setJustification("Test Justification Message 1");
		r1.setDateGen("2018-02-23");
		r1.setExpectedDt("2018-02-23");
		r1.setReqNo(1L);
		r1.setReqSts("Approved");
		r1.setReqDate("2018-02-23");

		Requisition r2 = new Requisition();
		r2.setProject(p2);
		r2.setRequestedBy("Harshad");
		r2.setJustification("Test Justification Message 2");
		r2.setDateGen("2018-02-23");
		r2.setExpectedDt("2018-02-23");
		r2.setReqNo(2L);
		r2.setReqSts("Approved");
		r2.setReqDate("2018-02-23");
		requisitionList.add(r1);
		requisitionList.add(r2);

		return requisitionList;
	}

	@ModelAttribute("getEditProjectListDetails")
	public List<Project> getEditProjectListDetails() {

		

		
		return Test.getProjectListDetails();
	}


	
	 @ModelAttribute("getItemsList")
	   public List<String> getItemsList() {
		 return Test.getItems();
	   }
	 @ModelAttribute("getItemsList2")
	   public List<Item> getItemsList2() {
		 
		 //===============================================================
		 System.out.println("########################## FETCH ITEMS #################################");
		 
			List<Item> itemList = null;

			try {

				AuthTokenInfo tokenInfo = sendTokenRequest();

				RestTemplate restTemplate = new RestTemplate();

				HttpEntity<String> request = new HttpEntity<String>(getHeaders());
				try {
					ResponseEntity<List> response = restTemplate.exchange(
							ErpConstants.ITEM_GET_ALL + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
							HttpMethod.GET, request, List.class);
					List<LinkedHashMap<String, Object>> itemMap = (List<LinkedHashMap<String, Object>>) response
							.getBody();
					
					System.out.println("### itemMap : "+itemMap);

					if (itemMap != null) {
						itemList = new ArrayList<>();

						for (LinkedHashMap<String, Object> linkedHashMap : itemMap) {

							Item item = new Item();
							Integer i = (Integer) linkedHashMap.get("itemId");

							Long l = i.longValue();
							item.setItemId(l);
							item.setItemName((String) linkedHashMap.get("itemName"));
							item.setItemDesc((String) linkedHashMap.get("itemDesc"));
								
							try {
								
								List<Grade> grades=new ArrayList<>();
								List<LinkedHashMap<String, Object>> gradeMap = (List<LinkedHashMap<String, Object>>) linkedHashMap
										.get("grades");
								
								for (LinkedHashMap<String, Object> linkedHashGradeMap : gradeMap) {
									
									Grade grade = new Grade();
									
									grade.setGradeId(((Integer) linkedHashGradeMap.get("gradeId")).longValue());
									grade.setGradeName((String) linkedHashGradeMap.get("gradeName"));
									grade.setGradeDesc((String) linkedHashMap.get("gradeDesc"));
									
									List<LinkedHashMap<String, Object>> unitMap = (List<LinkedHashMap<String, Object>>) linkedHashGradeMap
											.get("units");
									
									List<Unit> units=new ArrayList<>();
									for (LinkedHashMap<String, Object> linkedHashUnitMap : unitMap) {
										
										Unit unit = new Unit();
										
										unit.setUnitId(((Integer) linkedHashUnitMap.get("unitId")).longValue());
										unit.setUnitName((String) linkedHashUnitMap.get("unitName"));
										unit.setUnitDesc((String) linkedHashMap.get("unitDesc"));
										units.add(unit);
									}
									grade.setUnits(units);
									grades.add(grade);
								}
								item.setGrades(grades);
								
							} catch (Exception e) {
								
								
								e.printStackTrace();
							}


							itemList.add(item);
						}

					} else {
						System.out.println("No Item exist----------");
					}

				} catch (Exception excep) {
					excep.printStackTrace();
				}

			} catch (HttpClientErrorException excep) {
				excep.printStackTrace();
			}
		 
			 System.out.println("########################## FETCH ITEMS ################################# itemList "+itemList);
		 //==============================================================
		 
		 
		 return Test.getItemsList();
	   }
	 
	 
	 @ModelAttribute("getGradesList")
	   public List<String> getGradesList() {
		 return Test.getGrades();
	   }
	 
	 @ModelAttribute("getGradesList2")
	   public List<Grade> getGradesList2() {
		 return Test.getGradesList();
	   }
	 
	 @ModelAttribute("getQuantitiesList")
	   public List<String> getQuantitiesList() {
		 return Test.getQuantities();
	   }
	 
	 @ModelAttribute("getUnitsList")
	   public List<String> getUnitsList() {
		 return Test.getUnits();
	   }
	 
	 @ModelAttribute("getUnitsList2")
	   public List<Unit> getUnitsList2() {
		 return Test.getUnitsList();
	   }
	 
	 @ModelAttribute("getRequisitionItemsList")
	   public List<RequisitionItem> getRequisitionItemsList() {
		 return Test.getRequisitionItems();
	   }
	 
	 @ModelAttribute("getRequisitionsList")
	   public List<Requisition> getRequisitionsList() {
		 return Test.getRequisitions();
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