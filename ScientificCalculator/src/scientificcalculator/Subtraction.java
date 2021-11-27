/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import java.lang.Exception;

/**
 *
 * @author Andrea
 */
public class Subtraction implements ArithmeticalOperations{

    private ComplexNumber firstOp;
    private ComplexNumber secondOp;

    public Subtraction(ComplexNumber c1, ComplexNumber c2){
        this.firstOp = c1;
        this.secondOp = c2;
    }

    @Override
    public ComplexNumber execute() throws Exception{
        double realSum = firstOp.getRealPart() - secondOp.getRealPart();
        double immSum = firstOp.getImmPart() - secondOp.getImmPart();
        return new ComplexNumber(realSum, immSum);
    }
}
