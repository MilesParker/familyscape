package edu.brook.ccf.rpm;

/**
 * Neighborhood Cell Style 2D Java Implementation.
 * 
 * Generated by metaabm system: Jul 10, 2009 6:08:40 PM PDT in project: edu.brook.parent.escape  */

public class NeighborhoodCellStyle2D3DEditPart
		extends
			org.eclipse.amp.agf3d.TileEdit3DPart {

	protected void updateGraphics() {
		org.eclipse.swt.graphics.Color color = null;
		org.eclipse.draw3d.shapes.SolidCube shape = null;

		NeighborhoodCell background = (NeighborhoodCell) getModel();

		color = org.eclipse.draw2d.ColorConstants.black;

		shape = getCube();

		shape.setColor(color, 255);

	}
}
