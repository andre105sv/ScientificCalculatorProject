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
 * @author Andrea
 */
public class Power implements Operation{

    private ComplexNumber base, exponent;
    private double decimals;
    
    /**
    * Costruisce un oggetto di tipo Power a partire da un numero complesso come 
    * base, un numero complesso come esponente e dalla sua precisione.
    * @param    baseNumber      l'operando di tipo ComplexNumber
    * @param    expNumber       l'operando di tipo ComplexNumber
    * @param    decimals        la precisione in formato double
    */
    public Power(ComplexNumber baseNumber, ComplexNumber expNumber, double decimals){
        this.base = baseNumber;
        this.exponent = expNumber;
    }

    @Override
    public ComplexNumber[] execute() throws DivisionByZeroException, NotDefinedArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
