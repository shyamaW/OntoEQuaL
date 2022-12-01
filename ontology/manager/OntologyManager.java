/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.ontology.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Optional;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.SetOntologyID;
import org.semanticweb.owlapi.reasoner.OWLReasoner;


/**
 *
 * @author user
 */
public class OntologyManager {
    
   
        private static OntologyManager obj = new OntologyManager(); 

	OWLOntologyManager man = OWLManager.createOWLOntologyManager();
               
     
	OWLOntology o =null;
        OWLReasoner r =null;
	File file;
        
	  
    private OntologyManager() {} 
    
    public static OntologyManager getInstance() 
    { 
        return obj; 
    } 
    
    public OWLOntology loadOntology () {
        System.out.println("First Time Reading Ontology");
            if (o == null) {
		 System.out.println("First Time NULL");
               //  file = new File("ontology/agriDesingPatternV1.owl");// read file path
	     // file = new File("ontology/Test.owl");// read file path
               file = new File("ontology/(V15)GOVINENA_ONTOLOGY.owl");// read file path
               // file = new File("ontology/Crop_subhash.owl");// read file path
             // file = new File("ontology/TestCircularity.owl");// read file path
     
              
		try {
			o = man.loadOntologyFromOntologyDocument(file); // load file from the disk
                        
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return o;
            } else {
                 System.out.println("No more NULL");
                return o;
            }
	}
    /*
    public OWLReasoner getReasonerInstance () {
        System.out.println("Checking reasoner is NULL and Ontology NULL?? , if not return already available one");
        if (r == null) {
            System.out.println("First time NULL");
        OWLReasonerFactory hermitreasonerFactory = new ReasonerFactory();
        OWLReasoner r = hermitreasonerFactory.createReasoner(o);
        return r;
        } else {
            System.out.println("Second and more time not NULL");
            return r;
        }
    }*/
	
	public OWLOntology loadOntology (String filepath) {
	
		file = new File(filepath);// read file path
		try {
			o = man.loadOntologyFromOntologyDocument(file); // load file from the disk
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return o;
                
	}
	
	public String saveSLNOntology (OWLOntology o) {
		
		try {
			man.saveOntology(o);
		} catch (OWLOntologyStorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Ontology Saved";
	}
	
	public String savingOntology (OWLOntology o,String version, String filepath) throws FileNotFoundException {
		
		try {
			IRI versionIRI=IRI.create(version);
			SetOntologyID change=new SetOntologyID(o, 
				    new OWLOntologyID(o.getOntologyID().getOntologyIRI(), Optional.of(versionIRI)));
		
			// Create the change that will set our version IRI
			o.getOWLOntologyManager().applyChange(change);
			
			file = new File(filepath);// this is new file name
			man.saveOntology(o, new FunctionalSyntaxDocumentFormat(), new FileOutputStream(file));
			
		}catch (OWLOntologyStorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            // TODO Auto-generated catch block
		return "Ontology Saved";
	}
        
//          public void saveInferedOntology () throws FileNotFoundException {
//           
//            System.out.println("caaled reasoner and create onto");
//            InferredOntologyGenerator iog = new InferredOntologyGenerator(r);
//            System.out.println("created inferred ontology");
//            iog.fillOntology(df, this.o);
//            System.out.println("fillingOntology");
//            // Save the new ontology
//            OntologyManager.getInstance().savingOntology(this.o, o.getOntologyID().getOntologyIRI().get()+"/agriInferedv1", "ontology/agriInfferedV1.owl");
//            System.out.println("Inferred ontology saved!");
//        } 
        
        
        
}
