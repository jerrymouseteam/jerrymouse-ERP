package com.ERP.controller;

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

import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Project;
import com.ERP.model.User;
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

	public static final String REST_SERVICE_URI = "http://localhost:8080/ERPoAuth";

	public static final String AUTH_SERVER_URI = "http://localhost:8080/ERPoAuth/oauth/token";

	public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=Sam&password=abc125";

	public static final String QPM_ACCESS_TOKEN = "?access_token=";

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
		ResponseEntity<Object> response = restTemplate.exchange(AUTH_SERVER_URI
				+ QPM_PASSWORD_GRANT, HttpMethod.POST, request, Object.class);
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
			// System.out.println("access_token ="+map.get("access_token")+",
			// token_type="+map.get("token_type")+",
			// refresh_token="+map.get("refresh_token")
			// +", expires_in="+map.get("expires_in")+",
			// scope="+map.get("scope"));;
		} else {
			System.out.println("No user exist----------");

		}
		return tokenInfo;
	}

	/*
	 * @RequestMapping(value = { "/project" }, method = RequestMethod.GET)
	 * public String vprojrctDashboard(ModelMap model) {
	 * 
	 * Project project = new Project(); System.out.println("project");
	 * model.addAttribute("project", project); model.addAttribute("edit",
	 * false); model.addAttribute("loggedinuser", getPrincipal()); return
	 * "projectERP"; }
	 */

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
					REST_SERVICE_URI + "/project/" + QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, List.class);
			projectssMap = (List<LinkedHashMap<String, Object>>) response
					.getBody();
			System.out.println(projectssMap + " 3###############projectssMap");
			if (projectssMap != null) {

				// model.addAttribute("users", usersMap);
				model.addAttribute("loggedinuser", getPrincipal());
			} else {
				System.out.println("No user exist----------");
			}

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		return projectssMap;
	}

	@RequestMapping(value = "/closedproject", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List closedProject(ModelMap model) {
		AuthTokenInfo tokenInfo = sendTokenRequest();
		List<LinkedHashMap<String, Object>> projectssMap = null;
		System.out
				.println("\nTesting listAll Project API-$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$----------");
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		try {
			ResponseEntity<List> response = restTemplate.exchange(
					REST_SERVICE_URI + "/project/closed/" + QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, List.class);
			projectssMap = (List<LinkedHashMap<String, Object>>) response
					.getBody();
			System.out.println(projectssMap + " 3###############projectssMap");
			if (projectssMap != null) {

				// model.addAttribute("users", usersMap);
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
	@RequestMapping(value = { "/addproject" }, method = RequestMethod.GET)
	public String newProject(ModelMap model) {

		Project project = new Project();
		System.out.println("project");
		model.addAttribute("project", project);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/addproject" }, method = RequestMethod.POST)
	public ModelAndView addProject(@Valid Project project,
			BindingResult result, ModelAndView model) {
		System.out.println("\nTesting create project API--------addddd--"
				+ project);

		AuthTokenInfo tokenInfo = sendTokenRequest();
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addObject("error", result.getAllErrors());
			model.addObject("message", "project successfully added");
			model.setViewName("projectERP");
			return model;
		}

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> request = new HttpEntity<Object>(project,
				getHeaders());
		try {
			ResponseEntity<Project> response = restTemplate.postForEntity(
					REST_SERVICE_URI + "/project/create/" + QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), request,
					Project.class);
		} catch (HttpClientErrorException excep) {
			if (HttpStatus.CONFLICT.equals(excep.getStatusCode())) {
				FieldError ssoError = new FieldError("projectName",
						"project_id", messageSource.getMessage("projectName",
								new String[] { project.getProjectName()
										.toString() }, Locale.getDefault()));
				result.addError(ssoError);
				model.addObject("message", result.getAllErrors());
				model.setViewName("projectERP");

				return model;
			} else {
				excep.printStackTrace();
			}
		}
		model.addObject("success", "Project " + project.getProjectName()
				+ " registered successfully");
		model.addObject("loggedinuser", getPrincipal());
		// return "success";
		model.addObject("message", "project successfully added");
		model.setViewName("projectERP");

		return model;
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-project-{projectId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable int projectId, ModelMap model) {
		AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<Project> response = restTemplate.exchange(
				REST_SERVICE_URI + "/project/" + projectId + QPM_ACCESS_TOKEN
						+ tokenInfo.getAccess_token(), HttpMethod.GET, request,
				Project.class);
		Project project = response.getBody();
		System.out.println(project);

		// User user = userService.findBySSO(ssoId);
		model.addAttribute("project", project);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("message", "project successfully added");
		return "projectERP";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-project-{projectId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Project project, BindingResult result,
			ModelMap model, @PathVariable int projectId) {

		AuthTokenInfo tokenInfo = sendTokenRequest();

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * //Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in
		 * UI which is a unique key to a User.
		 * if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
		 * FieldError ssoError =new
		 * FieldError("user","ssoId",messageSource.getMessage
		 * ("non.unique.ssoId", new String[]{user.getSsoId()},
		 * Locale.getDefault())); result.addError(ssoError); return
		 * "registration"; }
		 */

		// userService.updateUser(user);

		System.out.println("\nTesting update Project API----------" + project);
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Object> request = new HttpEntity<Object>(project,
				getHeaders());
		ResponseEntity<User> response = restTemplate.exchange(REST_SERVICE_URI
				+ "/user/" + project.getProject_id() + QPM_ACCESS_TOKEN
				+ tokenInfo.getAccess_token(), HttpMethod.PUT, request,
				User.class);
		System.out.println(response.getBody());

		model.addAttribute("success", "Project " + project.getProjectName()
				+ " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-project-{projectId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable int projectId) {
		// userService.deleteUserBySSO(ssoId);
		AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		restTemplate.exchange(REST_SERVICE_URI + "/user/delete/" + projectId
				+ QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
				HttpMethod.DELETE, request, User.class);

		return "redirect:/list";
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

	/**
	 * This method returns true if users is already authenticated [logged-in],
	 * else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder
				.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

}