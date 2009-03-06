package edu.brook.ccf.rpm;

/**
 * Pregnancy Relationship Status Java Implementation.
 * 
 * Generated by metaabm system: Mar 4, 2009 8:11:39 PM PST in project: edu.brook.parent.escape  */

public enum PregnancyRelationshipStatusEnum {
	neverPregnant("Never Pregnant"), currentlyPregnant("Currently Pregnant"), wasPregnant(
			"Was Pregnant");

	private final String name;

	private PregnancyRelationshipStatusEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
