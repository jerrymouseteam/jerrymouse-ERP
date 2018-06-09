package com.ERP.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

import com.ERP.constants.ErpConstants;
import com.ERP.constants.UserStatus;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Project;
import com.ERP.model.User;
import com.ERP.model.UserProfile;
import com.ERP.service.UserProfileService;
import com.ERP.service.UserService;
import com.ERP.service.UserServiceImpl;

/*@Controller
@RequestMapping("/")
@SessionAttributes("roles")*/
public class UserController2 {

	@Autowired
	UserService userService;

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
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));

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
		AuthTokenInfo tokenInfo = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders h = getHeadersWithClientCredentials();
			HttpEntity<String> request = new HttpEntity<String>(h);
			ResponseEntity<Object> response = restTemplate.exchange(
					ErpConstants.AUTH_SERVER_URI + ErpConstants.QPM_PASSWORD_GRANT, HttpMethod.POST, request,
					Object.class);
			LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();

			if (map != null) {
				tokenInfo = new AuthTokenInfo();
				tokenInfo.setAccess_token((String) map.get("access_token"));
				tokenInfo.setToken_type((String) map.get("token_type"));
				tokenInfo.setRefresh_token((String) map.get("refresh_token"));
				tokenInfo.setExpires_in((Integer) map.get("expires_in"));
				tokenInfo.setScope((String) map.get("scope"));
				System.out.println(tokenInfo);
				// System.out.println("access_token
				// ="+map.get("access_token")+",
				// token_type="+map.get("token_type")+",
				// refresh_token="+map.get("refresh_token")
				// +", expires_in="+map.get("expires_in")+",
				// scope="+map.get("scope"));;
			} else {
				System.out.println("No user exist----------");

			}
			return tokenInfo;
		} catch (final HttpClientErrorException e) {
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}
		return tokenInfo;
	}

	//@RequestMapping(value = { "/", "/project" }, method = RequestMethod.GET)
	public String UserDashboard(HttpServletRequest request, ModelMap model,
			@RequestParam(value = "remember-me", required = false) boolean asSelectedCheckbox) {
		System.out.println("asSelectedCheckbox" + asSelectedCheckbox);
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {

				// do something
				// value can be retrieved using #cookie.getValue()
				System.out.println("asSelectedCheckbox" + cookie.getName());

			}
		}
		System.out.println("rew" + request.getParameter("remember-me"));
		Project project = new Project();
		View view = new JstlView();
		ModelAndView mv = new ModelAndView();
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("project", project);
		model.addAttribute("loggedinuser", getPrincipal());
		mv.addAllObjects(model);
		mv.setViewName("projectERP");
		// mv.setView( view.PATH_VARIABLES);

		// return mv;

		return "redirect:/dashBoard";
	}

	/**
	 * This method will list all existing users.
	 */
	//@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		AuthTokenInfo tokenInfo = sendTokenRequest();
		/*
		 * List<User> users = userService.findAllUsers();
		 * model.addAttribute("users", users);
		 * model.addAttribute("loggedinuser", getPrincipal()); return
		 * "userslist";
		 */

		System.out.println("\nTesting listAllUsers API-----------");
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		try {
			ResponseEntity<List> response = restTemplate.exchange(ErpConstants.REST_SERVICE_URI + "/user/"
					+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request, List.class);
			List<LinkedHashMap<String, Object>> usersMap = (List<LinkedHashMap<String, Object>>) response.getBody();
			if (usersMap != null) {

				model.addAttribute("users", usersMap);
				model.addAttribute("loggedinuser", getPrincipal());
			} else {
				System.out.println("No user exist----------");
			}

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		return "userslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	//@RequestMapping(value = { "/registerUser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {

		User user = new User();

		System.out.println("User register get");
		model.addAttribute("userForm", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("success", "");

		return "registration";
	}

	//@RequestMapping(value = { "/registerProject" }, method = RequestMethod.GET)
	public String registerProject(@ModelAttribute("projectForm") Project project, BindingResult result,
			ModelMap model) {

		model.addAttribute("success", "");

		return "registerProject";
	}

	//@RequestMapping(value = { "/dashBoard" }, method = RequestMethod.GET)
	public String dashBoard() {

		return "dashBoard";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	//@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("userForm") User user, BindingResult result, ModelMap model) {

		System.out.println("AppController -- saveUser -- User : " + user);
		System.out.println("AppController -- saveUser -- User : " + user.getUserProfiles());
		AuthTokenInfo tokenInfo = sendTokenRequest();

		if (result.hasErrors()) {
			return "registration";
		}

		System.out.println("\nTesting create User API----------" + user);
		System.out.println("\nTesting create User API----------" + user);
		RestTemplate restTemplate = new RestTemplate();

		user.setUserStatus(UserStatus.Active.toString());
		HttpEntity<Object> request = new HttpEntity<Object>(user, getHeaders());
		ResponseEntity<User> response = null;
		try {
			response = restTemplate.postForEntity(ErpConstants.REST_SERVICE_URI + "/user/create/"
					+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), request, User.class);
		} catch (HttpClientErrorException excep) {
			if (HttpStatus.CONFLICT.equals(excep.getStatusCode())) {
				FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId",
						new String[] { user.getSsoId() }, Locale.getDefault()));
				result.addError(ssoError);
				return "registration";
			}
		}

		System.out.println(" What is the response code " + response.getStatusCode() + " ## " + user.getSsoId());

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		User user1 = new User();
		model.addAttribute("userForm", user1);
		model.addAttribute("edit", false);
		model.addAttribute("success", "");

		// return "success";
		return "registration";
	}

	//@RequestMapping(value = { "/editUserList" }, method = RequestMethod.GET)
	public String editUserList(@ModelAttribute("userForm") User user, BindingResult result, ModelMap model) {
		AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting getUser API----------");

		User user1 = new User();
		System.out.println(user1);

		List<User> list = getEditUserListDetails();

		// User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user1);
		model.addAttribute("getEditUserListDetails", list);

		model.addAttribute("editUserStage", "editUserList");
		model.addAttribute("editUserList", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "editUser";
	}

	//@RequestMapping(value = { "/editUser" }, method = RequestMethod.POST)
	public String editUser(@ModelAttribute("userForm") User user, BindingResult result, ModelMap model,
			HttpServletRequest rq, HttpServletResponse resp) {

		System.out.println("\n Request " + rq.getPathInfo());
		System.out.println("AppController -- editUser -- User : " + user);

		return "redirect:/editUserList";
	}

	//@Transactional
	//@RequestMapping(value = { "/editUserDetails/{ssoId}" }, method = RequestMethod.GET)
	public String editUserDetails(@PathVariable String ssoId, ModelMap model) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting editUserTest API---------- ssoId :: " + ssoId);

		User user = userService.findBySSO(ssoId);

		System.out.println("*********** " + user);
		model.addAttribute("userForm", user);
		model.addAttribute("editUserStage", "editUserDetails");
		model.addAttribute("loggedinuser", getPrincipal());
		List<String> userStatusList = new ArrayList<String>();
		userStatusList.add(UserStatus.Active.toString());
		userStatusList.add(UserStatus.Inactive.toString());
		model.addAttribute("userStatusList", userStatusList);
		return "editUser";
	}

	///@RequestMapping(value = { "/updateUserDetails" }, method = RequestMethod.POST)
	public String updateUserDetails(ModelMap model, @ModelAttribute("userForm") User user) {
		System.out.println("*********************************************************");
		System.out.println("\nTesting updateUserDetails API---------- user :: " + user);
		System.out.println("*********************************************************");

		AuthTokenInfo tokenInfo = sendTokenRequest();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> request = new HttpEntity<Object>(user, getHeaders());
		try {
			restTemplate.put(ErpConstants.REST_SERVICE_URI + "/user/" + user.getSsoId() + ErpConstants.QPM_ACCESS_TOKEN
					+ tokenInfo.getAccess_token(), request, User.class);
		} catch (HttpClientErrorException excep) {/*
													 * if (HttpStatus.CONFLICT.
													 * equals
													 * (excep.getStatusCode()))
													 * { FieldError ssoError =
													 * new FieldError("user",
													 * "ssoId", messageSource
													 * .getMessage(
													 * "non.unique.ssoId" , new
													 * String[] {
													 * user.getSsoId() },
													 * Locale.getDefault()));
													 * result.addError(ssoError)
													 * ; return "registration";
													 * }
													 */
		}

		return "redirect:/editUserList";
	}

	///@RequestMapping(value = { "/getUserProjectDetails/{ssoId}" }, method = RequestMethod.GET)
	public String getUserProjectDetails(@PathVariable String ssoId, ModelMap model) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting getUserProjectDetails API---------- ssoId :: " + ssoId);

		// user=getEditUserDetails();

		Project p2 = new Project();
		p2.setProject_id(2);
		p2.setProjectName("projectSet1 EPR2");
		p2.setProjectClientName("projectSet1 ERP CLIENT 2");
		p2.setStructuralName("projectSet1 EPR1 Sector 2");

		model.addAttribute("proejctForm", p2);
		model.addAttribute("editUserStage", "getUserProjectDetails");
		model.addAttribute("loggedinuser", getPrincipal());
		return "editUser";
	}

	///@RequestMapping(value = { "/updateUserProjectDetails" }, method = RequestMethod.POST)
	public String updateUserProjectDetails(ModelMap model, @ModelAttribute("proejctForm") Project project) {

		System.out.println("\nTesting updateUserProjectDetails API---------- Project :: " + project);

		model.addAttribute("proejctForm", project);
		model.addAttribute("ssoId", 1);
		model.addAttribute("editUserStage", "getUserProjectDetails");
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:/editUserList";
	}

	////@Transactional
	//@RequestMapping(value = { "/getUserProjectListDetails/{ssoId}" }, method = RequestMethod.GET)
	public String getUserProjectListDetails(@PathVariable String ssoId, ModelMap model) {
		// AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting editUserTest API---------- ssoId :: " + ssoId);

		User user = userService.findBySSO(ssoId);

		model.addAttribute("userDetails", user);
		model.addAttribute("editUserStage", "getUserProjectListDetails");
		model.addAttribute("loggedinuser", getPrincipal());
		return "editUser";
	}

	//@RequestMapping(value = { "/editUserProject" }, method = RequestMethod.POST)
	public String editUserProject(@ModelAttribute("userForm") User user, BindingResult result, ModelMap model,
			HttpServletRequest rq, HttpServletResponse resp) {

		System.out.println("\n editUserProject Request " + rq.getPathInfo());
		System.out.println("AppController -- editUserProject -- User : " + user);

		return "redirect:/editUserList";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	//@RequestMapping(value = { "/editUser/{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String ssoId) {

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

		System.out.println("\nTesting update User API----------" + user);
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Object> request = new HttpEntity<Object>(user, getHeaders());
		ResponseEntity<User> response = restTemplate.exchange(ErpConstants.REST_SERVICE_URI + "/user/" + user.getId()
				+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.PUT, request, User.class);
		System.out.println(response.getBody());

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	///@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		// userService.deleteUserBySSO(ssoId);
		AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		System.out.println(" URL :::" + ErpConstants.REST_SERVICE_URI + "/user/delete/" + ssoId
				+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token() + HttpMethod.GET + request + User.class);
		restTemplate.exchange(ErpConstants.REST_SERVICE_URI + "/user/delete/" + ssoId + ErpConstants.QPM_ACCESS_TOKEN
				+ tokenInfo.getAccess_token(), HttpMethod.DELETE, request, User.class);

		return "redirect:/list";
	}

	/**
	 * This method will provide UserProfile list to views
	 */
	//@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

	/**
	 * This method handles Access-Denied redirect.
	 */
	///@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests. If users is already logged-in and
	 * tries to goto login page again, will be redirected to list page.
	 */
	//@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request) {
		// HttpServletRequest request;

		// String[] selectedStudentIds =
		// request.getParameterValues("remember-me");
		if (isCurrentAuthenticationAnonymous()) {

			return "login";
		} else {
			return "redirect:/list";
		}
		// return "userslist";
	}

	/**
	 * This method handles logout requests. Toggle the handlers if you are
	 * RememberMe functionality is useless in your app.
	 */
	//@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			// new SecurityContextLogoutHandler().logout(request, response,
			// auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
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

	/**
	 * This method returns true if users is already authenticated [logged-in],
	 * else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

	//@RequestMapping(value = { "/forgotPassword" }, method = RequestMethod.POST)
	public @ResponseBody String forgotPassword(@RequestParam String emailId) {

		System.out.println("\nTesting delcheckEmail  User API----------");
		String email = emailId.replaceAll("=", "").replaceAll("%40", "@");
		if (emailId != null || !("").equals(emailId)) {
			try {
				UserService usr = new UserServiceImpl();

			} catch (HttpClientErrorException excep) {

				excep.printStackTrace();

			}
		}

		return "../include/error";

	}

	//@RequestMapping(value = { "/changepassword" }, method = RequestMethod.GET)
	public @ResponseBody String changePassword() {

		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
			User user = userService.findBySSO(userName);
			user.getPassword();
		} else {
			userName = principal.toString();
		}
		return "aaa";

	}

	public User setClearUserData() {
		User user = new User();
		user.setId(null);
		user.setFirstName("");
		user.setMiddleName("");
		user.setLastName("");
		user.setMobileNumber("");
		user.setAlternateNumber("");
		user.setEmail("");
		user.setAddress("");
		user.setPassword("");
		user.setRetypePassword("");
		user.setUserProfiles(null);

		return user;

	}

	// @ModelAttribute("getEditUserListDetails")
	public List<User> getEditUserListDetails() {

		AuthTokenInfo tokenInfo = sendTokenRequest();
		List<User> userList = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());

		try {
			ResponseEntity<List> response = restTemplate.exchange(ErpConstants.REST_SERVICE_URI + "/user/"
					+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request, List.class);
			userList = response.getBody();
		} catch (HttpClientErrorException excep) {
			if (HttpStatus.NO_CONTENT.equals(excep.getStatusCode())) {
				return new ArrayList<User>();
			}
		}

		return userList;
	}

	/*
	 * // @ModelAttribute("getEditUserDetails") public User getEditUserDetails()
	 * {
	 * 
	 * Set<Project> projectSet1 = new HashSet<Project>(); Project p1 = new
	 * Project(); p1.setProject_id(1); p1.setProjectName("projectSet1 EPR1");
	 * p1.setProjectClientName("projectSet1 ERP CLIENT 1");
	 * p1.setStructuralName("projectSet1 EPR1 Sector 1");
	 * 
	 * Project p2 = new Project(); p2.setProject_id(2); p2.setProjectName(
	 * "projectSet1 EPR2"); p2.setProjectClientName("projectSet1 ERP CLIENT 2");
	 * p2.setStructuralName("projectSet1 EPR1 Sector 2"); projectSet1.add(p1);
	 * projectSet1.add(p2);
	 * 
	 * Set<Project> projectSet2 = new HashSet<Project>(); Project p3 = new
	 * Project(); p3.setProjectName("projectSet1 EPR3");
	 * p3.setProjectClientName("projectSet1 ERP CLIENT 3");
	 * p3.setStructuralName("projectSet1 EPR1 Sector 3"); projectSet2.add(p3);
	 * 
	 * User u1 = new User(); u1.setId(1); u1.setFirstName("Harsahd");
	 * u1.setMiddleName("P"); u1.setLastName("Gaikwad");
	 * u1.setMobileNumber("123456789"); u1.setAlternateNumber("987654321");
	 * u1.setEmail("Test@gmail.com"); u1.setAddress("TEst Address");
	 * u1.setSsoId("Harshag"); u1.setProject(projectSet1); //
	 * u1.setProject(projectSet2);
	 * 
	 * return u1; }
	 */

}