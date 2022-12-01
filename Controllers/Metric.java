/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.Controllers;

import java.util.Set;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 *
 * @author HP
 */
public class Metric{


    private int numberOfInstance;
    private int numberOfClasses;
    private int numberOfObjectProperty;
    private int numberOfDataProperty;
    private int numberOfAnnotation;
    private int numberOfAnnotationAssertion;
    private int numberOfDeclaredAxioms;
    private int logicalAxioms;
    private int numberOfChainProperty;
    private int numberofIsolatedInstance;
    private double instanceUsage;
    private double relationshipRichness;// ONTOQA metric
    private double classRichness;//ONTOQA
   // private Set<OWLObjectProperty> numberOfIsolatedObjectProperty;
    private double objectPropertyUsage;
    private int numberofIsolatedObjectProperty;
    private double datapropertyUsage;
    private int numberOfIsolatedDataProperty;
    private Set<String> ontologyClassList;
    private boolean consistencyState = true;
    private int numberOfIsolatedClass; // empty classess
    private int numberOfEquivalentClassAxiom;
    private int numberOfDisjointClassAxiom;
    private int numberOfSubPropertyAxiom;
    private int numberOfEquivalentOBJPropertyAxiom;
    private int numberOfDisjointOBJPropertyAxiom;
    private int numberOfSubClassAxiom;
    
    //Consistency functional property
    private int numberOfFunctionalOPAxiom;
    private int numberOfInverseFunctionalOPAxioms;
    private int numberOfTransitiveOPAxioms;
    private int numberOfSymmetricOPAxioms;
    private int numberOfAsymmetricOPAxioms;
    private int numberOfReflexiveOPAxioms;
    private int numberOfIreflexiveOPAxioms;
    private int numberOfFunctionalDPAxioms;
    
//Graph Metrics: Circularity, Depth, Breadth
     private boolean circles;
     private int maxDepth;
     private int maxBreadth;
     
//Schema Connectivity
     private int NumberOfconnectedClassWithRoot;
     private int NumberOfdisconnectedClassWithRootSize;
    
    
    /**
     * @return the numberOfInstance
     */
    public int getNumberOfInstance() {
        return numberOfInstance;
    }

    /**
     * @param numberOfInstance the numberOfInstance to set
     */
    public void setNumberOfInstance(int numberOfInstance) {
        this.numberOfInstance = numberOfInstance;
    }

    /**
     * @return the numberOfClasses
     */
    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    /**
     * @param numberOfClasses the numberOfClasses to set
     */
    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    /**
     * @return the numberOfObjectProperty
     */
    public int getNumberOfObjectProperty() {
        return numberOfObjectProperty;
    }

    /**
     * @param numberOfObjectProperty the numberOfObjectProperty to set
     */
    public void setNumberOfObjectProperty(int numberOfObjectProperty) {
        this.numberOfObjectProperty = numberOfObjectProperty;
    }

    /**
     * @return the numberOfDataProperty
     */
    public int getNumberOfDataProperty() {
        return numberOfDataProperty;
    }

    /**
     * @param numberOfDataProperty the numberOfDataProperty to set
     */
    public void setNumberOfDataProperty(int numberOfDataProperty) {
        this.numberOfDataProperty = numberOfDataProperty;
    }

    /**
     * @return the numberOfAnnotation
     */
    public int getNumberOfAnnotation() {
        return numberOfAnnotation;
    }

    /**
     * @param numberOfAnnotation the numberOfAnnotation to set
     */
    public void setNumberOfAnnotation(int numberOfAnnotation) {
        this.numberOfAnnotation = numberOfAnnotation;
    }
   /**
     * @return the numberOfAnnotationAssertion
     */
    public int getNumberOfAnnotationAssertion() {
        return numberOfAnnotationAssertion;
    }

    /**
     * @param numberOfAnnotationAssertion the numberOfAnnotationAssertion to set
     */
    public void setNumberOfAnnotationAssertion(int numberOfAnnotationAssertion) {
        this.numberOfAnnotationAssertion = numberOfAnnotationAssertion;
    }
    /**
     * @return the logicalAxioms
     */
    public int getLogicalAxioms() {
        return logicalAxioms;
    }

