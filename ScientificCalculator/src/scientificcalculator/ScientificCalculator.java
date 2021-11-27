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
        
        System.out.println("Progetto: ScientificCalculator");
        System.out.println("Versione: 1.4");
        
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);
        OperationFactory factory = new OperationFactory(a, b);

        ArithmeticalOperations addition = factory.getOperation("ADDITION");
        ComplexNumber res = addition.execute();
        System.out.println(res.toString());

    }

}
