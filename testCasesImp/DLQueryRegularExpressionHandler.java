/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.testCasesImp;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
public class DLQueryRegularExpressionHandler {
    private String query = "";
    private String variableID= "";
   
    
    public String dlQueryStatement (String DL,String type,String varInput) {
        String pattern = "&"+type;

        if (Pattern.compile(pattern).matcher(DL).find()) {
            System.out.println("pattern true");
            Matcher matcher = Pattern.compile(pattern).matcher(DL);
          //  System.out.println("test"+matcher.find());
                if (matcher.find())
                {
                   // System.out.println("xxxx: "+matcher.group());
                    query = DL.replaceAll(matcher.group(),varInput);
                   // System.out.println(query);                
                }
        }
//       System.out.println(this.getQuery().replaceAll("\\bVAR_X|VAR_Y|VAR_Z|VAR\\b", this.variableID));
        
        return query;
    }
    //used
    public ArrayList<String>  classTypeofDLReference (String DL) {
        ArrayList<String>  classType = new ArrayList<>();
        if (Pattern.compile("&").matcher(DL).find()) {
            
            Matcher matcher = Pattern.compile("&\\w+").matcher(DL);
                while (matcher.find())
                {
                   // System.out.println(matcher.group());
                    classType.add(matcher.group().substring(1));
                }
        }
//       System.out.println(this.getQuery().replaceAll("\\bVAR_X|VAR_Y|VAR_Z|VAR\\b", this.variableID));
        
        return classType;
    }

    // get the value to be replced in the DL type &Crop --> Potato
    public String getValueofType (String type,String inputValues) {
        String input = "";
        String inputVal = inputValues.replaceAll("\\s","");
        Matcher matcher = Pattern.compile(type).matcher(inputVal);
        boolean flag1 = matcher.find();
        if (flag1) {
           // System.out.println("into");
               Matcher matcherVal = Pattern.compile(":\\w+|:[\\@\\w+\\,]+").matcher(inputVal);
               boolean flag2 = matcherVal.find();
               //System.out.println(""+flag2);
               if (flag2) {
                    System.out.println(".............."+matcherVal.group());
                    input = matcherVal.group().substring(1);
                    System.out.println("---"+input);
               }
                }
        
        return input;
    }
    
    public ArrayList<String>  getdLCellReferenceID (String DL) {
        ArrayList<String>  cellRef = new ArrayList<>();
        if (Pattern.compile("@").matcher(DL).find()) {
            
            Matcher matcher = Pattern.compile("@\\w+").matcher(DL);
                while (matcher.find())
                {
                   // System.out.println(matcher.group());
                    cellRef.add(matcher.group().substring(1));
                }
        }
        return cellRef;
    }
    
    //used
//    public boolean isVariablesContain (String DL) {
//        
//        if (Pattern.compile("&").matcher(DL).find()) {
//            
//            return true;
//        } else {
//            return false;
//        }
//
//    }
    
    
}
