/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontoQual.Controllers;

import java.util.regex.Pattern;

/**
 *
 * @author HP
 */
public class CommonRegularExpressionHandler {
    
    public boolean isVariablesContain (String DL, String pattern) {
        
        if (Pattern.compile(pattern).matcher(DL).find()) {
            
            return true;
        } else {
            return false;
        }
    }
}
