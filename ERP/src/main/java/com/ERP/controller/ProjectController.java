package com.ERP.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.ERP.constants.ErpConstants;
import com.ERP.constants.ProjectStatus;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Project;
import com.ERP.model.UserProfile;
import com.ERP.service.UserProfileService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class ProjectController {

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	/*
	 * Prepare HTTP Headers.
	 */
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
		String base64ClientCredentials = new String(
				Base64.encodeBase64(plainClientCredentials.getBytes()));

		HttpHeaders headers = getHeaders();
		headers.add("Authorization", "Basic " + base64ClientCredentials);
		return headers;
	}

	/*
	 * Send a POST request [on /oauth/token] to get an access-token, which will
	 * then be send with each request.
	 */
	@SuppressWarnings({ "unchecked" })
	private static AuthTokenInfo sendTokenRequest() {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(
				getHeadersWithClientCredentials());
		ResponseEntity<Object> response = restTemplate.exchange(
				ErpConstants.AUTH_SERVER_URI + ErpConstants.QPM_PASSWORD_GRANT,
				HttpMethod.POST, request, Object.class);
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response
				.getBody();
		AuthTokenInfo tokenInfo = null;

		if (map != null) {
			tokenInfo = new AuthTokenInfo();
			tokenInfo.setAccess_token((String) map.get("access_token"));
			tokenInfo.setToken_type((String) map.get("token_type"));
			tokenInfo.setRefresh_token((String) map.get("refresh_token"));
			tokenInfo.setExpires_in((Integer) map.get("expires_in"));
			tokenInfo.setScope((String) map.get("scope"));
			System.out.println(tokenInfo);

		} else {
			System.out.println("No user exist----------");

		}
		return tokenInfo;
	}

	/**
	 * This method will list all existing projects.
	 */
	@RequestMapping(value = "/listproject", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List listProject(ModelMap model) {
		AuthTokenInfo tokenInfo = sendTokenRequest();
		List<LinkedHashMap<String, Object>> projectssMap = null;
		System.out
				.println("\nTesting listAll Project API-$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$----------");
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		try {
			ResponseEntity<List> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI + "/project/"
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, List.class);
			projectssMap = (List<LinkedHashMap<String, Object>>) response
					.getBody();
			System.out.println(projectssMap + " 3###############projectssMap");
			if (projectssMap != null) {
				model.addAttribute("loggedinuser", getPrincipal());
			} else {
				System.out.println("No user exist----------");
			}

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		return projectssMap;
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/addProject" }, method = RequestMethod.GET)
	public String newProject(ModelMap model) {

		Project project = new Project();

		System.out.println("project");
		model.addAttribute("projectForm", project);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "addProject";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/addProject" }, method = RequestMethod.POST)
	public ModelAndView addProject(
			@Valid @ModelAttribute("projectForm") Project project,
			BindingResult result, ModelAndView model) {
		System.out.println("\nTesting create project API--------addddd--"
				+ project);

		AuthTokenInfo tokenInfo = sendTokenRequest();
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addObject("error", result.getAllErrors());
			model.addObject("message", "project not added successfully");
			return model;
		}

		project.setProjectStatus(ProjectStatus.Open.getProjectStatus());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			project.setEndDate(dateFormat.parse(dateFormat.format(project
					.getEndDate())));
			project.setStartDate(dateFormat.parse(dateFormat.format(project
					.getStartDate())));
		} catch (ParseException parseException) {
			throw new RuntimeException(parseException);
		}

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> request = new HttpEntity<Object>(project,
				getHeaders());
		try {
			ResponseEntity<Project> response = restTemplate.postForEntity(
					ErpConstants.REST_SERVICE_URI + "/project/create/"
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), request,
					Project.class);
		} catch (HttpClientErrorException excep) {
			if (HttpStatus.CONFLICT.equals(excep.getStatusCode())) {
				FieldError ssoError = new FieldError("projectForm",
						"projectName", messageSource.getMessage("projectName",
								new String[] { project.getProjectName()
										.toString() }, Locale.getDefault()));
				result.addError(ssoError);
				model.addObject("message", result.getAllErrors());
				return model;
			} else {
				excep.printStackTrace();
			}
		}
		model.addObject("success", "Project " + project.getProjectName()
				+ " registered successfully");
		model.addObject("loggedinuser", getPrincipal());
		model.addObject("message", "project successfully added");
		model.addObject("projectForm", new Project());
		model.setViewName("addProject");

		return model;
	}

	@RequestMapping(value = { "/viewProjectDetails/{projectId}" }, method = RequestMethod.GET)
	public String viewProjectDetails(
			@PathVariable("projectId") Integer projectId, ModelMap model) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out
				.println("**************************************************************************");
		System.out
				.println("\nTesting viewProjectDetails API---------- ssoId :: "
						+ projectId);

		Project project = null;

		AuthTokenInfo tokenInfo = sendTokenRequest();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());

		try {
			ResponseEntity<Project> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI + "/project/" + projectId
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, Project.class);
			project = (Project) response.getBody();
			System.out.println(project + " 3###############projectssMap");

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		System.out.println("*********** " + project);
		model.addAttribute("projectForm", project);
		model.addAttribute("editProjectStage", "editViewProjectDetails");
		model.addAttribute("loggedinuser", getPrincipal());
		System.out
				.println("**************************************************************************");
		return "editProject";
	}

	@RequestMapping(value = { "/editProjectDetails/{projectId}" }, method = RequestMethod.GET)
	public String editProjectDetails(
			@PathVariable("projectId") String projectId, ModelMap model) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out
				.println("**************************************************************************");
		System.out
				.println("\nTesting editProjectDetails API---------- project_id :: "
						+ projectId);

		Project project = null;

		AuthTokenInfo tokenInfo = sendTokenRequest();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());

		try {
			ResponseEntity<Project> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI + "/project/" + projectId
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, Project.class);
			project = (Project) response.getBody();
			System.out.println(project + " 3###############projectssMap");

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		System.out.println("*********** " + project);
		model.addAttribute("projectForm", project);
		model.addAttribute("editProjectStage", "editProjectDetails");
		model.addAttribute("loggedinuser", getPrincipal());
		List<String> projectStatusList = new ArrayList<String>();
		projectStatusList.add(ProjectStatus.Open.getProjectStatus());
		projectStatusList.add(ProjectStatus.Closed.getProjectStatus());
		model.addAttribute("projectStatusList", projectStatusList);

		System.out
				.println("**************************************************************************");
		return "editProject";
	}

	@RequestMapping(value = { "/updateProjectDetails" }, method = RequestMethod.POST)
	public String updateProjectDetails(
			@Valid @ModelAttribute("projectForm") Project project,
			BindingResult result) {

		System.out
				.println("**************************************************************************");
		System.out
				.println("\nTesting updateProjectDetails API---------- project :: "
						+ project);
		System.out
				.println("**************************************************************************");

		AuthTokenInfo tokenInfo = sendTokenRequest();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> request = new HttpEntity<Object>(project,
				getHeaders());
		try {
			restTemplate.put(ErpConstants.REST_SERVICE_URI + "/project/"
					+ project.getProject_id() + ErpConstants.QPM_ACCESS_TOKEN
					+ tokenInfo.getAccess_token(), request, Project.class);
		} catch (HttpClientErrorException excep) {
			excep.printStackTrace();
		}

		return "redirect:/editProjectList";
	}

	@RequestMapping(value = { "/editProjectList" }, method = RequestMethod.GET)
	public String editProjectList(
			@ModelAttribute("projectForm") Project project,
			BindingResult result, ModelMap model) {

		model.addAttribute("editProjectStage", "editProjectList");

		return "editProject";
	}

	@RequestMapping(value = { "/editProject" }, method = RequestMethod.POST)
	public String editProject(
			@Valid @ModelAttribute("projectForm") Project project,
			BindingResult result, ModelMap model, HttpServletRequest rq,
			HttpServletResponse resp) {

		System.out.println("\n Request " + rq.getPathInfo());
		System.out.println("AppController -- editProject -- project : "
				+ project);
		AuthTokenInfo tokenInfo = sendTokenRequest();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Project> request = new HttpEntity<Project>(project,
				getHeaders());

		try {
			restTemplate.put(ErpConstants.REST_SERVICE_URI + "/project/"
					+ project.getProject_id() + ErpConstants.QPM_ACCESS_TOKEN
					+ tokenInfo.getAccess_token(), request);
		} catch (HttpClientErrorException excep) {
			if (HttpStatus.NOT_FOUND.equals(excep.getStatusCode())) {

			}
		}
		return "editProject";
	}

	@RequestMapping(value = { "/closedProjectList" }, method = RequestMethod.GET)
	public String closedProjectList(
			@ModelAttribute("projectForm") Project project,
			BindingResult result, ModelMap model) {

		model.addAttribute("success", "");

		return "closedProjectList";
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

	/**
	 * This method handles Access-Denied redirect.
	 */
	/*
	 * @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	 * public String accessDeniedPage(ModelMap model) {
	 * model.addAttribute("loggedinuser", getPrincipal()); return
	 * "accessDenied"; }
	 */

	/**
	 * This method handles logout requests. Toggle the handlers if you are
	 * RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value = "/logout_Project", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			// new SecurityContextLogoutHandler().logout(request, response,
			// auth);
			persistentTokenBasedRememberMeServices.logout(request, response,
					auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
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

	@ModelAttribute("getEditProjectListDetails")
	public List<Project> getEditProjectListDetails() {

		AuthTokenInfo tokenInfo = sendTokenRequest();
		List<Project> projectList = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());

		try {
			ResponseEntity<List> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI + "/project/list"
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, List.class);
			projectList = response.getBody();
		} catch (HttpClientErrorException excep) {
			if (HttpStatus.NO_CONTENT.equals(excep.getStatusCode())) {
				return new ArrayList<Project>();
			}
		}
		System.out.println("projectList:  "
				+ Arrays.deepToString(projectList.toArray()));
		return projectList;
	}

	@ModelAttribute("getClosedProjectList")
	public List<Project> getClosedProjectList() {

		AuthTokenInfo tokenInfo = sendTokenRequest();
		List<Project> projectList = null;
		System.out
				.println("\nTesting listAll Project API-$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$----------");
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		try {
			ResponseEntity<List> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI + "/project/closed/"
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, List.class);
			projectList = (List) response.getBody();
			System.out.println(projectList + " 3###############projectList");

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		return projectList;

	}

}