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
public class FactoryProducer{

    /**
    * Restituisce la somma di due nomeri complessi o reali.
    * @param    isArithmetical      true se l'operazione che si desidera 
    *                               effettuale è di tipo aritmetico
    * @return   un oggetto della classe astratta AbstractFactory
    */
    public static AbstractFactory getFactory(boolean isArithmetical){
        if(isArithmetical){
            return new ArithmeticalOperationFactory();
        } 
        else{
            return new TranscendentalOperationFactory();
        }
    }

}
