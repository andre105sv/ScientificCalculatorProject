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
    private double decimals;

    public Multiplication(ComplexNumber c1, ComplexNumber c2, double dec){
        this.firstOp = c1;
        this.secondOp = c2;
        this.decimals = dec;
    }

    /**
    * Restituisce il prodotto di due nomeri complessi o reali.
    * @return   l'oggetto di tipo ComplexNumber che si ottiene dal prodotto di 
    *           due numeri complessi o reali
    */
    @Override
    public ComplexNumber execute() throws Exception{
        ComplexNumber c = new ComplexNumber(((firstOp.getRealPart() * secondOp.getRealPart() - firstOp.getImmPart() * secondOp.getImmPart()) * decimals) / decimals, ((firstOp.getRealPart() * secondOp.getImmPart() + firstOp.getImmPart() * secondOp.getRealPart()) * decimals) / decimals);
        return c;
    }

    @Override
    public ComplexNumber[] executeSqrt() throws Exception{
        return null;
    }

}
