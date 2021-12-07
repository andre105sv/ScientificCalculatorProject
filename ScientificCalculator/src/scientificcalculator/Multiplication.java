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

    /**
    * Costruisce un oggetto di tipo Multiplication a partire da due numeri 
    * complessi e dalla loro precisione.
    * @param    c1      il primo fattore di tipo ComplexNumber 
    * @param    c2      il secondo fattore di tipo ComplexNumber
    * @param    dec     la precisione in formato double
    */
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
    public ComplexNumber[] execute() throws Exception{
        double op1 = Math.round((firstOp.getRealPart() * secondOp.getRealPart() - firstOp.getImmPart() * secondOp.getImmPart()) * decimals) / decimals;
        double op2 = Math.round((firstOp.getRealPart() * secondOp.getImmPart() + firstOp.getImmPart() * secondOp.getRealPart()) * decimals) / decimals;
        return new ComplexNumber[]{new ComplexNumber(op1, op2)};
    }
}
