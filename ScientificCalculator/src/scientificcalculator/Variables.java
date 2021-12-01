/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author filso
 */
public class Variables{
    private HashMap<Character,ComplexNumber> variablesMap;

    public Variables(){
        this.variablesMap = new HashMap<>();
    }

    public HashMap<Character, ComplexNumber> getVariablesMap(){
        return this.variablesMap;
    }

    @Override
    public String toString(){
        String s = "";
        for (Map.Entry<Character, ComplexNumber> entry : variablesMap.entrySet()){
            s += entry.getKey() + " = " + entry.getValue() + "SPLITTA_QUA";
        }
        return s;
    }

    

    
}
