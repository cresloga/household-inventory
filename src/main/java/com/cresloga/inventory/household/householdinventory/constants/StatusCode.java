package com.cresloga.inventory.household.householdinventory.constants;

public enum StatusCode {
	
	NOT_FOUND("DATA_NOT_FOUND","NO MATCH FOUND FOR GIVEN CRITERIA");
	
	private final String code;
	private final String desc;

	StatusCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
