package edu.brook.ccf.rpm;

import org.ascape.util.vis.ColorFeature;
import org.ascape.model.CellOccupant;
import org.ascape.model.HostCell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ColorConstants;

import org.eclipse.jface.viewers.IColorProvider;

/**
 * <!-- begin-user-doc -->
 * Gender Style Java Implementation.
 * 
 * Generated by AMF for model: FamilyScape.metaabm in project: edu.brook.parent.escape 
 * <!-- end-user-doc -->
 * @generated
 */
public class GenderStyleColorProvider implements IColorProvider {

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static IColorProvider singleton;

	/**
	 * <!-- begin-user-doc -->
	 * Provides a color for Adult based on wether we want to fill or not.
	 * 
	 * @param object the agent
	 * @return	the foreground color for the element, or <code>null</code> 
	 *   to use the default foreground color
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getColor(Object object, boolean fill) {
		Color color = null;
		Color fillColor = null;
		Color outlineColor = null;

		Adult style = (Adult) object;
		Adult drawGenderRule = style;
		double unitforAge = drawGenderRule.getAgeinYearsIndex() / 30.0;

		double unitforAgeRange = java.lang.Math.min(unitforAge, 1)

		;

		if (drawGenderRule.getGender() == GenderEnum.male) {
			fillColor = new Color(Display.getCurrent(),
					(int) (unitforAgeRange * 255),
					(int) (unitforAgeRange * 255), (int) (1 * 255));
			outlineColor = ColorConstants.blue;
			int now = drawGenderRule.getScape().getPeriod();

			if (now == drawGenderRule.getDayofLastSex()) {
			}
			if (drawGenderRule.getMaritalStatus() == MaritalStatusEnum.married) {
			}
		}
		if (drawGenderRule.getGender() == GenderEnum.female) {
			if (drawGenderRule.getPregnancyStatus() == PregnancyStatusEnum.pregnant) {
				fillColor = new Color(Display.getCurrent(),
						(int) (unitforAgeRange * 255), (int) (1 * 255),
						(int) (unitforAgeRange * 255));
				outlineColor = ColorConstants.green;
				int now = drawGenderRule.getScape().getPeriod();

				if (now == drawGenderRule.getDayofLastSex()) {
				}
				if (drawGenderRule.getMaritalStatus() == MaritalStatusEnum.married) {
				}
			}
			if (drawGenderRule.getPregnancyStatus() == PregnancyStatusEnum.notPregnant) {
				fillColor = new Color(Display.getCurrent(), (int) (1 * 255),
						(int) (unitforAgeRange * 255),
						(int) (unitforAgeRange * 255));
				outlineColor = ColorConstants.red;
				int now = drawGenderRule.getScape().getPeriod();

				if (now == drawGenderRule.getDayofLastSex()) {
				}
				if (drawGenderRule.getMaritalStatus() == MaritalStatusEnum.married) {
				}
			}
		}
		if (fill) {
			return fillColor;
		} else {
			return outlineColor;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Provides a foreground color for the given Adult.
	 * 
	 * @param object the agent
	 * @return	the foreground color for the element, or <code>null</code> 
	 *   to use the default foreground color
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getForeground(Object object) {
		Color color = getColor(object, false);
		if (color != null) {
			return color;
		}
		//try to see if we have a fill color, if we do, we'll paint the whole agent that color.
		color = getColor(object, true);
		if (color != null) {
			return color;
		}
		return ColorFeature.BLACK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Provides a background color for the given Adult.
	 * 
	 * @param object the agent
	 * @return	the background color for the element, or <code>null</code> 
	 *   to use the default background color
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getBackground(Object object) {
		Color color = getColor(object, true);
		if (color != null) {
			return color;
		}
		//if no fill color, just return white
		return ColorFeature.WHITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IColorProvider getDefault() {
		if (singleton == null) {
			singleton = new GenderStyleColorProvider();
		}
		return singleton;
	}
}
