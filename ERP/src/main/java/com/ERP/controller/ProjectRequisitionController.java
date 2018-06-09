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
import com.ERP.model.ProjectRequisition;
import com.ERP.model.Requisition;
import com.ERP.model.RequisitionItem;
import com.ERP.model.Unit;
import com.ERP.model.User;
import com.ERP.model.Vendor;
import com.ERP.model.VendorType;
import com.ERP.service.UserProfileService;
import com.ERP.util.AuthTokenAccess;
import com.ERP.util.GradeApiHandler;
import com.ERP.util.ItemApiHandler;
import com.ERP.util.ProjectApiHandler;
import com.ERP.util.UnitApiHandler;
import com.ERP.util.Utilities;

@Controller
@RequestMapping("/projectRequisition")

@SessionAttributes({ "roles", "getItemsList2", "getGradesList2", "getUnitsList2", "getProjectsList",
		"getRequisitionsList" })
public class ProjectRequisitionController {

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	RestTemplate restTemplate;

	Utilities u = new com.ERP.util.Utilities();

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/addrequisition" }, method = RequestMethod.GET)
	public String newProject(ModelMap model) {
		AuthTokenInfo tokenInfo = AuthTokenAccess.sendTokenRequest();

		ProjectRequisition requisition = null;
		HttpEntity<String> request = new HttpEntity<String>(AuthTokenAccess.getHeaders());
		try {
			ResponseEntity<ProjectRequisition> response = restTemplate
					.exchange(
							ErpConstants.REST_SERVICE_URI + "/requisitionAuth/addRequisition"
									+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
							HttpMethod.GET, request, ProjectRequisition.class);
			requisition = response.getBody();
		} catch (Exception excep) {
			excep.printStackTrace();
		}

		System.out.println(requisition);
		model.addAttribute("projectRequistionForm", requisition);
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
		itemTypeMap.put(MaterialType.ConventionalShuttering.getMaterialType(), conventionalVo);

		GradeUnitVo mivanVo = new GradeUnitVo();
		aggregateVo.getGradeType().add(GradeType.N_A.getGradeType());
		aggregateVo.getUnitType().add(UnitType.sqm.getUnitType());
		itemTypeMap.put(MaterialType.MivanShuttering.getMaterialType(), mivanVo);

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
		aggregateVo.getGradeType().add(GradeType.FE415.getGradeType() + " " + GradeType.d6mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE415.getGradeType() + " " + GradeType.d8mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE415.getGradeType() + " " + GradeType.d12mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE415.getGradeType() + " " + GradeType.d16mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE415.getGradeType() + " " + GradeType.d20mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE415.getGradeType() + " " + GradeType.d25mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE415.getGradeType() + " " + GradeType.d30mm.getGradeType());

		aggregateVo.getGradeType().add(GradeType.FE500.getGradeType() + " " + GradeType.d6mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE500.getGradeType() + " " + GradeType.d8mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE500.getGradeType() + " " + GradeType.d12mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE500.getGradeType() + " " + GradeType.d16mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE500.getGradeType() + " " + GradeType.d20mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE500.getGradeType() + " " + GradeType.d25mm.getGradeType());
		aggregateVo.getGradeType().add(GradeType.FE500.getGradeType() + " " + GradeType.d30mm.getGradeType());
		aggregateVo.getUnitType().add(UnitType.Mt.getUnitType());
		itemTypeMap.put(MaterialType.Steel.getMaterialType(), steelVo);

		model.addAttribute("itemTypeMap", itemTypeMap);

		/**
		 * TODO : Also need to check how exactly update for gradetype and unit
		 * will take place.
		 */

		HttpEntity<String> requestUser = new HttpEntity<String>(AuthTokenAccess.getHeaders());
		User user = null;
		String userName = getPrincipal();
		try {
			ResponseEntity<User> response = restTemplate.exchange(ErpConstants.REST_SERVICE_URI + "/user/ssoid/"
					+ userName + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET,
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
	public String createRequisition(@ModelAttribute("projectRequistionForm") ProjectRequisition projectRequisition,
			BindingResult result, ModelMap model) {

		AuthTokenInfo tokenInfo = sendTokenRequest();

		projectRequisition.setRequisitionCreatedDate(new Date());
		projectRequisition.setRequisitionUpdatedDate(new Date());
		projectRequisition.setRequisitionStatus("ACTIVE");

		try {

			ResponseEntity<Project> projectResponse = new ProjectApiHandler().findEntityDetailById(tokenInfo,
					projectRequisition.getProjectId());
			Project project = (Project) projectResponse.getBody();
			projectRequisition.setProject(project);
		} catch (Exception excep) {
			excep.printStackTrace();
		}

		List<RequisitionItem> requisitionItemLists = new ArrayList<>();

		for (RequisitionItem requisitionItem : projectRequisition.getRequisitionItems()) {

			if (requisitionItem.isChecked()) {

				try {

					ResponseEntity<Item> itemResponse = new ItemApiHandler().findEntityDetailById(tokenInfo,
							requisitionItem.getItemId());
					Item item = (Item) itemResponse.getBody();
					// System.out.println("#### ITEM : " + item);
					requisitionItem.setItem(item);

					ResponseEntity<Grade> gradeResponse = new GradeApiHandler().findEntityDetailById(tokenInfo,
							requisitionItem.getGradeId());
					Grade grade = (Grade) gradeResponse.getBody();
					// System.out.println("#### GRADE : " + grade);
					requisitionItem.setGrade(grade);

					ResponseEntity<Unit> unitResponse = new UnitApiHandler().findEntityDetailById(tokenInfo,
							requisitionItem.getUnitId());
					Unit unit = (Unit) unitResponse.getBody();
					// System.out.println("#### UNIT : " + unit);
					requisitionItem.setUnit(unit);

					requisitionItem.setCreatedDate(new Date());
					requisitionItem.setUpdatedDate(new Date());

					requisitionItemLists.add(requisitionItem);

				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		}
		projectRequisition.setRequisitionItems(requisitionItemLists);

		try {

			// AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Object> request = new HttpEntity<Object>(projectRequisition, getHeaders());
			try {
				ResponseEntity<ProjectRequisition> response = restTemplate
						.postForEntity(ErpConstants.PROJECTREQUISITION_CREATE + ErpConstants.QPM_ACCESS_TOKEN
								+ tokenInfo.getAccess_token(), request, ProjectRequisition.class);
			} catch (HttpClientErrorException excep) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// AuthTokenInfo tokenInfo = AuthTokenAccess.sendTokenRequest();

		System.out.println("==========================================");

		System.out.println("projectRequistion : " + projectRequisition);

		System.out.println("==========================================");

		/*
		 * if (result.hasErrors()) { System.out.println(result.getAllErrors());
		 * model.addObject("error", result.getAllErrors());
		 * model.setViewName("raisedRequistion"); return model; }
		 */

		/*
		 * HttpEntity<Object> request = new HttpEntity<Object>(requistionForm,
		 * AuthTokenAccess.getHeaders()); try { restTemplate.postForEntity(
		 * ErpConstants.REST_SERVICE_URI + "/requisitionAuth/addRequisition/" +
		 * ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), request,
		 * Requisition.class); } catch (HttpClientErrorException excep) {
		 * 
		 * excep.printStackTrace();
		 * 
		 * }
		 */

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
	public String raisedRequistion(@ModelAttribute("projectRequistionForm") ProjectRequisition projectRequistion,
			BindingResult result, ModelMap model) {

		System.out.println("*********** INSIDE raisedRequistion *******************8");

		///////////////////////////////////////////////

		AuthTokenInfo tokenInfo = sendTokenRequest();

		try {
			ResponseEntity<Item> itemResponse = new ItemApiHandler().findEntityDetailById(tokenInfo, 1l);
			Item item = (Item) itemResponse.getBody();
			System.out.println("#### ITEM :  " + item);

			ResponseEntity<Grade> gradeResponse = new GradeApiHandler().findEntityDetailById(tokenInfo, 1l);
			Grade grade = (Grade) gradeResponse.getBody();
			System.out.println("#### GRADE :  " + grade);

			ResponseEntity<Unit> unitResponse = new UnitApiHandler().findEntityDetailById(tokenInfo, 1l);
			Unit unit = (Unit) unitResponse.getBody();
			System.out.println("#### UNIT :  " + unit);

			ResponseEntity<Project> projectResponse = new ProjectApiHandler().findEntityDetailById(tokenInfo, 1l);
			Project project = (Project) projectResponse.getBody();
			System.out.println("#### Project :  " + project);

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		/////////////////////////////////////////////////

		model.addAttribute("editRequisitionStage", "getRequisitionList");

		return "raisedRequistion";

	}

	@RequestMapping(value = { "/editRequisitionDetails/{requisitionId}" }, method = RequestMethod.GET)
	public String editProjectRequisitionDetails(@PathVariable Long requisitionId, ModelMap model,
			@ModelAttribute("getRequisitionsList") List<ProjectRequisition> projectRequisitions) {
		System.out.println("\nTesting getProjectRequisitionDetails API---------- requisitionId :: " + requisitionId);

		ProjectRequisition projectRequisition = null;

		for (ProjectRequisition v : projectRequisitions) {
			if (v.getRequisitionId() == requisitionId) {

				projectRequisition = v;
				break;
			}
		}

		List<RequisitionItem> requisitionItems = projectRequisition.getRequisitionItems();
		for (RequisitionItem requisitionItem : requisitionItems) {
			System.out.println("################ " + requisitionItem.getItemId());
		}

		model.addAttribute("projectRequistionForm", projectRequisition);

		model.addAttribute("editRequisitionStage", "editRequisitionDetails");
		return "editRequistion";
	}

	@RequestMapping(value = { "/updateRequisitionDetails" }, method = RequestMethod.POST)
	public String updateMyData(ModelMap model,
			@ModelAttribute("projectRequistionForm") ProjectRequisition projectRequisition) {

		System.out.println("\nTesting updateMyData API---------- Requisition :: " + projectRequisition);

		AuthTokenInfo tokenInfo = sendTokenRequest();

		// projectRequisition.setRequisitionCreatedDate(new Date());
		projectRequisition.setRequisitionUpdatedDate(new Date());
		// projectRequisition.setRequisitionStatus("ACTIVE");

		try {

			ResponseEntity<Project> projectResponse = new ProjectApiHandler().findEntityDetailById(tokenInfo,
					projectRequisition.getProjectId());
			Project project = (Project) projectResponse.getBody();
			projectRequisition.setProject(project);
		} catch (Exception excep) {
			excep.printStackTrace();
		}

		List<RequisitionItem> requisitionItemLists = new ArrayList<>();

		for (RequisitionItem requisitionItem : projectRequisition.getRequisitionItems()) {

			if (!(requisitionItem.getRequisitionItemId() == 0 && !requisitionItem.isChecked())) {

				try {

					System.out.println("^^^ requisitionItem.getItemId()" + requisitionItem.getItemId());
					System.out.println("^^^ requisitionItem.getGradeId()" + requisitionItem.getGradeId());
					System.out.println("^^^ requisitionItem.getUnitId()" + requisitionItem.getUnitId());

					ResponseEntity<Item> itemResponse = new ItemApiHandler().findEntityDetailById(tokenInfo,
							requisitionItem.getItemId());
					Item item = (Item) itemResponse.getBody();
					// System.out.println("#### ITEM : " + item);
					requisitionItem.setItem(item);

					ResponseEntity<Grade> gradeResponse = new GradeApiHandler().findEntityDetailById(tokenInfo,
							requisitionItem.getGradeId());
					Grade grade = (Grade) gradeResponse.getBody();
					// System.out.println("#### GRADE : " + grade);
					requisitionItem.setGrade(grade);

					ResponseEntity<Unit> unitResponse = new UnitApiHandler().findEntityDetailById(tokenInfo,
							requisitionItem.getUnitId());
					Unit unit = (Unit) unitResponse.getBody();
					// System.out.println("#### UNIT : " + unit);
					requisitionItem.setUnit(unit);
					/*
					 * requisitionItem.setCreatedDate(new Date());
					 * requisitionItem.setUpdatedDate(new Date());
					 */

					requisitionItemLists.add(requisitionItem);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
		projectRequisition.setRequisitionItems(requisitionItemLists);

		try {

			// AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Object> request = new HttpEntity<Object>(projectRequisition, getHeaders());

			try {
				restTemplate.put(ErpConstants.PROJECTREQUISITION_UPDATE + ErpConstants.QPM_ACCESS_TOKEN
						+ tokenInfo.getAccess_token(), request, ProjectRequisition.class);
			} catch (HttpClientErrorException excep) {
				excep.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// model.addAttribute("loggedinuser", u.getPrincipal());
		return "redirect:/projectRequisition/editRequistion";
	}

	@RequestMapping(value = { "/getRequisitionDetails/{requisitionId}" }, method = RequestMethod.GET)
	public String getProjectRequisitionDetails(@PathVariable Long requisitionId, ModelMap model,
			@ModelAttribute("getRequisitionsList") List<ProjectRequisition> projectRequisitions) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting getProjectRequisitionDetails API---------- requisitionId :: " + requisitionId);

		ProjectRequisition projectRequisition1 = null;

		AuthTokenInfo tokenInfo = sendTokenRequest();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());

		try {
			ResponseEntity<ProjectRequisition> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI + "/projectRequisition/" + requisitionId
							+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
					HttpMethod.GET, request, ProjectRequisition.class);

			System.out.println("mmm response.getBody() : " + response.getBody());
			projectRequisition1 = (ProjectRequisition) response.getBody();
			System.out.println(projectRequisition1 + " 3###############projectssMap");

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		ProjectRequisition projectRequisition = null;

		for (ProjectRequisition v : projectRequisitions) {
			if (v.getRequisitionId() == requisitionId) {

				projectRequisition = v;
				break;
			}
		}

		List<RequisitionItem> requisitionItems = projectRequisition.getRequisitionItems();
		for (RequisitionItem requisitionItem : requisitionItems) {
			System.out.println("################ " + requisitionItem.getItemId());
		}

		model.addAttribute("projectRequistionForm", projectRequisition1);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("editRequisitionStage", "getRequisitionDetails");
		return "editRequistion";
	}

	@RequestMapping(value = { "/editRequistion" }, method = RequestMethod.GET)
	public String editRequistion(@ModelAttribute("requistionForm") Requisition requistion, BindingResult result,
			ModelMap model) {

		List<ProjectRequisition> projectRequisitionList = null;

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
					projectRequisitionList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : projectRequisitionMap) {

						ProjectRequisition projectRequisition = new ProjectRequisition();
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

						projectRequisition.setRequisitionId(i.longValue());

						/*
						 * projectRequisition .setRequisitionCreatedDate((Date)
						 * linkedHashMap.get("requisitionCreatedDate"));
						 * projectRequisition .setRequisitionUpdatedDate((Date)
						 * linkedHashMap.get("requisitionUpdatedDate"));
						 */
						projectRequisition.setRequisitionStatus((String) linkedHashMap.get("requisitionStatus"));
						projectRequisition
								.setRequisitionJustification((String) linkedHashMap.get("requisitionJustification"));
						projectRequisition.setRequisitionDateOfGeneration(
								(String) linkedHashMap.get("requisitionDateOfGeneration"));
						projectRequisition.setRequisitionExpectedDelivery(
								(String) linkedHashMap.get("requisitionExpectedDelivery"));
						projectRequisition
								.setRequisitionRequestedBY((String) linkedHashMap.get("requisitionRequestedBY"));

						LinkedHashMap<String, Object> projectMap = (LinkedHashMap<String, Object>) linkedHashMap
								.get("project");

						// Project project = new Project();

						// project.setProject_id(((Integer)
						// projectMap.get("project_id")));
						System.out.println("projectMap.get(project_id)).longValue() " + projectMap.get("project_id"));
						projectRequisition.setProjectId(((Integer) projectMap.get("project_id")));
						List<RequisitionItem> requisitionItems = new ArrayList<>();
						List<LinkedHashMap<String, Object>> requisitionItemsMap = (List<LinkedHashMap<String, Object>>) linkedHashMap
								.get("requisitionItems");

						for (LinkedHashMap<String, Object> linkedHashrequisitionItemsMap : requisitionItemsMap) {

							RequisitionItem requisitionItem = new RequisitionItem();

							LinkedHashMap<String, Object> itemMap = (LinkedHashMap<String, Object>) linkedHashrequisitionItemsMap
									.get("item");

							System.out.println("itemMap.get(itemId)).longValue() " + itemMap.get("itemId"));
							/*
							 * Item item = new Item();
							 * 
							 * item.setItemId(((Integer)
							 * itemMap.get("itemId")).longValue());
							 */
							requisitionItem.setItemId(((Integer) itemMap.get("itemId")).longValue());

							LinkedHashMap<String, Object> gradeMap = (LinkedHashMap<String, Object>) linkedHashrequisitionItemsMap
									.get("grade");

							/*
							 * Grade grade = new Grade();
							 * 
							 * grade.setGradeId(((Integer)
							 * gradeMap.get("gradeId")).longValue());
							 */

							System.out.println("gradeMap.get(gradeId)).longValue() " + gradeMap.get("gradeId"));
							requisitionItem.setGradeId(((Integer) gradeMap.get("gradeId")).longValue());

							LinkedHashMap<String, Object> unitMap = (LinkedHashMap<String, Object>) linkedHashrequisitionItemsMap
									.get("unit");

							/*
							 * Unit unit = new Unit();
							 * 
							 * unit.setUnitId(((Integer)
							 * unitMap.get("unitId")).longValue());
							 */
							System.out.println("unitMap.get(unitId)).longValue() " + unitMap.get("unitId"));
							System.out.println("linkedHashrequisitionItemsMap.get(quantity)).longValue() "
									+ linkedHashrequisitionItemsMap.get("quantity"));
							System.out.println("linkedHashrequisitionItemsMap.get(checked)).longValue() "
									+ linkedHashrequisitionItemsMap.get("checked"));
							System.out.println("linkedHashrequisitionItemsMap.get(usedFor)).longValue() "
									+ linkedHashrequisitionItemsMap.get("usedFor"));

							requisitionItem.setUnitId(((Integer) unitMap.get("unitId")).longValue());

							requisitionItem.setRequisitionItemId(
									((Integer) linkedHashrequisitionItemsMap.get("requisitionItemId")).longValue());

							requisitionItem
									.setQuantity(((Integer) linkedHashrequisitionItemsMap.get("quantity")).longValue());

							requisitionItem.setChecked(((boolean) linkedHashrequisitionItemsMap.get("checked")));

							requisitionItem.setUsedFor(((String) linkedHashrequisitionItemsMap.get("usedFor")));

							requisitionItems.add(requisitionItem);

						}

						projectRequisition.setRequisitionItems(requisitionItems);
						projectRequisitionList.add(projectRequisition);
					}

					System.out.println(
							"==> PROJECT REQUISITION CONTROLLER : projectRequisitionList : " + projectRequisitionList);

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

		model.addAttribute("getRequisitionsList", projectRequisitionList);
		model.addAttribute("editRequisitionStage", "getRequisitionList");
		return "editRequistion";

	}

	@RequestMapping(value = { "/deleteRequisitionDetails/{projectRequisitionId}" }, method = RequestMethod.GET)
	public String deleteProjectRequisitionDetails(@PathVariable("projectRequisitionId") Long projectRequisitionId,
			ModelMap model) {

		System.out.println("\nTesting deleteRequisitionDetails API---------- requisitionId :: " + projectRequisitionId);

		ProjectRequisition projectRequisition = new ProjectRequisition();
		projectRequisition.setRequisitionId(projectRequisitionId);

		AuthTokenInfo tokenInfo = sendTokenRequest();
		// RestTemplate restTemplate = new RestTemplate();
		// HttpEntity<String> request = new HttpEntity<String>(getHeaders());

		try {

			// AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<Object> request = new HttpEntity<Object>(projectRequisition, getHeaders());

			try {
				restTemplate.put(ErpConstants.PROJECTREQUISITION_DELETE + ErpConstants.QPM_ACCESS_TOKEN
						+ tokenInfo.getAccess_token(), request, ProjectRequisition.class);
			} catch (HttpClientErrorException excep) {
				excep.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/projectRequisition/editRequistion";

	}

	@RequestMapping(value = "/getGradesForItems", method = RequestMethod.GET)
	public @ResponseBody List<String> getGradesForItems(
			@RequestParam(value = "bankId", required = true) String itemName) {

		System.out.println("*************** finding getGradesForItems for itemName " + itemName);
		return Test.getGradesForItems(itemName);
	}

	@RequestMapping(value = "/findGradesByItemId", method = RequestMethod.GET)
	public @ResponseBody List<Grade> findGradesByItemId(@RequestParam(value = "itemId", required = true) Long itemId,
			@ModelAttribute("getItemsList2") List<Item> items) {

		System.out.println("*************** finding Grades for itemId " + itemId);

		List<Grade> grades = null;
		for (Item item : items) {

			if (item.getItemId() == itemId) {
				grades = new ArrayList<>();

				grades.addAll(item.getGrades());

				break;

			}
		}

		return grades;

	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	@ModelAttribute("getProjectsList")
	public List<Project> getProjectsList() {

		System.out.println("########################## FETCH PROJECT #################################");

		List<Project> proejctList = null;

		try {

			AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			try {
				ResponseEntity<List> response = restTemplate.exchange(
						ErpConstants.PROJECT_GET_ALL + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
						HttpMethod.GET, request, List.class);
				List<LinkedHashMap<String, Object>> projectMap = (List<LinkedHashMap<String, Object>>) response
						.getBody();

				if (projectMap != null) {
					proejctList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : projectMap) {

						Project project = new Project();
						Integer i = (Integer) linkedHashMap.get("project_id");

						project.setProject_id(i);
						project.setProjectName((String) linkedHashMap.get("projectName"));

						proejctList.add(project);
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

		System.out.println("########################## FETCH PROJECT #################################  ");
		// ==============================================================

		return proejctList;

		// return Test.getProjectListDetails();
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
				List<LinkedHashMap<String, Object>> itemMap = (List<LinkedHashMap<String, Object>>) response.getBody();

				if (itemMap != null) {
					itemList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : itemMap) {

						Item item = new Item();
						Integer i = (Integer) linkedHashMap.get("itemId");

						Long l = i.longValue();
						item.setItemId(l);
						item.setItemName((String) linkedHashMap.get("itemName"));
						item.setItemDesc((String) linkedHashMap.get("itemDesc"));

						/*
						 * try {
						 * 
						 * List<Grade> grades = new ArrayList<>();
						 * List<LinkedHashMap<String, Object>> gradeMap =
						 * (List<LinkedHashMap<String, Object>>) linkedHashMap
						 * .get("grades");
						 * 
						 * for (LinkedHashMap<String, Object> linkedHashGradeMap
						 * : gradeMap) {
						 * 
						 * Grade grade = new Grade();
						 * 
						 * grade.setGradeId(((Integer)
						 * linkedHashGradeMap.get("gradeId")).longValue());
						 * grade.setGradeName((String)
						 * linkedHashGradeMap.get("gradeName"));
						 * grade.setGradeDesc((String)
						 * linkedHashMap.get("gradeDesc"));
						 * 
						 * List<LinkedHashMap<String, Object>> unitMap =
						 * (List<LinkedHashMap<String, Object>>)
						 * linkedHashGradeMap .get("units");
						 * 
						 * List<Unit> units = new ArrayList<>(); for
						 * (LinkedHashMap<String, Object> linkedHashUnitMap :
						 * unitMap) {
						 * 
						 * Unit unit = new Unit();
						 * 
						 * unit.setUnitId(((Integer)
						 * linkedHashUnitMap.get("unitId")).longValue());
						 * unit.setUnitName((String)
						 * linkedHashUnitMap.get("unitName"));
						 * unit.setUnitDesc((String)
						 * linkedHashMap.get("unitDesc")); units.add(unit); }
						 * grade.setUnits(units); grades.add(grade); }
						 * item.setGrades(grades);
						 * 
						 * } catch (Exception e) {
						 * 
						 * e.printStackTrace(); }
						 */

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

		System.out.println("########################## FETCH ITEMS #################################  ");
		// ==============================================================

		// return Test.getItemsList();
		return itemList;
	}

	@ModelAttribute("getGradesList")
	public List<String> getGradesList() {
		return Test.getGrades();
	}

	@ModelAttribute("getGradesList2")
	public List<Grade> getGradesList2() {

		System.out.println("########################## FETCH GRADE #################################");

		List<Grade> gradeList = null;

		try {

			AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			try {
				ResponseEntity<List> response = restTemplate.exchange(
						ErpConstants.GRADE_GET_ALL + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
						HttpMethod.GET, request, List.class);
				List<LinkedHashMap<String, Object>> gradeMap = (List<LinkedHashMap<String, Object>>) response.getBody();

				if (gradeMap != null) {
					gradeList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : gradeMap) {

						Grade grade = new Grade();

						grade.setGradeId(((Integer) linkedHashMap.get("gradeId")).longValue());
						grade.setGradeName((String) linkedHashMap.get("gradeName"));
						grade.setGradeDesc((String) linkedHashMap.get("gradeDesc"));
						gradeList.add(grade);
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

		System.out.println("########################## FETCH GRADE #################################  ");

		// return Test.getGradesList();

		return gradeList;
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

		System.out.println("########################## FETCH UNIT #################################");

		List<Unit> unitList = null;

		try {

			AuthTokenInfo tokenInfo = sendTokenRequest();

			RestTemplate restTemplate = new RestTemplate();

			HttpEntity<String> request = new HttpEntity<String>(getHeaders());
			try {
				ResponseEntity<List> response = restTemplate.exchange(
						ErpConstants.UNIT_GET_ALL + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
						HttpMethod.GET, request, List.class);
				List<LinkedHashMap<String, Object>> unitMap = (List<LinkedHashMap<String, Object>>) response.getBody();

				if (unitMap != null) {
					unitList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : unitMap) {

						Unit unit = new Unit();

						unit.setUnitId(((Integer) linkedHashMap.get("unitId")).longValue());
						unit.setUnitName((String) linkedHashMap.get("unitName"));
						unit.setUnitDesc((String) linkedHashMap.get("unitDesc"));
						unitList.add(unit);
					}

				} else {
					System.out.println("No Unit exist----------");
				}

			} catch (Exception excep) {
				excep.printStackTrace();
			}

		} catch (HttpClientErrorException excep) {
			excep.printStackTrace();
		}

		System.out.println("########################## FETCH UNIT #################################  ");

		// return Test.getGradesList();

		return unitList;

		// return Test.getUnitsList();
	}

	@ModelAttribute("getRequisitionItemsList")
	public List<RequisitionItem> getRequisitionItemsList() {
		return Test.getRequisitionItems();
	}

	@ModelAttribute("getRequisitionsList")
	public List<ProjectRequisition> getRequisitionsList() {

		System.out.println("########################## getRequisitionsList #################################");

		List<ProjectRequisition> projectRequisitionList = null;

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
					projectRequisitionList = new ArrayList<>();

					for (LinkedHashMap<String, Object> linkedHashMap : projectRequisitionMap) {

						ProjectRequisition projectRequisition = new ProjectRequisition();
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

						projectRequisition.setRequisitionId(i.longValue());

						/*
						 * projectRequisition .setRequisitionCreatedDate((Date)
						 * linkedHashMap.get("requisitionCreatedDate"));
						 * projectRequisition .setRequisitionUpdatedDate((Date)
						 * linkedHashMap.get("requisitionUpdatedDate"));
						 */
						projectRequisition.setRequisitionStatus((String) linkedHashMap.get("requisitionStatus"));
						projectRequisition
								.setRequisitionJustification((String) linkedHashMap.get("requisitionJustification"));
						projectRequisition.setRequisitionDateOfGeneration(
								(String) linkedHashMap.get("requisitionDateOfGeneration"));
						projectRequisition.setRequisitionExpectedDelivery(
								(String) linkedHashMap.get("requisitionExpectedDelivery"));
						projectRequisition
								.setRequisitionRequestedBY((String) linkedHashMap.get("requisitionRequestedBY"));

						LinkedHashMap<String, Object> projectMap = (LinkedHashMap<String, Object>) linkedHashMap
								.get("project");

						// Project project = new Project();

						// project.setProject_id(((Integer)
						// projectMap.get("project_id")));
						System.out.println("projectMap.get(project_id)).longValue() " + projectMap.get("project_id"));
						projectRequisition.setProjectId(((Integer) projectMap.get("project_id")));
						List<RequisitionItem> requisitionItems = new ArrayList<>();
						List<LinkedHashMap<String, Object>> requisitionItemsMap = (List<LinkedHashMap<String, Object>>) linkedHashMap
								.get("requisitionItems");

						for (LinkedHashMap<String, Object> linkedHashrequisitionItemsMap : requisitionItemsMap) {

							RequisitionItem requisitionItem = new RequisitionItem();

							LinkedHashMap<String, Object> itemMap = (LinkedHashMap<String, Object>) linkedHashrequisitionItemsMap
									.get("item");

							System.out.println("itemMap.get(itemId)).longValue() " + itemMap.get("itemId"));
							/*
							 * Item item = new Item();
							 * 
							 * item.setItemId(((Integer)
							 * itemMap.get("itemId")).longValue());
							 */
							requisitionItem.setItemId(((Integer) itemMap.get("itemId")).longValue());

							LinkedHashMap<String, Object> gradeMap = (LinkedHashMap<String, Object>) linkedHashrequisitionItemsMap
									.get("grade");

							/*
							 * Grade grade = new Grade();
							 * 
							 * grade.setGradeId(((Integer)
							 * gradeMap.get("gradeId")).longValue());
							 */

							System.out.println("gradeMap.get(gradeId)).longValue() " + gradeMap.get("gradeId"));
							requisitionItem.setGradeId(((Integer) gradeMap.get("gradeId")).longValue());

							LinkedHashMap<String, Object> unitMap = (LinkedHashMap<String, Object>) linkedHashrequisitionItemsMap
									.get("unit");

							/*
							 * Unit unit = new Unit();
							 * 
							 * unit.setUnitId(((Integer)
							 * unitMap.get("unitId")).longValue());
							 */
							System.out.println("unitMap.get(unitId)).longValue() " + unitMap.get("unitId"));
							System.out.println("linkedHashrequisitionItemsMap.get(quantity)).longValue() "
									+ linkedHashrequisitionItemsMap.get("quantity"));
							System.out.println("linkedHashrequisitionItemsMap.get(checked)).longValue() "
									+ linkedHashrequisitionItemsMap.get("checked"));
							System.out.println("linkedHashrequisitionItemsMap.get(usedFor)).longValue() "
									+ linkedHashrequisitionItemsMap.get("usedFor"));

							requisitionItem.setUnitId(((Integer) unitMap.get("unitId")).longValue());

							requisitionItem.setRequisitionItemId(
									((Integer) linkedHashrequisitionItemsMap.get("requisitionItemId")).longValue());

							requisitionItem
									.setQuantity(((Integer) linkedHashrequisitionItemsMap.get("quantity")).longValue());

							requisitionItem.setChecked(((boolean) linkedHashrequisitionItemsMap.get("checked")));

							requisitionItem.setUsedFor(((String) linkedHashrequisitionItemsMap.get("usedFor")));

							requisitionItems.add(requisitionItem);

						}

						projectRequisition.setRequisitionItems(requisitionItems);
						projectRequisitionList.add(projectRequisition);
					}

					System.out.println(
							"==> PROJECT REQUISITION CONTROLLER : projectRequisitionList : " + projectRequisitionList);

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
		return projectRequisitionList;
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