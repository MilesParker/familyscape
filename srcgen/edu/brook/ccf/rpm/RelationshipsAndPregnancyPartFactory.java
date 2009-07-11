package edu.brook.ccf.rpm;
public class RelationshipsAndPregnancyPartFactory
		extends
			org.eclipse.amp.escape.ascape.adapt.AscapePartFactory {

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
