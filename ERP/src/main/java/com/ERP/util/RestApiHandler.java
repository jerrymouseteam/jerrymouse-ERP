package com.ERP.util;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ERP.model.AuthTokenInfo;
import com.ERP.model.Project;

public interface RestApiHandler<T> {
	
	

	ResponseEntity<T> save(AuthTokenInfo tokenInfo, T className);
	List<LinkedHashMap<String, Object>> findAllInfo(AuthTokenInfo tokenInfo);
	ResponseEntity<T> getDetailsById(AuthTokenInfo tokenInfo, Long id);
	ResponseEntity<List> getListEntityInfo(AuthTokenInfo tokenInfo);
}
