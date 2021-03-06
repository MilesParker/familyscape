package edu.brook.ccf.rpm;

/**
 * <!-- begin-user-doc -->
 * SES Java Implementation.
 * Socio-Economic Category. Currently defined by mother's education level, i.e. high school, high-school degree, some college, at least a college degree.
 * Generated by AMF for model: FamilyScape.metaabm in project: edu.brook.parent.escape 
 * <!-- end-user-doc -->
 * @generated
 */
public enum SESEnum {
	cat1("Category 1"), cat3("Category 3"), cat2("Category 2"), category4(
			"Category 4");

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SESEnum(String name) {
		this.name = name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		return name;
	}
}
