package edu.brook.ccf.rpm;

/**
 * Marital Status Java Implementation.
 * 
 * Generated by metaabm system: Nov 20, 2009 7:01:25 PM PST in project: edu.brook.parent.escape  */

public enum MaritalStatusEnum {
	married("Married"), single("Single"), divorced("Divorced");

	private final String name;

	private MaritalStatusEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
