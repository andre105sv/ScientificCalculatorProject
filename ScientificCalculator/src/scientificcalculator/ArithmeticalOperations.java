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
public interface ArithmeticalOperations{

    /**
    * Restituisce un vettore di numeri complessi contenente il risultato della
    * operazione aritmetica.
    * @throws   DivisionByZeroException   se viene diviso un numero per 0  
    * @throws   NotDefinedArgumentException   se viene calcolata la radice 
    *                                         quadrata di 0
    * @return   il vettore di ComplexNumber che si ottiene dal risultato della
    *           operazione aritmetica specificata
    */
    public ComplexNumber[] execute() throws DivisionByZeroException, NotDefinedArgumentException;

}
