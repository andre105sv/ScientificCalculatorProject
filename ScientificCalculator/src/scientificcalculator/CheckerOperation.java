/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.NotDefinedNameOperationException;
import exceptions.NotDefinedValueOperationException;
import exceptions.NumberAsNameOperationException;
import exceptions.ExistentOperationException;
import exceptions.NotCorrectValueOperationException;
import exceptions.BlankSpaceStringException;
import exceptions.NotExistentOperationException;
import exceptions.SameNameException;
import java.util.Arrays;

/**
 *
 * @author Andrea
 */
public class CheckerOperation{

    private CheckerComplexNumber checker;

    public CheckerOperation(double dec){
        checker = new CheckerComplexNumber(dec);
    }

    /**
    * Restituisce "true" se la stringa specificata in input indica un'operazione
    * di tipo aritmetico ("+", "-", "*", "/", "sqrt", "+-").
    * @param    op      la stringa che identifica l'operazione
    * @return   true    se l'operazione specificata in input è di tipo 
    *                   aritmetico
    */
    private boolean isArithmeticalOperation(String op){
        if((op.equals("+")) || (op.equals("-")) || (op.equals("*")) || (op.equals("/")) || (op.equals("+-"))){
            return true;
        }
        if((op.equalsIgnoreCase("sqrt"))){
            return true;
        }
        return false;
    }

    /**
    * Restituisce "true" se la stringa specificata in input indica un'operazione
    * di tipo trascendentale ("mod", "arg", "exp").
    * @param    op      la stringa che identifica l'operazione
    * @return   true    se l'operazione specificata in input è di tipo 
    *                   trascendentale
    */
    private boolean isTranscendentalOperation(String op){
        if((op.equals("mod")) || (op.equals("arg")) || (op.equals("exp"))){
            return true;
        }
        return false;
    }

    /**
    * Restituisce "true" se la stringa specificata in input indica un'operazione
    * che lavora sullo stack ("clear", "dup", "drop", "swap", "over").
    * @param    op      la stringa che identifica l'operazione
    * @return   true    se l'operazione specificata in input lavora sullo 
    *                   stack
    */
    private boolean isStackOperation(String op){
        if((op.equalsIgnoreCase("drop")) || (op.equalsIgnoreCase("dup")) || (op.equalsIgnoreCase("swap")) || (op.equalsIgnoreCase("over")) || (op.equalsIgnoreCase("clear"))){
            return true;
        }
        if((op.equalsIgnoreCase("save") || (op.equalsIgnoreCase("restore")))){
            return true;
        }
        return false;
    }

    /**
    * Restituisce "true" se la stringa specificata in input indica un'operazione
    * che lavora con le variabili (">a", "<a", "+a", "-a").
    * @param    op      la stringa che identifica l'operazione
    * @return   true    se l'operazione specificata in input lavora con le 
    *                   variabili
    */
    private boolean isOperationWithVariables(String op){
        if((op.length() == 2) && (op.charAt(0) == '>') && ((int)op.charAt(1) > 96) && ((int)op.charAt(1) < 123)){
            return true;
        }
        if((op.length() == 2) && (op.charAt(0) == '<') && ((int)op.charAt(1) > 96) && ((int)op.charAt(1) < 123)){
            return true;
        }
        if((op.length() == 2) && (op.charAt(0) == '+') && ((int)op.charAt(1) > 96) && ((int)op.charAt(1) < 123)){
            return true;
        }
        if((op.length() == 2) && (op.charAt(0) == '-') && ((int)op.charAt(1) > 96) && ((int)op.charAt(1) < 123)){
            return true;
        }
        return false;
    }

    /**
    * Restituisce "true" se la stringa specificata in input indica un'operazione
    * di tipo personalizzato.
    * @param    op      la stringa che identifica l'operazione
    * @return   true    se l'operazione specificata in input è di tipo 
    *                   personalizzato
    */
    private boolean isCustomizedOperation(CustomizedOperationsMap customOperation, String op){
        if(customOperation.getCustomizedOperationsMap().containsKey(op)){
            return true;
        }
        return false;
    }

    /**
    * Restituisce "true" se la stringa specificata in input è un'operazione.
    * @param    op      la stringa che identifica l'operazione
    * @return   true    se la stringa specificata in input è un'operazione
    */
    private boolean isOperation(CustomizedOperationsMap customOperation, String operationString){
        if(this.isArithmeticalOperation(operationString)){
            return true;
        }
        if(this.isStackOperation(operationString)){
            return true;
        }
        if(this.isCustomizedOperation(customOperation, operationString)){
            return true;
        }
        if(this.isOperationWithVariables(operationString)){
            return true;
        }
        if(this.isTranscendentalOperation(operationString)){
            return true;
        }
        return false;
    }

