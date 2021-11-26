/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author anton
 */
public class StackPrincipale {
    private List<ComplexNumber> stack;
    private int size;
    
//Crea l'oggetto StackPrincipale inizializzando i suoi attributi. Lo stack è implementato con una LinkedList
    public StackPrincipale(){
        this.stack = new LinkedList<>();
        this.size = this.stack.size();
    }

//Inserisce un elemento in coda alla LiskedList, in modo analogo a ciò che avverrebbe in uno stack    
    public void insertNumber(ComplexNumber number){
        this.stack.add(number);
        this.size=this.stack.size();
    }
    
//restituisce il numero di elementi nello stack
    public int getSize(){
        return this.size;
    }
    
    public ComplexNumber removeLastNumber(){
        ComplexNumber number = this.stack.remove(this.stack.size()-1);
        this.size=this.stack.size();
        return number;
    }

    public List<ComplexNumber> getFirst12Elements() {
        if (this.getSize()>=12)
            return this.stack.subList(this.getSize()-12,this.getSize());
        else
            return this.stack;
    }
    
    

}
