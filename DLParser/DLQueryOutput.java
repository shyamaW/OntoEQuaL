/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.DLParser;

import java.util.ArrayList;
import java.util.Set;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 *
 * @author HP
 */
public class DLQueryOutput {
    private ArrayList<String> superClasses = null;
    private ArrayList<String> subClasses = null;
    private ArrayList<String> EquivelentClasses = null;
    private ArrayList<String> individuals = null;

    /**
     * @return the superClasses
     */
    public ArrayList<String> getSuperClasses() {
        return superClasses;
    }

    /**
     * @param superClasses the superClasses to set
     * @param shortFormProvider
     */
    public void setSuperClasses(Set<OWLClass> superClasses, ShortFormProvider shortFormProvider) {

        this.superClasses = GenerateStringEntities (shortFormProvider,superClasses);
    }

    /**
     * @return the subClasses
     */
    public ArrayList<String> getSubClasses() {
        return subClasses;
    }

    /**
     * @param shortFormProvider
     * @param subClasses the subClasses to set
     */
    public void setSubClasses(ShortFormProvider shortFormProvider,Set<OWLClass> subClasses) {
        
        this.subClasses = GenerateStringEntities (shortFormProvider,subClasses);
    }

    /**
     * @return the EquivelentClasses
     */
    public ArrayList<String> getEquivelentClasses() {
        return EquivelentClasses;
    }

    /**
     * @param shortFormProvider
     * @param EquivelentClasses the EquivelentClasses to set
     */
    public void setEquivelentClasses(ShortFormProvider shortFormProvider, Set<OWLClass>  EquivelentClasses) {
        this.EquivelentClasses = GenerateStringEntities (shortFormProvider,EquivelentClasses);
    }

    /**
     * @return the individuals
     */
    public ArrayList<String> getIndividuals() {
        return individuals;
    }

    /**
     * @param shortFormProvider
     * @param individuals the individuals to set
     */
    public void setIndividuals(ShortFormProvider shortFormProvider, Set<OWLNamedIndividual> individuals) {
        this.individuals = GenerateStringEntities (shortFormProvider,individuals);
    }
    
    private ArrayList<String> GenerateStringEntities(ShortFormProvider shortFormProvider, Set<? extends OWLEntity> entities) {
     ArrayList<String> stringClass = new ArrayList<>();
        if (!entities.isEmpty()) {
            for (OWLEntity entity : entities) {
                stringClass.add(shortFormProvider.getShortForm(entity));
            }
        } else {
            stringClass.add("NONE");
            }
        return stringClass;
    }
}
