/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.Controllers;

import com.ontoQual.DLParser.DLQueryManager;
import com.ontoQual.DLParser.DLQueryOutput;
import com.ontoQual.ontology.manager.OntologyManager;
import com.ontoQual.testCasesImp.DLCellReferenceValueManipulator;
import java.io.IOException;
import java.util.ArrayList;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

/**
 *
 * @author HP
 */
public class TestExecuteController {
    DLQueryManager man =  new DLQueryManager();
    CommonRegularExpressionHandler regExpressCheck = new CommonRegularExpressionHandler();
    DLCellReferenceValueManipulator dlmanupulator = new DLCellReferenceValueManipulator();
    ArrayList<TestTemplate> cases = new ArrayList<>();

    public TestExecuteController(ArrayList<TestTemplate> tt) {
        this.cases = tt;
    }

    public TestTemplate runTestCase (TestTemplate test) throws OWLOntologyCreationException, IOException {

            OWLOntology o = OntologyManager.getInstance().loadOntology();
            
            
                if (!(test.getDlQuery()==null)) {
               DLQueryOutput actualOutputObj = man.getDLInputText(o,test.getDlQuery());//DLQueryOutput Object
                test.setActualResultSuperClasses(actualOutputObj.getSuperClasses());
                test.setActualResultSubClasses(actualOutputObj.getSubClasses());
                test.setActualResultEquivalentClasses(actualOutputObj.getEquivelentClasses());
                test.setActualResultIndividuals(actualOutputObj.getIndividuals());
                 }
            
            return test;
        }
    
    // get all run test cases: ID, DL, Actual Answers
    public ArrayList<TestTemplate> RunTestCases () throws OWLOntologyCreationException, IOException {
        
        for (TestTemplate t: this.cases) {   
           if (regExpressCheck.isVariablesContain(t.getDlQuery(),"@")) {
               System.out.println("True "+ t.getTestID());
               System.out.println(dlmanupulator.getDLForReferenceValues(t.getDlQuery(),this.cases));
            } else {
               System.out.println("False " + t.getTestID());
              // runTestCase(t);
               t.setRemark(true);
            }
        }
        return this.cases;
    }
    
        
}
