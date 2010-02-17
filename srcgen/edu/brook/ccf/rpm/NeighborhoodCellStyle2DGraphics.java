package edu.brook.ccf.rpm;

/**
 * Neighborhood Cell Style 2D Java Implementation.
 * 
 * Generated by metaabm system: Feb 16, 2010 7:32:04 PM PST for model: RPP3D.metaabm in project: edu.brook.parent.escape 
 */

public class NeighborhoodCellStyle2DGraphics
		extends
			org.ascape.util.vis.DrawFeature {

	enum Shapes {
		rectangle, oval, marker
	};

	Shapes shape = Shapes.rectangle;

	public void draw(org.eclipse.draw2d.Graphics g, Object object, int width,
			int height) {

		NeighborhoodCell rootActGroup = (NeighborhoodCell) object;
		NeighborhoodCell background = rootActGroup;

		org.eclipse.swt.graphics.Color backgroundColorGray = org.eclipse.draw2d.ColorConstants.gray;
		g.setForegroundColor(backgroundColorGray);
		g.setBackgroundColor(backgroundColorGray);
		shape = shape.rectangle;
		if (shape == Shapes.oval) {
			g.fillOval(0, 0, width, height);
		} else if (shape == Shapes.marker) {
			int d = (int) (width * .25 - 1);
			int d2 = (int) (width * .5 - 1);
			g.fillOval(d, d, d2, d2);
		} else if (shape == Shapes.rectangle) {
			g.fillRectangle(0, 0, width, height);
		}

	}
}
