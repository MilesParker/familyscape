package edu.brook;
public class DemographicPrisonersDilemmaPartFactory
		extends
			org.eclipse.amp.escape.ascape.adapt.AscapePartFactory {

	protected org.eclipse.gef.EditPart getPartForElement(Object model) {

		if (model instanceof Player) {
			return new edu.brook.CooperateDefectStyle();
		}

		if (model instanceof PlayCell) {
			return new edu.brook.PlayCellStyle();
		}

		return super.getPartForElement(model);
	}
}
