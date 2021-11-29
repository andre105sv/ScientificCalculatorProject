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
public class Addition implements ArithmeticalOperations{

    private ComplexNumber firstOp;
    private ComplexNumber secondOp;
    private double decimals;

    public Addition(ComplexNumber c1, ComplexNumber c2, double dec){
        this.firstOp = c1;
        this.secondOp = c2;
        this.decimals = dec;
    }

    /**
    * Restituisce la somma di due nomeri complessi o reali.
    * @return   l'oggetto di tipo ComplexNumber che si ottiene dalla somma di 
    *           due numeri complessi o reali
    */
    @Override
    public ComplexNumber[] execute() throws Exception{
        double realSum = firstOp.getRealPart() + secondOp.getRealPart();
        double immSum = firstOp.getImmPart() + secondOp.getImmPart();
        return new ComplexNumber[]{new ComplexNumber(Math.round(realSum* decimals) / decimals, Math.round(immSum * decimals) / decimals)};
    }

   

}
