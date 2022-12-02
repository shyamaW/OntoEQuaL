/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.Controllers;

import com.ontoQual.ontology.manager.OntologyManager;
import com.ontoQual.whiteboxevaluater.ConsistencyChecker;
import com.ontoQual.whiteboxevaluater.ConsistencyMetric;
import com.ontoQual.whiteboxevaluater.DataCompleteness;
import com.ontoQual.whiteboxevaluater.GeneralMetric;
import com.ontoQual.whiteboxevaluater.GraphConsistencyChecker;
import com.ontoQual.whiteboxevaluater.GraphModularityBFS;
import com.ontoQual.whiteboxevaluater.MetricResult;
import com.ontoQual.whiteboxevaluater.SchemaCompleteness;
import com.ontoQual.whiteboxevaluater.SchemaConnectivity;
import java.util.Set;
import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

/**
 *
 * @author HP
 */
public class MetricController {
    Metric m = new Metric();
    MetricResult metricResult = new MetricResult();
    OWLOntology o = null;
    OWLReasonerFactory hermitreasonerFactory = new ReasonerFactory();
    OWLReasoner reasoner = null;
    OWLDataFactory df = null;
    
    public MetricController (String ontologfilePath) {
        
        this.o = OntologyManager.getInstance().loadOntology(ontologfilePath);
        this.reasoner = hermitreasonerFactory.createReasoner(this.o);
        this.df = OWLManager.getOWLDataFactory(); 
        
    }
    public Metric getGeneralQualityMetric() {
        getGeneralMetric();          
        return m;
    }
    
    public Metric getDataLevelQualityMetrics () {
        getDataLevelMetrics();
        return m;
    }
    
    public Metric getSchemaLevelQualityMetrics () {
        getScemaLevelMetrics();
        return m;
    }
    
    public Metric getConsistencyQualityMetrics () {
        getConsistencyMetrics();
        return m;
    }
    
    public Metric getGraphQualityMetrics () {
        getGraphMetrics();
        return m;
    }
    public Metric getSchemaConnectivityQualityMetrics (String root) {
        getSchemaConnectivityMetrics(root);
        // should allow users to select: Need If statements otherwise results will be delayed
       // getSchemaConnectivityMetrics(root); 
        return m;
    }
    
    public Metric checkConsistency() {
                    //        if (selectedconsistencyStatus) {
            //            checkConsistency();
            // this fuction should be tested with adding inconsistency ontology
            //the metrics depend on the reasoner should be Tested
            //        }
        ConsistencyChecker consistencyChecker = new ConsistencyChecker(o, reasoner);
       // consistencyChecker.isOntologyConsistent();//- should be called
        m.setConsistencyState(consistencyChecker.isOntologyConsistent());
        return m;
    }
    
    private void getGeneralMetric () {
        GeneralMetric generalMetric = new GeneralMetric(o);
        OWLEntityManipulator entityManipulator = new OWLEntityManipulator();
        Set<OWLClass> classList = generalMetric.getClassesList();
        m.setNumberOfClasses(classList.size());
        m.setOntologyClassList(entityManipulator.getOWLClassSignature(classList));
        m.setNumberOfObjectProperty(generalMetric.getNumberOfObjectProperty());
        m.setNumberOfDataProperty(generalMetric.getNumberOfDataProperty());
        m.setNumberOfInstance(generalMetric.getNumberOfInstance());
        m.setLogicalAxioms(generalMetric.getLogicalAxiomsCount());
        m.setNumberOfDeclaredAxioms(generalMetric.getDeclaredAxioms());
        m.setNumberOfChainProperty(generalMetric.getNumberOfChianProperties());
        m.setNumberOfSubClassAxiom(generalMetric.getNumberOfSubClasses());
        //Consistency Basic Metric
       m.setNumberOfEquivalentClassAxiom(generalMetric.getNumberOfEquivalentClassesAxiom());
       m.setNumberOfDisjointClassAxiom(generalMetric.getNumberOfDijointClassesAxiom());
       m.setNumberOfEquivalentOBJPropertyAxiom(generalMetric.getNumberOfEquivalentOBJPropertyAxioms());
       m.setNumberOfDisjointOBJPropertyAxiom(generalMetric.getNumberOfDisjointOBJPropertyAxioms());
       m.setNumberOfSubPropertyAxiom(generalMetric.getNumberOfSubClassOfOBJPropertyAxioms());
        // Get Comprehensability Basic Metrics
        m.setNumberOfAnnotation(generalMetric.getNumberOfAnnotation());
        m.setNumberOfAnnotationAssertion(generalMetric.getNumberOfAnnotationPropertyAxiom());
    }
    
