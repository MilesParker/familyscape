package edu.brook.ccf.rpm;
public class RelationshipsAndPregnancyPartFactory
		extends
			com.metascape.escape.view.gef.ScapePartFactory {
	protected org.eclipse.gef.EditPart getPartForElement(Object model) {

		if (model instanceof Adult) {
			return new edu.brook.ccf.rpm.GenderStyle();
		}

		if (model instanceof NeighborhoodCell) {
			return new edu.brook.ccf.rpm.NeighborhoodCellStyle2D();
		}

		return super.getPartForElement(model);
	}
}
