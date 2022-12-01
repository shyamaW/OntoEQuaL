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
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
/**
 *
 * @author HP
 */
public class SchemaConnectivity {
    OWLOntology o = null;
    Map<OWLClass, Set<OWLObjectProperty>> clsObjMap = new HashMap<>();
    OWLDataFactory df = null;
     MetricResult m = new MetricResult();
    private String IOR;

    public SchemaConnectivity(OWLOntology onto) {
        this.o = onto;
        this.df = o.getOWLOntologyManager().getOWLDataFactory();
        this.IOR = o.getOntologyID().getOntologyIRI().get()+"#";
    }
   
    
     private Map<OWLClass, Set<OWLObjectProperty>> getRelationsofClasses () {
        
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
        }
            clsObjMap.put(cls,objPropertyList);
        }
        
        for (Map.Entry<OWLClass, Set<OWLObjectProperty>> entry : clsObjMap.entrySet()) {
            
             System.out.println(entry.getKey() + ":---------" + entry.getValue());
        }
        
        return clsObjMap;
    }
    // create visited list and call to the graph search method
    public MetricResult connectionSearchDFS (String root) {
        OWLClass c = df.getOWLClass(IOR+root);
        getRelationsofClasses ();
        Set<OWLClass> visited = new HashSet<>();
        Set<OWLClass> diconnectedClassWithRoot = new HashSet<>();
        checkConnectivity(c, visited);
        System.out.println("-------------------------------All connected classes--------------------------");
        for (OWLClass vid: visited) {
            System.out.println(vid);
        }
        m.setConnectedClassesList(visited);
        
        System.out.println("see more disconnected classes......................................");
         for (Map.Entry<OWLClass, Set<OWLObjectProperty>> entry : clsObjMap.entrySet()) {
             if (!visited.contains(entry.getKey())){
                if(!isSubClassesOfvisisted(visited,entry.getKey())){
                    if (!isEquivalentClass(visited,entry.getKey())) {
                    checkConnectivity(entry.getKey(), visited);
                    System.out.println("Disconnented Classess: ....................." + entry.getKey());
                    diconnectedClassWithRoot.add(entry.getKey());
                }
                }
             }
          }
         m.setDisconnectedClassList(diconnectedClassWithRoot);
      return m;
    }
    
    private boolean isSubClassesOfvisisted(Set<OWLClass> visited, OWLClass subClass) {
        boolean value = false;
        Set<OWLClass> visitedSubClasses = new HashSet<>();
        
        if (!visitedSubClasses.contains(subClass)) {
            visitedSubClasses.add(subClass);
        Set<OWLSubClassOfAxiom> supClassList = o.getSubClassAxiomsForSubClass(subClass);
       // System.out.println("check SuperClass "+ subClass);
        for (OWLSubClassOfAxiom superClass : supClassList) {
           // System.out.println(superClass.getSuperClass());
            if (visited.contains(superClass.getSuperClass())) {
                visited.add(subClass);
                value = true;
            } else if (isSubClassesOfvisisted(visited, (OWLClass) superClass.getSuperClass())) {
                value = true;
                visited.add(subClass);
            } else {
                value = false;
            }
        }
        }
        return value;
    }
    // consider only explicit axioms
    public boolean isEquivalentClass(Set<OWLClass> visited, OWLClass equivalentClass) {
        
        Set<OWLClass> visitEquival = new HashSet<>();
        boolean value = false;
         
        System.out.println("checking equivalency class: " + equivalentClass);
        Set<OWLEquivalentClassesAxiom> equivalentList = o.getEquivalentClassesAxioms(equivalentClass);
        for(OWLEquivalentClassesAxiom equiClass :equivalentList ) {
            
            visitEquival = equiClass.getClassesInSignature();
            for (OWLClass c : visitEquival) {
            if (!c.equals(equivalentClass)) {
                if (!visited.contains(c)) {
                    value =  false;
                } else {
                    value =  true;
                    break;
                }
            } 
            }
        }
        return value;
    }
    
    private void checkConnectivity (OWLClass c, Set<OWLClass> visited) {
        System.out.println("--------------------searching connected class with root----------------------------");
        visited.add(c);
        //clsObjMap.get(c);
        System.out.println("-->:--> " + c);
        for (OWLObjectProperty obj: clsObjMap.get(c)) {
            
           for (OWLObjectPropertyRangeAxiom ax : o.getObjectPropertyRangeAxioms(obj)) {
              // System.out.println("axioms: ----------------"+ ax);
              // System.out.println("visitedList"+visited+ "range: " +ax.getRange().toString());
               if (!ax.getRange().toString().startsWith("ObjectUnionOf")) {
               if(!visited.contains(ax.getRange())) {
                   // System.out.println(" with Object property: "+ obj);
                    checkConnectivity((OWLClass) ax.getRange(), visited);
               }
               }
           }
        }
    }
    
        
    
}
