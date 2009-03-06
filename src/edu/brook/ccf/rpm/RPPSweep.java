package edu.brook.ccf.rpm;

import org.ascape.model.space.SpatialTemporalException;
import org.ascape.util.sweep.SweepDimension;
import org.ascape.view.nonvis.SweepControlView;

public class RPPSweep extends RelationshipsAndPregnancy {
    public void createScape() {
        setInputDataFile("/Volumes/Resources/Developer/repos/brook/edu.brook.parent.escape/data/NSFG_Unmarried.txt");
        setOutputRunFile("/Volumes/Resources/Developer/repos/brook/edu.brook.parent.escape/run-output/Sweep.txt");
        setOutputData(false);
        try {
            setStopPeriod(1365);
        } catch (SpatialTemporalException e) {
            throw new RuntimeException(e);
        }
        super.createScape();
    }

    public void createViews() {
        super.createViews();
        SweepControlView view = new SweepControlView();
        addView(view);
        view.getSweepGroup().addMember(new SweepDimension(this, "PRelationshipEndMaximum", 0.0, 0.05, 0.0025));
    }
}
