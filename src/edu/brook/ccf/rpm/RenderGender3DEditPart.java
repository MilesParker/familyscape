package edu.brook.ccf.rpm;

import org.ascape.util.data.UnitIntervalDataPoint;
import org.ascape.util.vis.ColorFeature;
import org.ascape.util.vis.ColorFeatureConcrete;
import org.ascape.util.vis.ColorFeatureGradiatedIndex;
import org.eclipse.amp.agf3d.RenderEdit3DPart;
import org.eclipse.draw3d.graphics3d.Graphics3D;
import org.eclipse.draw3d.graphics3d.Graphics3DDraw;
import org.eclipse.draw3d.graphics3d.Graphics3DUtil;
import org.eclipse.swt.graphics.Color;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.Disk;

/**
 * Gender Style Java Implementation.
 * 
 * Generated by metaabm system: Jun 1, 2009 6:36:11 PM PDT in project: edu.brook.parent.escape
 */

public class RenderGender3DEditPart extends RenderEdit3DPart {

    private final class AgeUnitValue extends UnitIntervalDataPoint {
        public double getValue(Object object) {
            Adult adult = (Adult) getModel();
            double unitforAge = adult.getAgeinYearsIndex() / 30.0;
            return java.lang.Math.min(unitforAge, 1);
        }
    }

    private static final Color RACE_OTHER = ColorFeatureConcrete.create(240, 128, 128);
    private static final Color RACE_HISPANIC = ColorFeatureConcrete.create(107, 66, 38);
    private static final Color RACE_BLACK = ColorFeature.BLACK;
    private static final Color RACE_WHITE = ColorFeatureConcrete.create(184, 184, 184);
    private static final Color SES_4 = ColorFeatureConcrete.createHSB(120, 1.0f, 0.67f);
    private static final Color SES_3 = ColorFeatureConcrete.createHSB(120, 0.7f, 0.67f);
    private static final Color SES_2 = ColorFeatureConcrete.createHSB(120, 0.5f, 0.67f);
    private static final Color SES_1 = ColorFeatureConcrete.createHSB(120, 0.2f, 0.67f);
    private static final Color EDU_3 = ColorFeatureConcrete.createHSB(200, 1.0f, 0.67f);
    private static final Color EDU_2 = ColorFeatureConcrete.createHSB(200, 0.7f, 0.67f);
    private static final Color EDU_1 = ColorFeatureConcrete.createHSB(200, 0.2f, 0.67f);

    private static final Color START_RED = ColorFeatureConcrete.createHSB(0, 1.0f, 0.7f);
    private static final Color LIGHT_RED = ColorFeatureConcrete.createHSB(0, 0.7f, 1.0f);

    private static final Color START_BLUE = ColorFeatureConcrete.createHSB(240, 1.0f, 0.7f);
    private static final Color LIGHT_BLUE = ColorFeatureConcrete.createHSB(240, 0.7f, 1.0f);

    private ColorFeatureGradiatedIndex maleAgeColor = new ColorFeatureGradiatedIndex("Age Color", START_BLUE,
                                                                                     LIGHT_BLUE, new AgeUnitValue());

    private ColorFeatureGradiatedIndex femaleAgeColor = new ColorFeatureGradiatedIndex("Age Color", START_RED,
                                                                                       LIGHT_RED,
                                                                                       new AgeUnitValue());

    private ColorFeatureGradiatedIndex pregnantAgeColor = new ColorFeatureGradiatedIndex("Age Color",
                                                                                         ColorFeature.GREEN, new AgeUnitValue());
    private float totalHeight;

