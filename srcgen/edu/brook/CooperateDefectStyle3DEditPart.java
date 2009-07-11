package edu.brook;

/**
 * Cooperate Defect Style Java Implementation.
 * 
 * Generated by metaabm system: Jul 10, 2009 6:08:36 PM PDT in project: edu.brook.parent.escape  */

public class CooperateDefectStyle3DEditPart
		extends
			org.eclipse.amp.agf3d.CubeEdit3DPart {

	protected void updateGraphics() {
		org.eclipse.swt.graphics.Color color = null;
		org.eclipse.draw3d.shapes.SolidCube shape = null;

		for (int i = 1; i <= 4; i++) {
			setShowMarker(i, false);
		}

		Player playerRule = (Player) getModel();

		if (playerRule.isCooperate()) {

			color = org.eclipse.draw2d.ColorConstants.blue;

			shape = getCube();

			shape.setColor(color, 255);

		}

		if (!(playerRule.isCooperate())) {

			color = org.eclipse.draw2d.ColorConstants.red;

			shape = getCube();

			shape.setColor(color, 255);

		}

	}
}
