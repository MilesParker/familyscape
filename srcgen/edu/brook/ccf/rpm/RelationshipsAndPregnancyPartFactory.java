package edu.brook.ccf.rpm;

import org.ascape.model.HostCell;
import org.eclipse.amp.escape.ascape.adapt.AscapePartFactory;
import org.eclipse.gef.EditPart;
import org.eclipse.amp.escape.ascape.gef.DefaultHostCellEditPart;

public class RelationshipsAndPregnancyPartFactory extends AscapePartFactory {

	protected EditPart getPartForElement(Object model) {

		if (model instanceof Adult) {
			return new edu.brook.ccf.rpm.GenderStyle();
		}

		if (model instanceof NeighborhoodCell) {
			return new edu.brook.ccf.rpm.NeighborhoodCellStyle2D();
		}

		return super.getPartForElement(model);
	}
}
