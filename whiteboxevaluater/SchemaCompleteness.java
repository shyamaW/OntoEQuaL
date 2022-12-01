/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.whiteboxevaluater;

import java.util.HashSet;
import java.util.Set;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

/**
 *
 * @author HP
 */
public class SchemaCompleteness {
   
    private OWLOntology o = null;
     private OWLReasoner r = null;
     private String IOR;
     OWLDataFactory df = null;
     MetricResult m = new MetricResult();

    public SchemaCompleteness( OWLOntology onto,OWLReasoner reasoner ) {
        this.o = onto;
        this.r = reasoner;
        this.IOR = o.getOntologyID().getOntologyIRI().get()+"#";;
        this.df = o.getOWLOntologyManager().getOWLDataFactory();
    }
    //1-OntoQA measures Implementation - set UI Relationship Richness
    public double relationshipRichness () {
        double RR = 0.0;
        int P = o.getObjectPropertiesInSignature().size();// Number of non-inheritance relationships
        int H = o.getAxioms(AxiomType.SUBCLASS_OF).size();// Number of inheritance relationships
        
        if ((P+H) != 0) {
            System.out.println("P = "+P+" H = "+H);
            RR = 100.0 *(double) P/ (P+H);
            return RR;
        } else {
            System.out.println("P+H is Zero!!");
            return RR;
        } 
    }
    
    //2-AgriOntoMetric- isolated obj Properties....... UI object property usage
    public MetricResult relationshipRichnessObj () {
        double RRo = 0.00;
        Set<OWLObjectProperty> isolatedObjPop = new HashSet<>();
     
        int objwithDR = 0, P_domain, P_range,P_declared,P_chain;
            Set<OWLObjectProperty> objDeclared = o.getObjectPropertiesInSignature();
            for (OWLObjectProperty obj : objDeclared) {
               P_domain = o.getObjectPropertyDomainAxioms(obj).size();
               P_range = o.getObjectPropertyRangeAxioms(obj).size();

               if (P_domain >0 && P_range >0) {
                   objwithDR++;
               } else if ( InferedDomainANDRange(obj)){
                   objwithDR++;
               } else if (isSuperProperty(obj)) {
                   objwithDR++;
               } else {
                   isolatedObjPop.add(obj);
               }
            }
            
            int beforeListSize = isolatedObjPop.size();
            // remove chain properties from the isolated list
            isolatedObjPop = RemoveChainPropertyFromIsoaltedList (isolatedObjPop);
            int afterListSize = isolatedObjPop.size();
            // set Metric values with Isolated OP list and the count
            m.setListOfIsolatedObjectProperty(isolatedObjPop);
            m.setNumberOfIsolatedObjectProperty(afterListSize);
            System.out.println(isolatedObjPop);

            P_declared= o.getObjectPropertiesInSignature().size();// Number of object Property declared
            P_chain = (beforeListSize - afterListSize);
            objwithDR = objwithDR + P_chain;
            System.out.println("Total Number of Missing Domain AND/OR Range : " + afterListSize);
        if (P_declared != 0) {
            System.out.println("P = "+objwithDR+" H = "+P_declared);
            RRo = 100.0 *(double) objwithDR / P_declared;
            System.out.println(RRo);
        } else {
            System.out.println("NO any object property has been declared!!");
        }
        // set OP usage metric
        m.setObjectPropertyUsage(RRo);
        
     return m;
    }
    
    private Set<OWLObjectProperty> RemoveChainPropertyFromIsoaltedList (Set<OWLObjectProperty> OP_LIST) {
            Set<OWLObjectPropertyExpression> chainpropList = new HashSet<>();
            Set<OWLObjectProperty> IsoaltedList = new HashSet<>();
            o.getAxioms(AxiomType.SUB_PROPERTY_CHAIN_OF).forEach(s -> chainpropList.add(s.getSuperProperty()));
            //System.out.println("chain Size: "+chainpropList);
            for (OWLObjectProperty op: OP_LIST) {
                    if (!chainpropList.contains(op)) {
                            IsoaltedList.add(op);
                    } 
                }
            return IsoaltedList;
    }
    private boolean InferedDomainANDRange(OWLObjectProperty OP) {
        boolean value = false;
            int domain = r.getObjectPropertyDomains(OP).getFlattened().size();
            int range = r.getObjectPropertyRanges(OP).getFlattened().size();
            if (domain >1 && range >1) {
                value = true;
            }
        return value;
    }
    
