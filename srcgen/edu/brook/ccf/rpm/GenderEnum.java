package edu.brook.ccf.rpm;

/**
 * Gender Java Implementation.
 * 
 * Generated by metaabm system: Dec 11, 2009 6:36:38 PM PST for model: RelationshipsAndPregnancyData.metaabm in project: edu.brook.parent.escape 
 */

public enum GenderEnum {
	female("Female"), male("Male");

	private final String name;

	private GenderEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
