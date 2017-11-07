package com.ERP.controller;

import java.util.Arrays;

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
import com.ERP.model.Requisition;
import com.ERP.service.UserProfileService;
import com.ERP.util.AuthTokenAccess;

@Controller
@RequestMapping("/requisition")
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

}