    private boolean isSuperProperty (OWLObjectProperty OP) {
        boolean value = false;
        if (o.getObjectSubPropertyAxiomsForSuperProperty(OP).size() >0) {
            value = true;
        }
        return value;
    }
    
    //3-AgriOntoMetric- isolated Attributed Data Properties - UI Isolated DP
    public Set<OWLDataProperty> attributeUsedRichness () {
        double RR_DP_D = 0.00;
        Set<OWLDataProperty> isolatedDataPop = new HashSet<>();
               // Set<OWLDataProperty> isolatedDataPopDR = new HashSet<OWLDataProperty>();  
        int DataPoPwithD = 0, DP_domainAll,DP_declared;
        
            Set<OWLDataProperty> DPDeclared = o.getDataPropertiesInSignature();
            for (OWLDataProperty Dobj : DPDeclared) {
               // System.out.println(obj);
               DP_domainAll = r.getDataPropertyDomains(Dobj).getFlattened().size();
            
                System.out.println("Name: -------"+Dobj);
                System.out.println("DP Damains: "+ r.getDataPropertyDomains(Dobj).getFlattened());
                System.out.println("Onto equ: "+ r.getEquivalentDataProperties(Dobj));
                System.out.println(o.getDataPropertyRangeAxioms(Dobj));
            
               //o.getDataPropertyDomainAxioms(obj);
               
               if (DP_domainAll >1) {
                   DataPoPwithD++;
               } else {
                   isolatedDataPop.add(Dobj);
                   System.out.println(Dobj+"---------------------------------------------------");
               }
            }
           // m.setNumberOfIsolatedDataProperty(isolatedDataPop);
            // calculating Richness of Data Property considering All Domains only
//            DP_declared= o.getDataPropertiesInSignature().size();// Number of Data Property declared
//            
//            if (DP_declared !=0) {
//                System.out.println("Data Property With Domains = "+DataPoPwithD+" Declared DP Domain = "+DP_declared );
//                RR_DP_D = 100.0 *(double) DataPoPwithD / DP_declared;
//                 return RR_DP_D;
//            } else {
//            System.out.println("NO any Data property has been declared!!");
//            return RR_DP_D;
//        } 
        return isolatedDataPop;
    }
    //UI data property Usage
    public double dataPropertyRichnessDR () {
         // calculating Richness of Data Property considering explicit Domains and Ranges
         double RR_DP_D = 0.00; 
         int DataPoPwithDR = 0,DP_range, DP_domain, DP_declared;
         Set<OWLDataProperty> DPDeclaredList = o.getDataPropertiesInSignature();
         DP_declared= o.getDataPropertiesInSignature().size();// Number of Data Property declared
            
             for (OWLDataProperty obj : DPDeclaredList) {
                DP_range = o.getDataPropertyRangeAxioms(obj).size();
                DP_domain = o.getDataPropertyDomainAxioms(obj).size();
                 if (DP_range >= 1 && DP_domain >= 1) {
                     DataPoPwithDR++;
                 } else {
                     System.out.println("incomplete Property: domain and Range "+obj);
                 }
             }
            
            if (DP_declared !=0) {
                System.out.println("Data Property With explicit Domains and Range = "+DataPoPwithDR+" Declared DP Domain = "+DP_declared );
                RR_DP_D = 100.0 *(double) DataPoPwithDR / DP_declared;
                 return RR_DP_D;
            } else {
            System.out.println("NO any Data property has been declared!!");
            return RR_DP_D;
        }
    }
    
    //OntoQA - UI Class Richness
    public MetricResult classRichness () {
        double clsR = 0, usedCls = 0;
       int Declared_class =  o.getClassesInSignature().size();
       Set<OWLClass> declaredClass = o.getClassesInSignature();
       Set<OWLClass> emptyClasses = new HashSet<>();
       if (!declaredClass.isEmpty()) {
           
       for (OWLClass clas : declaredClass) {
           if (!r.getInstances(clas).isEmpty()) {
               usedCls++;// counting non-empty classes
           } else {
               System.out.println("Empty Class");
               System.out.println(clas);
               emptyClasses.add(clas);
            }
    }
       m.setEmptyClass(emptyClasses);
       // calculating class Richness
           System.out.println("used Classes: "+ usedCls + " Total declared classes: "+ Declared_class);
       clsR = 100.0 *(double) usedCls / Declared_class;
       m.setClassRichness(clsR);
      
       } else {
           System.out.println("No any clasess are declared");
           
       }
       return m;
    }

    
}
