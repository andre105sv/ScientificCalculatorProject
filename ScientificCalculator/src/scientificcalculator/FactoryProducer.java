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

    public static AbstractFactory getFactory(boolean isArithmetical){
        if(isArithmetical){
            return new ArithmeticalOperationFactory();
        } 
        else{
            return new TranscendentalOperationFactory();
        }
    }

}
