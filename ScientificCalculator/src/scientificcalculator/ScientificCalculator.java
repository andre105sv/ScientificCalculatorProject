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
       System.out.println("Versione: 1.0");
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       String a="";
        try {
            System.out.println("Enter Input : ");
            a = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ScientificCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
       String b="4";
       String c="5j";
       double realpart=4;
       double immpart=5;
       
       ComplexNumberTest.sintassTest(a);
       ComplexNumberTest.sintassTest(b);
       ComplexNumberTest.sintassTest(c);
       ComplexNumberTest.sintassTest(realpart,immpart);
        
    }
    
}
