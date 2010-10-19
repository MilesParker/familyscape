/*
 * Copyright 1998-2007 The Brookings Institution, NuTech Solutions,Inc., Metascape LLC, and contributors.
 * All rights reserved.
 * This program and the accompanying materials are made available solely under of the BSD license "ascape-license.txt".
 * Any referenced or included libraries carry licenses of their respective copyright holders.
 */
package edu.brook.ccf.rpm;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TooManyListenersException;

import org.ascape.model.Agent;
import org.ascape.model.event.ScapeEvent;
import org.ascape.util.PropertyAccessor;
import org.ascape.view.nonvis.DataOutputView;

/**
 * User: jmiller Date: Nov 2, 2005 Time: 1:02:02 PM To change this template use
 * Options | File Templates.
 */

/**
 * Very similar to DataOutputView, this view outputs all model and member-agent scape data. The other differnce is that
 * data here is written to an XML file. Note: If the RunDataSet is being used, it must be added in the Ant file before
 * the AllOutputView.
 */
public class SnapshotView extends DataOutputView {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List agentAccessors;

    private List enumAccessors;

    private List<Integer> writePeriodsList;

    public static List determineEnumAccessors(Object object, Class stopClass, boolean includeGetters)
    throws IntrospectionException {
        ArrayList tempPropertyAccessors = new ArrayList();
        PropertyDescriptor[] infoProperties;
        if (stopClass == null || object.getClass() == stopClass) {
            infoProperties = Introspector.getBeanInfo(object.getClass()).getPropertyDescriptors();
        } else {
            infoProperties = Introspector.getBeanInfo(object.getClass(), stopClass).getPropertyDescriptors();
        }
        for (int i = 0; i < infoProperties.length; i++) {
            // if (infoProperties[i].getWriteMethod() != null && infoProperties[i].getReadMethod() != null &&
            // ((infoProperties[i].getReadMethod().getReturnType() == Integer.TYPE) ||
            // (infoProperties[i].getReadMethod().getReturnType() == Double.TYPE) ||
            // (infoProperties[i].getReadMethod().getReturnType() == Float.TYPE))) {
            if ((includeGetters || infoProperties[i].getWriteMethod() != null)
                    && infoProperties[i].getReadMethod() != null) {
                Object[] enumValues = infoProperties[i].getReadMethod().getReturnType().getEnumConstants();
                if (enumValues != null) {
                    tempPropertyAccessors.add(new PropertyAccessor(object, infoProperties[i]));
                }
            }
        }
        return tempPropertyAccessors;
    }

    /**
     * Writes the headers for the run parameters to the run data stream or file. Data is output as tab delimited ASCII
     * text, with the selected "EOLSeparator" separating each period.
     * 
     * @throws IOException
     *         Signals that an I/O exception has occurred.
     */
    public void writeRunHeader() throws IOException {
        try {
            agentAccessors = PropertyAccessor.determineReadWriteAccessors(getScape().getPrototypeAgent(), Agent.class,
                                                                          true);
            enumAccessors = determineEnumAccessors(getScape().getPrototypeAgent(), Agent.class, true);
            agentAccessors.addAll(enumAccessors);

            runDataStream.writeBytes("Run\tPeriod\t");

            for (Object object : agentAccessors) {
                PropertyAccessor accessor = (PropertyAccessor) object;
                runDataStream.writeBytes(accessor.getLongName());
                runDataStream.writeBytes("\t");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isPeriod(String periods, int period) {
        StringTokenizer tokens = new StringTokenizer(periods, ",");
        while (tokens.hasMoreElements()) {
            String next = tokens.nextToken();
            if (next.equals(period + "")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Writes the current run parameters to the data stream or file. Data is output as tab delimited ASCII text, with
     * the selected "EOLSeparator" separating each period.
     * 
     * @throws IOException
     *         Signals that an I/O exception has occurred.
     */
    public void writeRunData() throws IOException {
        try {
            for (Object agent : getScape()) {
                runDataStream.writeBytes(runCount + "\t");
                runDataStream.writeBytes(getScape().getPeriod() + "\t");
                for (Object accessor : agentAccessors) {
                    PropertyAccessor propertyAccessor = (PropertyAccessor) accessor;
                    runDataStream.writeBytes(propertyAccessor.getAsText(agent, propertyAccessor.getDescriptor()));
                    runDataStream.writeBytes("\t");
                }
                runDataStream.writeBytes(EOLString);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void scapeAdded(ScapeEvent scapeEvent) throws TooManyListenersException {
        // TODO Auto-generated method stub
        super.scapeAdded(scapeEvent);
        try {
            FamilyScape rpp = (FamilyScape) getScape().getScape();
            setRunFile(new java.io.File(rpp.getAllOutputFile()));
        } catch (java.io.IOException e) {
            System.err.println("Can't output all data because a file problem occurred: " + e.getLocalizedMessage());
        }
    }

    public static int lastPeriod(String periods) {
        StringTokenizer tokens = new StringTokenizer(periods, ",");
        String last = "";
        while (tokens.hasMoreElements()) {
            String next = tokens.nextToken();
            last = next;
        }
        return Integer.valueOf(last);
    }

    public void scapeIterated(ScapeEvent scapeEvent) {
        super.scapeIterated(scapeEvent);
        if (isPeriod(((FamilyScape) getScape().getScape()).getWritePeriods(), getScape().getPeriod())
                && runDataStream != null) {
            try {
                writeRunData();
            } catch (IOException e) {
                throw new RuntimeException("IO Exception occurred while sending run data. " + e);
            }
        }
    }

    public void scapeStopped(ScapeEvent scapeEvent) {
        runCount++;
    }

    /**
     * For now, not writing Period data.
     * 
     * @throws IOException
     *         Signals that an I/O exception has occurred.
     */
    public void writePeriodHeader() throws IOException {
        // no op
    }

    /**
     * For now, not writing Period data.
     * 
     * @throws IOException
     *         Signals that an I/O exception has occurred.
     */
    public void writePeriodData() throws IOException {
        // no op
    }

    public void setWritePeriods(int[] writePeriods) {
        this.writePeriodsList = new ArrayList();
        for (int i : writePeriods) {
            writePeriodsList.add(new Integer(i));
        }
    }
}
