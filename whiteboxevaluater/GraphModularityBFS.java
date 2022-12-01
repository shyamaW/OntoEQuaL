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
public class GraphModularityBFS {
    OWLOntology o =null;
    OWLReasoner r =null;
    OWLDataFactory df = null;
    Set<OWLClass> visited = new HashSet<>();
    Set<OWLClass> subBranchNodes = new HashSet<>();
    Set<OWLClass> temSubBranchNodes = new HashSet<>();
    Set<OWLClass> circularClass = new HashSet<>();
    MetricResult m = new MetricResult();
    int breadth,maxBreadth = 0;
    
    public GraphModularityBFS (OWLOntology onto, OWLReasoner reasoner, OWLDataFactory dataFactory) {
        this.o = onto;
        this.r = reasoner;
        this.df = dataFactory;
    }
         /**
     * @return true, Circles is available
     */
     public MetricResult graphBreadth() {
        NodeSet<OWLClass> subClasses= r.getSubClasses(df.getOWLThing(), true);
        System.out.println(subClasses);
         Set<OWLClass> subclses = subClasses.getFlattened();
         temSubBranchNodes = subclses;
         if (!temSubBranchNodes.isEmpty()) {
             
             do {  
             for (OWLClass owlClass : temSubBranchNodes) {
                 System.out.println(owlClass + "Root Node");
                    checkCirclesBFS(owlClass,visited);
             } 
             temSubBranchNodes = null;
             temSubBranchNodes = subBranchNodes;
             subBranchNodes = null;
             } while (temSubBranchNodes != null);        
     }
          return m;
     }
     
     private void checkCirclesBFS(OWLClass owlCls, Set<OWLClass> visitedList) {
         if (!visitedList.contains (owlCls)) {
             breadth = 0;
         visitedList.add(owlCls);
         
         Set<OWLSubClassOfAxiom> subClasses = o.getSubClassAxiomsForSuperClass(owlCls);
            // System.out.println("SubClasses: " + subClasses);
            if (!subClasses.isEmpty()) {
                
            for (OWLSubClassOfAxiom subClassAxiom : subClasses) {
                breadth++;
                    OWLClass subClass = (OWLClass) subClassAxiom.getSubClass();
                    System.out.println("..."+subBranchNodes);
                    System.out.println("CHECK" + subClass);
                    
                    subBranchNodes.add (subClass);
                    //checkCirclesBFS(subClass,visitedList);
            }
            if (maxBreadth < breadth) {
                maxBreadth = breadth;
            }
            } else {
                System.out.println("end node: " + owlCls);
            }
        } else {
             System.out.println("Revisited - Circularity Detected: "+ owlCls);
         }
         
        m.setMaxBreadth(maxBreadth);
     }
 
 
}
