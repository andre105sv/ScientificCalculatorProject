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
public class Exponential implements ArithmeticalOperations{
    private ComplexNumber operand;

    public Exponential(ComplexNumber operand){
        this.operand = operand;
        
    }

    @Override
    public ComplexNumber[] execute() throws DivisionByZeroException, NotDefinedArgumentException{
       double realPart = Math.exp(operand.getRealPart()) * Math.cos(operand.getImmPart());
       double immPart = Math.exp(operand.getRealPart()) * Math.sin(operand.getImmPart());
       ComplexNumber[] result = new ComplexNumber[1];
       result[0] = new ComplexNumber(realPart, immPart);
       return result;
    }
}
