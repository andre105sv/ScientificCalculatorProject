/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class CommandExecutor{

    private List<VariablesStackCommand> stack;

    public CommandExecutor(){
        stack = new LinkedList<>();
    }
    
    /**
    * Aggiunge allo stack il comando da effettuare e lo esegue.
    * @param command 
    */
    public void perform(VariablesStackCommand command){
        this.stack.add(command);
        command.perform();
    }
    
    /**
    * Esegue l'undo dell'ultimo comando effettuato restituendo la precedente 
    * istanza di Variables.
    * @return      l'ultima istanza di variables
    */
    public Variables undoLast(){
        VariablesStackCommand last = this.stack.remove(this.stack.size() - 1);
        return last.undo();
    }

}
