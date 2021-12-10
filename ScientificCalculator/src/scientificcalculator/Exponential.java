/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.DivisionByZeroException;
import exceptions.NotDefinedArgumentException;

/**
 *
 * @author anton
 */
public class Exponential implements TranscendentalOperations{
    private ComplexNumber operand;
    private double decimals;
    
    /**
    * Costruisce un oggetto di tipo Exponential a partire da un numero 
    * complesso e dalla sua precisione.
    * @param    operand       l'operando di tipo ComplexNumber
    * @param    decimals     la precisione in formato double
    */
    public Exponential(ComplexNumber operand, double decimals){
        this.operand = operand;
        this.decimals = decimals;
    }

    /**
    * Restituisce l'esponenziale di un numero complesso. 
    * @return   un array di ComplexNumber contenente l'esponenziale del numero complesso.
    */
    @Override
    public ComplexNumber[] execute(){
       double realPart = Math.exp(operand.getRealPart()) * Math.cos(operand.getImmPart());
       double immPart = Math.exp(operand.getRealPart()) * Math.sin(operand.getImmPart());
       ComplexNumber[] result = new ComplexNumber[1];
       result[0] = new ComplexNumber(realPart, immPart);
       return result;
    }
}
