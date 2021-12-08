/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

/**
 *
 * @author Andrea
 */
public class ReversalSign implements ArithmeticalOperations{

    private ComplexNumber operand;
    private double decimals;

    /**
    * Costruisce un oggetto di tipo ReversalSign a partire da un numero 
    * complesso e dalla sua precisione.
    * @param    c       l'operando di tipo ComplexNumber
    * @param    dec     la precisione in formato double
    */
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
    public ComplexNumber[] execute(){
        return new ComplexNumber[]{new ComplexNumber(Math.round((-operand.getRealPart()) * decimals) / decimals, Math.round((-operand.getImmPart()) * decimals) / decimals)};
    }

}
