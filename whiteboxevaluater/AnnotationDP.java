/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.whiteboxevaluater;

import org.semanticweb.owlapi.model.OWLOntology;

/**
 *
 * @author HP
 */
public class AnnotationDP {
    private OWLOntology onto = null;
    public AnnotationDP(OWLOntology o) {
        this.onto = o;
    }
    
    public int getNumberOfAnnotation() {
        this.onto.getAnnotations().size();
        return this.onto.getAnnotationPropertiesInSignature().size();
    }
}
