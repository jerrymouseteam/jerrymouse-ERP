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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ERP.constants.ErpConstants;
import com.ERP.model.Test;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.KeyValueMapper;
import com.ERP.util.Utilities;

@Controller
@RequestMapping("/")
// @SessionAttributes({ "roles", "getVendorTypes", "getEditVendorsListDetails"
// })
public class TestController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	Utilities u = new com.ERP.util.Utilities();

	@RequestMapping(value = { "/registerTest" }, method = RequestMethod.GET)
	public String registerTest(ModelMap model) {

		Test test = new Test();
		System.out.println("$$$ registerTest");
		model.addAttribute("testForm", test);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("getKeyValueMappers", getKeyValueMappers());

		return "registerTest";
	}

	@RequestMapping(value = { "/createTest" }, method = RequestMethod.POST)
	public String createTest(@ModelAttribute("testForm") Test test, BindingResult result, ModelMap model) {

		test = new Test();
		System.out.println("$$$ createTest test "+test);
		model.addAttribute("testForm", test);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", u.getPrincipal());
		model.addAttribute("success", "");

		return "redirect:/registerTest";
	}

	@ModelAttribute("getKeyValueMappers")
	public List<KeyValueMapper> getKeyValueMappers() {

		List<KeyValueMapper> keyValueMapperList = new ArrayList<KeyValueMapper>();
		keyValueMapperList.add(new KeyValueMapper(1, "Harshad"));
		keyValueMapperList.add(new KeyValueMapper(2, "Vivek"));

		return keyValueMapperList;
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
