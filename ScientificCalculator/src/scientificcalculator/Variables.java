/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Andrea
 */
public class Variables{

    private HashMap<Character,ComplexNumber> variablesMap;
    private int size;

    /**
    * Costruisce un oggetto di tipo Variables.
    * Costruisce una HashMap e inizializza la dimensione dell'oggetto a 0.
    */
    public Variables(){
        this.variablesMap = new HashMap<>();
        this.size = 0;
    }

    /**
    * Restituisce la mappa delle variabili memorizzate.
    * @return   l'oggetto di tipo HashMap contenente le coppie (variabile, 
    *           valore)
    */
    public HashMap<Character, ComplexNumber> getVariablesMap(){
        return this.variablesMap;
    }

    /**
    * Restituisce la dimensione della mappa delle variabili.
    * @return   un numero intero che indica la dimensione della mappa delle 
    *           variabili
    */
    public int getSize(){
        return this.variablesMap.size();
    }

    /**
    * Inserisce un numero complesso in una variabile.
    * @param    character    l'oggetto di tipo Character che indica la variabile
    * @param    number       il ComplexNumber da associare alla variabile
    */
    public void insertVariable(Character character, ComplexNumber number){
        this.variablesMap.put(character, number);
    }

    /**
    * Restituisce il ComplexNumber associato ad una certa variabile.
    * @param    character   l'oggetto di tipo Character che indica la variabile
    * @return   il numero complesso associato alla variabile character in input
    */
    public ComplexNumber getValueFromVariable(Character character){
        return this.variablesMap.get(character);
    }

    /**
    * Restituisce tutte le associazioni variabile-valore sotto forma di stringa.
    * @return   una stringa che indica le associazioni variabile-valore separate
    *           da "\n"
    */
    @Override
    public String toString(){
        String s = "";
        for (Map.Entry<Character, ComplexNumber> entry : variablesMap.entrySet()){
            s += entry.getKey() + " = " + entry.getValue() + "\n";
        }
        return s;
    }
    
}
