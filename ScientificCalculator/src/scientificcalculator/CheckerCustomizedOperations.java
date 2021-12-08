/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.NotDefinedOperationException;
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
public class CheckerCustomizedOperations {

    private Checker checkerOperation;

    public CheckerCustomizedOperations(){
        checkerOperation = new Checker();
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
            if((checkerOperation.isRealNumber(tmpArray[1])) || (checkerOperation.isComplexNumber(tmpArray[1]))){
                throw new NumberAsNameOperationException();
            }
            else if(checkerOperation.isOperation(customOperation, tmpArray[1])){
                throw new ExistentOperationException();
            }
            else{
                for(int k = 2; k < tmpArray.length; k++){
                    if((!checkerOperation.isOperation(customOperation, tmpArray[k])) && (!checkerOperation.isRealNumber(tmpArray[k])) && (!checkerOperation.isComplexNumber(tmpArray[k]))){
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
            if((checkerOperation.isRealNumber(tmpArray[2])) || (checkerOperation.isComplexNumber(tmpArray[2]))){
                throw new NumberAsNameOperationException();
            }
            else if(!checkerOperation.isCustomizedOperation(customOperation, tmpArray[1])){
                throw new NotExistentOperationException();
            }
            else if(tmpArray[1].equalsIgnoreCase(tmpArray[2])){
                throw new SameNameException();
            }
            else if(checkerOperation.isOperation(customOperation, tmpArray[2])){
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
                    if((!checkerOperation.isOperation(customOperation, tmpArray[k])) && (!checkerOperation.isRealNumber(tmpArray[k])) && (!checkerOperation.isComplexNumber(tmpArray[k]))){
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
