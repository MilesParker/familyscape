package edu.brook.ccf.rpm;

/**
 * <!-- begin-user-doc -->
 * Marital Status Java Implementation.
 * 
 * Generated by AMF for model: FamilyScape.metaabm in project: edu.brook.parent.escape 
 * <!-- end-user-doc -->
 * @generated
 */
public enum MaritalStatusEnum {
	married("Married"), single("Single"), divorced("Divorced");

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
	private MaritalStatusEnum(String name) {
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
