package com.ERP.controller;

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
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Project;
import com.ERP.model.User;
import com.ERP.model.UserProfile;
import com.ERP.service.UserProfileService;
import com.ERP.service.UserService;
import com.ERP.service.UserServiceImpl;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

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
		AuthTokenInfo tokenInfo = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders h = getHeadersWithClientCredentials();
			HttpEntity<String> request = new HttpEntity<String>(h);
			ResponseEntity<Object> response = restTemplate.exchange(
					ErpConstants.AUTH_SERVER_URI
							+ ErpConstants.QPM_PASSWORD_GRANT, HttpMethod.POST,
					request, Object.class);
			LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response
					.getBody();

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

	@RequestMapping(value = { "/", "/project" }, method = RequestMethod.GET)
	public ModelAndView UserDashboard(
			HttpServletRequest request,
			ModelMap model,
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

		return mv;
	}

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
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
			ResponseEntity<List> response = restTemplate.exchange(
					ErpConstants.REST_SERVICE_URI + "/user/"
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), HttpMethod.GET,
					request, List.class);
			List<LinkedHashMap<String, Object>> usersMap = (List<LinkedHashMap<String, Object>>) response
					.getBody();
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
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {

		User user = new User();
		System.out.println("user");
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		AuthTokenInfo tokenInfo = sendTokenRequest();
		user.setMobileNumber("9999999999");
		user.setAlternateNumber("9999999999");
		user.setAddress("Thane (west");
		user.setRetypePassword(user.getPassword());
		if (result.hasErrors()) {
			return "registration";
		}

		System.out.println("\nTesting create User API----------" + user);
		System.out.println("\nTesting create User API----------" + user);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> request = new HttpEntity<Object>(user, getHeaders());
		try {
			ResponseEntity<User> response = restTemplate.postForEntity(
					ErpConstants.REST_SERVICE_URI + "/user/create/"
							+ ErpConstants.QPM_ACCESS_TOKEN
							+ tokenInfo.getAccess_token(), request, User.class);
		} catch (HttpClientErrorException excep) {
			if (HttpStatus.CONFLICT.equals(excep.getStatusCode())) {
				FieldError ssoError = new FieldError("user", "ssoId",
						messageSource.getMessage("non.unique.ssoId",
								new String[] { user.getSsoId() },
								Locale.getDefault()));
				result.addError(ssoError);
				return "registration";
			}
		}
		/*
		 * System.out.println(" What is the response code " +
		 * response.getStatusCode() + " ## " + user.getSsoId());
		 */

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be
		 * implementing custom @Unique annotation and applying it on field [sso]
		 * of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you
		 * can fill custom errors outside the validation framework as well while
		 * still using internationalized messages.
		 */
		/*
		 * if (response.getStatusCode().equals(HttpStatus.CONFLICT)) {
		 * FieldError ssoError = new FieldError("user", "ssoId",
		 * messageSource.getMessage("non.unique.ssoId", new String[] {
		 * user.getSsoId() }, Locale.getDefault())); result.addError(ssoError);
		 * return "registration"; }
		 */

		/* userService.saveUser(user); */

		model.addAttribute("success", "User " + user.getFirstName() + " "
				+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		// return "success";
		return "registrationsuccess";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		ResponseEntity<User> response = restTemplate.exchange(
				ErpConstants.REST_SERVICE_URI + "/user/ssoid/" + ssoId
						+ ErpConstants.QPM_ACCESS_TOKEN
						+ tokenInfo.getAccess_token(), HttpMethod.GET, request,
				User.class);
		User user = response.getBody();
		System.out.println(user);

		// User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

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
		ResponseEntity<User> response = restTemplate.exchange(
				ErpConstants.REST_SERVICE_URI + "/user/" + user.getId()
						+ ErpConstants.QPM_ACCESS_TOKEN
						+ tokenInfo.getAccess_token(), HttpMethod.PUT, request,
				User.class);
		System.out.println(response.getBody());

		model.addAttribute("success", "User " + user.getFirstName() + " "
				+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}

	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		// userService.deleteUserBySSO(ssoId);
		AuthTokenInfo tokenInfo = sendTokenRequest();
		System.out.println("\nTesting delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		System.out.println(" URL :::" + ErpConstants.REST_SERVICE_URI
				+ "/user/delete/" + ssoId + ErpConstants.QPM_ACCESS_TOKEN
				+ tokenInfo.getAccess_token() + HttpMethod.GET + request
				+ User.class);
		restTemplate.exchange(
				ErpConstants.REST_SERVICE_URI + "/user/delete/" + ssoId
						+ ErpConstants.QPM_ACCESS_TOKEN
						+ tokenInfo.getAccess_token(), HttpMethod.DELETE,
				request, User.class);

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
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests. If users is already logged-in and
	 * tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
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
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
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

	@RequestMapping(value = { "/forgotPassword" }, method = RequestMethod.POST)
	public @ResponseBody
	String forgotPassword(@RequestParam String emailId) {

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

	@RequestMapping(value = { "/changepassword" }, method = RequestMethod.GET)
	public @ResponseBody
	String changePassword() {

		String userName = null;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
			User user = userService.findBySSO(userName);
			user.getPassword();
		} else {
			userName = principal.toString();
		}
		return "aaa";

	}

}