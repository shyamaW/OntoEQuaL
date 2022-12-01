package com.ontoQual.Controllers;

import com.ontoQual.testCasesImp.DLDataLevelQueryGenerator;
import com.ontoQual.testCasesImp.DLExcelQueryTemplate;
import com.ontoQual.testCasesImp.DLQueryRegularExpressionHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author HP
 */
public class DLQueryGenerationController {
    CommonRegularExpressionHandler regExpressCheck = new CommonRegularExpressionHandler();
    DLDataLevelQueryGenerator dataLevelquery = new DLDataLevelQueryGenerator();
    
    public TestTemplate getPreProcessedDLQuery (DLExcelQueryTemplate rawQueryTemp) { // get each excel raw as an object
       TestTemplate DLtestCase = new TestTemplate();
       if (regExpressCheck.isVariablesContain(rawQueryTemp.getDlquery(),"&")) {
           DLtestCase.setDlQuery(dataLevelquery.dataLevelQueryManupulation(rawQueryTemp).getDLprocessedQuery());
           DLtestCase.setTestID(rawQueryTemp.getDlID());
           DLtestCase.setCellRef(rawQueryTemp.getCellRef());
        } else {
           System.out.println("Schema DL Query");
           DLtestCase.setDlQuery(rawQueryTemp.getDlquery());// set TestCases- DL
           DLtestCase.setTestID(rawQueryTemp.getDlID()); // set TestCases- ID
           DLtestCase.setCellRef(rawQueryTemp.getCellRef());
       }
       return DLtestCase;
    }
    
    
}
