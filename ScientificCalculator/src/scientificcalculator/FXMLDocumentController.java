/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import exceptions.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


/**
 * FXML Controller class
 *
 * @author group_6
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField input;
    private final double DECIMAL_NUMBERS = 1000.0;
    private final int MAX_VIEW_SIZE = 12;
    private StackPrincipale stack;
    @FXML
    private Button insertBtn;
    private Button deleteBtn;
    private Button clearBtn;
    @FXML
    private ListView<ComplexNumber> elementiStack;
    private ObservableList<ComplexNumber> obList; 
    private ObservableList<String> obVariables;
    private DropCommand drop; //oggetto che esegue tutte le drop su stackPrincipale
    private ClearCommand clear;// -- tutte le clear
    private DupCommand dup;// -- tutte le dup
    private SwapCommand swap;// -- tutte le swap
    private OverCommand over;// -- tutte le over
    private Variables variables;
    private VariablesStack variablesStack;
    private CustomizedOperationsMap customizedOperations;
    private OperationFactory factory;
    private Checker checker;
    @FXML
    private ListView<String> listVariables;

    /**
    * Inserisce nello stack un numero indicato come reale o complesso.
    * @param    singleOp    la stringa che identifica un numero complesso o 
    *                       reale da inserire nello stack
    */
    private void runPushOperation(String singleOp){
        if(checker.isComplexNumber(singleOp)){
            ComplexNumber zComplex = checker.createFromComplexNumber(singleOp);
            stack.insertNumber(zComplex);
        }
        else if(checker.isRealNumber(singleOp)){
            ComplexNumber zReal = checker.createFromSingleNumber(singleOp);
            stack.insertNumber(zReal);
        }
    }

    /**
    * Inserisce nello stack il risultato dell'operazione aritmetica specificata
    * in input ("ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION", 
    * "SQUARE_ROOT", "REVERSAL_SIGN").
    * @param    singleOp    la stringa che identifica l'operazione aritmetica
    *                       da eseguire
    */
    private void runArithmeticalOperation(String singleOp){
        try{
            if(stack.getSize() > 0){
                if(singleOp.equals("sqrt")){
                    ArithmeticalOperations squareRoot = factory.getOperation("SQUARE_ROOT", stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = squareRoot.execute(); 
                    for(ComplexNumber c : result)
                        stack.insertNumber(c);
                }
                else if(singleOp.equals("+-")){
                    ArithmeticalOperations reverse = factory.getOperation("REVERSAL_SIGN", stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = reverse.execute();
                    stack.insertNumber(result[0]);
                }
            }
            if(stack.getSize() > 1){
                if(singleOp.equals("+")){
                    ArithmeticalOperations addition = factory.getOperation("ADDITION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = addition.execute();
                    stack.insertNumber(result[0]);
                }
                else if(singleOp.equals("-")){
                    ArithmeticalOperations subtraction = factory.getOperation("SUBTRACTION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = subtraction.execute();
                    stack.insertNumber(result[0]);
                }
                else if(singleOp.equals("*")){
                    ArithmeticalOperations multiplication = factory.getOperation("MULTIPLICATION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = multiplication.execute();
                    stack.insertNumber(result[0]);
                }
                else if(singleOp.equals("/")){
                    ArithmeticalOperations division = factory.getOperation("DIVISION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = division.execute();
                    stack.insertNumber(result[0]);
                }
            }
        }
        catch(DivisionByZeroException ex){
            System.out.println("Non è possibile dividere un numero per zero.");
        }
        catch(NotDefinedArgumentException ex){
            System.out.println("La radice quadrata di 0 non è definita.");
        }
    }

    /**
    * Esegue l'operazione sullo stack specificata in input ("clear", "dup", 
    * "drop", "swap", "over").
    * @param    singleOp    la stringa che identifica un'operazione che lavora
    *                       sullo stack
    */
    private void runStackOperation(String singleOp){
        if(singleOp.equalsIgnoreCase("clear")){
            clear.perform();
        }
        if(stack.getSize() > 0){
            if(singleOp.equalsIgnoreCase("dup")){
                dup.perform();
            }
            else if(singleOp.equalsIgnoreCase("drop")){
                drop.perform();
            }
        }
        if(stack.getSize() > 1){
            if(singleOp.equalsIgnoreCase("swap")){
                swap.perform();
            }
            else if(singleOp.equalsIgnoreCase("over")){
                over.perform();
            }
        }
    }
    
    private void showVariables(){
        obVariables.clear();
        String s = variables.toString();
        String[] tmp = s.split("\n");
        for(String x : tmp)
            obVariables.add(x);
    }
    

    /**
    * Esegue l'operazione sulle variabili specificata in input.
    * È possibile utilizzare come nome di una variabile una delle 26 lettere
    * dell'alfabeto latino.
    * >a -> salvataggio nella variabile "a" dell'ultimo valore inserito nello 
    *       stack e rimozione dallo stesso;
    * <a -> inserimento del valore di "a" nello stack e rimozione della 
    *       variabile;
    * +a -> somma nella variabile "a" dell'ultimo valore inserito nello stack
    *       e del contenuto già presente in "a";
    * -a -> differenza tra l'ultimo valore inserito nello stack e il contenuto 
    *       già presente in "a" con memorizzazione del risultato in "a".
    * @param    command     la stringa che identifica un comando che opera con
    *                       le variabili seguito dalla variabile
    */
    private void runOperationOnVariables(String command){
        try{
            if((command.length() == 2) && (command.charAt(0) == '>') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123)){
                variables.insertVariable(command.charAt(1), stack.removeLastNumber());
            }
            if((command.length() == 2) && (command.charAt(0) == '<') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123)){
                stack.insertNumber(variables.getValueFromVariable(command.charAt(1)));
            }
            if((command.length() == 2) && (command.charAt(0) == '+') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123)){
                ArithmeticalOperations addition = factory.getOperation("ADDITION", stack.removeLastNumber(), variables.getValueFromVariable(command.charAt(1)), DECIMAL_NUMBERS);
                ComplexNumber[] result = addition.execute();
                stack.insertNumber(result[0]); 
            }
            if((command.length() == 2) && (command.charAt(0) == '-') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123)){
                ArithmeticalOperations subtraction = factory.getOperation("SUBTRACTION", stack.removeLastNumber(), variables.getValueFromVariable(command.charAt(1)), DECIMAL_NUMBERS);
                ComplexNumber[] result = subtraction.execute();
                stack.insertNumber(result[0]); 
            }
        }
        catch(ArithmeticalException exc){
            System.out.println("Errore nell'esecuzione dell'operazione aritmetica.");
        }
    }

    /**
    * Esegue un'operazione di creazione, modifica o cancellazione di una
    * operazione personalizzata.
    * create OPERATION_NAME DEFINITION ->   crea un'operazione personalizzata;
    * rename OPERATION_NAME_1 OPERATION_NAME_2 ->   rinomina un'operazione
    *                                               personalizzata definita in 
    *                                               precedenza;
    * set OPERATION_NAME NEW_DEFINITION ->  ridefinisce un'operazione
    *                                       personalizzata esistente;
    * delete OPERATION_NAME ->  rimuove un'operazione personalizzata
    *                           esistente.
    * @param    command     la stringa che identifica il comando, il nome della
    *                       operazione personalizzata e i parametri associati al
    *                       comando da eseguire
    */
    private void customOperation(String command){
        if((command.length() > 5) && (command.toLowerCase().substring(0, 6).equals("create"))){
            String[] tmpArray = command.split("\\s+");
            if(tmpArray.length == 1){
                System.out.println("Devi specificare quale operazione personalizzata vuoi creare!");
            }
            else if(tmpArray.length == 2){
                System.out.println("Devi specificare le operazioni da associare al nuovo alias!");
            }
            else{
                if((checker.isRealNumber(tmpArray[1])) || (checker.isComplexNumber(tmpArray[1]))){
                    System.out.println("Non puoi usare un numero come nome di un'operazione personalizzata!");
                }
                else if(checker.isOperation(customizedOperations, tmpArray[1])){
                    System.out.println("Quest'operazione esiste già!");
                }
                else{
                    for(int k = 2; k < tmpArray.length; k++){
                        if((!checker.isOperation(customizedOperations, tmpArray[k])) && (!checker.isRealNumber(tmpArray[k])) && (!checker.isComplexNumber(tmpArray[k]))){
                            System.out.println("La stringa inserita non è un'operazione o un numero!");
                            input.clear();
                            return;
                        }
                    }
                    customizedOperations.insertCustomOperation(tmpArray[1], Arrays.copyOfRange(tmpArray, 2, tmpArray.length));   
                }
            }
            System.out.println(customizedOperations.toString());
        }
        if((command.length() > 5) && (command.toLowerCase().substring(0, 6).equals("rename"))){
            String[] tmpArray = command.split("\\s+");
            if(tmpArray.length == 1){
                System.out.println("Devi specificare quale operazione personalizzata vuoi rinominare!");
            }
            else if(tmpArray.length == 2){
                System.out.println("Devi specificare il nuovo nome dell'operazione personalizzata da rinominare!");
            }
            else if(tmpArray.length > 3){
                System.out.println("Il nome di un'operazione personalizzata non deve contenere spazi!");
            }
            else{
                if((checker.isRealNumber(tmpArray[2])) || (checker.isComplexNumber(tmpArray[2]))){
                    System.out.println("Non puoi usare un numero come nome di un'operazione personalizzata!");
                }
                else if(!checker.isCustomizedOperation(customizedOperations, tmpArray[1])){
                    System.out.println("Quest'operazione personalizzata non è presente in memoria!");
                }
                else if(tmpArray[1].equalsIgnoreCase(tmpArray[2])){
                    System.out.println("Il nuovo nome da attribuire all'operazione personalizzata dev'essere diverso dal precedente.");
                }
                else if(checker.isOperation(customizedOperations, tmpArray[2])){
                    System.out.println("Il nuovo nome che vuoi attribuire esiste già!");
                }
                else{
                    customizedOperations.renameCustomOperation(tmpArray[1], tmpArray[2]);
                }
            }
            System.out.println(customizedOperations.toString());
        }
        if((command.length() > 2) && (command.toLowerCase().substring(0, 3).equals("set"))){
            String[] tmpArray = command.split("\\s+");
            if(tmpArray.length == 1){
                System.out.println("Devi specificare quale operazione personalizzata vuoi modificare!");
            }
            else if(tmpArray.length == 2){
                System.out.println("Devi specificare il nome dell'operazione da modificare e la sua nuova espressione!");
            }
            else{
                if(customizedOperations.getCustomizedOperationsMap().containsKey(tmpArray[1])){
                    for(int k = 2; k < tmpArray.length; k++){
                        if((!checker.isOperation(customizedOperations, tmpArray[k])) && (!checker.isRealNumber(tmpArray[k])) && (!checker.isComplexNumber(tmpArray[k]))){
                            System.out.println("La stringa inserita non è un'operazione!");
                            input.clear();
                            return;
                        }
                    }
                    customizedOperations.insertCustomOperation(tmpArray[1], Arrays.copyOfRange(tmpArray, 2, tmpArray.length));
                }
                else{
                    System.out.println("L'operazione specificata non esiste perciò non può essere modificata!");
                }
            }
            System.out.println(customizedOperations.toString());
        }
        if((command.length() > 5) && (command.toLowerCase().substring(0, 6).equals("delete"))){
            String[] tmpArray = command.split("\\s+");
            if(tmpArray.length == 1){
                System.out.println("Devi specificare quale operazione personalizzata vuoi cancellare!");
            }
            else if(tmpArray.length > 2){
                System.out.println("Il nome di un'operazione personalizzata non deve contenere spazi!");
            }
            else{
                if(customizedOperations.getCustomizedOperationsMap().containsKey(tmpArray[1])){
                    customizedOperations.deleteCustomOperation(tmpArray[1]);
                }
                else{
                    System.out.println("Quest'operazione non è presente in memoria!");
                }
            }
            System.out.println(customizedOperations.toString());
        }
    }

    /**
    * Esegue l'operazione personalizzata specificata in input.
    * @param    singleOp    la stringa che identifica un'operazione 
    *                       personalizzata
    */
    private void runCustomizedOperation(String stringOp){
        if(customizedOperations.getCustomizedOperationsMap().containsKey(stringOp)){
            for(String operation : customizedOperations.getCustomizedOperationsMap().get(stringOp)){
                if(customizedOperations.getCustomizedOperationsMap().containsKey(operation)){
                    this.runCustomizedOperation(operation);
                }
                else{
                    this.runPushOperation(operation);
                    this.runArithmeticalOperation(operation);
                    this.runStackOperation(operation);
                    this.runOperationOnVariables(operation);
                }
            }
        }
    }
    
    private void saveVariables(String text){
         if(text.equalsIgnoreCase("save") && variables.getSize() > 0){
            variablesStack.insertVariables(new Variables(variables.getVariablesMap())); //implementarlo con il pattern Command
         }
    }
    
    private void restoreVariables(String text){
        if(text.equalsIgnoreCase("restore") && variablesStack.getSize() > 0){
            variables = variablesStack.removeLast();
        }
    }
    

    /**
     * Inizializza la controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        stack = new StackPrincipale();
        variables = new Variables();
        variablesStack = new VariablesStack();
        customizedOperations = new CustomizedOperationsMap();
        checker = new Checker();
        checker.setDecimals(DECIMAL_NUMBERS);
        factory = new OperationFactory();
        input.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER))
                insertBtn.fire();
        });
        drop = new DropCommand(stack);
        clear = new ClearCommand(stack);
        dup = new DupCommand(stack);
        swap = new SwapCommand(stack);
        over = new OverCommand(stack);
        obList = FXCollections.observableArrayList();
        obVariables = FXCollections.observableArrayList();
        obList.addAll(stack.getFirst12Elements());
        listVariables.setItems(obVariables);
        elementiStack.setItems(obList);  
    }    

    /**
    * Rimuove il contenuto della casella di testo in cui si inserisce un
    *  operando o un'operazione.
    */
    @FXML
    private void deleteText(ActionEvent event){
        input.setText("");
    }

    /**
    * Esegue il comando "clear" sullo stack e resetta il contenuto della 
    * ObservableList.
    */
    @FXML
    private void clearStack(ActionEvent event){
        clear.perform();
        obList.clear();
    }

    /**
    * Gestisce il comando inserito in input nella casella di testo e 
    * l'aggiornamento dell'interfaccia grafica.
    */
    @FXML
    private void insert(ActionEvent event) throws Exception{
        String text = input.getText();
        this.runPushOperation(text);
        this.runArithmeticalOperation(text);
        this.runStackOperation(text);
        this.customOperation(text);
        this.runOperationOnVariables(text);
        this.runCustomizedOperation(text);
        this.saveVariables(text);
        this.restoreVariables(text);
        
        this.showVariables();
        obList.clear(); 
        obList.addAll(stack.getFirst12Elements());
        elementiStack.maxHeight(12);
        input.clear();
    }


}
