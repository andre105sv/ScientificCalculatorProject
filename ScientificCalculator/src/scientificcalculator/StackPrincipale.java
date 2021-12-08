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
public class StackPrincipale{

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
    * @return   il numero di elementi nello stack
    */
    public int getSize(){
        return this.size;
    }
    
    /**
    * Restituisce l'ultimo elemento inserito nello stack e lo rimuove.
    * @return   l'ultimo oggetto ComplexNumber inserito
    */
    public ComplexNumber removeLastNumber(){
        ComplexNumber number = this.stack.remove(this.stack.size() - 1);
        this.size = this.stack.size();
        return number;
    }

    /**
    * Restituisce una lista di ComplexNumber formata dagli ultimi 12 elementi 
    * inseriti nella list stack.
    * Se la lista stack ha meno di 12 elementi la restituisce per intero.
    * @return   gli ultimi elementi presenti nello stack
    */
    public List<ComplexNumber> getFirst12Elements(){
        if (this.getSize() >= 12){
            return this.stack.subList(this.getSize() - 12, this.getSize());
        }
        else{
            return this.stack;
        }
    }
    
    /**
    * Scambia di posto gli ultimi due elementi inseriti nello stack.
    * Se lo stack ha meno di 2 elementi non esegue nessuna operazione.
    */
    public void swap(){
        if(this.getSize() > 1){
            ComplexNumber tmp1 = this.removeLastNumber();
            ComplexNumber tmp2 = this.removeLastNumber();
            this.insertNumber(tmp1);
            this.insertNumber(tmp2);
        }
    }
    
     /**
    * Inserisce nello stack il penultimo elemento precedentemente inserito.
    * Se lo stack ha meno di 2 element1 non esegue nessuna operazione.
    */
    public void over(){
        if(this.getSize() > 1){
            ComplexNumber tmp1 = this.removeLastNumber();
            ComplexNumber tmp2 = this.removeLastNumber();
            this.insertNumber(tmp2);
            this.insertNumber(tmp1);
            this.insertNumber(tmp2);
        }
    }
    
     /**
    * Reinserisce l'ultimo elemento inserito nello stack.
    * Se lo stack ha meno di 1 elemento non esegue nessuna operazione.
    */
    public void dup(){
        if(this.getSize() > 0){
            ComplexNumber tmp1 = this.removeLastNumber();
            this.insertNumber(tmp1);
            this.insertNumber(tmp1);
        }
    }

    /**
    * Rimuove tutti gli elementi presenti nello stack.
    * Lo stack sarà vuoto al termine dell'esecuzione del metodo.
    */
    public void clear(){
        this.stack.clear();
        this.size = this.stack.size();
    }

}
