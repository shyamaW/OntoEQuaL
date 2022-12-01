/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.whiteboxevaluater;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import com.ontoQual.ontology.manager.OntologyManager;

/**
 *
 * @author HP
 */
public class dataConnectivity {
    OWLOntology o = OntologyManager.getInstance().loadOntology();
    Map<OWLClass, Set<OWLObjectProperty>> clsObjMap = new HashMap<OWLClass, Set<OWLObjectProperty>>();
   Map<OWLObjectProperty, Set<OWLClassExpression>> ObjRangeMap = new HashMap<OWLObjectProperty, Set<OWLClassExpression>>();
    
   public Map<OWLClass, Set<OWLObjectProperty>> getRelationsofClasses () {
        
        Set<OWLClass> allClasses = o.getClassesInSignature();
        Set<OWLObjectProperty> objectProptyAll = o.getObjectPropertiesInSignature();
        
        
        for (OWLClass cls: allClasses) {
            Set<OWLObjectProperty> objPropertyList = new HashSet<OWLObjectProperty> ();
            for (OWLObjectProperty obj : objectProptyAll) {
           for (OWLObjectPropertyDomainAxiom ax : o.getObjectPropertyDomainAxioms(obj)) {
               if (cls.equals(ax.getDomain())) {
                   objPropertyList.add(obj);
               }
           }
           Set<OWLClassExpression> range = new HashSet<>();
           for (OWLObjectPropertyRangeAxiom ax : o.getObjectPropertyRangeAxioms(obj)) {
              range.add(ax.getRange());
           }
           ObjRangeMap.put(obj,range);
           
        }
            clsObjMap.put(cls,objPropertyList);
        }
        
        for (Map.Entry<OWLClass, Set<OWLObjectProperty>> entry : clsObjMap.entrySet()) { 
             System.out.println(entry.getKey() + ":---------" + entry.getValue());
        }
         System.out.println("Ranges-----------------------------------");
        for (Map.Entry<OWLObjectProperty, Set<OWLClassExpression>> entryR : ObjRangeMap.entrySet()) { 
             System.out.println(entryR.getKey() + ":---------" + entryR.getValue());
        }
        return clsObjMap;
    }
//    // create visited list and call to the graph search method
//    public void connectionSearchDFS (OWLClass c) {
//        getRelationsofClasses ();
//        Set<OWLClass> visited = new HashSet<>();
//        checkConnectivity(c, visited);
//        
//        System.out.println("see more disconnected classes......................................");
//         for (Map.Entry<OWLClass, Set<OWLObjectProperty>> entry : clsObjMap.entrySet()) {
//            
//             if (!visited.contains(entry.getKey())){
//                 checkConnectivity(entry.getKey(), visited);
//             }
//        }
//      
//    }
//    
//    public void checkConnectivity (OWLClass c, Set<OWLClass> visited) {
//        System.out.println("------------------------------------------------");
//        visited.add(c);
//        clsObjMap.get(c);
//        System.out.println("-->:--> " + c);
//        for (OWLObjectProperty obj: clsObjMap.get(c)) {
//            
//           for (OWLObjectPropertyRangeAxiom ax : o.getObjectPropertyRangeAxioms(obj)) {
//               System.out.println("axioms: ----------------"+ ax);
//               System.out.println("visitedList"+visited+ "range: " +ax.getRange().toString());
//               if (!ax.getRange().toString().startsWith("ObjectUnionOf")) {
//               if(!visited.contains(ax.getRange())) {
//                    System.out.println(" with Object property: "+ obj);
//                    checkConnectivity((OWLClass) ax.getRange(), visited);
//               }
//               }
//           }
//        }
//    }
    
}
