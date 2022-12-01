/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.Controllers;

import java.util.HashSet;
import java.util.Set;
import org.semanticweb.owlapi.model.OWLClass;

/**
 *
 * @author HP
 */
public class OWLEntityManipulator {

    public Set<String> getOWLClassSignature(Set<OWLClass> owlclassList) {
        Set<String> owlClassSignatures = new HashSet<>();
        for (OWLClass owlClass: owlclassList) {
            owlClassSignatures.add(owlClass.getIRI().getFragment());
        }
        return owlClassSignatures;
    }
}
