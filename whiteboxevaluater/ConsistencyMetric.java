/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.whiteboxevaluater;

import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 *
 * @author HP
 */
public class ConsistencyMetric {
    private OWLOntology onto = null;
    private int FunctionalOPAxiom;
    private int InverseFunctionalOPAxioms;
    private int TransitiveOPAxioms;
    private int SymmetricOPAxioms;
    private int AsymmetricOPAxioms;
    private int ReflexiveOPAxioms;
    private int IreflexiveOPAxioms;
    private int FunctionalDPAxioms;
    
    public ConsistencyMetric(OWLOntology o) {
        this.onto = o;
    }

    /**
     * @return the FunctionalOPAxiom
     */
    public int getFunctionalOPAxiom() {
        return onto.getAxiomCount(AxiomType.FUNCTIONAL_OBJECT_PROPERTY);
    }

    /**
     * @return the InverseFunctionalOPAxioms
     */
    public int getInverseFunctionalOPAxioms() {
         return onto.getAxiomCount(AxiomType.INVERSE_FUNCTIONAL_OBJECT_PROPERTY);
    }

    /**
     * @return the TransitiveOPAxioms
     */
    public int getTransitiveOPAxioms() {
        return onto.getAxiomCount(AxiomType.TRANSITIVE_OBJECT_PROPERTY);
    }

    /**
     * @return the SymmetricOPAxioms
     */
    public int getSymmetricOPAxioms() {
       return onto.getAxiomCount(AxiomType.SYMMETRIC_OBJECT_PROPERTY);
    }

    /**
     * @return the AsymmetricOPAxioms
     */
    public int getAsymmetricOPAxioms() {
        return onto.getAxiomCount(AxiomType.ASYMMETRIC_OBJECT_PROPERTY);
    }

    /**
     * @return the ReflexiveOPAxioms
     */
    public int getReflexiveOPAxioms() {
        return onto.getAxiomCount(AxiomType.REFLEXIVE_OBJECT_PROPERTY);
    }

    /**
     * @return the IreflexiveOPAxioms
     */
    public int getIreflexiveOPAxioms() {
        return onto.getAxiomCount(AxiomType.IRREFLEXIVE_OBJECT_PROPERTY);
    }

    /**
     * @return the FunctionalDPAxioms
     */
    public int getFunctionalDPAxioms() {
        return onto.getAxiomCount(AxiomType.FUNCTIONAL_DATA_PROPERTY);
    }
    
    
}
