/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.whiteboxevaluater;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.search.EntitySearcher;


/**
 *
 * @author HP
 */
public class DataCompleteness {
     private OWLOntology o = null;
     private OWLReasoner r = null;
     private String IOR;
     OWLDataFactory df = null;
     MetricResult m = new MetricResult();

    public DataCompleteness( OWLOntology onto,OWLReasoner reasoner ) {
        this.o = onto;
        this.r = reasoner;
        this.IOR = o.getOntologyID().getOntologyIRI().get()+"#";
        this.df = o.getOWLOntologyManager().getOWLDataFactory();
    }
      // get both explict and implicit Type - class Assertions of Instances
    public MetricResult getInstancesClassAssertionmetric (){ 
        int no_instanceDeclared,no_type, usedinstance = 0, emptyInstance = 0;
        Set<OWLNamedIndividual> instanceDeclared = new HashSet<>();
         Set<OWLNamedIndividual> isolatedIndividual = new HashSet<>();
        instanceDeclared = this.o.getIndividualsInSignature();
        no_instanceDeclared = instanceDeclared.size();
        if (no_instanceDeclared != 0 ) {
        for (OWLNamedIndividual ind: instanceDeclared) {
            no_type = this.r.getTypes(ind).getFlattened().size();
            if (no_type > 1) {
                usedinstance++;
            } else {
                System.out.println("Instance without Type: "+ind);
                isolatedIndividual.add(ind);
                emptyInstance++;
            }
        }
            m.setNumberOfinstancehasType(usedinstance);
            m.setNumberOfIsolatedInstances(emptyInstance);
            m.setListOfIsolatedIndividuals(isolatedIndividual);
        } else {
            System.out.println("No any instances have been defined!");
        } 
        return m;
    }

    // UI Instance usage
    public double getInstanceUsage (MetricResult metricResult) {
        double istanceRR = 0;
        if (metricResult.getNumberOfDeclaredIndividual() != 0) {
         System.out.println("Used Instance: "+metricResult.getNumberOfinstancehasType() + " Declared instance: " +metricResult.getNumberOfDeclaredIndividual());
            istanceRR = 100.0 *(double) metricResult.getNumberOfinstancehasType() / metricResult.getNumberOfDeclaredIndividual(); 
        }
        return istanceRR;
    }
    
      public void connectivityOfInstanceinSchema ( String rootInd) {
        OWLNamedIndividual indIRI = df.getOWLNamedIndividual(IOR+rootInd);

        if (isIndividualInOnto(indIRI)) {
        Set<OWLClassExpression> classSetIND = getTypeofIndividual(indIRI);// get Types of the Individual including owl:things
            System.out.println("classes: "+classSetIND);
        
       // get Object Property of a particular Individual
       Set<OWLObjectPropertyAssertionAxiom> objax_forInd =  o.getObjectPropertyAssertionAxioms(indIRI);
        Set<OWLObjectPropertyExpression> objPropofInd = new HashSet<>(); ;
        for (OWLObjectPropertyAssertionAxiom ob: objax_forInd) {
                   System.out.println("inndividual: "+rootInd +" property " + ob.getProperty()+ " with individual: "+ ob.getObject());
                   objPropofInd.add(ob.getProperty()); // need to get getObject too
               }
        
        if (classSetIND.size()> 1) {
        Set<OWLObjectProperty> objectProptyofClass = new HashSet<>();
        
        for (OWLClassExpression e : classSetIND) {
            if (!e.isOWLThing()) {
            System.out.println("class Type --------------" + e);
            objectProptyofClass = getAllObjectPropertyOfClass (e);
            System.out.println("Proterites of the Class: " +objectProptyofClass);
            }
            //checking individuals have the properties of Class
            for (OWLObjectProperty objcls: objectProptyofClass) {
                if(objPropofInd.contains(objcls)) {
                System.out.println(objcls+"Tringgered Obj in " + objPropofInd.contains(objcls)); 
            }else {
                    System.out.println(objcls+" is not defined for individual : "+ rootInd);  
                }
        }
        }
        
        } else {
            System.out.println(" NO class TYPE has been defined for Individual: "+ rootInd);
        }
        }
        else {
            System.out.println("No any Named Individual : "+ rootInd);
        }
        
  
    }
    
    public double numIndividualInClass (String className) {
        OWLClass classIRI = df.getOWLClass(IOR+className);
        System.out.println(classIRI);
        System.out.println(r.getInstances(classIRI));
        int indSize = o.getIndividualsInSignature().size();
        int classInddefined = r.getInstances(classIRI).getFlattened().size();
        //calculating class Importance
        if (indSize !=0) {
            System.out.println("Instance in class: "+classInddefined + " Declared instance: " +indSize);
            double importance = 100.0 *(double) classInddefined / indSize;
            return importance;
        } else {
             System.out.println("No any instances have been defined!");
            return 0;
        } 
    }
    
