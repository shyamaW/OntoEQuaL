/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.uiManager;

import com.ontoQual.Controllers.DLQueryGenerationController;
import com.ontoQual.mm.Controller.MappingMasterController;
import com.ontoQual.DLParser.DLQueryManager;
import com.ontoQual.Controllers.TestExecuteController;
import com.ontoQual.Controllers.TestTemplate;
import com.ontoQual.ontology.manager.OntologyManager;
import com.ontoQual.testCasesImp.DLQueryRegularExpressionHandler;
import com.ontoQual.testCasesImp.DLExcelQueryTemplate;
import com.ontoQual.testCasesImp.OntoEntityChecker;
import com.ontoQual.whiteboxevaluater.GraphConsistencyChecker;
import com.ontoQual.whiteboxevaluater.ConsistencyChecker;
import com.ontoQual.whiteboxevaluater.DataCompleteness;
import com.ontoQual.whiteboxevaluater.GraphModularityBFS;
import com.ontoQual.whiteboxevaluater.MetricResult;
import com.ontoQual.whiteboxevaluater.SchemaCompleteness;
import com.ontoQual.whiteboxevaluater.SchemaConnectivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.reasoner.InferenceDepth;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

/**
 *
 * @author HP
 */
public class Demo {

    public static void main(String[] args) throws OWLOntologyCreationException, IOException, InvalidFormatException {
//       MappingMasterController mm = new MappingMasterController();
//       mm.exampleTest(null);
        OWLOntology o = OntologyManager.getInstance().loadOntology();
        OWLReasonerFactory hermitreasonerFactory = new ReasonerFactory();
        OWLReasoner reasoner = hermitreasonerFactory.createReasoner(o);

        OWLDataFactory df = OWLManager.getOWLDataFactory();
        GraphModularityBFS g = new GraphModularityBFS(o, reasoner, df);
        System.out.println("Breadth: " + g.graphBreadth().getMaxBreadth());
//       GraphConsistencyChecker cc = new GraphConsistencyChecker(o,reasoner,df);
//      // cc.isCircularity();
//        MetricResult m = cc.isCircle();
//        System.out.println(""+ m.isCircularity()+ "" +m.getMaxDepth());
//        System.err.println(""+m.getCircularityClasses());

//       SchemaConnectivity sc = new SchemaConnectivity(o);
//       sc.connectionSearchDFS("Variety");
//    DataCompleteness dp = new DataCompleteness(o,reasoner);
//    dp.getObjectPropertyAsserstionOfIndividuals();
//       ConsistencyChecker c = new ConsistencyChecker(o, reasoner);
//       System.out.println("consistency checker: " + c.isOntologyConsistent());
        /*  
        TestTemplate t1 = new TestTemplate();
        TestTemplate t2 = new TestTemplate();
       // TestTemplate t3 = new TestTemplate();
        //TestTemplate t4 = new TestTemplate();
        ArrayList<TestTemplate> tt = new ArrayList<>();
        ArrayList<String> t1_expect = new ArrayList<>(); 
        t1.setTestID("CQ_1");
        t1_expect.add("SM 64");
        t1_expect.add("Amanda");
        t1_expect.add("Anjalee");
        t1_expect.add("Hodi Lenairri");
        t1_expect.add("Padagoda");
        t1_expect.add("Thinnavelli Purple");
        t1.setDlQuery("Variety AND isVarietyOf value Brinjal");
        t1.setExpectedResult(t1_expect);
        
        ArrayList<String> t2_expect = new ArrayList<String>(); 
        t2.setTestID("CQ_2");
        t2_expect.add("Shoot and fruit borer");
        t2_expect.add("Leaf webber");
        t2_expect.add("Red spider mite");
        t2_expect.add("Leaf hoppers");
        t2_expect.add("White fly");
        t2_expect.add("Aphids");
        t2_expect.add("Thrips");
        t2_expect.add("Mealy bug");
        t2_expect.add("Lace bug");
        t2.setDlQuery("Pest and affects value Brinjal");
        t2.setExpectedResult(t2_expect);
        tt.add(t1);// row 1-case1
        tt.add(t2);// row 2-case2
        
        TestExecuteController tsr = new TestExecuteController(tt);
        
        
        for (TestTemplate testcase : tsr.TestRun()) {
            System.out.println("output\n" + testcase.getActualResultIndividuals());
        }
         */
//       DLQueryRegularExpressionHandler tem =  new DLQueryRegularExpressionHandler();
//       tem.dlQueryStatement("Variety AND isVarietyOf value &VAR", "Potato");
//       DLQueryRegularExpressionHandler tem1 =  new DLQueryRegularExpressionHandler();
//       System.out.println("" + tem1.classTypeofDLReference("Pest and affects some ((testing and &Crop)and teste &GrowingProblem)"));
/*
ArrayList<TestTemplate> createdTestCases = new ArrayList<>();

        ArrayList<String> inputValue1 = new ArrayList<>();
        inputValue1.add("Crop: Brinjal");
        String dl1 = "Variety AND isVarietyOf value &Crop";
      
        DLExcelQueryTemplate g = new DLExcelQueryTemplate("CQ_1",dl1, inputValue1);
       DLQueryGenerationController d0 = new DLQueryGenerationController();
       createdTestCases.add(d0.getPreProcessedDLQuery(g));
       
       ArrayList<String> inputVal2 = new ArrayList<>();
      inputVal2.add("Crop:@0");
       DLExcelQueryTemplate g1 = new DLExcelQueryTemplate("CQ_2", "Pest and affects value &Crop", inputVal2);
       DLQueryGenerationController d = new DLQueryGenerationController();
       createdTestCases.add(d.getPreProcessedDLQuery(g1));
       
         ArrayList<String> inputVal3 = new ArrayList<>();
      inputVal3.add("Crop:Brinjal");
       DLExcelQueryTemplate g2 = new DLExcelQueryTemplate("CQ_3", "Disease and affects value &Crop", inputVal3);
       DLQueryGenerationController d1 = new DLQueryGenerationController();
       createdTestCases.add(d1.getPreProcessedDLQuery(g2));
       
       ArrayList<String> inputVal4 = new ArrayList<>();
      inputVal4.add("Variety:@A2");
       DLExcelQueryTemplate g4 = new DLExcelQueryTemplate("CQ_4", "(Disease and isResistanceDiseaseOf some ( (DiseaseResistanceEvent and isDiseaseResistanceEventOf value &Variety) and (DiseaseResistanceEvent AND hasDiseaseResistanceRate value Low)))", inputVal4);
       DLQueryGenerationController d14 = new DLQueryGenerationController();
       createdTestCases.add(d14.getPreProcessedDLQuery(g4));
       
       ArrayList<String> inputVal5 = new ArrayList<>();
      inputVal5.add("Crop:Brinjal");
      inputVal5.add("GrowingProblem:@A4,@A5");
       DLExcelQueryTemplate g5 = new DLExcelQueryTemplate("CQ_5", "Symptom and isSymptomOf some ((GrowingProblemEvent and isGrowingProblemEventOf value &Crop) and (GrowingProblemEvent and hasGrowingProblem value &GrowingProblem))", inputVal5);
       DLQueryGenerationController d15 = new DLQueryGenerationController();
       createdTestCases.add(d15.getPreProcessedDLQuery(g5));
       
       String s6= "ControlMethod and hasControlMethodType value \"Cultural\"^^xsd:string and isRelatedControlMethodOf some ((GrowingProblemEvent and hasGrowingProblem value &GrowingProblem) and (isGrowingProblemEventOf value &Crop))";
       ArrayList<String> inputVal6 = new ArrayList<>();
      inputVal6.add("Crop:Potato");
      inputVal6.add("GrowingProblem:@A4,@A5");
       DLExcelQueryTemplate g6 = new DLExcelQueryTemplate("CQ_6",s6, inputVal6);
       DLQueryGenerationController d16 = new DLQueryGenerationController();
       createdTestCases.add(d16.getPreProcessedDLQuery(g6));
       
       String s7= "ApplicationMethod and isApplicationMethodOfControlMethodEvent some ((ControlMethodEvent and isControlMethodEventOf some ((GrowingProblemEvent and hasGrowingProblem value &GrowingProblem) and (isGrowingProblemEventOf value &Crop))) and (ControlMethodEvent and hasControlMethod value &ControlMethod))";
       ArrayList<String> inputVal7 = new ArrayList<>();
      inputVal7.add("Crop:Potato");
      inputVal7.add("GrowingProblem:@A4,@A5");
      inputVal7.add("ControlMethod:@A4");
       DLExcelQueryTemplate g7 = new DLExcelQueryTemplate("CQ_7",s7, inputVal7);
       DLQueryGenerationController d17 = new DLQueryGenerationController();
       createdTestCases.add(d17.getPreProcessedDLQuery(g7));
       
       String s8 = "Unit and isUnitOfControlMethodEvent  some (ControlMethodEvent and (hasRelatedGrowingProblem value &GrowingProblem) and (isControlMethodEventOfCrop value &Crop) and (hasPesticide value &Pesticide))";
       ArrayList<String> inputVal8 = new ArrayList<>();
      inputVal8.add("Crop:Potato");
      inputVal8.add("GrowingProblem:@A4,@A5");
      inputVal8.add("Pesticide:Thiram");
       DLExcelQueryTemplate g8 = new DLExcelQueryTemplate("CQ_8",s8, inputVal8);
       DLQueryGenerationController d18 = new DLQueryGenerationController();
       createdTestCases.add(d18.getPreProcessedDLQuery(g8));
       
       DLExcelQueryTemplate g9 = new DLExcelQueryTemplate("CQ_9", "Variety", null);
       DLQueryGenerationController d9 = new DLQueryGenerationController();
       createdTestCases.add(d9.getPreProcessedDLQuery(g9));
       
//       DLExcelQueryTemplate g10 = new DLExcelQueryTemplate("CQ_10", "DiseaseControl or Pest", null);
//       DLQueryGenerationController d10 = new DLQueryGenerationController();
//       createdTestCases.add(d10.getPreProcessedDLQuery(g10));

       System.out.println("--------------------------------------------------");
       for (TestTemplate s:createdTestCases) {
           System.out.println("" + s.getTestID());
           System.out.println("" +s.getDlQuery());
       }
       System.out.println("----------------------------------------");
       TestExecuteController tsr = new TestExecuteController(createdTestCases);
       for (TestTemplate tt: tsr.RunTestCases()) {
           System.out.println(tt.getTestID());
           System.out.println(tt.getDlQuery());
           System.out.println(tt.getActualResultIndividuals());
           System.out.println("-------------------------------");
       }
       
         */
 /*
        Matcher matcher = Pattern.compile("Crop").matcher(ss);
        boolean flag1 = matcher.find();
        if (flag1) {
           // System.out.println("into");
               //Matcher matcherVal = Pattern.compile(":\\w+|:[\\@\\w+\\,\\@\\w+]+|:\\@\\w+").matcher(ss);
               Matcher matcherVal = Pattern.compile(":\\w+|:[\\@\\w+\\,]+").matcher(ss);
               boolean flag2 = matcherVal.find();
               System.out.println("sec : "+ flag2);
               if (flag2) {
                    System.out.println(".............."+matcherVal.group());
                    String input = matcherVal.group().substring(1);
                    System.out.println("---"+input);
               }
                }
         */
    }
}
