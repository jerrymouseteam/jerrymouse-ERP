package com.jerrymouse.util;

public enum ReqStatus {

	req_raised("req raised"), req_authorize("req authorize"), pur_order_added(
			"pur order added"), challan_added("challan added");

	private String reqStatus;

	private ReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	public String getReqStatus() {
		return reqStatus;
	}

}
