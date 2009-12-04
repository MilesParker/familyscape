package edu.brook.ccf.rpm;

public class RPPFileLoader {
    public void load(RelationshipsAndPregnancy model) {
        org.ascape.view.nonvis.ScapeFromFileView fileView = new org.ascape.view.nonvis.ScapeFromFileView();
        try {
            fileView.setFile(model.getInputDataFile());
        } catch (java.io.IOException e) {
            throw new RuntimeException("File Problem in Scape File Control Test " + e);
        }
        model.getAdultScape().addView(fileView);
    }
}
