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
import com.ERP.model.VendorDTO;

public class VendorApiHandler implements RestApiHandler<VendorDTO> {

	@Override
	public ResponseEntity<VendorDTO> save(AuthTokenInfo tokenInfo, VendorDTO className) {

		ResponseEntity<VendorDTO> response = null;
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Object> request = new HttpEntity<Object>(className, Utilities.getHeaders());

		try {
			response = restTemplate.postForEntity(ErpConstants.VENDOR_CREATE
					+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), request, VendorDTO.class);

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
			ResponseEntity<List> response = restTemplate.exchange(ErpConstants.VENDOR_GET_ALL
					+ ErpConstants.QPM_ACCESS_TOKEN + tokenInfo.getAccess_token(), HttpMethod.GET, request, List.class);
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
	public ResponseEntity<VendorDTO> getDetailsById(AuthTokenInfo tokenInfo, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<VendorDTO> findEntityDetailById(AuthTokenInfo tokenInfo, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
