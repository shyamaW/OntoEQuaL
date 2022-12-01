/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.whiteboxevaluater;

import java.util.Set;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 *
 * @author HP
 */
public class GeneralMetric {

    private OWLOntology onto = null;
    public GeneralMetric(OWLOntology o) {
        this.onto = o;
    }

    /**
     * @return the numberOfInstance
     */
    public int getNumberOfInstance() {
        return this.onto.getIndividualsInSignature().size();
    }

    /**
     * @return the numberOfClasses
     */
    public  Set<OWLClass> getClassesList() {
        
        return this.onto.getClassesInSignature();
    }
    
    /**
     * @return the numberOfObjectProperty
     */
    public int getNumberOfObjectProperty() {
        return this.onto.getObjectPropertiesInSignature().size();
    }

    /**
     * @return the numberOfDataProperty
     */
    public int getNumberOfDataProperty() {
        return this.onto.getDataPropertiesInSignature().size();
    }

    /**
     * @return the logicalAxioms
     */
    public int getLogicalAxiomsCount() {
        return this.onto.getLogicalAxiomCount();
    }

    /**
     * @return the onto
     */
    public int getDeclaredAxioms() {
        return this.onto.getAxioms(AxiomType.DECLARATION).size();
    }
       
    //get only explicit class Assertions
    public int getNumberOfIndividualWithClassAsserssion() { 
        return this.onto.getAxioms(AxiomType.CLASS_ASSERTION).size();
    }
    
    public int getNumberOfChianProperties () {
          return onto.getAxioms(AxiomType.SUB_PROPERTY_CHAIN_OF).size();
    }
    
    public int getNumberOfSubClasses () {
          return onto.getAxioms(AxiomType.SUBCLASS_OF).size();
    }
    
    // Consistency Metrics
    public int getNumberOfEquivalentClassesAxiom () {
        return onto.getAxiomCount(AxiomType.EQUIVALENT_CLASSES);
    }
    
    public int getNumberOfDijointClassesAxiom() {
        return onto.getAxiomCount(AxiomType.DISJOINT_CLASSES);
    }
    
    public int getNumberOfDisjointOBJPropertyAxioms() {
        return onto.getAxiomCount(AxiomType.DISJOINT_OBJECT_PROPERTIES);
    }
    
    public int getNumberOfEquivalentOBJPropertyAxioms() {
        return onto.getAxiomCount(AxiomType.EQUIVALENT_OBJECT_PROPERTIES);
    }
    
    public int getNumberOfSubClassOfOBJPropertyAxioms() {
        return onto.getAxiomCount(AxiomType.SUB_OBJECT_PROPERTY);
    }
    
    //Comprehensability Basic Metrics
    
      /**
     * @return the numberOfAnnotation
     */
    public int getNumberOfAnnotation() {
        return onto.getAnnotationPropertiesInSignature().size();
    }
    
    public int getNumberOfAnnotationPropertyAxiom() {
        return onto.getAxiomCount(AxiomType.ANNOTATION_ASSERTION);
    }
}
