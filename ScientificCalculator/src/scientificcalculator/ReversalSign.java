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
public class ReversalSign implements ArithmeticalOperations{

    private ComplexNumber operand;
    private double decimals;

    public ReversalSign(ComplexNumber c, double dec){
        this.operand = c;
        this.decimals = dec;
    }

    /**
    * Restituisce l'opposto di un numero complesso o reale.
    * @return   l'oggetto di tipo ComplexNumber che si ottiene invertendo il 
    *           segno di un numero complesso o reale
    */
    @Override
    public ComplexNumber execute() throws Exception{
        return new ComplexNumber(((-operand.getRealPart()) * decimals) / decimals, ((-operand.getImmPart()) * decimals) / decimals);
    }

    @Override
    public ComplexNumber[] executeSqrt() throws Exception{
        return null;
    }

}