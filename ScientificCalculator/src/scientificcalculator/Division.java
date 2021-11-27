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
    private double decimals;

    public Division(ComplexNumber c1, ComplexNumber c2, double dec){
        this.firstOp = c1;
        this.secondOp = c2;
        this.decimals = dec;
    }

    /**
    * Restituisce il rapporto di due nomeri complessi o reali.
    * @return   l'oggetto di tipo ComplexNumber che si ottiene dal rapporto tra 
    *           due numeri complessi o reali
    */
    @Override
    public ComplexNumber execute() throws Exception{
        if((secondOp.getRealPart() == 0) && (secondOp.getImmPart() == 0)){
            throw new Exception("Divisione per 0 non amessa");
        }
        ComplexNumber c = new ComplexNumber((((firstOp.getRealPart() * secondOp.getRealPart() + firstOp.getImmPart() * secondOp.getImmPart()) / (Math.pow(secondOp.getRealPart(), 2) + Math.pow(secondOp.getImmPart(), 2))) * decimals) / decimals, (((firstOp.getImmPart() * secondOp.getRealPart() - firstOp.getRealPart() * secondOp.getImmPart()) / (Math.pow(secondOp.getRealPart(),2) + Math.pow(secondOp.getImmPart(), 2))) * decimals) / decimals);
        return c;
    }

    @Override
    public ComplexNumber[] executeSqrt() throws Exception{
        return null;
    }


}
