/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import exceptions.NotDefinedArgumentException;

/**
 *
 * @author filso
 */
public class Modulus implements Operation{
    
    private ComplexNumber operand;
    private double decimals;

    /**
    * Costruisce un oggetto di tipo Modulus a partire da un numero complesso e 
    * dalla sua precisione.
    * @param    operand         l'operando di tipo ComplexNumber
    * @param    decimals        la precisione in formato double
    */
    public Modulus(ComplexNumber operand, double decimals){
        this.operand = operand;
        this.decimals = decimals;
    }

    /**
    * Restituisce il modulo di un numero complesso. 
    * @return   un array di ComplexNumber contenente il modulo del numero 
    *           complesso.
    */
    @Override
    public ComplexNumber[] execute() throws NotDefinedArgumentException{
        if((this.operand.getRealPart() == 0) && (this.operand.getImmPart() == 0)){
            throw new NotDefinedArgumentException();
        }
        double op1 = Math.round(Math.sqrt(Math.pow(operand.getRealPart(), 2) + Math.pow(operand.getImmPart(), 2)) * decimals) / decimals;
        return new ComplexNumber[]{new ComplexNumber(op1, 0)};
    }

}
