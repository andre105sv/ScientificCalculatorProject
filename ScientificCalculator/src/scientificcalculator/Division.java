/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.DivisionByZeroException;

/**
 *
 * @author splas
 */
public class Division implements ArithmeticalOperations{

    private ComplexNumber firstOp;
    private ComplexNumber secondOp;
    private double decimals;

    /**
    * Costruisce un oggetto di tipo Division a partire da due numeri complessi
    * e dalla loro precisione.
    * @param    c1      il dividendo di tipo ComplexNumber 
    * @param    c2      il divisore di tipo ComplexNumber
    * @param    dec     la precisione in formato double
    */
    public Division(ComplexNumber c1, ComplexNumber c2, double dec){
        this.firstOp = c1;
        this.secondOp = c2;
        this.decimals = dec;
    }

    /**
    * Restituisce il rapporto di due nomeri complessi o reali.
    * @throws   DivisionByZeroException   se viene diviso un numero per 0
    * @return   l'oggetto di tipo ComplexNumber che si ottiene dal rapporto tra 
    *           due numeri complessi o reali
    */
    @Override
    public ComplexNumber[] execute() throws DivisionByZeroException{
        if((secondOp.getRealPart() == 0) && (secondOp.getImmPart() == 0)){
            throw new DivisionByZeroException();
        }
        double quoz = Math.round(((firstOp.getRealPart() * secondOp.getRealPart() + firstOp.getImmPart() * secondOp.getImmPart()) / (Math.pow(secondOp.getRealPart(), 2) + Math.pow(secondOp.getImmPart(), 2))) * decimals) / decimals;
        double div =  Math.round(((firstOp.getImmPart() * secondOp.getRealPart() - firstOp.getRealPart() * secondOp.getImmPart()) / (Math.pow(secondOp.getRealPart(),2) + Math.pow(secondOp.getImmPart(), 2))) * decimals) / decimals;     
        return new ComplexNumber[]{new ComplexNumber(quoz, div)};
    }

   


}
