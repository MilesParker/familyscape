package edu.brook.ccf.rpm;

public class FSFileLoader {
    public void load(FamilyScape model) {
		System.err.println("LOAD");

        org.ascape.view.nonvis.ScapeFromFileView fileView = new org.ascape.view.nonvis.ScapeFromFileView();
        try {
            fileView.setFile(model.getInputDataFile());
        } catch (java.io.IOException e) {
            throw new RuntimeException("File Problem in Scape File Control Test " + e);
        }
        model.getAdultScape().addView(fileView);
        fileView.scapeInitialized(null);
    }
}
