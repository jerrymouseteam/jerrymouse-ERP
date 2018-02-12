package com.ERP.util;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ERP.constants.ErpConstants;
import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Bank;
import com.ERP.model.BankBranch;
import com.ERP.model.Project;

public class BankApiHandler implements RestApiHandler<Bank> {

	private ResponseEntity<Bank> response = null;

	@Override
	public ResponseEntity<Bank> save(AuthTokenInfo tokenInfo, Bank className) {

		ResponseEntity<Bank> response = null;
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Object> request = new HttpEntity<Object>(className, Utilities.getHeaders());

		try {

			String url = ErpConstants.BANK_CREATE + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token();
			System.out.println(">>>>>>>>>>>>>>>>> url " + url);
			response = restTemplate.postForEntity(url, request, Bank.class);

		} catch (HttpClientErrorException excep) {
			excep.printStackTrace();

		}

		return response;

	}

	@Override
	public List<LinkedHashMap<String, Object>> findAllInfo(AuthTokenInfo tokenInfo) {

		System.out.println("\nTesting listAllUsers API-----------");
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> request = new HttpEntity<String>(Utilities.getHeaders());
		try {
			ResponseEntity<List> response = restTemplate.exchange(
					ErpConstants.BANK_GET_ALL + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
					HttpMethod.GET, request, List.class);
			List<LinkedHashMap<String, Object>> usersMap = (List<LinkedHashMap<String, Object>>) response.getBody();
			if (usersMap != null) {

				System.out.println(usersMap);
				return usersMap;
			} else {
				System.out.println("No user exist----------");
			}

		} catch (Exception excep) {
			excep.printStackTrace();
			return null;
		}

		return null;
	}

	@Override
	public ResponseEntity<Bank> getDetailsById(AuthTokenInfo tokenInfo, Long id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> request = new HttpEntity<String>(Utilities.getHeaders());

			response = restTemplate.exchange(ErpConstants.BANK_GET_BY_ID + id
					+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request, Bank.class);

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		System.out.println("&&&&&&&&&&&&&&&&& response : "+response);
		
		return response;
	}
}
