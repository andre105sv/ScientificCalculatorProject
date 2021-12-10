/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import exceptions.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.FileChooser;


/**
 * FXML Controller class
 *
 * @author group_6
 */
public class FXMLDocumentController implements Initializable {

    //@FXML
    //private Label label;
    @FXML
    private Label noticeLbl;
    @FXML
    private TextField inputTxt;
    private final double DECIMAL_NUMBERS = 1000;
    private final int MAX_VIEW_SIZE = 12;
    private StackPrincipale stack;
    @FXML
    private Button insertBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private ListView<ComplexNumber> elementsList;
    private ObservableList<ComplexNumber> obList; 
    private ObservableList<String> obVariables;
    private ObservableList<String> obOperations;
    private DropCommand drop; //oggetto che esegue tutte le drop su stackPrincipale
    private ClearCommand clear;// -- tutte le clear
    private DupCommand dup;// -- tutte le dup
    private SwapCommand swap;// -- tutte le swap
    private OverCommand over;// -- tutte le over
    private PushVariablesCommand pushVariables;
    private Variables variables;
    private VariablesStack variablesStack;
    private CustomizedOperationsMap customizedOperations;
    private OperationFactory factory;
    private CheckerComplexNumber checkerNumber;
    private CheckerOperation checkerOperation;
    @FXML
    private ListView<String> variablesList;
    @FXML
    private ListView<String> operationsList;
    @FXML
    private Button saveBtn;
    @FXML
    private Button restoreBtn;

