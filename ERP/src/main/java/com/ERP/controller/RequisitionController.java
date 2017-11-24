package com.ERP.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.servlet.ModelAndView;

import com.ERP.constants.ErpConstants;
import com.ERP.constants.GradeType;
import com.ERP.constants.MaterialType;
import com.ERP.constants.UnitType;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Project;
import com.ERP.model.Requisition;
import com.ERP.service.UserProfileService;
import com.ERP.util.AuthTokenAccess;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class RequisitionController {

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	RestTemplate restTemplate;

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
		model.addAttribute("requisition", requisition);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("materialType", Arrays.asList(MaterialType.values()));
		model.addAttribute("gradeType", Arrays.asList(GradeType.values()));
		model.addAttribute("unitType", Arrays.asList(UnitType.values()));

		/**
		 * TODO : Also need to check how exactly update for gradetype and unit
		 * will take place.
		 */
		/*
		 * TODO : Need to confirm how project would be retrieved. String
		 * userName = getPrincipal(); if (userName != null) { EmpLogin empLogin
		 * = ; Set<String> projectName = new HashSet<String>(0); Set<String>
		 * projectSectName = new HashSet<String>(0); for (EmployeeProjectJoin
		 * projectJoin : empLogin.getEmpDetails() .getEmployeeProjectJoins()) {
		 * if (projectJoin.getProject() != null) {
		 * projectName.add(projectJoin.getProject().getProjNm());
		 * projectSectName.add(projectJoin.getProject().getProjSect()); } }
		 * mv.addObject("projectName", projectName);
		 * mv.addObject("projSectName", projectSectName); mv.addObject("reqno",
		 * userDao.getSequenceValue("requisition_seq")); }
		 * mv.setViewName("materialRequisition");
		 */

		return "requisitionRegistration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/addrequisition" }, method = RequestMethod.POST)
	public ModelAndView addProject(@Valid Requisition requisition,
			BindingResult result, ModelAndView model) {
		AuthTokenInfo tokenInfo = AuthTokenAccess.sendTokenRequest();

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addObject("error", result.getAllErrors());
			model.setViewName("requisitionERP");
			return model;
		}

		HttpEntity<Object> request = new HttpEntity<Object>(requisition,
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

		}
		model.addObject("success", "Requisition " + requisition.getReqNo()
				+ " added successfully");
		model.addObject("loggedinuser", getPrincipal());
		model.addObject("message", "Requisition successfully added");
		model.setViewName("requisitionERP");

		return model;
	}

	/**
	 * This method will list all existing projects.
	 */
	/*@RequestMapping(value = "/listproject", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Requisition> listRequisition(ModelMap model) {
		AuthTokenInfo tokenInfo = AuthTokenAccess.sendTokenRequest();
		List<Requisition> requisitionList = null;

		HttpEntity<String> request = new HttpEntity<String>(
				AuthTokenAccess.getHeaders());
		try {
			ResponseEntity<List> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI + "/requisitionAuth/list/"
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, List.class);
			requisitionList = (List<Requisition>) response.getBody();
			if (!requisitionList.isEmpty()) {

				model.addAttribute("loggedinuser", getPrincipal());
			} else {
				System.out.println("List is empty ----------");
			}

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		return requisitionList;
	}*/

	
	/* Requistion Controller */

	@RequestMapping(value = { "/raisedRequistion" }, method = RequestMethod.GET)
	public String raisedRequistion(@ModelAttribute("requistionForm") Requisition requistion, BindingResult result,
			ModelMap model) {

		System.out.println("*********** INSIDE raisedRequistion *******************8");
		
		return "raisedRequistion";

	}
	@RequestMapping(value = { "/editRequistion" }, method = RequestMethod.GET)
	public String editRequistion(@ModelAttribute("requistionForm") Requisition requistion, BindingResult result,
			ModelMap model) {

		System.out.println("*********** INSIDE editRequistion *******************8");
		
		return "editRequistion";

	}
	@RequestMapping(value = { "/deleteRequistion" }, method = RequestMethod.GET)
	public String deleteRequistion(@ModelAttribute("requistionForm") Requisition requistion, BindingResult result,
			ModelMap model) {

		System.out.println("*********** INSIDE raisedRequistion *******************8");
		
		return "deleteRequistion";

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
	
	@ModelAttribute("getEditRequisitionListDetails")
	public List<Requisition> getEditRequisitionListDetails() {
		
		Project p1=new Project();
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
		
		Project p2=new Project();
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
		
		
		List<Requisition> requisitionList=new ArrayList<>();
		
		Requisition r1=new Requisition();
		r1.setProject(p1);
		r1.setRequestedBy("John");
		r1.setJustification("Test Justification Message 1");
		r1.setDateGen(new Date());
		r1.setExpectedDt(new Date());
		r1.setReqNo(1L);
		r1.setReqSts("Approved");
		
		Requisition r2=new Requisition();
		r2.setProject(p2);
		r2.setRequestedBy("Harshad");
		r2.setJustification("Test Justification Message 2");
		r2.setDateGen(new Date());
		r2.setExpectedDt(new Date());
		r2.setReqNo(2L);
		r2.setReqSts("Approved");
		requisitionList.add(r1);
		requisitionList.add(r2);
		
		
				
		
		return requisitionList;
	}
	
	
	@ModelAttribute("getEditProjectListDetails")
	public List<Project> getEditProjectListDetails() {

		List<Project> projectList = new ArrayList<>();
		
		Project p1=new Project();
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
		
		
		Project p2=new Project();
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
		
		
		
		
		
		projectList.add(p1);
		projectList.add(p2);
		return projectList;
	}
	
	
	 /*"Requisition [reqNo=" + reqNo + ", project=" + project + ", dateGen=" + dateGen + ", delDt=" + delDt
		+ ", expectedDt=" + expectedDt + ", reqSts=" + reqSts + ", authorizeSectEngg=" + authorizeSectEngg
		+ ", requestedBy=" + requestedBy + ", justification=" + justification + ", itemLists=" + itemLists
		+ "]";*/

}