    protected void renderShape(Graphics3D g3d) {
        Adult adult = (Adult) getModel();
        // float scale = 0.6f + adult.getAgeinYearsIndex() * .01f;
        float scale = 1.0f;

        float bodyWidth = 0.4f * scale;
        float bodyDepth = 0.3f * scale;
        float bodyHeight = 0.4f * scale;
        float legWidth = 0.1f * scale;
        float legHeight = 0.6f * scale;
        float skirtHeight = 0.3f * scale;
        float headWidth = 0.3f * scale;
        float headHeight = 0.2f * scale;
        totalHeight = legHeight + bodyHeight + headHeight;

        // base
        g3d.glTranslatef(0.5f, .5f, 0);

        colorForGenderAndAge(g3d, adult);

        // legs
        // colorForEdu(g3d, adult);
        g3d.glTranslatef(bodyWidth * .25f, bodyDepth / 2.0f, 0);
        drawCylinder(g3d, legWidth, legHeight, false);
        g3d.glTranslatef(bodyWidth * .5f, 0, 0);
        drawCylinder(g3d, legWidth, legHeight, false);
        g3d.glTranslatef(-bodyWidth * .75f, -bodyDepth * .5f, 0);

        if (adult.getGender() == GenderEnum.male) {
            g3d.glTranslatef(0, 0, legHeight);
        } else {
            g3d.glTranslatef(bodyWidth * .5f, bodyDepth / 2.0f, legHeight - skirtHeight);
            drawCylinder(g3d, bodyWidth * 1.5f, bodyWidth * .8f, skirtHeight, false);
            g3d.glTranslatef(-bodyWidth * .5f, -bodyDepth / 2.0f, skirtHeight);
        }

        // body
        // colorForSES(g3d, adult);
        drawCube(g3d, bodyWidth, bodyDepth, bodyHeight);
        // if (adult.isPregnant()) {
        // g3d.glTranslatef(bodyWidth * 0.5f, bodyDepth * 0.5f, 0);
        // glSetColor(g3d, ColorFeature.RED, 200);
        // drawCylinder(g3d, bodyWidth * 1.5f, bodyHeight * .5f, true);
        // g3d.glTranslatef(-bodyWidth * .5f, -bodyDepth * .5f, 0);
        // }
        g3d.glTranslatef(bodyWidth / 2.0f, bodyDepth / 2.0f, bodyHeight);

        // head
        // colorForRace(g3d, adult);
        drawCylinder(g3d, headWidth, headHeight, true);

        g3d.glTranslatef(0.0f, 0.0f, -(legHeight + bodyHeight));

        drawForSexOccurred(g3d, adult, totalHeight);
        drawForRelationship(g3d, adult);

        g3d.glTranslatef(-.5f, -.5f, -(legHeight + bodyHeight));
        g3d.glEnd();
    }

    private void drawForRelationship(Graphics3D g3d, Adult adult) {
        if (adult.isInRelationship()) {
            if (adult.getMaritalStatus() == MaritalStatusEnum.married) {
                glSetColor(g3d, RACE_HISPANIC, 255);
            } else {
                glSetColor(g3d, ColorFeature.DARK_GRAY, 255);
            }
            drawCylinder(g3d, 1.0f, 0.05f, true);
        }
        else if (adult.getMaritalStatus() == MaritalStatusEnum.married) {
            // error
            glSetColor(g3d, ColorFeature.RED, 150);
            drawCylinder(g3d, 1.0f, 0.05f, true);
        }
    }

    private void drawForSexOccurred(Graphics3D g3d, Adult adult, float scale) {
        if (adult.getDayofLastSex() == adult.getScape().getPeriod()) {
            g3d.glTranslatef(0, 0, .05f);
            glSetColor(g3d, ColorFeature.YELLOW, 100);
            drawCylinder(g3d, 1.0f, totalHeight, true);
            g3d.glTranslatef(0, 0, -.05f);
        }
    }

    protected void colorForGenderAndAge(Graphics3D g3d, Adult adult) {
        if (adult.getGender() == GenderEnum.male) {
            glSetColor(g3d, maleAgeColor.getColor(adult));
        } else {
            if (!adult.isPregnant()) {
                glSetColor(g3d, femaleAgeColor.getColor(adult));
            } else {
                glSetColor(g3d, ColorFeatureConcrete.GREEN);
                // glSetColor(g3d, pregnantAgeColor.getColor(adult));
            }
        }
    }

