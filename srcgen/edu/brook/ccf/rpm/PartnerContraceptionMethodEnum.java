package edu.brook.ccf.rpm;

/**
 * Partner Contraception Method Java Implementation.
 * 
 * Generated by metaabm system: Mar 6, 2009 1:43:17 PM PST in project: edu.brook.parent.escape  */

public enum PartnerContraceptionMethodEnum {
	partnerSterilized("Partner Sterilized"), otherContraception(
			"Other Contraception");

	private final String name;

	private PartnerContraceptionMethodEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
