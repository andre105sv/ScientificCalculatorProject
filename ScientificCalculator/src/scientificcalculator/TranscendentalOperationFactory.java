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
public class TranscendentalOperationFactory extends AbstractFactory{

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
    @Override
    public Operation getOperation(String operation, ComplexNumber firstOp, ComplexNumber secondOp, double decimals){
        if(operation.equalsIgnoreCase("POWER")){
            return new Power(firstOp, secondOp, decimals);
        }
        else{
            return null;
        }
    }

    /**
    * Restituisce un oggetto di tipo Operation su cui poter effettuare 
    * l'operazione specificata in input.
    * @param    operation   la stringa che indica l'operazione da effettuare
    * @param    operand     l'operando di tipo ComplexNumber
    * @param    decimals    il parametro di tipo double che indica la precisione
    *                       da utilizzare 
    * @return   un oggetto di tipo Operation su cui eseguire l'operazione 
    *           specificata
    */
    @Override
    public Operation getOperation(String operation, ComplexNumber operand, double decimals){
        if(operation.equalsIgnoreCase("MODULUS")){
            return new Modulus(operand, decimals);
        }
        else if(operation.equalsIgnoreCase("PHASE")){
            return new Phase(operand, decimals);
        }
        else if(operation.equalsIgnoreCase("EXPONENTIAL")){
            return new Exponential(operand, decimals);
        }
        else{
            return null;
        }
    }

}
