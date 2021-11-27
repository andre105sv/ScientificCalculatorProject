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
    
    /**
    * Restituisce un oggetto di tipo ArithmeticalOperations su cui poter 
    * effettuare l'operazione specificata in input.
    * @param    a   il primo operando di tipo ComplexNumber
    * @param    b   il secondo operando di tipo ComplexNumber
    * @return   un oggetto di tipo ArithmeticalOperations su cui eseguire la
    *           operazione specificata
    */
    public ArithmeticalOperations getOperation(String operation, ComplexNumber firstOp, ComplexNumber secondOp, double decimals){
        if(operation == null){
            return null;
        }
        else if(operation.equalsIgnoreCase("ADDITION")){
            return new Addition(firstOp, secondOp, decimals);
        }
        else if(operation.equalsIgnoreCase("SUBTRACTION")){
            return new Subtraction(firstOp, secondOp, decimals);
        }
        else if(operation.equalsIgnoreCase("MULTIPLICATION")){
            return new Multiplication(firstOp, secondOp, decimals);
        }
        else if(operation.equalsIgnoreCase("DIVISION")){
            return new Division(firstOp, secondOp, decimals);
        }
        else{
            return null;
        }
    }

    /**
    * Restituisce un oggetto di tipo ArithmeticalOperations su cui poter 
    * effettuare l'operazione specificata in input.
    * @param    operand     il primo operando di tipo ComplexNumber
    * @return   un oggetto di tipo ArithmeticalOperations su cui eseguire la
    *           operazione specificata
    */
    public ArithmeticalOperations getOperation(String operation, ComplexNumber operand, double decimals){
        if(operation == null){
            return null;
        }
        else if(operation.equalsIgnoreCase("SQUARE_ROOT")){
            return new SquareRoot(operand, decimals);
        }
        else if(operation.equalsIgnoreCase("REVERSAL_SIGN")){
            return new ReversalSign(operand, decimals);
        }
        else{
            return null;
        }
    }

}