    /**
    * Effettua una verifica del comando "create" e restituisce un array di 
    * stringhe contenente i parametri per la creazione di una operazione
    * personalizzata.
    * @param    customOperation     l'oggetto di tipo CustomizedOperationsMap
    *                               che contiene le operazioni personalizzate
    *                               sinora memorizzate
    * @param    commandString   la stringa che identifica il comando "create", 
    *                           il nome dell'operazione personalizzata e la sua
    *                           definizione
    * @return   un array di stringhe contenente i parametri per creare una
    *           operazione personalizzata
    */
    public String[] checkCreateOperation(CustomizedOperationsMap customOperation, String commandString) throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        String[] tmpArray = commandString.split("\\s+");
        if(tmpArray.length == 1){
            throw new NotDefinedNameOperationException();     
        }
        else if(tmpArray.length == 2){
            throw new NotDefinedValueOperationException();
        }
        else{
            if((checker.isSingleNumber(tmpArray[1])) || (checker.isCartesianComplexNumber(tmpArray[1]))){
                throw new NumberAsNameOperationException();
            }
            else if(this.isOperation(customOperation, tmpArray[1])){
                throw new ExistentOperationException();
            }
            else{
                for(int k = 2; k < tmpArray.length; k++){
                    if((!this.isOperation(customOperation, tmpArray[k])) && (!checker.isSingleNumber(tmpArray[k])) && (!checker.isCartesianComplexNumber(tmpArray[k]))){
                        throw new NotCorrectValueOperationException();
                    }
                }
                return Arrays.copyOfRange(tmpArray, 1, tmpArray.length);
            }
        }
    }
        
    /**
    * Effettua una verifica del comando "rename" e restituisce un array di 
    * stringhe contenente i parametri per la ridenominazione di una operazione 
    * personalizzata.
    * @param    customOperation     l'oggetto di tipo CustomizedOperationsMap
    *                               che contiene le operazioni personalizzate
    *                               sinora memorizzate
    * @param    commandString   la stringa che identifica il comando "rename", 
    *                           il vecchio nome dell'operazione personalizzata 
    *                           e il rispettivo nuovo nome
    * @return   un array di stringhe contenente i parametri per rinominare una
    *           operazione personalizzata
    */
    public String[] checkRenameOperation(CustomizedOperationsMap customOperation, String commandString) throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        String[] tmpArray = commandString.split("\\s+");
        if(tmpArray.length == 1){
            throw new NotDefinedNameOperationException();   
        }
        else if(tmpArray.length == 2){
            throw new NotDefinedValueOperationException();
        }
        else if(tmpArray.length > 3){
            throw new BlankSpaceStringException();
        }
        else{
            if((checker.isSingleNumber(tmpArray[2])) || (checker.isCartesianComplexNumber(tmpArray[2]))){
                throw new NumberAsNameOperationException();
            }
            else if(!this.isCustomizedOperation(customOperation, tmpArray[1])){
                throw new NotExistentOperationException();
            }
            else if(tmpArray[1].equalsIgnoreCase(tmpArray[2])){
                throw new SameNameException();
            }
            else if(this.isOperation(customOperation, tmpArray[2])){
                throw new ExistentOperationException();
            }
            else{
                return new String[]{tmpArray[1], tmpArray[2]};
            }
        }
    }

    /**
    * Effettua una verifica del comando "set" e restituisce un array di stringhe
    * contenente i parametri per la ridefinizione di un'operazione
    * personalizzata.
    * @param    customOperation     l'oggetto di tipo CustomizedOperationsMap
    *                               che contiene le operazioni personalizzate
    *                               sinora memorizzate
    * @param    commandString   la stringa che identifica il comando "set", 
    *                           il nome dell'operazione personalizzata e la sua
    *                           nuova definizione
    * @return   un array di stringhe contenente i parametri per ridefinire una
    *           operazione personalizzata
    */
    public String[] checkSetOperation(CustomizedOperationsMap customOperation, String commandString) throws NotDefinedNameOperationException, NotDefinedValueOperationException, NotExistentOperationException, NotCorrectValueOperationException{
        String[] tmpArray = commandString.split("\\s+");
        if(tmpArray.length == 1){
            throw new NotDefinedNameOperationException();   
        }
        else if(tmpArray.length == 2){
            throw new NotDefinedValueOperationException();
        }
        else{
            if(!customOperation.getCustomizedOperationsMap().containsKey(tmpArray[1])){
                throw new NotExistentOperationException();
            }
            else{
                for(int k = 2; k < tmpArray.length; k++){
                    if((!this.isOperation(customOperation, tmpArray[k])) && (!checker.isSingleNumber(tmpArray[k])) && (!checker.isCartesianComplexNumber(tmpArray[k]))){
                        throw new NotCorrectValueOperationException();
                    }
                }
                return Arrays.copyOfRange(tmpArray, 1, tmpArray.length);
            }
        }
    }

    /**
    * Effettua una verifica del comando "delete" e restituisce il nome 
    * dell'operazione da cancellare.
    * @param    customOperation     l'oggetto di tipo CustomizedOperationsMap
    *                               che contiene le operazioni personalizzate
    *                               sinora memorizzate
    * @param    commandString   la stringa che identifica il comando "delete" e
    *                           il nome dell'operazione personalizzata da 
    *                           eliminare
    * @return   il nome dell'operazione da cancellare
    */
    public String checkDeleteOperation(CustomizedOperationsMap customOperation, String commandString) throws NotDefinedNameOperationException, BlankSpaceStringException, NotExistentOperationException{
        String[] tmpArray = commandString.split("\\s+");
        if(tmpArray.length == 1){
            throw new NotDefinedNameOperationException();  
        }
        else if(tmpArray.length > 2){
            throw new BlankSpaceStringException();
        }
        else{
            if(!customOperation.getCustomizedOperationsMap().containsKey(tmpArray[1])){
                throw new NotExistentOperationException();
            }
            else{
                return tmpArray[1];
            }
        }
    }

}