    /**
    * Inserisce nello stack un numero indicato come reale o complesso.
    * @param    singleOp    la stringa che identifica un numero complesso o 
    *                       reale da inserire nello stack
    */
    private void runPushOperation(String singleOp){
        if(checkerNumber.isCartesianComplexNumber(singleOp)){
            ComplexNumber zComplex = checkerNumber.createFromComplexNumber(singleOp);
            stack.insertNumber(zComplex);
        }
        else if(checkerNumber.isSingleNumber(singleOp)){
            ComplexNumber zReal = checkerNumber.createFromSingleNumber(singleOp);
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
                    ArithmeticalOperations squareRoot = factory.getArithmeticalOperations("SQUARE_ROOT", stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = squareRoot.execute(); 
                    for(ComplexNumber c : result)
                        stack.insertNumber(c);
                }
                else if(singleOp.equals("+-")){
                    ArithmeticalOperations reverse = factory.getArithmeticalOperations("REVERSAL_SIGN", stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = reverse.execute();
                    stack.insertNumber(result[0]);
                }
                else if(singleOp.equals("mod")){
                    TranscendentalOperations modulus = factory.getTranscendentalOperations("MODULUS", stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = modulus.execute();
                    stack.insertNumber(result[0]);
                }
                else if(singleOp.equals("arg")){
                    TranscendentalOperations phase = factory.getTranscendentalOperations("PHASE", stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = phase.execute();
                    stack.insertNumber(result[0]);
                }
                else if(singleOp.equals("exp")){
                    TranscendentalOperations exp = factory.getTranscendentalOperations("EXPONENTIAL", stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = exp.execute();
                    stack.insertNumber(result[0]);
                }
            }
            if(stack.getSize() > 1){
                if(singleOp.equals("+")){
                    ArithmeticalOperations addition = factory.getArithmeticalOperations("ADDITION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = addition.execute();
                    stack.insertNumber(result[0]);
                }
                else if(singleOp.equals("-")){
                    ArithmeticalOperations subtraction = factory.getArithmeticalOperations("SUBTRACTION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = subtraction.execute();
                    stack.insertNumber(result[0]);
                }
                else if(singleOp.equals("*")){
                    ArithmeticalOperations multiplication = factory.getArithmeticalOperations("MULTIPLICATION", stack.removeLastNumber(), stack.removeLastNumber(), DECIMAL_NUMBERS);
                    ComplexNumber[] result = multiplication.execute();
                    stack.insertNumber(result[0]);
                }
                else if(singleOp.equals("/")){
                    ComplexNumber op1 = stack.removeLastNumber();
                    ComplexNumber op2 = stack.removeLastNumber();
                    if(op2.getRealPart() == 0 && op2.getImmPart() == 0){
                        stack.insertNumber(op2);
                        stack.insertNumber(op1);
                    }
                    ArithmeticalOperations division = factory.getArithmeticalOperations("DIVISION", op1, op2, DECIMAL_NUMBERS);
                    ComplexNumber[] result = division.execute();
                    stack.insertNumber(result[0]);
                }
                
            }
        }
        catch(DivisionByZeroException ex1){
            noticeLbl.setText("Non è possibile dividere un numero per zero.");
        }
        catch(NotDefinedArgumentException ex2){
            noticeLbl.setText("La radice quadrata di 0 non è definita.");
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
                variables.getVariablesMap().remove(command.charAt(1));
            }
            if((command.length() == 2) && (command.charAt(0) == '+') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123)){
                ArithmeticalOperations addition = factory.getArithmeticalOperations("ADDITION", stack.removeLastNumber(), variables.getValueFromVariable(command.charAt(1)), DECIMAL_NUMBERS);
                ComplexNumber[] result = addition.execute();
                stack.insertNumber(result[0]); 
            }
            if((command.length() == 2) && (command.charAt(0) == '-') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123)){
                ArithmeticalOperations subtraction = factory.getArithmeticalOperations("SUBTRACTION", stack.removeLastNumber(), variables.getValueFromVariable(command.charAt(1)), DECIMAL_NUMBERS);
                ComplexNumber[] result = subtraction.execute();
                stack.insertNumber(result[0]); 
            }
        }
        catch(ArithmeticalException ex){
            noticeLbl.setText("Errore nell'esecuzione dell'operazione aritmetica.");
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
        try{
            if((command.length() > 5) && (command.toLowerCase().substring(0, 6).equals("create"))){
                String[] customArray = checkerOperation.checkCreateOperation(customizedOperations, command);
                customizedOperations.insertCustomOperation(customArray[0], Arrays.copyOfRange(customArray, 1, customArray.length));   
            }
            else if((command.length() > 5) && (command.toLowerCase().substring(0, 6).equals("rename"))){
                String[] customArray = checkerOperation.checkRenameOperation(customizedOperations, command);
                customizedOperations.renameCustomOperation(customArray[0], customArray[1]);   
            }
            else if((command.length() > 2) && (command.toLowerCase().substring(0, 3).equals("set"))){
                String[] customArray = checkerOperation.checkSetOperation(customizedOperations, command);
                customizedOperations.insertCustomOperation(customArray[0], Arrays.copyOfRange(customArray, 1, customArray.length));   
            }
            else if((command.length() > 5) && (command.toLowerCase().substring(0, 6).equals("delete"))){
                String opToRemove = checkerOperation.checkDeleteOperation(customizedOperations, command);
                customizedOperations.deleteCustomOperation(opToRemove);   
            }
        }
        catch(NotDefinedNameOperationException ex1){
            noticeLbl.setText("È necessario specificare il nome dell'operazione personalizzata.\nPer info clicca su HELP.");
        }
        catch(NotDefinedValueOperationException ex2){
            noticeLbl.setText("È necessario definire tutti i campi dell'operazione personalizzata.\nPer info clicca su HELP.");
        }
        catch(NumberAsNameOperationException ex3){
            noticeLbl.setText("Non puoi usare un numero come nome di un'operazione personalizzata!");
        }
        catch(ExistentOperationException ex4){
            noticeLbl.setText("Quest'operazione esiste già!");
        }
        catch(NotCorrectValueOperationException ex5){
            noticeLbl.setText("La stringa inserita non è un'operazione o un numero!");
        }
        catch(BlankSpaceStringException ex6){
            noticeLbl.setText("Il nome di un'operazione personalizzata non deve contenere spazi!");
        }
        catch(NotExistentOperationException ex7){
            noticeLbl.setText("Quest'operazione personalizzata non è presente in memoria!");
        }
        catch(SameNameException ex8){
            noticeLbl.setText("Il nuovo nome da attribuire all'operazione personalizzata dev'essere diverso dal precedente.");
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
                    this.saveVariables(operation);
                    this.restoreVariables(operation);
                }
            }
        }
    }

    /**
    * Esegue l'operazione di salvataggio di tutte le variabili in una struttura 
    * dati VariablesStack in modo da poterle recuperare in seguito.
    * @param    text    la stringa che identifica il comando in input
    */
    private void saveVariables(String text){
         if(text.equalsIgnoreCase("save") && variables.getSize() > 0){
            //variablesStack.insertVariables(new Variables(variables.getVariablesMap()));
            pushVariables.perform(new Variables(variables.getVariablesMap()));
         }
    }
    
    /**
    * Esegue l'operazione di ripristino delle variabili dalla struttura dati
    * VariablesStack in cui esse erano memorizzate.
    * @param    text    la stringa che identifica il comando in input
    */
    private void restoreVariables(String text){
        if(text.equalsIgnoreCase("restore") && variablesStack.getSize() > 0){
            //variables = variablesStack.removeLast();
            variables = pushVariables.undo(null);
        }
    }

    /**
    * Permette di aggiungere le variabili memorizzate all'interno della 
    * rispettiva Observable List.
    */
    private void showVariables(){
        obVariables.clear();
        String s = variables.toString();
        String[] tmp = s.split("\n");
        for(String x : tmp){
            obVariables.add(x);
        }
    }

    /**
    * Permette di aggiungere le operazioni personalizzate all'interno della 
    * rispettiva Observable List.
    */
    private void showOperations(){
        obOperations.clear();
        String s = customizedOperations.toString();
        String[] tmp = s.split("\n");
        for(String x : tmp){
            obOperations.add(x);
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
        checkerNumber = new CheckerComplexNumber();
        checkerNumber.setDecimals(DECIMAL_NUMBERS);
        checkerOperation = new CheckerOperation();
        factory = new OperationFactory();
        inputTxt.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER))
                insertBtn.fire();
        });
        drop = new DropCommand(stack);
        clear = new ClearCommand(stack);
        dup = new DupCommand(stack);
        swap = new SwapCommand(stack);
        over = new OverCommand(stack);
        noticeLbl.setText("");
        pushVariables = new PushVariablesCommand(variablesStack);
        obList = FXCollections.observableArrayList();
        obVariables = FXCollections.observableArrayList();
        obOperations = FXCollections.observableArrayList();
        variablesList.setItems(obVariables);
        operationsList.setItems(obOperations);
        elementsList.setItems(obList);
    }    

    /**
    * Rimuove il contenuto della casella di testo in cui si inserisce un
    *  operando o un'operazione.
    */
    @FXML
    private void deleteText(ActionEvent event){
        inputTxt.setText("");
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
        noticeLbl.setText("");
        String text = inputTxt.getText();
        this.runPushOperation(text);
        this.runArithmeticalOperation(text);
        this.runStackOperation(text);
        this.customOperation(text);
        this.runOperationOnVariables(text);
        this.runCustomizedOperation(text);
        this.saveVariables(text);
        this.restoreVariables(text);        
        this.showVariables();
        this.showOperations();
        obList.clear(); 
        obList.addAll(stack.getFirst12Elements());
        elementsList.maxHeight(12);
        inputTxt.clear();
    }

    @FXML
    private void saveFile(ActionEvent event) throws FileNotFoundException, IOException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File ("C:\\Users\\filso\\OneDrive\\Documenti\\NetBeansProjects"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files","*.txt"));
        File selectedFile = fc.showSaveDialog(null);
        PrintWriter printWriter = new PrintWriter(selectedFile);
        printWriter.write(customizedOperations.toString());
        printWriter.close(); 
    }
    
    @FXML
    private void openFile(ActionEvent event) throws FileNotFoundException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File ("C:\\Users\\filso\\OneDrive\\Documenti\\NetBeansProjects"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files","*.txt"));
        File selectedFile = fc.showOpenDialog(null);
        Scanner scanner = new Scanner(selectedFile);
        customizedOperations.getCustomizedOperationsMap().clear();
        String[] linea = null;
        while (scanner.hasNextLine()){
            linea = scanner.nextLine().replace("[", "").replace("]", "").trim().split("=");
            String[] values = linea[1].split(",");
            for(int k = 0; k < values.length; k++){
                values[k] = values[k].trim();
            }                  
            customizedOperations.insertCustomOperation(linea[0].trim(), values);
            System.out.println(customizedOperations.toString());
        }
    } 
    @FXML
    private void saveVariables(ActionEvent event) {
        if( variables.getSize() > 0){
            pushVariables.perform(new Variables(variables.getVariablesMap()));
         }
    }

    @FXML
    private void restoreVariables(ActionEvent event) {
        if(variablesStack.getSize() > 0){
            variables = pushVariables.undo(null);
            this.showVariables();
        }
    }

}
