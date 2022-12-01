/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.Controllers;

import com.ontoQual.ontology.manager.OntologyManager;
import com.ontoQual.whiteboxevaluater.SchemaConnectivity;
import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

/**
 *
 * @author HP
 */
public class MetricConnectivityController {

    OWLOntology o = null;
    OWLReasonerFactory hermitreasonerFactory = new ReasonerFactory();
    OWLReasoner reasoner = null;
    
    public MetricConnectivityController(String ontologfilePath) {
        this.o = OntologyManager.getInstance().loadOntology(ontologfilePath);
        this.reasoner = hermitreasonerFactory.createReasoner(this.o);
    }
    public void classConnectivity(String root) {
            getSchemaConnectivity("Crop");
    }
    private void getSchemaConnectivity (String rootClass) {
        SchemaConnectivity schemaConnectivity = new SchemaConnectivity(o);
        schemaConnectivity.connectionSearchDFS(rootClass);
    }
}
