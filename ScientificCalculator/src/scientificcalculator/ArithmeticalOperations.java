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
public interface ArithmeticalOperations{

    /**
    * Restituisce un vettore di numeri complessi contenente il risultato della
    * operazione aritmetica.
    * @return   il vettore di ComplexNumber che si ottiene dal risultato della
    *           operazione aritmetica specificata
    */
    public ComplexNumber[] execute() throws Exception;

}
