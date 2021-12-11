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
public abstract class VariablesStackCommand{

    protected VariablesStack variablesStack;
    
    /**
    * Costruttore della classe astratta VariablesStackCommand.
    * Setta l'attributo variablesStack 
    * @param    variablesStack    l'istanza di VariablesStack su cui il comando opera
    */
    public VariablesStackCommand(VariablesStack variablesStack) {
        this.variablesStack = variablesStack;
    }
    
    /**
    * Esegue una certa azione sullo stack.
    * @param    variables       un'istanza di Variables 
    * @return   un'istanza di Variables o null
    */
    public abstract Variables perform(Variables variables);
    
    /**
    * Esegue l'azione duale della perform() sullo stack.
    * @return   un'istanza di Variables o null
    */
    public abstract Variables undo(Variables variables);

}
