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
public abstract class AbstractFactory{
    
    /**
    * Restituisce un oggetto di tipo Operation su cui poter effettuare 
    * l'operazione specificata in input.
    * @param    operation   la stringa che indica l'operazione da effettuare
    * @param    firstOp     il primo operando di tipo ComplexNumber
    * @param    secondOp    il secondo operando di tipo ComplexNumber
    * @param    decimals    il parametro di tipo double che indica la precisione
    *                       da utilizzare 
    * @return   un oggetto di tipo Operation su cui eseguire l'operazione 
    *           specificata
    */
    public abstract Operation getOperation(String operation, ComplexNumber firstOp, ComplexNumber secondOp, double decimals);
        
    /**
    * Restituisce un oggetto di tipo Operation su cui poter effettuare 
    * l'operazione specificata in input.
    * @param    operation   la stringa che indica l'operazione da effettuare
    * @param    operand     il primo operando di tipo ComplexNumber
    * @param    decimals    il parametro di tipo double che indica la precisione
    *                       da utilizzare 
    * @return   un oggetto di tipo Operation su cui eseguire l'operazione 
    *           specificata
    */
    public abstract Operation getOperation(String operation, ComplexNumber operand, double decimals);

}
