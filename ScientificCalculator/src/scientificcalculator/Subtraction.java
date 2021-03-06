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
public class Subtraction implements Operation{

    private ComplexNumber firstOp;
    private ComplexNumber secondOp;
    private double decimals;

    /**
    * Costruisce un oggetto di tipo Subtraction a partire da due numeri 
    * complessi e dalla loro precisione.
    * @param    c1      il minuendo di tipo ComplexNumber 
    * @param    c2      il sottraendo di tipo ComplexNumber
    * @param    dec     la precisione in formato double
    */
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
    public ComplexNumber[] execute(){
        double realSum = Math.round((firstOp.getRealPart() - secondOp.getRealPart()) * decimals) / decimals;
        double immSum = Math.round((firstOp.getImmPart() - secondOp.getImmPart()) * decimals) / decimals;
        return new ComplexNumber[]{new ComplexNumber(realSum, immSum)};
    }

}
