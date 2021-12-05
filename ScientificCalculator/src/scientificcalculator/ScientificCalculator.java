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

    static double DECIMAL_NUMBERS = 1000.0;
    static StackPrincipale stack = new StackPrincipale();
    static DupCommand dup = new DupCommand(stack); 
    static OverCommand over = new OverCommand(stack); 
    static SwapCommand swap = new SwapCommand(stack); 
    static DropCommand drop = new DropCommand(stack); 

    public static void runOperation(String singleOp) throws Exception{
        OperationFactory factory = new OperationFactory();
        if(stack.getSize() > 0){
            if(singleOp.equals("sqrt")){
                ArithmeticalOperations squareRoot = factory.getOperation("SQUARE_ROOT", stack.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = squareRoot.execute(); 
                for(ComplexNumber c : result)
                    stack.insertNumber(c);
            }
            else if(singleOp.equals("+-")){
                ArithmeticalOperations reverse = factory.getOperation("REVERSAL_SIGN", stack.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = reverse.execute();
                stack.insertNumber(result[0]);
            }
            else if(singleOp.equalsIgnoreCase("dup")){
                dup.perform();
            }
            else if(singleOp.equalsIgnoreCase("drop")){
                drop.perform();
            }
        }
        if(stack.getSize() > 1){
            if(singleOp.equals("+")){
                ArithmeticalOperations addition = factory.getOperation("ADDITION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = addition.execute();
                stack.insertNumber(result[0]);
            }
            else if(singleOp.equals("-")){
                ArithmeticalOperations subtraction = factory.getOperation("SUBTRACTION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = subtraction.execute();
                stack.insertNumber(result[0]);
            }
            else if(singleOp.equals("*")){
                ArithmeticalOperations multiplication = factory.getOperation("MULTIPLICATION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = multiplication.execute();
                stack.insertNumber(result[0]);
            }
            else if(singleOp.equals("/")){
                ArithmeticalOperations division = factory.getOperation("DIVISION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = division.execute();
                stack.insertNumber(result[0]);
            }
            else if(singleOp.equalsIgnoreCase("swap")){
                swap.perform();
            }
            else if(singleOp.equalsIgnoreCase("over")){
                over.perform();
            }
        }
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        System.out.println("Progetto: ScientificCalculator");
        System.out.println("Versione: 2.0");

    }

}
