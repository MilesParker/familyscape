package edu.brook.ccf.rpm;

import org.ascape.view.vis.GEFView;
import org.eclipse.amp.agf3d.I3DModelFactoryProvider;
import org.eclipse.amp.escape.ascape.adapt.Ascape3DPartFactory;
import org.eclipse.amp.escape.ascape.agf3d.GEF3DView;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

public class RPP3D extends RelationshipsAndPregnancy implements I3DModelFactoryProvider {
    public void createGraphicViews() {
        addView(new GEFView());
        addView(new GEF3DView());
    }

    public EditPartFactory getEditPart3DFactory() {
        return new Ascape3DPartFactory() {
            public EditPart getPartForElement(Object model) {
                if (model instanceof Adult) {
                    return new RenderGender3DEditPart();
                }
                // if (model instanceof NeighborhoodCell) {
                // return new Tile3DEditPart();
                // }
                return super.getPartForElement(model);
            }
        };
    }
}
