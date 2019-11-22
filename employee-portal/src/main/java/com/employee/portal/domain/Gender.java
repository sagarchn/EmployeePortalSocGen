package com.employee.portal.domain;

public enum Gender {
	MALE("Male"), FEMALE("Female"), OTHER("Other");

	private String val;

	Gender(String v) {
		this.val = v;
	}
}
