package edu.brook.ccf.rpm;

/**
 * Neighborhood Cell Java Implementation.
 * 
 * Generated by metaabm system: Oct 8, 2009 5:46:39 PM PDT in project: edu.brook.parent.escape  */

public class NeighborhoodCell extends org.ascape.model.HostCell {

	/**
	 * Constructs a new Neighborhood Cell.
	 */

	public NeighborhoodCell() {
		createUniqueID();
	}
	//todo, make this a useful value for evaluating compatibility of different versions of generated classes
	private static final long serialVersionUID = 89989998L;

	private String uniqueID;

	public String getUID() {
		return uniqueID;
	}

	public void createUniqueID() {
		//uniqueID = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5);
	}

	/**
	 * Clones the agent, ensuring that a unique id is assigned.
	 */
	public Object clone() {
		try {
			NeighborhoodCell clone = (NeighborhoodCell) super.clone();
			clone.createUniqueID();
			return clone;
		} catch (Exception e) {
			throw new RuntimeException("Unexpected cloning exception: " + e);
		}
	}

	public RelationshipsAndPregnancy getRelationshipsAndPregnancy() {
		return (RelationshipsAndPregnancy) getScape().getRoot();
	}

	public java.util.List getNetwork() {
		return ((org.ascape.model.space.Graph) getRelationshipsAndPregnancy()
				.getPartners().getSpace()).getNeighborsFor(this);
	}

	public String getName() {
		if (name == null) {
			return "Neighborhood Cell " + uniqueID;
		} else {
			return name;
		}
	}
}
