/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anton
 */
public class ScientificCalculator {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Progetto: ScientificCalculator ");
        System.out.println("Versione: 1.1");

        //+ 42 - 35j oppure 42 - 35j oppure - 42 - 35j oppure + 43 oppure - 34 oppure 56
        
        String s1 = "+ 42 - 35j";
        ComplexNumber c1 = new ComplexNumber(s1);
        System.out.println(c1.toString());
        
        String s2 = "42 - 35j";
        ComplexNumber c2 = new ComplexNumber(s2);
        System.out.println(c2.toString());
        
        String s3 = "- 42 - 35j";
        ComplexNumber c3 = new ComplexNumber(s3);
        System.out.println(c3.toString());
        
        String s4 = "+ 43";
        ComplexNumber c4 = new ComplexNumber(s4);
        System.out.println(c4.toString());
        
        String s5 = "- 34";
        ComplexNumber c5 = new ComplexNumber(s5);
        System.out.println(c5.toString());

        String s6 = "56";
        ComplexNumber c6 = new ComplexNumber(s6);
        System.out.println(c6.toString());

    }

}
