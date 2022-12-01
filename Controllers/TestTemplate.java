/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.Controllers;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class TestTemplate {
    private String testID = null;
    private String dlQuery = null;
    private ArrayList<String> precondition = null;
    private ArrayList<String> testInput = null;
    private ArrayList<String> expectedResult= null;
    private ArrayList<String> actualResultSuperClasses= null;
    private ArrayList<String> actualResultSubClasses = null;
    private ArrayList<String> actualResultEquivalentClasses = null;
    private ArrayList<String> actualResultIndividuals = null;
    private int status = 0; // Pass=2, Partially=1, Failed=0
    private boolean remark = false;
    private String testIDcellReference = "";
     private String cellRef = "";
    /**
     * @return the testID
     */
    public String getTestID() {
        return testID;
    }

    /**
     * @param testID the testID to set
     */
    public void setTestID(String testID) {
        this.testID = testID;
    }

    /**
     * @return the dlQuery
     */
    public String getDlQuery() {
        return dlQuery;
    }

    /**
     * @param dlQuery the dlQuery to set
     */
    public void setDlQuery(String dlQuery) {
        this.dlQuery = dlQuery;
    }

    /**
     * @return the precondition
     */
    public ArrayList<String> getPrecondition() {
        return precondition;
    }

    /**
     * @param precondition the precondition to set
     */
    public void setPrecondition(ArrayList<String> precondition) {
        this.precondition = precondition;
    }

    /**
     * @return the testInput
     */
    public ArrayList<String> getTestInput() {
        return testInput;
    }

    /**
     * @param testInput the testInput to set
     */
    public void setTestInput(ArrayList<String> testInput) {
        this.testInput = testInput;
    }

    /**
     * @return the expectedResult
     */
    public ArrayList<String> getExpectedResult() {
        return expectedResult;
    }

    /**
     * @param expectedResult the expectedResult to set
     */
    public void setExpectedResult(ArrayList<String> expectedResult) {
        this.expectedResult = expectedResult;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the remark
     */
    public boolean getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(boolean remark) {
        this.remark = remark;
    }

    /**
     * @return the actualResultSuperClasses
     */
    public ArrayList<String> getActualResultSuperClasses() {
        return actualResultSuperClasses;
    }

    /**
     * @param actualResultSuperClasses the actualResultSuperClasses to set
     */
    public void setActualResultSuperClasses(ArrayList<String> actualResultSuperClasses) {
        this.actualResultSuperClasses = actualResultSuperClasses;
    }

    /**
     * @return the actualResultSubClasses
     */
    public ArrayList<String> getActualResultSubClasses() {
        return actualResultSubClasses;
    }

    /**
     * @param actualResultSubClasses the actualResultSubClasses to set
     */
    public void setActualResultSubClasses(ArrayList<String> actualResultSubClasses) {
        this.actualResultSubClasses = actualResultSubClasses;
    }

    /**
     * @return the actualResultEquivalentClasses
     */
    public ArrayList<String> getActualResultEquivalentClasses() {
        return actualResultEquivalentClasses;
    }

    /**
     * @param actualResultEquivalentClasses the actualResultEquivalentClasses to set
     */
    public void setActualResultEquivalentClasses(ArrayList<String> actualResultEquivalentClasses) {
        this.actualResultEquivalentClasses = actualResultEquivalentClasses;
    }

    /**
     * @return the actualResultIndividuals
     */
    public ArrayList<String> getActualResultIndividuals() {
        return actualResultIndividuals;
    }

    /**
     * @param actualResultIndividuals the actualResultIndividuals to set
     */
    public void setActualResultIndividuals(ArrayList<String> actualResultIndividuals) {
        this.actualResultIndividuals = actualResultIndividuals;
    }

    /**
     * @return the testIDcellReference
     */
    public String getTestIDcellReference() {
        return testIDcellReference;
    }

    /**
     * @param testIDcellReference the testIDcellReference to set
     */
    public void setTestIDcellReference(String testIDcellReference) {
        this.testIDcellReference = testIDcellReference;
    }

    /**
     * @return the cellRef
     */
    public String getCellRef() {
        return cellRef;
    }

    /**
     * @param cellRef the cellRef to set
     */
    public void setCellRef(String cellRef) {
        this.cellRef = cellRef;
    }

    
         
}
