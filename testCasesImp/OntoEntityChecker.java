/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.testCasesImp;

import com.ontoQual.ontology.manager.OntologyManager;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

/**
 *
 * @author HP
 */
public class OntoEntityChecker {
    IRI IOR = IRI.create("http://www.sln4mop.org/ontologies/2021/GoviOntologyV1");
     OWLOntology o1 = OntologyManager.getInstance().loadOntology();
   public void getEntity(String entityName) throws OWLOntologyCreationException {
        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
        OWLOntology o= man.createOntology(IOR);
        OWLDataFactory df = o.getOWLOntologyManager().getOWLDataFactory();
     
       OWLObjectProperty hasValue = df.getOWLObjectProperty(IOR + "#hasValue");
       OWLDeclarationAxiom d_hasValue = df.getOWLDeclarationAxiom(hasValue);
       OWLEntity e = d_hasValue.getEntity();
       System.out.println("test "+e.getEntityType());
   }
    
   public void testFIltering () {
       //OWLEntity e;
     //  o1.signature().filter();
     // get all entities Starting from P
       o1.signature().filter((e ->(!e.isBuiltIn()&& e.getIRI().getFragment().startsWith("P")))).forEach(System.out::println);
   }
}
