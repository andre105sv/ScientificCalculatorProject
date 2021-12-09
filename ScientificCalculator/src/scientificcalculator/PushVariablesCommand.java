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
public class PushVariablesCommand extends VariablesStackCommand{

     /**
    * Crea un oggetto della classe PushVariablesCommand, che permette di effettuare le operazioni di inserimento e rimozione sullo stack che gli viene passato.
    * Setta l'attributo variablesStack
    * @param    variablesStack    l'istanza di VariablesStack su cui il comando opera
    */
    public PushVariablesCommand(VariablesStack variablesStack) {
        super(variablesStack);
    }
    
    /**
    * esegue l'operazione di push sullo stack
    * @param variables un'istanza di Variables 
    * @return   null
    */
    @Override
    public Variables perform(Variables variables) {
        this.variablesStack.insertVariables(variables);
        return null;
    }

    /**
    * esegue l'operazione di pop (duale della push) sullo stack
    * @param variables un'istanza di Variables 
    * @return   lultima istana di Variables inserita 
    */
    @Override
    public Variables undo(Variables variables) {
       return this.variablesStack.removeLast();
    }
    
}
