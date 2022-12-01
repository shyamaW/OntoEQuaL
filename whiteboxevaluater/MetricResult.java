/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.whiteboxevaluater;

import java.util.Set;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 *
 * @author HP
 */
public class MetricResult {

    private double instanceUsage;
    private int numberOfIsolatedInstances;
    private int numberOfinstancehasType; // instanceUsage
    private int numberOfDeclaredIndividual;
    private Set<OWLNamedIndividual> listOfIsolatedIndividuals;
    private Set<OWLObjectProperty> listOfIsolatedObjectProperty;
    private int numberOfIsolatedObjectProperty;
    private double objectPropertyUsage;
    private Set<OWLDataProperty> numberOfIsolatedDataProperty;
    private double classRichness;
    private Set<OWLClass> emptyClass;
    private Set<OWLClass> circularityClasses;
    private boolean circularity = false;
    private int maxDepth;
    private int maxBreadth;
    private Set<OWLClass> connectedClassesList;
    private Set<OWLClass> disconnectedClassList;
    
    /**
     * @return the instanceUsage
     */
    public double getInstanceUsage() {
        return instanceUsage;
    }

    /**
     * @param instanceRichness the instanceUsage to set
     */
    public void setInstanceUsage(double instanceRichness) {
        this.instanceUsage = instanceRichness;
    }
    
    /**
     * @return the numberOfIsolatedInstances
     */
    public int getNumberOfIsolatedInstances() {
        return numberOfIsolatedInstances;
    }

    /**
     * @param numberOfIsolatedInstances the numberOfIsolatedInstances to set
     */
    public void setNumberOfIsolatedInstances(int numberOfIsolatedInstances) {
        this.numberOfIsolatedInstances = numberOfIsolatedInstances;
    }

    /**
     * @return the instanceCompleteness
     */
    public int getNumberOfinstancehasType() {
        return numberOfinstancehasType;
    }

    /**
     * @param numberOfinstancehasType
     */
    public void setNumberOfinstancehasType(int numberOfinstancehasType) {
        this.numberOfinstancehasType = numberOfinstancehasType;
    }

    /**
     * @return the numberOfDeclaredIndividual
     */
    public int getNumberOfDeclaredIndividual() {
        return numberOfDeclaredIndividual;
    }

    /**
     * @param numberOfDeclaredIndividual the numberOfDeclaredIndividual to set
     */
    public void setNumberOfDeclaredIndividual(int numberOfDeclaredIndividual) {
        this.numberOfDeclaredIndividual = numberOfDeclaredIndividual;
    }

    /**
     * @return the listOfIsolatedIndividuals
     */
    public Set<OWLNamedIndividual> getListOfIsolatedIndividuals() {
        return listOfIsolatedIndividuals;
    }

    /**
     * @param listOfIsolatedIndividuals the listOfIsolatedIndividuals to set
     */
    public void setListOfIsolatedIndividuals(Set<OWLNamedIndividual> listOfIsolatedIndividuals) {
        this.listOfIsolatedIndividuals = listOfIsolatedIndividuals;
    }

    /**
     * @return the listOfIsolatedObjectProperty
     */
    public Set<OWLObjectProperty> getListOfIsolatedObjectProperty() {
        return listOfIsolatedObjectProperty;
    }

    /**
     * @param listOfIsolatedObjectProperty the listOfIsolatedObjectProperty to set
     */
    public void setListOfIsolatedObjectProperty(Set<OWLObjectProperty> listOfIsolatedObjectProperty) {
        this.listOfIsolatedObjectProperty = listOfIsolatedObjectProperty;
    }
    /**
     * @return the objectPropertyUsage
     */
    public double getObjectPropertyUsage() {
        return objectPropertyUsage;
    }

    /**
     * @param objectPropertyUsage the objectPropertyUsage to set
     */
    public void setObjectPropertyUsage(double objectPropertyUsage) {
        this.objectPropertyUsage = objectPropertyUsage;
    }
    /**
     * @return the numberOfIsolatedObjectProperty
     */
    public int getNumberOfIsolatedObjectProperty() {
        return numberOfIsolatedObjectProperty;
    }

    /**
     * @param numberOfIsolatedObjectProperty the numberOfIsolatedObjectProperty to set
     */
    public void setNumberOfIsolatedObjectProperty(int numberOfIsolatedObjectProperty) {
        this.numberOfIsolatedObjectProperty = numberOfIsolatedObjectProperty;
    }

    /**
     * @return the numberOfIsolatedDataProperty
     */
    public Set<OWLDataProperty> getNumberOfIsolatedDataProperty() {
        return numberOfIsolatedDataProperty;
    }

    /**
     * @param numberOfIsolatedDataProperty the numberOfIsolatedDataProperty to set
     */
    public void setNumberOfIsolatedDataProperty(Set<OWLDataProperty> numberOfIsolatedDataProperty) {
        this.numberOfIsolatedDataProperty = numberOfIsolatedDataProperty;
    }

    /**
     * @return the classRichness
     */
    public double getClassRichness() {
        return classRichness;
    }

    /**
     * @param classRichness the classRichness to set
     */
    public void setClassRichness(double classRichness) {
        this.classRichness = classRichness;
    }

    /**
     * @return the emptyClass
     */
    public Set<OWLClass> getEmptyClass() {
        return emptyClass;
    }

    /**
     * @param emptyClass the emptyClass to set
     */
    public void setEmptyClass(Set<OWLClass> emptyClass) {
        this.emptyClass = emptyClass;
    }

    /**
     * @return the circularityClasses
     */
    public Set<OWLClass> getCircularityClasses() {
        return circularityClasses;
    }

    /**
     * @param circularityClasses the circularityClasses to set
     */
    public void setCircularityClasses(Set<OWLClass> circularityClasses) {
        this.circularityClasses = circularityClasses;
    }

    /**
     * @return the circularity
     */
    public boolean isCircularity() {
        return circularity;
    }

    /**
     * @param circularity the circularity to set
     */
    public void setCircularity(boolean circularity) {
        this.circularity = circularity;
    }

    /**
     * @return the maxDepth
     */
    public int getMaxDepth() {
        return maxDepth;
    }

    /**
     * @param maxDepth the maxDepth to set
     */
    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    /**
     * @return the maxBreadth
     */
    public int getMaxBreadth() {
        return maxBreadth;
    }

    /**
     * @param maxBreadth the maxBreadth to set
     */
    public void setMaxBreadth(int maxBreadth) {
        this.maxBreadth = maxBreadth;
    }

    /**
     * @return the connectedClassesList
     * * calling from Schema Connectivity
     */
    public Set<OWLClass> getConnectedClassesList() {
        return connectedClassesList;
    }

    /**
     * @param connectedClassesList the connectedClassesList to set
     * calling from Schema Connectivity
     */
    public void setConnectedClassesList(Set<OWLClass> connectedClassesList) {
        this.connectedClassesList = connectedClassesList;
    }

    /**
     * @return the disconnectedClassList
     * * calling from Schema Connectivity
     */
    public Set<OWLClass> getDisconnectedClassList() {
        return disconnectedClassList;
    }

    /**
     * @param disconnectedClassList the disconnectedClassList to set
     * * calling from Schema Connectivity
     */
    public void setDisconnectedClassList(Set<OWLClass> disconnectedClassList) {
        this.disconnectedClassList = disconnectedClassList;
    }

}
