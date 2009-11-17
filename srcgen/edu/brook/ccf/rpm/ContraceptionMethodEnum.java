package edu.brook.ccf.rpm;

/**
 * Contraception Method Java Implementation.
 * 
 * Generated by metaabm system: Nov 13, 2009 2:51:11 PM PST in project: edu.brook.parent.escape  */

public enum ContraceptionMethodEnum {
	none("None"), sterilized("Sterilized"), pill("Pill"), condomMediumIntender(
			"Condom Medium Intender"), condomHighIntender(
			"Condom High Intender");

	private final String name;

	private ContraceptionMethodEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
