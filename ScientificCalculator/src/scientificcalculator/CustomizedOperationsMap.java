/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 *
 * @author Andrea
 */
public class CustomizedOperationsMap{

    private HashMap<String, String[]> customMap;
    private int size;

    /**
    * Costruisce un oggetto di tipo CustomizedOperationsMap.
    * Costruisce una HashMap e inizializza la dimensione dell'oggetto a 0.
    */
    public CustomizedOperationsMap(){
        this.customMap = new HashMap<>();
        this.size = 0;
    }

    /**
    * Restituisce la mappa delle coppie (alias, operazioni).
    * @return   l'oggetto di tipo HashMap contenente le coppie (alias, 
    *           operazioni)
    */
    public HashMap<String, String[]> getCustomizedOperationsMap(){
        return this.customMap;
    }

    /**
    * Restituisce la dimensione della mappa delle operazioni personalizzate.
    * @return   un numero intero che indica la dimensione della mappa delle 
    *           operazioni personalizzate
    */
    public int getSize(){
        return this.customMap.size();
    }

    /**
    * Associa un insieme di operazioni ad un'operazione personalizzata.
    * @param    operationName       l'alias dell'operazione personalizzata
    * @param    operationsArray     l'array contenente le operazioni da 
    *                               effettuare quando si esegue l'operazione
    *                               personalizzata
    */
    public void insertCustomOperation(String operationName, String[] operationsArray){
        this.customMap.put(operationName, operationsArray);
    }

    /**
    * Rinomina un'operazione personalizzata esistente.
    * @param    oldOperationName        l'alias dell'operazione personalizzata
    *                                   da sostituire
    * @param    newOperationName        l'alias della nuova operazione 
    *                                   personalizzata
    */
    public void renameCustomOperation(String oldOperationName, String newOperationName){
        String[] operationsArray = this.customMap.get(oldOperationName);
        this.customMap.remove(oldOperationName);
        this.customMap.put(newOperationName, operationsArray);
    }

    /**
    * Cancella un'operazione personalizzata esistente.
    * @param    operationName   l'alias dell'operazione personalizzata
    *                           da cancellare
    */
    public void deleteCustomOperation(String operationName){
        this.customMap.remove(operationName);
    }
    
    /**
    * Restituisce tutte le associazioni alias-operazioni sotto forma di stringa.
    * @return   una stringa che indica le associazioni alias-operazioni separate
    *           da "\n"
    */
    @Override
    public String toString(){
        String s = "";
        for(Map.Entry<String, String[]> entry : this.customMap.entrySet()){
            s += entry.getKey() + " = " + Arrays.toString(entry.getValue()) + "\n";
        }
        return s;
    }
    
}
