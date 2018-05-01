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
import com.ERP.model.Unit;
import com.ERP.model.Project;

public class UnitApiHandler implements RestApiHandler<Unit> {

	@Override
	public ResponseEntity<Unit> save(AuthTokenInfo tokenInfo, Unit className) {

		ResponseEntity<Unit> response = null;
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Object> request = new HttpEntity<Object>(className, Utilities.getHeaders());

		try {
			response = restTemplate.postForEntity(
					ErpConstants.VENDOR_CREATE + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), request,
					Unit.class);

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
					ErpConstants.VENDOR_GET_ALL + ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(),
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
	public ResponseEntity<Unit> getDetailsById(AuthTokenInfo tokenInfo, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Unit> findEntityDetailById(AuthTokenInfo tokenInfo, Long id) {

		// AuthTokenInfo tokenInfo = sendTokenRequest();
		ResponseEntity<Unit> response = null;
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(Utilities.getHeaders());

		try {
			response = restTemplate.exchange(ErpConstants.REST_SERVICE_URI + "/unit/" + id
					+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request, Unit.class);

		} catch (Exception excep) {
			excep.printStackTrace();
		}

		return response;
	}
}
