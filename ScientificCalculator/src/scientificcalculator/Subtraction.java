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
    private double decimals;

    public Subtraction(ComplexNumber c1, ComplexNumber c2, double dec){
        this.firstOp = c1;
        this.secondOp = c2;
        this.decimals = dec;
    }
    
    /**
    * Restituisce il rapporto di due nomeri complessi o reali.
    * @return   l'oggetto di tipo ComplexNumber che si ottiene dalla differenza 
    *           tra due numeri complessi o reali
    */
    @Override
    public ComplexNumber execute() throws Exception{
        double realSum = ((firstOp.getRealPart() - secondOp.getRealPart()) * decimals) / decimals;
        double immSum = ((firstOp.getImmPart() - secondOp.getImmPart()) * decimals) / decimals;
        return new ComplexNumber(realSum, immSum);
    }

    @Override
    public ComplexNumber[] executeSqrt() throws Exception{
        return null;
    }

}
