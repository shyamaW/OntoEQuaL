/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.DLParser;

import java.util.Set;
import jdk.nashorn.internal.runtime.ParserException;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 *
 * @author HP
 */
public class DLQueryOutputRender {
    public final DLQueryEngine dlQueryEngine;
    private final ShortFormProvider shortFormProvider;

    public DLQueryOutputRender(DLQueryEngine engine, ShortFormProvider shortFormProvider) {
        this.shortFormProvider = shortFormProvider;
        dlQueryEngine = engine;
        }

    public DLQueryOutput askQuery(String classExpression) {
        DLQueryOutput dloutput = new DLQueryOutput();
        if (classExpression.length() == 0) {
            System.out.println("No class expression specified");
            return dloutput;
        } else {
            try {
                Set<OWLClass> superClasses = dlQueryEngine.getSuperClasses(
                        classExpression, false);
                dloutput.setSuperClasses(superClasses, shortFormProvider);
                Set<OWLClass> equivalentClasses = dlQueryEngine
                        .getEquivalentClasses(classExpression);
                dloutput.setEquivelentClasses(shortFormProvider, equivalentClasses);
                Set<OWLClass> subClasses = dlQueryEngine.getSubClasses(classExpression,
                        true);
                dloutput.setSubClasses(shortFormProvider, subClasses);
                Set<OWLNamedIndividual> individuals = dlQueryEngine.getInstances(
                        classExpression, true);
                dloutput.setIndividuals(shortFormProvider, individuals);
              return dloutput;
            } catch (ParserException e) {
                System.out.println("Output is NULL" + e.getMessage());
                return dloutput;
            }
            }
        }
}

