package com.ERP.constants;

public class ErpConstants {

	
	  public static final String REST_SERVICE_URI =
	  "http://localhost:8089/ERPoAuth";
	  
	  public static final String AUTH_SERVER_URI =
	 "http://localhost:8089/ERPoAuth/oauth/token";
	 

/*	public static final String REST_SERVICE_URI = "https://erpoauth-cf.cfapps.io";
	
	public static final String AUTH_SERVER_URI = "https://erpoauth-cf.cfapps.io/oauth/token";*/

	public static final String QPM_PASSWORD_GRANT = "?grant_type=password&username=Sam&password=abc125";

	public static final String QPM_ACCESS_TOKEN = "?access_token=";
	
	
	public static final String PROJECT_GET_ALL = REST_SERVICE_URI + "/project/list/";

	public static final String BANK_CREATE = REST_SERVICE_URI + "/bank/create/";
	public static final String BANK_UPDATE = REST_SERVICE_URI + "/bank/create/";
	public static final String BANK_DELETE = REST_SERVICE_URI + "/bank/create/";
	public static final String BANK_GET_ALL = REST_SERVICE_URI + "/bank/list/";
	public static final String BANK_GET_BY_ID = REST_SERVICE_URI + "/bank/";

	public static final String BANK_BRANCH_CREATE = REST_SERVICE_URI + "/bankBranch/create/";
	public static final String BANK_BRANCH_UPDATE = REST_SERVICE_URI + "/bank/create/";
	public static final String BANK_BRANCH_DELETE = REST_SERVICE_URI + "/bankBranch/{ifsc}";
	public static final String BANK_BRANCH_GET_ALL = REST_SERVICE_URI + "/bankBranch/list";
	public static final String BANK_BRANCH_GET_BY_ID = REST_SERVICE_URI + "/bankBranch/";
	public static final String BANK_BRANCH_FIND_USING_BANK_ID = REST_SERVICE_URI + "/bankBranch/list/";

	public static final String ADDRESS_CREATE = REST_SERVICE_URI + "/address/create/";
	public static final String ADDRESS_UPDATE = REST_SERVICE_URI + "/address/{addressId}";
	public static final String ADDRESS_DELETE = REST_SERVICE_URI + "/address/{addressId}";
	public static final String ADDRESS_GET_ALL = REST_SERVICE_URI + "/address/list/";
	public static final String ADDRESS_GET_BY_ID = REST_SERVICE_URI + "/address/{addressId}";

	public static final String VENDOR_CREATE = REST_SERVICE_URI + "/vendor/create2/";
	public static final String VENDOR_UPDATE = REST_SERVICE_URI + "/vendor/update/";
	public static final String VENDOR_DELETE = REST_SERVICE_URI + "/vendor/{vendorId}";
	public static final String VENDOR_GET_ALL = REST_SERVICE_URI + "/vendor/list";
	public static final String VENDOR_GET_BY_ID = REST_SERVICE_URI + "/vendor/{vendorId}";

	public static final String VENDOR_TYPE_CREATE = REST_SERVICE_URI + "/vendorType/create/";
	public static final String VENDOR_TYPE_UPDATE = REST_SERVICE_URI + "/vendorType/{vendorTypeId}";
	public static final String VENDOR_TYPE_DELETE = REST_SERVICE_URI + "/vendorType/{vendorTypeId}";
	public static final String VENDOR_TYPE_GET_ALL = REST_SERVICE_URI + "/vendorType/list/";
	public static final String VENDOR_TYPE_GET_MESSAGE = REST_SERVICE_URI + "/vendorType/message";
	public static final String VENDOR_TYPE_GET_BY_ID = REST_SERVICE_URI + "/vendorType/{vendorTypeId}";
	
	
	public static final String ITEM_CREATE = REST_SERVICE_URI + "/item/create/";
	public static final String ITEM_UPDATE = REST_SERVICE_URI + "/item/{itemId}";
	public static final String ITEM_DELETE = REST_SERVICE_URI + "/item/{itemId}";
	public static final String ITEM_GET_ALL = REST_SERVICE_URI + "/item/list/";
	public static final String ITEM_GET_MESSAGE = REST_SERVICE_URI + "/item/message";
	public static final String ITEM_GET_BY_ID = REST_SERVICE_URI + "/item/{itemId}";
	
	public static final String GRADE_CREATE = REST_SERVICE_URI + "/grade/create/";
	public static final String GRADE_UPDATE = REST_SERVICE_URI + "/grade/{gradeId}";
	public static final String GRADE_DELETE = REST_SERVICE_URI + "/grade/{gradeId}";
	public static final String GRADE_GET_ALL = REST_SERVICE_URI + "/grade/list/";
	public static final String GRADE_GET_MESSAGE = REST_SERVICE_URI + "/grade/message";
	public static final String GRADE_GET_BY_ID = REST_SERVICE_URI + "/grade/{gradeId}";
	
	public static final String UNIT_CREATE = REST_SERVICE_URI + "/unit/create/";
	public static final String UNIT_UPDATE = REST_SERVICE_URI + "/unit/{unitId}";
	public static final String UNIT_DELETE = REST_SERVICE_URI + "/unit/{unitId}";
	public static final String UNIT_GET_ALL = REST_SERVICE_URI + "/unit/list/";
	public static final String UNIT_GET_MESSAGE = REST_SERVICE_URI + "/unit/message";
	public static final String UNIT_GET_BY_ID = REST_SERVICE_URI + "/unit/{unitId}";

	public static final String VENDOR_BANK_PROFILE_CREATE = REST_SERVICE_URI + "/vendorBankProfile/create/";
	public static final String VENDOR_BANK_PROFILE_UPDATE = REST_SERVICE_URI
			+ "/vendorBankProfile/{vendorBankProfileId}";
	public static final String VENDOR_BANK_PROFILE_DELETE = REST_SERVICE_URI
			+ "/vendorBankProfile/{vendorBankProfileId}";
	public static final String VENDOR_BANK_PROFILE_GET_ALL = REST_SERVICE_URI + "/vendorBankProfile/list";
	public static final String VENDOR_BANK_PROFILE = REST_SERVICE_URI + "/vendorBankProfile/{vendorBankProfileId}";

}
