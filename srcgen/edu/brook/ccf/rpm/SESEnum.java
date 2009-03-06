package edu.brook.ccf.rpm;

/**
 * SES Java Implementation.
 * Socio-Economic Category. Currently defined by mother's education level, i.e. high school, high-school degree, some college, at least a college degree.
 * Generated by metaabm system: Mar 4, 2009 8:11:39 PM PST in project: edu.brook.parent.escape  */

public enum SESEnum {
	cat1("Category 1"), cat3("Category 3"), cat2("Category 2"), category4(
			"Category 4");

	private final String name;

	private SESEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
