/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.testCasesImp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author HP
 */
public class DLDataLevelQueryGenerator {
        
    private DLQueryRegularExpressionHandler classTypeList =  new DLQueryRegularExpressionHandler();
    
    public DLDataLevelRawTemplate dataLevelQueryManupulation (DLExcelQueryTemplate rawQueryTemp) {
        DLDataLevelRawTemplate dataLevelTemplate = new DLDataLevelRawTemplate();
        
            //get Classes Types refereed in the DL
            String DL = rawQueryTemp.getDlquery();
            ArrayList<String> DLTypes = classTypeList.classTypeofDLReference(DL);// checked Ex: &Crop --> [Crop, GrowingProblem]
            
            if (areDistinct(DLTypes) && isSizeEqual(DLTypes, rawQueryTemp.getInputValue())) {
                
            for (String s:DLTypes) {
                //get input value for S
                String val = "";
                for (String inputValue : rawQueryTemp.getInputValue()) {
                  val = classTypeList.getValueofType(s, inputValue);
                  System.out.println("testing......"+val);

                if (!val.equals("")) {
                    System.out.println("val not null");
                    DL = classTypeList.dlQueryStatement(DL,s,val);
                    System.out.println("DL processed: " +DL);
                    dataLevelTemplate.setDLprocessedQuery(classTypeList.dlQueryStatement(DL,s,val));
                }
                }
                
            }
            } else {
                System.out.println("inputs and DL variables are miss matched");
            }
        
//        dataLevelTemplate.setDLID(DLID);
//        
        return dataLevelTemplate;
    }
    
    public static boolean areDistinct(ArrayList<String> list)
    {
        // Set all array elements in a HashSet
        Set<String> str = new HashSet<String>(list);
 
        // check size of the array and set
        return (str.size() == list.size());
    }
    
    public static boolean isSizeEqual(ArrayList<String> list1,ArrayList<String> list2 )
    {
        // check the list size are equal
        return (list1.size() == list2.size());
    }
}
