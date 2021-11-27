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
public class Multiplication implements ArithmeticalOperations{

    private ComplexNumber firstOp;
    private ComplexNumber secondOp;

    public Multiplication(ComplexNumber c1, ComplexNumber c2){
        this.firstOp = c1;
        this.secondOp = c2;
    }

    @Override
    public ComplexNumber execute() throws Exception{
        ComplexNumber c = new ComplexNumber(firstOp.getRealPart() * secondOp.getRealPart() - firstOp.getImmPart() * secondOp.getImmPart(), firstOp.getRealPart() * secondOp.getImmPart() + firstOp.getImmPart() * secondOp.getRealPart());
        return c;
    }

}