    private void colorForRace(Graphics3D g3d, Adult adult) {
        switch (adult.getRace()) {
            case white:
                glSetColor(g3d, RACE_WHITE);
                break;
            case black:
                glSetColor(g3d, RACE_BLACK);
                break;
            case hispanic:
                glSetColor(g3d, RACE_HISPANIC);
                break;
            case other:
                glSetColor(g3d, RACE_OTHER);
                break;
        }
    }

    private void colorForSES(Graphics3D g3d, Adult adult) {
        switch (adult.getSES()) {
            case cat1:
                glSetColor(g3d, SES_1);
                break;
            case cat2:
                glSetColor(g3d, SES_2);
                break;
            case cat3:
                glSetColor(g3d, SES_3);
                break;
            case category4:
                glSetColor(g3d, SES_4);
                break;
        }
    }

    private void colorForEdu(Graphics3D g3d, Adult adult) {
        switch (adult.getEducation()) {
            case nHS:
                glSetColor(g3d, EDU_1);
                break;
            case hS:
                glSetColor(g3d, EDU_2);
                break;
            case pHS:
                glSetColor(g3d, EDU_3);
                break;
        }
    }

    private void drawCylinder(Graphics3D g3d, float width, float height, boolean cap) {
        drawCylinder(g3d, width, width, height, cap);
    }

    private void drawCylinder(Graphics3D g3d, float width1, float width2, float height, boolean cap) {
        Cylinder head = new Cylinder();
        head.setNormals(Graphics3DUtil.GLU_FLAT);
        head.setDrawStyle(Graphics3DUtil.GLU_FILL);
        head.draw(width1 / 2, width2 / 2, height, 30, 10);
        g3d.glTranslatef(0, 0, height);
        if (cap) {
            Disk disk = new Disk();
            disk.setNormals(Graphics3DUtil.GLU_FLAT);
            disk.setDrawStyle(Graphics3DUtil.GLU_FILL);
            disk.setOrientation(Graphics3DUtil.GLU_INSIDE);
            disk.draw(width1 / 2, 0, 10, 1);
        }
        g3d.glTranslatef(0, 0, -height);
    }

    private void drawCube(Graphics3D g3d, float width, float depth, float height) {
        g3d.glBegin(Graphics3DDraw.GL_QUADS);

        // back
        g3d.glNormal3f(0, 0, height);
        g3d.glVertex3f(0, 0, height);
        g3d.glVertex3f(width, 0, height);
        g3d.glVertex3f(width, depth, height);
        g3d.glVertex3f(0, depth, height);

        // left
        g3d.glNormal3f(-width, 0, 0);
        g3d.glVertex3f(0, 0, 0);
        g3d.glVertex3f(0, 0, height);
        g3d.glVertex3f(0, depth, height);
        g3d.glVertex3f(0, depth, 0);

        // right
        g3d.glNormal3f(width, 0, 0);
        g3d.glVertex3f(width, 0, height);
        g3d.glVertex3f(width, 0, 0);
        g3d.glVertex3f(width, depth, 0);
        g3d.glVertex3f(width, depth, height);

        // top
        g3d.glNormal3f(0, depth, 0);
        g3d.glVertex3f(0, depth, height);
        g3d.glVertex3f(width, depth, height);
        g3d.glVertex3f(width, depth, 0);
        g3d.glVertex3f(0, depth, 0);

        // bottom
        g3d.glNormal3f(0, -depth, 0);
        g3d.glVertex3f(0, 0, 0);
        g3d.glVertex3f(width, 0, 0);
        g3d.glVertex3f(width, 0, height);
        g3d.glVertex3f(0, 0, height);
        g3d.glEnd();
    }
}
