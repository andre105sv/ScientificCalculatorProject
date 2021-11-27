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

    private ComplexNumber firstOp;
    private ComplexNumber secondOp;
    
    public OperationFactory(ComplexNumber c1, ComplexNumber c2){
        this.firstOp = c1;
        this.secondOp = c2;
    }

    public ArithmeticalOperations getOperation(String operation){
        if(operation == null){
            return null;
        }
        else if(operation.equalsIgnoreCase("ADDITION")){
            return new Addition(firstOp, secondOp);
        }
        else{
            return null;
        }
    }


}
