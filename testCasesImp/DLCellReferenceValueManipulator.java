/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.testCasesImp;

import com.ontoQual.Controllers.TestTemplate;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class DLCellReferenceValueManipulator {
    private DLQueryRegularExpressionHandler classTypeList =  new DLQueryRegularExpressionHandler();
    ArrayList<String> dl = new ArrayList<>();
    
    // return DL for Cell values A3 A5
    public ArrayList<String> getDLForReferenceValues (String DL, ArrayList<TestTemplate> testCases) {
        classTypeList.getdLCellReferenceID(DL);// get cell values A3, A5
        return null;
    }
}
