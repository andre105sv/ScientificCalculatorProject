/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;
import java.util.*;
/**
 *
 * @author anton
 */
public class StackPrincipale {
    private List<ComplexNumber> stack;
    private int size;
    
    /**
    * Costruisce un oggetto di tipo StackPrincipale inizializzando i suoi 
    * attributi. Lo stack è implementato con una LinkedList.
    */
    public StackPrincipale(){
        this.stack = new LinkedList<>();
        this.size = this.stack.size();
    }

    /**
    * Inserisce un elemento in coda alla LinkedList (analogamente a ciò che 
    * avviene in uno stack).
    * @param    number   l'oggetto ComplexNumber da inserire
    */
    public void insertNumber(ComplexNumber number){
        this.stack.add(number);
        this.size = this.stack.size();
    }
    
    /**
    * Restituisce il numero di elementi nello stack.
    * @return       il numero di elementi nello stack
    */
    public int getSize(){
        return this.size;
    }
    
    /**
    * Restituisce l'ultimo elemento inserito nello stack e lo rimuove.
    * @return       l'ultimo oggetto ComplexNumber inserito
    */
    public ComplexNumber removeLastNumber(){
        ComplexNumber number = this.stack.remove(this.stack.size()-1);
        this.size = this.stack.size();
        return number;
    }
    

    

}
