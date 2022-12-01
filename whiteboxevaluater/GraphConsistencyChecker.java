/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.whiteboxevaluater;

import java.util.HashSet;
import java.util.Set;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 *
 * @author HP
 */
public class GraphConsistencyChecker {
    OWLOntology o =null;
    OWLReasoner r =null;
    OWLDataFactory df = null;
    Set<OWLClass> visited = new HashSet<>();
    Set<OWLClass> circularClass = new HashSet<>();
    MetricResult m = new MetricResult();
    int depth, maxDepth;
    
    public GraphConsistencyChecker (OWLOntology onto, OWLReasoner reasoner, OWLDataFactory dataFactory) {
        this.o = onto;
        this.r = reasoner;
        this.df = dataFactory;
    }
         /**
     * @return true, Circles is available
     */
     public MetricResult isCircle() {
        NodeSet<OWLClass> subClasses= r.getSubClasses(df.getOWLThing(), true);
        System.out.println(subClasses);
         Set<OWLClass> subclses = subClasses.getFlattened();
         if (!subclses.isEmpty()) {
             for (OWLClass owlClass : subclses) {
                 System.out.println(owlClass + "Root Node");
                    depth = 0;
                    checkCirclesDFS(owlClass,visited);
                    if (maxDepth < depth) {
                    maxDepth = depth;
                    }
             }
     }
          System.out.println("MaximumDepth: "+ maxDepth);
          m.setMaxDepth(maxDepth);
          m.setCircularityClasses(circularClass);
          if (!circularClass.isEmpty()) {
              m.setCircularity(true);
          }
          return m;
     }
     
     
     private void checkCirclesDFS(OWLClass owlCls, Set<OWLClass> visitedList) {
         if (!visitedList.contains (owlCls)) {
         visitedList.add(owlCls);

         Set<OWLSubClassOfAxiom> subClasses = o.getSubClassAxiomsForSuperClass(owlCls);
            // System.out.println("SubClasses: " + subClasses);
            if (!subClasses.isEmpty()) {
                depth++;
            for (OWLSubClassOfAxiom subClassAxiom : subClasses) {
                    OWLClass subClass = (OWLClass) subClassAxiom.getSubClass();
                    checkCirclesDFS(subClass,visitedList);
            }
            } else {
                System.out.println("end node: " + owlCls);
            }
            
        } else {
             System.out.println("Revisited - Circularity Detected: "+ owlCls);
             circularClass.add(owlCls);
         }
     }
     
     /*
     public void isCircularity() {
           
       Set<OWLClass> allClasses = new HashSet<>();
       //Set<OWLClass> superClasses = new HashSet<>();
       
       allClasses = o.getClassesInSignature();
        //Retrived superClasses In the ontology
      for (OWLClass owlClass : allClasses) {
             
             Set<OWLSubClassOfAxiom> subClasses = o.getSubClassAxiomsForSuperClass(owlClass);
             if (!subClasses.isEmpty()) {
             if (!visited.contains(owlClass)) {
                 System.out.println(owlClass + "Root Node");
                    depth = 0;
                    checkCirclesDFS(owlClass,visited);
                    if (maxDepth < depth) {
                        maxDepth = depth;
                    }
             }
             }
        }
         System.out.println("MaximumDepth: "+ maxDepth);
       } */
 
}
