package com.ERP.model;

import java.io.Serializable;

public class KeyValueMapper implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long key;
	private String value;
	public long getKey() {
		return key;
	}
	public void setKey(long key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "KeyValueMapper [key=" + key + ", value=" + value + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (key ^ (key >>> 32));
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyValueMapper other = (KeyValueMapper) obj;
		if (key != other.key)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	public KeyValueMapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KeyValueMapper(long key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	

}
