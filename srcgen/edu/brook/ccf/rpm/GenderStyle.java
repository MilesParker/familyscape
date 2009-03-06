package edu.brook.ccf.rpm;

/**
 * Gender Style Java Implementation.
 * 
 * Generated by metaabm system: Mar 6, 2009 1:43:16 PM PST in project: edu.brook.parent.escape  */

public class GenderStyle extends com.metascape.escape.view.gef.AgentEditPart {

	/**
	 * Constructs a new Gender Style.
	 */

	public GenderStyle() {
		createUniqueID();
	}
	//todo, make this a useful value for evaluating compatibility of different versions of generated classes
	private static final long serialVersionUID = 89989998L;

	private String uniqueID;

	public String getUID() {
		return uniqueID;
	}

	public void createUniqueID() {
		uniqueID = org.apache.commons.lang.RandomStringUtils
				.randomAlphanumeric(5);
	}

	/**
	 * Clones the agent, ensuring that a unique id is assigned.
	 */
	public Object clone() {
		try {
			GenderStyle clone = (GenderStyle) super.clone();
			clone.createUniqueID();
			return clone;
		} catch (Exception e) {
			throw new RuntimeException("Unexpected cloning exception: " + e);
		}
	}

	org.eclipse.draw2d.geometry.Dimension notShown = new org.eclipse.draw2d.geometry.Dimension(
			0, 0);

	protected org.eclipse.draw2d.IFigure buildFigure(
			org.eclipse.draw2d.IFigure figure) {
		org.eclipse.swt.graphics.Color color = null;
		boolean createFigure = figure == null;
		org.eclipse.draw2d.Shape markerFigure = null;
		if (!createFigure) {
			((org.eclipse.draw2d.Shape) figure).setFill(false);
			((org.eclipse.draw2d.Shape) figure).setOutline(false);
		}
		Adult drawGenderRule = (Adult) getModel();
		double unitforAge = drawGenderRule.getAgeinYearsIndex() / 30.0;

		if (drawGenderRule.getGender() == GenderEnum.male) {

			if (createFigure) {
				figure = shapeRectangle();
			}

			if (!createFigure) {
				color = new org.eclipse.swt.graphics.Color(
						org.eclipse.swt.widgets.Display.getCurrent(),
						(int) (unitforAge * 255), (int) (unitforAge * 255),
						(int) (1.0 * 255));

			}

			if (!createFigure) {
				figure.setBackgroundColor(color);
				((org.eclipse.draw2d.Shape) figure).setFill(true);

			}

			if (!createFigure) {
				color = org.eclipse.draw2d.ColorConstants.blue;

			}

			if (!createFigure) {
				figure.setForegroundColor(color);
				((org.eclipse.draw2d.Shape) figure).setOutline(true);

			}
			int now = drawGenderRule.getScape().getPeriod();

			if (drawGenderRule.getMaritalStatus() == MaritalStatusEnum.married) {

				if (!createFigure) {
					color = org.eclipse.draw2d.ColorConstants.black;

				}

				figure = shapeMarker();

				if (!createFigure) {
					figure.setBackgroundColor(color);
					((org.eclipse.draw2d.Shape) figure).setFill(true);

					figure = getFigure();

				}

			}

			if (now == drawGenderRule.getDayofLastSex()) {

				if (!createFigure) {
					color = org.eclipse.draw2d.ColorConstants.orange;

				}

				if (!createFigure) {
					figure.setBackgroundColor(color);
					((org.eclipse.draw2d.Shape) figure).setFill(true);

				}

			}

		}

		if (drawGenderRule.getGender() == GenderEnum.female) {

			if (createFigure) {
				figure = shapeOval();
			}
			if (drawGenderRule.isPregnant()) {

				if (!createFigure) {
					color = new org.eclipse.swt.graphics.Color(
							org.eclipse.swt.widgets.Display.getCurrent(),
							(int) (unitforAge * 255), (int) (1.0 * 255),
							(int) (unitforAge * 255));

				}

				if (!createFigure) {
					figure.setBackgroundColor(color);
					((org.eclipse.draw2d.Shape) figure).setFill(true);

				}

				if (!createFigure) {
					color = org.eclipse.draw2d.ColorConstants.green;

				}

				if (!createFigure) {
					figure.setForegroundColor(color);
					((org.eclipse.draw2d.Shape) figure).setOutline(true);

				}
				int now = drawGenderRule.getScape().getPeriod();

				if (drawGenderRule.getMaritalStatus() == MaritalStatusEnum.married) {

					if (!createFigure) {
						color = org.eclipse.draw2d.ColorConstants.black;

					}

					figure = shapeMarker();

					if (!createFigure) {
						figure.setBackgroundColor(color);
						((org.eclipse.draw2d.Shape) figure).setFill(true);

						figure = getFigure();

					}

				}

				if (now == drawGenderRule.getDayofLastSex()) {

					if (!createFigure) {
						color = org.eclipse.draw2d.ColorConstants.orange;

					}

					if (!createFigure) {
						figure.setBackgroundColor(color);
						((org.eclipse.draw2d.Shape) figure).setFill(true);

					}

				}

			}

			if (!drawGenderRule.isPregnant()) {

				if (!createFigure) {
					color = new org.eclipse.swt.graphics.Color(
							org.eclipse.swt.widgets.Display.getCurrent(),
							(int) (1.0 * 255), (int) (unitforAge * 255),
							(int) (unitforAge * 255));

				}

				if (!createFigure) {
					figure.setBackgroundColor(color);
					((org.eclipse.draw2d.Shape) figure).setFill(true);

				}

				if (!createFigure) {
					color = org.eclipse.draw2d.ColorConstants.red;

				}

				if (!createFigure) {
					figure.setForegroundColor(color);
					((org.eclipse.draw2d.Shape) figure).setOutline(true);

				}
				int now = drawGenderRule.getScape().getPeriod();

				if (drawGenderRule.getMaritalStatus() == MaritalStatusEnum.married) {

					if (!createFigure) {
						color = org.eclipse.draw2d.ColorConstants.black;

					}

					figure = shapeMarker();

					if (!createFigure) {
						figure.setBackgroundColor(color);
						((org.eclipse.draw2d.Shape) figure).setFill(true);

						figure = getFigure();

					}

				}

				if (now == drawGenderRule.getDayofLastSex()) {

					if (!createFigure) {
						color = org.eclipse.draw2d.ColorConstants.orange;

					}

					if (!createFigure) {
						figure.setBackgroundColor(color);
						((org.eclipse.draw2d.Shape) figure).setFill(true);

					}

				}

			}

		}

		return figure;
	}

}
