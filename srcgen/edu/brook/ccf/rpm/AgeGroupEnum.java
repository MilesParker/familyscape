package edu.brook.ccf.rpm;

/**
 * Age Group Java Implementation.
 * 
 * Generated by AMF for model: RelationshipsAndPregnancyData.metaabm in project: edu.brook.parent.escape 
 */

public enum AgeGroupEnum {
	years15to19("15 to 19"), years20to24("20 to 24"), years25to29("25 to 29"), years30to44(
			"30 to 44");

	private final String name;

	private AgeGroupEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
