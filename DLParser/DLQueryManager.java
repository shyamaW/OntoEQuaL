package com.ontoQual.DLParser;

import java.io.File;
import java.io.IOException;
import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.util.ShortFormProvider;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class DLQueryManager {
      File file;
      DLQueryOutputRender dlQueryPrinter = null;
      
      public DLQueryOutput getDLInputText (OWLOntology o,String InputDLquery) throws OWLOntologyCreationException,IOException {
        
//      final OpenlletReasoner reasoner = OpenlletReasonerFactory.getInstance().createReasoner(o);
       
        OWLReasonerFactory hermitreasonerFactory = new ReasonerFactory();
        OWLReasoner reasoner = hermitreasonerFactory.createReasoner(o);

          System.out.println("Reasoning Finised");

        ShortFormProvider shortFormProvider = new SimpleShortFormProvider();
        // Create the DLQueryOutputRender helper class. This will manage the
        // parsing of input and printing of results
      
        dlQueryPrinter = new DLQueryOutputRender(new DLQueryEngine(reasoner, shortFormProvider), shortFormProvider) ;   

            String classExpression = InputDLquery;
            
          if (dlQueryPrinter == null || classExpression == null ) {
              System.out.println("dlQueryPrinter OR classExpression: DL query is empty");
              return null;
             } else {
              System.out.println("classExpression!" + classExpression);
            return dlQueryPrinter.askQuery(classExpression.trim());
            }
      }

}