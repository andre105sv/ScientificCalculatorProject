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
public class PushVariablesCommand implements VariablesStackCommand{

    private VariablesStack variablesStack;
    private Variables variables;

    /**
    * Crea un oggetto della classe PushVariablesCommand, che permette di 
    * effettuare le operazioni di inserimento e rimozione sullo stack che 
    * gli viene passato.
    * Imposta l'attributo variablesStack.
    * @param    variablesStack  l'istanza di VariablesStack su cui il comando 
    *                           opera
    */
    public PushVariablesCommand(VariablesStack varStack, Variables var) {
        this.variablesStack = varStack;
        this.variables = var;
    }
    /**
    * Esegue l'operazione di push sullo stack.
    * @param    variables   un'istanza di Variables 
    * @return   null
    */
    @Override
    public void perform(){
        this.variablesStack.insertVariables(this.variables);
    }

    /**
    * Esegue l'operazione di pop (duale della push) sullo stack.
    * @param    variables   un'istanza di Variables 
    * @return   l'ultima istanza di Variables inserita 
    */
    @Override
    public Variables undo() {
       return this.variablesStack.removeLast();
    }
    
}
