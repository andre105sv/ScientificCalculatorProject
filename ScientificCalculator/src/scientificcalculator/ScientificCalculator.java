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
    public static void main(String[] args) throws Exception{
        
        System.out.println("Progetto: ScientificCalculator");
        System.out.println("Versione: 1.5");
        
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);
        OperationFactory factory = new OperationFactory();

        ArithmeticalOperations addition = factory.getOperation("ADDITION", a, b);
        ComplexNumber res1 = addition.execute();
        System.out.println(res1.toString());

        ArithmeticalOperations subtraction = factory.getOperation("SUBTRACTION", a, b);
        ComplexNumber res2 = subtraction.execute();
        System.out.println(res2.toString());

        ArithmeticalOperations multiplication = factory.getOperation("MULTIPLICATION", a, b);
        ComplexNumber res3 = multiplication.execute();
        System.out.println(res3.toString());

        ArithmeticalOperations division = factory.getOperation("DIVISION", a, b);
        ComplexNumber res4 = division.execute();
        System.out.println(res4.toString());

    }

}
