/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import java.lang.Exception;

/**
 *
 * @author splas
 */
public class Division implements ArithmeticalOperations{

    private ComplexNumber firstOp;
    private ComplexNumber secondOp;

    public Division(ComplexNumber c1, ComplexNumber c2){
        this.firstOp = c1;
        this.secondOp = c2;
    }

    @Override
    public ComplexNumber execute() throws Exception{
        if((secondOp.getRealPart() == 0) && (secondOp.getImmPart() == 0)){
            throw new Exception("Divisione per 0 non amessa");
        }
        ComplexNumber c = new ComplexNumber((firstOp.getRealPart() * secondOp.getRealPart() + firstOp.getImmPart() * secondOp.getImmPart()) / (Math.pow(secondOp.getRealPart(), 2) + Math.pow(secondOp.getImmPart(), 2)), (firstOp.getImmPart() * secondOp.getRealPart() - firstOp.getRealPart() * secondOp.getImmPart()) / (Math.pow(secondOp.getRealPart(),2) + Math.pow(secondOp.getImmPart(), 2)));
        return c;
    }

}
