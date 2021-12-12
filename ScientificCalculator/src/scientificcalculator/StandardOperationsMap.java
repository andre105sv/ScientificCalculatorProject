/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Andrea
 */
public class StandardOperationsMap{

    private HashMap<String, String> stdOperationsMap;

    /**
    * Costruisce un oggetto di tipo StandardOperationsMap.
    * Costruisce una HashMap e inizializza la dimensione dell'oggetto a 0.
    */
    public StandardOperationsMap(){
        this.stdOperationsMap = new HashMap<>();
        this.insertStdOperation("+", "Calculates the sum of the last two elements of the stack.");
        this.insertStdOperation("-", "Calculates the difference between the last number and the second last one.");
        this.insertStdOperation("*", "Calculates the multiplication of the last two elements of the stack.");
        this.insertStdOperation("/", "Calculates the division between the last number and the second last one.");
        this.insertStdOperation("+-", "Calculates the inverse number of the last element of the stack.");
        this.insertStdOperation(">x", "Sets the last element of the stack as value of the variable 'x' only if 'x' respect the syntax.\nRemoves the last element from the stack.\nAll the variables must be in lowercase.\n'x' is a generic letter from 'a' to 'z'.");
        this.insertStdOperation("<x", "Inserts the value of 'x' onto the stack deleting the variables used.");
        this.insertStdOperation("+x", "Calculates the sum between the last element of the stack and the value of the variable 'x'.\nRemoves the last element from the stack.\nSaves the result onto the stack.");
        this.insertStdOperation("-x", "Calculates the difference between the last element of the stack and the value of the variable 'x'.\nRemoves the last element from the stack.\nSaves the result onto the stack.");
        this.insertStdOperation("ARG", "Calculates the argument (phase) of the last element onto the stack.");
        this.insertStdOperation("CLEAR", "Removes all the elements from the stack.");
        String createDescription = "Creates an user-defined operation specifying a name and a sequence of operations including the push of numbers.\n";
        createDescription += "The user-defined operation may contain other user-defined operation.\n";
        createDescription += "When the user-defined operation is invoked, all the operations in the sequence are executed in order.\n";
        createDescription += "All the words are NOT case sensitive.\n";
        createDescription += "The format is the following:\n\n\n";
        createDescription += "  es.    CREATE    HYPOTENUSE    DUP * SWAP DUP * + SQRT";
        this.insertStdOperation("CREATE", createDescription);
        String deleteDescription = "Deletes an user-defined operation specifying its name.\n";
        deleteDescription += "All the words are NOT case sensitive.\n";
        deleteDescription += "The format is the following:\n\n\n";
        deleteDescription += "  es.    DELETE    HYPOTENUSE";
        this.insertStdOperation("DELETE", deleteDescription);
        this.insertStdOperation("DROP", "Removes the last element from the stack.");
        this.insertStdOperation("DUP", "Pushes a copy of the last element onto the stack.");
        this.insertStdOperation("EXP", "Calculates the exponential of the last element onto the stack and pushes the result onto it.");
        this.insertStdOperation("MOD", "Calculates the modulus of the last element onto the stack and pushes the result onto it.");
        this.insertStdOperation("OVER", "Pushes a copy of the second last element onto the stack.");
        String renameDescription = "Renames an user-defined operation specifying its name and its new name.\n";
        renameDescription += "All the words are NOT case sensitive.\n";
        renameDescription += "The format is the following:\n\n\n";
        renameDescription += "  es.    RENAME    OLDNAME    NEWNAME";
        this.insertStdOperation("RENAME", renameDescription);
        this.insertStdOperation("RESTORE", "Restores for all variables the last values that were saved on the 'variable stack'.\nThe restored variables are removed from that stack.");
        this.insertStdOperation("SAVE", "Saves a copy of all the variables on a 'variable stack'.\nThis 'variable stack' is distinct from the stack used for the operands by the operations.");
        String setDescription = "Modifies the definition of an user-defined operation specifying its name and its new definition.\n";
        setDescription += "All the words are NOT case sensitive.\n";
        setDescription += "The format is the following:\n\n\n";
        setDescription += "  es.    SET    OPNAME    dup + swap";
        this.insertStdOperation("SET", setDescription);
        this.insertStdOperation("SQRT", "Calculates the square root of the last element onto the stack and pushes the result onto it.");
        this.insertStdOperation("SWAP", "Exchanges the last two elements added onto the stack.");    
    }

    /**
    * Inserisce un'operazione standard in una map.
    * @param    character    l'oggetto di tipo Character che indica la variabile
    * @param    number       il ComplexNumber da associare alla variabile
    */
    private void insertStdOperation(String name, String description){
        this.stdOperationsMap.put(name, description);
    }

    /**
    * Restituisce la descrizione associata ad una certa operazione.
    * @param    name   l'oggetto di tipo Character che indica la variabile
    * @return   il numero complesso associato alla variabile character in input
    */
    public String getDescription(String name){
        return this.stdOperationsMap.get(name);
    }

    /**
    * Restituisce tutte le associazioni nome-descrizione sotto forma di stringa.
    * @return   una stringa che indica le associazioni nome-descrizione separate
    *           da "\n"
    */
    @Override
    public String toString(){
        String s = "";
        for (Map.Entry<String, String> entry : stdOperationsMap.entrySet()){
            s += entry.getKey() + "\n";
        }
        return s;
    }

}
