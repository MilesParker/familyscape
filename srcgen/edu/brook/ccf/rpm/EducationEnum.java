package edu.brook.ccf.rpm;

/**
 * Education Java Implementation.
 * 
 * Generated by metaabm system: Oct 8, 2009 5:46:39 PM PDT in project: edu.brook.parent.escape  */

public enum EducationEnum {
	nHS("NHS"), pHS("PHS"), hS("HS");

	private final String name;

	private EducationEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