    public double instanceWithOutObjPropInClass (String className) {
        
        OWLClass classIRI = df.getOWLClass(IOR+className);
        int objInclassCount = 0;
        
        Set<OWLObjectProperty> OPDeclared = o.getObjectPropertiesInSignature();
         //count the number of objectProperty defined in the class
        for (OWLObjectProperty obj : OPDeclared) {
            boolean match = r.getObjectPropertyDomains(obj).entities().anyMatch(s -> s.containsEntityInSignature(classIRI)); 
            if (match) {
                System.out.println(obj);
                objInclassCount++;
            }
        }
       //get individuals in a class
        Iterator<OWLIndividual> itr = EntitySearcher.getIndividuals(classIRI, o).iterator();
        int i = 0;
         while(itr.hasNext()) {
             
         OWLIndividual element = itr.next();
         System.out.println(element + "");
          //get Object property defined for individuals
          Set<OWLObjectPropertyExpression> objProps = EntitySearcher.getObjectPropertyValues(element, o).keySet();
             System.out.println();
             System.out.println("Total Obj in class: "+ objInclassCount + "Used by Individual: "+(i++)+ "-" + element+ "Count: "+objProps.size());
      }
         
        return 0;
    }
    
    public void checkObjCOmpletenessOfInstance (String ind) {
          OWLNamedIndividual indIRI = df.getOWLNamedIndividual(IOR+ind);
          Set<OWLClass> types = new HashSet<OWLClass>();
          Set<OWLObjectProperty> objPropList = new HashSet<OWLObjectProperty>();
          System.out.println();
          
          Iterator<OWLClass> itr = r.getTypes(indIRI).entities().iterator();
            itr.next();
             while(itr.hasNext()) {
                    types.add(itr.next());
             }
             
          System.out.println(types + " is type");
          
          Set<OWLObjectProperty> OPDeclared = o.getObjectPropertiesInSignature();
         //count the number of objectProperty defined in the class of Instance
        for (OWLClass cls : types) {

            System.out.println("class" + cls);
        for (OWLObjectProperty obj : OPDeclared) {
            boolean matchD = r.getObjectPropertyDomains(obj).entities().anyMatch(s -> s.containsEntityInSignature(cls)); 
            if (matchD) {
                    objPropList.add(obj);
                }
            }
            
        }
        System.out.println("Object Prop List: " +objPropList);
        System.out.println("Object Size: " +objPropList.size());
       Iterator<OWLObjectProperty> t =  objPropList.stream().iterator();
       
       while (t.hasNext()) {
           OWLObjectProperty ob = t.next();
           //System.out.println("test2: "+r.getObjectPropertyValues(indIRI, ob));
        if (r.getObjectPropertyValues(indIRI, ob).isEmpty()){
           System.out.println("Not used Prop: "+ ob);
        }
       }
      //  System.out.println("-------------------------All Object Prop-----------------");
       // System.out.println(objPropList);
    }
    
  
    public boolean isIndividualInOnto (OWLNamedIndividual ind) {
        boolean x = false;
      for (OWLNamedIndividual i :o.getIndividualsInSignature()){
           System.out.println("i "+ i);
          if (ind.equals(i)) {
              x= true;
              break;
          }
      }
      return x;
    }
    // get Types of given Individual
    public Set<OWLClassExpression> getTypeofIndividual(OWLNamedIndividual indIRI) {
        
        Set<OWLClassExpression> classSet = new HashSet<>();
        EntitySearcher.getTypes(indIRI, o).forEach(classSet::add);
        //EntitySearcher.getTypes(indIRI, o).forEach(s -> System.out.println(s.isOWLThing()));
        return classSet;
    }
    
    // get object propoerties of a given class
    public Set<OWLObjectProperty>  getAllObjectPropertyOfClass (OWLClassExpression clsExpression) {
        Set<OWLObjectProperty> objectProptyofClass = new HashSet<>();
        Set<OWLObjectProperty> objectProptyAll = o.getObjectPropertiesInSignature();
        
        for (OWLObjectProperty obj : objectProptyAll) {
           for (OWLObjectPropertyDomainAxiom ax : o.getObjectPropertyDomainAxioms(obj)) {
               if (clsExpression.equals(ax.getDomain())) {
                   objectProptyofClass.add(obj); 
               }
           }
//           for (OWLObjectPropertyRangeAxiom ax : o.getObjectPropertyRangeAxioms(obj)) {
//               if (clsExpression.equals(ax.getRange())) {
//                   objectProptyofClass.add(obj); 
//               }
//           }
           
        }
        return objectProptyofClass;
       
    }
    //get ObjectPropoert Assertion of Individuals
    // Reasoned assertions are not counted
    public void getObjectPropertyAsserstionOfIndividuals () {
        Set<OWLNamedIndividual> indDeclared = this.o.getIndividualsInSignature();
        int f = 0;
        for (OWLNamedIndividual indIRI : indDeclared) {
//            System.out.println(indIRI +" \n" +o.getObjectPropertyAssertionAxioms(indIRI));
            if (o.getObjectPropertyAssertionAxioms(indIRI).isEmpty()) {
                f++;
                System.out.println(""+indIRI);
            } 
        }
        System.out.println("Number of Emplty: "+ f);
        System.out.println("total Individuals"+ o.getIndividualsInSignature().size());
    }
         
  
  

}
