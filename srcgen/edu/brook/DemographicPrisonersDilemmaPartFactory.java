package edu.brook;
public class DemographicPrisonersDilemmaPartFactory
		extends
			com.metascape.escape.view.gef.ScapePartFactory {
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