    private void getDataLevelMetrics() {
        DataCompleteness dataCompleteness = new DataCompleteness(o,reasoner);
        metricResult = dataCompleteness.getInstancesClassAssertionmetric();
        metricResult.setNumberOfDeclaredIndividual(m.getNumberOfInstance());
        m.setNumberofIsolatedInstance(metricResult.getNumberOfIsolatedInstances());
        m.setInstanceUsage(dataCompleteness.getInstanceUsage(metricResult));
    }
    
    private void getScemaLevelMetrics() {
        SchemaCompleteness schemaCompleteness = new SchemaCompleteness(o,reasoner);
        m.setRelationshipRichness(schemaCompleteness.relationshipRichness());
        
        metricResult = schemaCompleteness.relationshipRichnessObj();// Object Prperty usage
        m.setObjectPropertyUsage(metricResult.getObjectPropertyUsage());
        m.setNumberofIsolatedObjectProperty(metricResult.getNumberOfIsolatedObjectProperty());
        m.setDatapropertyUsage(schemaCompleteness.dataPropertyRichnessDR());
        m.setNumberOfIsolatedDataProperty(schemaCompleteness.attributeUsedRichness().size());
        metricResult = schemaCompleteness.classRichness();// class usage- empty classes AND class richness
        m.setClassRichness(metricResult.getClassRichness()); // Class Richness
        m.setNumberOfIsolatedClass(metricResult.getEmptyClass().size());
    }
    
    private void getSchemaConnectivityMetrics (String root) {
        SchemaConnectivity sc = new SchemaConnectivity(o);
        metricResult =  sc.connectionSearchDFS(root);
        m.setNumberOfconnectedClassWithRoot(metricResult.getConnectedClassesList().size());
        m.setNumberOfdisconnectedClassWithRootSize(metricResult.getDisconnectedClassList().size());
    }
    private void getGraphMetrics() {
        GraphConsistencyChecker graphCheck = new GraphConsistencyChecker(o, reasoner, df);
        metricResult = graphCheck.isCircle();
        m.setCircles(metricResult.isCircularity());
        m.setMaxDepth(metricResult.getMaxDepth());
        GraphModularityBFS bfs = new GraphModularityBFS(o, reasoner, df);
        m.setMaxBreadth(bfs.graphBreadth().getMaxBreadth()); // check the bug
    }
    
    private void getAnnotationMetrics() {
        //Naming Conventions DP
        
    }
    private void getConsistencyMetrics() {
        ConsistencyMetric consistencyMetric = new ConsistencyMetric(o);
        m.setNumberOfFunctionalOPAxiom(consistencyMetric.getFunctionalOPAxiom());
        m.setNumberOfInverseFunctionalOPAxioms(consistencyMetric.getInverseFunctionalOPAxioms());
        m.setNumberOfTransitiveOPAxioms(consistencyMetric.getTransitiveOPAxioms());
        m.setNumberOfSymmetricOPAxioms(consistencyMetric.getSymmetricOPAxioms());
        m.setNumberOfAsymmetricOPAxioms(consistencyMetric.getAsymmetricOPAxioms());
        m.setNumberOfReflexiveOPAxioms(consistencyMetric.getReflexiveOPAxioms());
        m.setNumberOfIreflexiveOPAxioms(consistencyMetric.getIreflexiveOPAxioms());
        m.setNumberOfFunctionalDPAxioms(consistencyMetric.getFunctionalDPAxioms());
    }
    
    
}
