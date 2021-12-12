/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

/**
 *
 * @author anton
 */
public interface VariablesStackCommand{

    /**
    * Esegue una certa azione sullo stack.
    * @param    variables   un'istanza di Variables 
    * @return   un'istanza di Variables o null
    */
    public void perform();
    
    /**
    * Esegue l'azione duale della perform() sullo stack.
    * @return   un'istanza di Variables o null
    */
    public Variables undo();

}