    /**
     * @param logicalAxioms the logicalAxioms to set
     */
    public void setLogicalAxioms(int logicalAxioms) {
        this.logicalAxioms = logicalAxioms;
    }

    /**
     * @return the numberOfDeclaredAxioms
     */
    public int getNumberOfDeclaredAxioms() {
        return numberOfDeclaredAxioms;
    }

    /**
     * @param numberOfDeclaredAxioms the numberOfDeclaredAxioms to set
     */
    public void setNumberOfDeclaredAxioms(int numberOfDeclaredAxioms) {
        this.numberOfDeclaredAxioms = numberOfDeclaredAxioms;
    }

        /**
     * @return the numberOfSubClassAxiom
     */
    public int getNumberOfSubClassAxiom() {
        return numberOfSubClassAxiom;
    }

    /**
     * @param numberOfSubClassAxiom the numberOfSubClassAxiom to set
     */
    public void setNumberOfSubClassAxiom(int numberOfSubClassAxiom) {
        this.numberOfSubClassAxiom = numberOfSubClassAxiom;
    }
    /**
     * @return the instanceUsage
     */
    public double getInstanceUsage() {
        return instanceUsage;
    }

    /**
     * @param instanceRichness the instanceUsage to set
     */
    public void setInstanceUsage(double instanceUsage) {
        this.instanceUsage = instanceUsage;
    }
    /**
     * @return the numberofIsolatedInstance
     */
    public int getNumberofIsolatedInstance() {
        return numberofIsolatedInstance;
    }

    /**
     * @param numberofIsolatedInstance the numberofIsolatedInstance to set
     */
    public void setNumberofIsolatedInstance(int numberofIsolatedInstance) {
        this.numberofIsolatedInstance = numberofIsolatedInstance;
    }
    
        /**
     * @return the relationshipRichness
     */
    public double getRelationshipRichness() {
        return relationshipRichness;
    }

