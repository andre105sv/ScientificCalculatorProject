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
 * @author anton
 */
public class VariablesStack{

    private List<Variables> stack;
    private int size;
    
    /**
    * Costruisce un oggetto di tipo VariablesStack inizializzando i suoi 
    * attributi. 
    * Lo stack è implementato con una LinkedList.
    */
    public VariablesStack(){
        this.stack = new LinkedList<>();
        this.size = 0;
    }
    
    /**
    * Inserisce un elemento in coda alla LinkedList (analogamente a ciò che 
    * avviene in uno stack).
    * @param    variables   l'oggetto Variables da inserire
    */
    public void insertVariables(Variables variables){
        this.stack.add(variables);
        this.size = this.stack.size();
    }
    
    /**
    * Restituisce il numero di elementi nello stack.
    * @return   il numero di elementi nello stack
    */
    public int getSize(){
        return this.size;
    }
    
    /**
    * Restituisce l'ultimo elemento inserito nello stack e lo rimuove.
    * @return   l'ultimo oggetto Variables inserito
    */
    public Variables removeLast(){
        Variables variables = this.stack.remove(this.stack.size() - 1);
        this.size = this.stack.size();
        return variables;
    }

}
