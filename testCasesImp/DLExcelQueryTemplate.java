/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.testCasesImp;

import java.util.ArrayList;

/**
 *
 * @author HP
 */

public class DLExcelQueryTemplate {
    private String dlquery = null; // DL in the excel sheet
    private String dlID = null; // DL ID in the excel sheet
    private ArrayList<String>  inputValue = null; // DL individuals to be added in order
   // private ArrayList<String> dlInputType = null; // DL input individual Type:Class
   // private ArrayList<String> dependentCQ =  new ArrayList<>(); // DL input Dependencies
    private boolean dependecy = false;
     private String cellRef = "";

    public DLExcelQueryTemplate(String ID, String query, ArrayList<String> inputs, String cellReference) {
        this.dlquery = query;
        this.dlID = ID;
        this.inputValue = inputs;
        this.cellRef = cellReference;
       // this.dependentCQ = dependencies;
        //this.dependecy = dependency;
    }
    
    
    /**
     * @return the dlquery
     */
    public String getDlquery() {
        return dlquery;
    }

    /**
     * @return the dlID
     */
    public String getDlID() {
        return dlID;
    }

    /**
     * @return the dependentCQ
     */
//    public ArrayList<String> getDependentCQ() {
//        return dependentCQ;
//    }

    /**
     * @param dlquery the dlquery to set
     */
    public void setDlquery(String dlquery) {
        this.dlquery = dlquery;
    }

    /**
     * @param dlID the dlID to set
     */
    public void setDlID(String dlID) {
        this.dlID = dlID;
    }

    /**
     * @return the inputValue
     */
    public ArrayList<String> getInputValue() {
        return inputValue;
    }

    /**
     * @param inputValue the inputValue to set
     */
    public void setInputValue(ArrayList<String> inputValue) {
        this.inputValue = inputValue;
    }

    /**
     * @param dependentCQ the dependentCQ to set
     */
//    public void setDependentCQ(ArrayList<String> dependentCQ) {
//        this.dependentCQ = dependentCQ;
//    }

    /**
     * @return the dependecy
     */
    public boolean isDependecy() {
        return dependecy;
    }

    /**
     * @return the cellRef
     */
    public String getCellRef() {
        return cellRef;
    }

    
    
}
