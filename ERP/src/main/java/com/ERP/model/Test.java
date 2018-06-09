package com.ERP.model;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<KeyValueMapper> keyValueMappers;


	public List<KeyValueMapper> getKeyValueMappers() {
		return keyValueMappers;
	}


	public void setKeyValueMappers(List<KeyValueMapper> keyValueMappers) {
		this.keyValueMappers = keyValueMappers;
	}


	@Override
	public String toString() {
		return "Test [keyValueMappers=" + keyValueMappers + "]";
	}
	
	
	
	
	

}
