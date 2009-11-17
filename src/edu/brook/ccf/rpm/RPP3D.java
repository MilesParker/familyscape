package edu.brook.ccf.rpm;

import org.eclipse.amp.agf3d.AgentEdit3DPart;
import org.eclipse.amp.agf3d.I3DModelFactoryProvider;
import org.eclipse.amp.agf3d.RenderingShapeProvider;
import org.eclipse.amp.escape.ascape.adapt.Ascape3DPartFactory;
import org.eclipse.amp.escape.ascape.agf3d.GEF3DView;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

public class RPP3D extends RelationshipsAndPregnancy implements I3DModelFactoryProvider {
    public void createGraphicViews() {
        addView(new GEF3DView());
    }

    public EditPartFactory getEditPart3DFactory() {
        return new Ascape3DPartFactory() {
            public EditPart getPartForElement(Object model) {
                if (model instanceof Adult) {
                    return new AgentEdit3DPart(RenderingShapeProvider.createProvider(new IndividualRenderer()), null);
                }
                // if (model instanceof NeighborhoodCell) {
                // return new Tile3DEditPart();
                // }
                return super.getPartForElement(model);
            }
        };
    }
}
