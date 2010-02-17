package edu.brook.ccf.rpm;

/**
 * Pregnancy Status Java Implementation.
 * 
 * Generated by metaabm system: Feb 16, 2010 7:31:53 PM PST for model: RelationshipsAndPregnancyData.metaabm in project: edu.brook.parent.escape 
 */

public enum PregnancyStatusEnum {
	notPregnant("Not Pregnant"), pregnant("Pregnant");

	private final String name;

	private PregnancyStatusEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
