/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.whiteboxevaluater;

import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 *
 * @author HP
 */
public class ConsistencyChecker {
    private OWLOntology o = null;
    private OWLReasoner r = null;
    
    public ConsistencyChecker( OWLOntology onto,OWLReasoner reasoner ) {
        this.o = onto;
        this.r = reasoner;
     }
    public boolean isOntologyConsistent() {
        // check ontology is consistent with reasoners - HermiT
        return r.isConsistent();
    }
}
