/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.NotDefinedArgumentException;

/**
 *
 * @author Andrea
 */
public interface TranscendentalOperations {

    /**
    * Restituisce un vettore di numeri complessi contenente il risultato della
    * operazione trascendentale.
    * @return   il vettore di ComplexNumber che si ottiene dal risultato della
    *           operazione trascendentale specificata
    */
    public ComplexNumber[] execute() throws NotDefinedArgumentException;

}
