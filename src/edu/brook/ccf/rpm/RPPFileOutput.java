package edu.brook.ccf.rpm;

public class RPPFileOutput {
    public void setup(final RelationshipsAndPregnancy model) {
        System.err.println("--");
        if (!model.getOutputRunFile().equals("")) {
            org.ascape.view.nonvis.DataOutputView dataView = new org.ascape.view.nonvis.DataOutputView() {
                protected void scapeChanged() {
                    if (SnapshotView.isPeriod(model.getWritePeriods(), model.getPeriod())) {
                        super.scapeChanged();
                    }
                }
            };
            model.getAdultScape().addView(dataView);
            try {
                String outputRunFile = model.getOutputRunFile().replace("\\.txt",
                                                                        model.getName() + ".txt");
                System.err.println(outputRunFile);
                dataView.setRunFile(new java.io.File(outputRunFile));
                if (!model.getOutputPeriodFile().equals("")) {
                    String outputPeriodFile = model.getOutputPeriodFile().replace(
                                                                                  "\\.txt",
                                                                                  model.getName()
                                                                                  + ".txt");
                    System.err.println(outputPeriodFile);
                    dataView.setPeriodFile(new java.io.File(outputPeriodFile));
                }
            } catch (java.io.IOException e) {
                System.err.println("Can't output data because a file problem occurred: " + e.getLocalizedMessage());
            }
        }
        if (model.isOutputData() && !model.getAllOutputFile().equals("")) {
            SnapshotView allView = new SnapshotView();
            model.getAdultScape().addView(allView);
            try {
                String outputRunFile = model.getOutputRunFile().replace(".txt", model.getName() + ".txt");
                allView
                .setRunFile(new java.io.File(outputRunFile));
            } catch (java.io.IOException e) {
                System.err.println("Can't output all data because a file problem occurred: " + e.getLocalizedMessage());
            }
            try {
                model.setStopPeriod(SnapshotView.lastPeriod(model.getWritePeriods()));
            } catch (org.ascape.model.space.SpatialTemporalException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
