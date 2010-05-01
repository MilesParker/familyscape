package edu.brook.ccf.rpm;

import java.util.List;

import org.eclipse.swt.graphics.Color;
import org.eclipse.jface.viewers.IColorProvider;

import org.ascape.model.Agent;
import org.ascape.model.CellOccupant;
import org.ascape.model.HostCell;
import org.ascape.model.LocatedAgent;
import org.ascape.model.Scape;
import org.ascape.model.event.ScapeEvent;
import org.ascape.model.rule.Rule;
import org.ascape.model.space.CollectionSpace;
import org.ascape.model.space.Coordinate;
import org.ascape.model.space.Coordinate2DDiscrete;
import org.ascape.model.space.Graph;
import org.ascape.model.space.Location;
import org.ascape.runtime.NonGraphicRunner;
import org.ascape.util.Conditional;
import org.ascape.util.vis.ColorFeature;
import org.ascape.util.vis.ColorFeatureConcrete;
import org.ascape.view.vis.ChartView;
import org.ascape.view.vis.GEFView;

import org.eclipse.gef.EditPartFactory;
import org.eclipse.amp.agf.gef.ModelFactoryProvider;
import org.eclipse.amp.escape.ascape.adapt.AscapePartFactory;
import org.eclipse.amp.escape.ascape.adapt.AscapePartTreeFactory;

/**
 * Neighborhood Cell Java Implementation.
 * 
 * Generated by AMF for model: RelationshipsAndPregnancyData.metaabm in project: edu.brook.parent.escape 
 */

public class NeighborhoodCell extends HostCell {

	/**
	 * Constructs a new Neighborhood Cell.
	 */

	public NeighborhoodCell() {
	}
	//todo, make this a useful value for evaluating compatibility of different versions of generated classes
	private static final long serialVersionUID = 89989998L;

	private static long nextUniqueID;

	private long uniqueID;

	public long getUID() {
		if (uniqueID == 0) {
			uniqueID = nextUniqueID++;
		}
		return uniqueID;
	}

	/**
	 * Clones the agent, ensuring that a unique id is assigned.
	 */
	public Object clone() {
		try {
			NeighborhoodCell clone = (NeighborhoodCell) super.clone();
			clone.uniqueID = 0;
			return clone;
		} catch (Exception e) {
			throw new RuntimeException("Unexpected cloning exception: " + e);
		}
	}

	public RelationshipsAndPregnancy getRelationshipsAndPregnancy() {
		return (RelationshipsAndPregnancy) getScape().getScape();
	}

	public java.util.List getNetwork() {
		return ((Graph) getRelationshipsAndPregnancy().getPartners().getSpace())
				.getNeighborsFor(this);
	}

	public String getName() {
		if (name == null) {
			return "Neighborhood Cell " + getUID();
		} else {
			return name;
		}
	}
}
