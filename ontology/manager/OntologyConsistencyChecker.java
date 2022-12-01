/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.ontology.manager;

import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 *
 * @author HP
 */
public class OntologyConsistencyChecker {
         public void isConsistancyOnto (OWLReasoner r) {
         System.out.println("check consistency"+ r.isConsistent());
    } 
}