    /**
     * @param relationshipRichness the relationshipRichness to set
     */
    public void setRelationshipRichness(double relationshipRichness) {
        this.relationshipRichness = relationshipRichness;
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
     * @return the numberofIsolatedObjectProperty
     */
    public int getNumberofIsolatedObjectProperty() {
        return numberofIsolatedObjectProperty;
    }

    /**
     * @param numberofIsolatedObjectProperty the numberofIsolatedObjectProperty to set
     */
    public void setNumberofIsolatedObjectProperty(int numberofIsolatedObjectProperty) {
        this.numberofIsolatedObjectProperty = numberofIsolatedObjectProperty;
    }

    /**
     * @return the datapropertyUsage
     */
    public double getDatapropertyUsage() {
        return datapropertyUsage;
    }

    /**
     * @param datapropertyUsage the datapropertyUsage to set
     */
    public void setDatapropertyUsage(double datapropertyUsage) {
        this.datapropertyUsage = datapropertyUsage;
    }

    /**
     * @return the numberOfIsolatedDataProperty
     */
    public int getNumberOfIsolatedDataProperty() {
        return numberOfIsolatedDataProperty;
    }

    /**
     * @param numberOfIsolatedDataProperty the numberOfIsolatedDataProperty to set
     */
    public void setNumberOfIsolatedDataProperty(int numberOfIsolatedDataProperty) {
        this.numberOfIsolatedDataProperty = numberOfIsolatedDataProperty;
    }

    /**
     * @return the numberOfChainProperty
     */
    public int getNumberOfChainProperty() {
        return numberOfChainProperty;
    }

    /**
     * @param numberOfChainProperty the numberOfChainProperty to set
     */
    public void setNumberOfChainProperty(int numberOfChainProperty) {
        this.numberOfChainProperty = numberOfChainProperty;
    }

    /**
     * @return the ontologyClassList
     */
    public Set<String> getOntologyClassList() {
        return ontologyClassList;
    }

    /**
     * @param ontologyClassList the ontologyClassList to set
     */
    public void setOntologyClassList(Set<String> ontologyClassList) {
        this.ontologyClassList = ontologyClassList;
    }

    /**
     * @param consistencyState the consistencyState to set
     */
    public void setConsistencyState(boolean consistencyState) {
        this.consistencyState = consistencyState;
    }

    /**
     * @return the consistencyState
     */
    public boolean isConsistencyState() {
        return consistencyState;
    }

    /**
     * @return the numberOfIsolatedClass
     */
    public int getNumberOfIsolatedClass() {
        return numberOfIsolatedClass;
    }

    /**
     * @param numberOfIsolatedClass the numberOfIsolatedClass to set
     */
    public void setNumberOfIsolatedClass(int numberOfIsolatedClass) {
        this.numberOfIsolatedClass = numberOfIsolatedClass;
    }

    /**
     * @return the numberOfEquivalentClassAxiom
     */
    public int getNumberOfEquivalentClassAxiom() {
        return numberOfEquivalentClassAxiom;
    }

    /**
     * @param numberOfEquivalentClassAxiom the numberOfEquivalentClassAxiom to set
     */
    public void setNumberOfEquivalentClassAxiom(int numberOfEquivalentClassAxiom) {
        this.numberOfEquivalentClassAxiom = numberOfEquivalentClassAxiom;
    }

    /**
     * @return the numberOfDisjointClassAxiom
     */
    public int getNumberOfDisjointClassAxiom() {
        return numberOfDisjointClassAxiom;
    }

    /**
     * @param numberOfDisjointClassAxiom the numberOfDisjointClassAxiom to set
     */
    public void setNumberOfDisjointClassAxiom(int numberOfDisjointClassAxiom) {
        this.numberOfDisjointClassAxiom = numberOfDisjointClassAxiom;
    }

    /**
     * @return the numberOfSubPropertyAxiom
     */
    public int getNumberOfSubPropertyAxiom() {
        return numberOfSubPropertyAxiom;
    }

    /**
     * @param numberOfSubPropertyAxiom the numberOfSubPropertyAxiom to set
     */
    public void setNumberOfSubPropertyAxiom(int numberOfSubPropertyAxiom) {
        this.numberOfSubPropertyAxiom = numberOfSubPropertyAxiom;
    }

    /**
     * @return the numberOfEquivalentOBJPropertyAxiom
     */
    public int getNumberOfEquivalentOBJPropertyAxiom() {
        return numberOfEquivalentOBJPropertyAxiom;
    }

    /**
     * @param numberOfEquivalentOBJPropertyAxiom the numberOfEquivalentOBJPropertyAxiom to set
     */
    public void setNumberOfEquivalentOBJPropertyAxiom(int numberOfEquivalentOBJPropertyAxiom) {
        this.numberOfEquivalentOBJPropertyAxiom = numberOfEquivalentOBJPropertyAxiom;
    }

    /**
     * @return the numberOfDisjointOBJPropertyAxiom
     */
    public int getNumberOfDisjointOBJPropertyAxiom() {
        return numberOfDisjointOBJPropertyAxiom;
    }

    /**
     * @param numberOfDisjointOBJPropertyAxiom the numberOfDisjointOBJPropertyAxiom to set
     */
    public void setNumberOfDisjointOBJPropertyAxiom(int numberOfDisjointOBJPropertyAxiom) {
        this.numberOfDisjointOBJPropertyAxiom = numberOfDisjointOBJPropertyAxiom;
    }

    /**
     * @return the numberOfFunctionalOPAxiom
     */
    public int getNumberOfFunctionalOPAxiom() {
        return numberOfFunctionalOPAxiom;
    }

    /**
     * @param numberOfFunctionalOPAxiom the numberOfFunctionalOPAxiom to set
     */
    public void setNumberOfFunctionalOPAxiom(int numberOfFunctionalOPAxiom) {
        this.numberOfFunctionalOPAxiom = numberOfFunctionalOPAxiom;
    }

    /**
     * @return the numberOfInverseFunctionalOPAxioms
     */
    public int getNumberOfInverseFunctionalOPAxioms() {
        return numberOfInverseFunctionalOPAxioms;
    }

    /**
     * @param numberOfInverseFunctionalOPAxioms the numberOfInverseFunctionalOPAxioms to set
     */
    public void setNumberOfInverseFunctionalOPAxioms(int numberOfInverseFunctionalOPAxioms) {
        this.numberOfInverseFunctionalOPAxioms = numberOfInverseFunctionalOPAxioms;
    }

    /**
     * @return the numberOfTransitiveOPAxioms
     */
    public int getNumberOfTransitiveOPAxioms() {
        return numberOfTransitiveOPAxioms;
    }

    /**
     * @param numberOfTransitiveOPAxioms the numberOfTransitiveOPAxioms to set
     */
    public void setNumberOfTransitiveOPAxioms(int numberOfTransitiveOPAxioms) {
        this.numberOfTransitiveOPAxioms = numberOfTransitiveOPAxioms;
    }

    /**
     * @return the numberOfSymmetricOPAxioms
     */
    public int getNumberOfSymmetricOPAxioms() {
        return numberOfSymmetricOPAxioms;
    }

    /**
     * @param numberOfSymmetricOPAxioms the numberOfSymmetricOPAxioms to set
     */
    public void setNumberOfSymmetricOPAxioms(int numberOfSymmetricOPAxioms) {
        this.numberOfSymmetricOPAxioms = numberOfSymmetricOPAxioms;
    }

    /**
     * @return the numberOfAsymmetricOPAxioms
     */
    public int getNumberOfAsymmetricOPAxioms() {
        return numberOfAsymmetricOPAxioms;
    }

    /**
     * @param numberOfAsymmetricOPAxioms the numberOfAsymmetricOPAxioms to set
     */
    public void setNumberOfAsymmetricOPAxioms(int numberOfAsymmetricOPAxioms) {
        this.numberOfAsymmetricOPAxioms = numberOfAsymmetricOPAxioms;
    }

    /**
     * @return the numberOfReflexiveOPAxioms
     */
    public int getNumberOfReflexiveOPAxioms() {
        return numberOfReflexiveOPAxioms;
    }

    /**
     * @param numberOfReflexiveOPAxioms the numberOfReflexiveOPAxioms to set
     */
    public void setNumberOfReflexiveOPAxioms(int numberOfReflexiveOPAxioms) {
        this.numberOfReflexiveOPAxioms = numberOfReflexiveOPAxioms;
    }

    /**
     * @return the numberOfIreflexiveOPAxioms
     */
    public int getNumberOfIreflexiveOPAxioms() {
        return numberOfIreflexiveOPAxioms;
    }

    /**
     * @param numberOfIreflexiveOPAxioms the numberOfIreflexiveOPAxioms to set
     */
    public void setNumberOfIreflexiveOPAxioms(int numberOfIreflexiveOPAxioms) {
        this.numberOfIreflexiveOPAxioms = numberOfIreflexiveOPAxioms;
    }

    /**
     * @return the numberOfFunctionalDPAxioms
     */
    public int getNumberOfFunctionalDPAxioms() {
        return numberOfFunctionalDPAxioms;
    }

    /**
     * @param numberOfFunctionalDPAxioms the numberOfFunctionalDPAxioms to set
     */
    public void setNumberOfFunctionalDPAxioms(int numberOfFunctionalDPAxioms) {
        this.numberOfFunctionalDPAxioms = numberOfFunctionalDPAxioms;
    }

    /**
     * @return the circles
     */
    public boolean isCircles() {
        return circles;
    }

    /**
     * @param circles the circles to set
     */
    public void setCircles(boolean circles) {
        this.circles = circles;
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
     * @return the NumberOfconnectedClassWithRoot
     */
    public int getNumberOfconnectedClassWithRoot() {
        return NumberOfconnectedClassWithRoot;
    }

    /**
     * @param NumberOfconnectedClassWithRoot the NumberOfconnectedClassWithRoot to set
     */
    public void setNumberOfconnectedClassWithRoot(int NumberOfconnectedClassWithRoot) {
        this.NumberOfconnectedClassWithRoot = NumberOfconnectedClassWithRoot;
    }

    /**
     * @return the NumberOfdisconnectedClassWithRootSize
     */
    public int getNumberOfdisconnectedClassWithRootSize() {
        return NumberOfdisconnectedClassWithRootSize;
    }

    /**
     * @param NumberOfdisconnectedClassWithRootSize the NumberOfdisconnectedClassWithRootSize to set
     */
    public void setNumberOfdisconnectedClassWithRootSize(int NumberOfdisconnectedClassWithRootSize) {
        this.NumberOfdisconnectedClassWithRootSize = NumberOfdisconnectedClassWithRootSize;
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

}
