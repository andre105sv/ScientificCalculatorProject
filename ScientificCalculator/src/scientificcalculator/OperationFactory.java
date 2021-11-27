/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

/**
 *
 * @author Andrea
 */
public class OperationFactory{
    
    public ArithmeticalOperations getOperation(String operation, ComplexNumber firstOp, ComplexNumber secondOp){
        if(operation == null){
            return null;
        }
        else if(operation.equalsIgnoreCase("ADDITION")){
            return new Addition(firstOp, secondOp);
        }
        else if(operation.equalsIgnoreCase("SUBTRACTION")){
            return new Subtraction(firstOp, secondOp);
        }
        else if(operation.equalsIgnoreCase("MULTIPLICATION")){
            return new Multiplication(firstOp, secondOp);
        }
        else if(operation.equalsIgnoreCase("DIVISION")){
            return new Division(firstOp, secondOp);
        }
        else{
            return null;
        }
    }

}
