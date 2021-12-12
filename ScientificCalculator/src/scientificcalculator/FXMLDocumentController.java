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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author group_6
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label noticeLbl;
    
    @FXML
    private TextField inputTxt;
    private final double DECIMAL_NUMBERS = 1000;
    private final int MAX_VIEW_SIZE = 12;
    private ElementsStack stack;
    @FXML
    private Button insertBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Button restoreBtn;
    @FXML
    private ListView<ComplexNumber> elementsList;
    @FXML
    private ListView<String> variablesList;
    @FXML
    private ListView<String> operationsList;
    
   
    private ObservableList<ComplexNumber> obList; 
    private ObservableList<String> obVariables;
    private ObservableList<String> obOperations;
    
    private DropCommand drop; //oggetto che esegue tutte le drop su ElementsStack
    private ElementsStackCommand clear;// -- tutte le clear
    private ElementsStackCommand dup;// -- tutte le dup
    private ElementsStackCommand swap;// -- tutte le swap
    private ElementsStackCommand over;// -- tutte le over
    private CommandExecutor executor;
    private Variables variables;
    private VariablesStack variablesStack;
    private CustomizedOperationsMap customizedOperations;
   
    private AbstractFactory arithmeticalFactory, transcendentalFactory;
    private CheckerComplexNumber checkerNumber;
    private CheckerOperation checkerOperation;



    /**
    * Inserisce nello stack un numero indicato come reale o complesso.
    * @param    singleOp    la stringa che identifica un numero complesso o 
    *                       reale da inserire nello stack
    */
    private void runPushOperation(String singleOp){
        if(checkerNumber.isCartesianComplexNumber(singleOp)){
            ComplexNumber zComplex = checkerNumber.createFromComplexNumber(singleOp);
            stack.insertNumber(zComplex);
            noticeLbl.setText("Last: " + zComplex.toString() + " added as operand.");
        }
        else if(checkerNumber.isSingleNumber(singleOp)){
            ComplexNumber zReal = checkerNumber.createFromSingleNumber(singleOp);
            stack.insertNumber(zReal);
            noticeLbl.setText("Last: " + zReal.toString() + " added as operand.");
        }
    }

    /**
    * Inserisce nello stack il risultato dell'operazione aritmetica specificata
    * in input ("ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION", 
    * "SQUARE_ROOT", "REVERSAL_SIGN").
    * @param    singleOp    la stringa che identifica l'operazione aritmetica
    *                       da eseguire
    */
    private void runArithmeticalOrTranscendentalOperation(String singleOp){
        try{
            if(stack.getSize() > 0){
                if(singleOp.equals("sqrt")){
                    ComplexNumber selected = stack.removeLastNumber();
                    if((selected.getRealPart() == 0) && (selected.getImmPart() == 0)){
                        stack.insertNumber(selected);
                    }
                    Operation squareRoot = arithmeticalFactory.getOperation("SQUARE_ROOT", selected, DECIMAL_NUMBERS);
                    ComplexNumber[] result = squareRoot.execute();
                    for(ComplexNumber c : result){
                        stack.insertNumber(c);
                    }
                    noticeLbl.setText("Last: SQRT of " + selected.toString());
                }
                else if(singleOp.equals("+-")){
                    ComplexNumber selected = stack.removeLastNumber();
                    Operation reverse = arithmeticalFactory.getOperation("REVERSAL_SIGN", selected, DECIMAL_NUMBERS);
                    ComplexNumber[] result = reverse.execute();
                    stack.insertNumber(result[0]);
                    noticeLbl.setText("Last: REVERSAL_SIGN of " + selected.toString());
                }
                else if(singleOp.equals("mod")){
                    ComplexNumber selected = stack.removeLastNumber();
                    Operation modulus = transcendentalFactory.getOperation("MODULUS", selected, DECIMAL_NUMBERS);
                    ComplexNumber[] result = modulus.execute();
                    stack.insertNumber(result[0]);
                    noticeLbl.setText("Last: MODULUS of " + selected.toString());
                }
                else if(singleOp.equals("arg")){
                    ComplexNumber selected = stack.removeLastNumber();
                    Operation phase = transcendentalFactory.getOperation("PHASE", selected, DECIMAL_NUMBERS);
                    ComplexNumber[] result = phase.execute();
                    stack.insertNumber(result[0]);
                    noticeLbl.setText("Last: ARGUMENT / PHASE of " + selected.toString());
                }
                else if(singleOp.equals("exp")){
                    ComplexNumber selected = stack.removeLastNumber();
                    Operation exp = transcendentalFactory.getOperation("EXPONENTIAL", selected, DECIMAL_NUMBERS);
                    ComplexNumber[] result = exp.execute();
                    stack.insertNumber(result[0]);
                    noticeLbl.setText("Last: EXPONENTIAL of " + selected.toString());
                }
            }
            if(stack.getSize() > 1){
                if(singleOp.equals("+")){
                    ComplexNumber op1 = stack.removeLastNumber();
                    ComplexNumber op2 = stack.removeLastNumber();
                    Operation addition = arithmeticalFactory.getOperation("ADDITION", op1, op2, DECIMAL_NUMBERS);
                    ComplexNumber[] result = addition.execute();
                    stack.insertNumber(result[0]);
                    noticeLbl.setText("Last: ADDITION of " + op1.toString() + " and " + op2.toString());
                }
                else if(singleOp.equals("-")){
                    ComplexNumber op1 = stack.removeLastNumber();
                    ComplexNumber op2 = stack.removeLastNumber();
                    Operation subtraction = arithmeticalFactory.getOperation("SUBTRACTION", op1, op2, DECIMAL_NUMBERS);
                    ComplexNumber[] result = subtraction.execute();
                    stack.insertNumber(result[0]);
                    noticeLbl.setText("Last: SUBTRACTION of " + op2.toString() + " from " + op1.toString());
                }
                else if(singleOp.equals("*")){
                    ComplexNumber op1 = stack.removeLastNumber();
                    ComplexNumber op2 = stack.removeLastNumber();
                    Operation multiplication = arithmeticalFactory.getOperation("MULTIPLICATION", op1, op2, DECIMAL_NUMBERS);
                    ComplexNumber[] result = multiplication.execute();
                    stack.insertNumber(result[0]);
                    noticeLbl.setText("Last: MULTIPLICATION of " + op1.toString() + " and " + op2.toString());
                }
                else if(singleOp.equals("/")){
                    ComplexNumber op1 = stack.removeLastNumber();
                    ComplexNumber op2 = stack.removeLastNumber();
                    if((op2.getRealPart() == 0) && (op2.getImmPart() == 0)){
                        stack.insertNumber(op2);
                        stack.insertNumber(op1);
                    }
                    Operation division = arithmeticalFactory.getOperation("DIVISION", op1, op2, DECIMAL_NUMBERS);
                    ComplexNumber[] result = division.execute();
                    stack.insertNumber(result[0]);
                    noticeLbl.setText("Last: DIVISION between " + op1.toString() + " and " + op2.toString());
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
            noticeLbl.setText("Last: all the elements have been removed from the stack.");
        }
        if(stack.getSize() > 0){
            if(singleOp.equalsIgnoreCase("dup")){
                dup.perform();
                noticeLbl.setText("Last: pushed a copy of the last element onto the stack.");
            }
            else if(singleOp.equalsIgnoreCase("drop")){
                drop.perform();
                noticeLbl.setText("Last: the top of the stack has been removed.");
            }
        }
        if(stack.getSize() > 1){
            if(singleOp.equalsIgnoreCase("swap")){
                swap.perform();
                noticeLbl.setText("Last: exchanged the last two element in the stack.");
            }
            else if(singleOp.equalsIgnoreCase("over")){
                over.perform();
                noticeLbl.setText("Last: pushed a copy of the second last element onto the stack.");
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
            if((command.length() == 2) && (command.charAt(0) == '>') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123) && (stack.getSize() > 0)){
                variables.insertVariable(command.charAt(1), stack.removeLastNumber());
                noticeLbl.setText("Last: removed the top of the stack and saved into the variable '" + command.charAt(1) + "'.");
            }
            if((command.length() == 2) && (command.charAt(0) == '<') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123) && (variables.getValueFromVariable(command.charAt(1)) != null)){
                stack.insertNumber(variables.getValueFromVariable(command.charAt(1)));
                variables.getVariablesMap().remove(command.charAt(1));
                noticeLbl.setText("Last: pushed the value of the variable '" + command.charAt(1) + "' onto the stack.");
            }
            if((command.length() == 2) && (command.charAt(0) == '+') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123) && (stack.getSize() > 0) && (variables.getValueFromVariable(command.charAt(1)) != null)){
                Operation addition = arithmeticalFactory.getOperation("ADDITION", stack.removeLastNumber(), variables.getValueFromVariable(command.charAt(1)), DECIMAL_NUMBERS);
                ComplexNumber[] result = addition.execute();
                stack.insertNumber(result[0]); 
                noticeLbl.setText("Last: added the top of the stack to the value of the variable '" + command.charAt(1) + "'.");
            }
            if((command.length() == 2) && (command.charAt(0) == '-') && ((int)command.charAt(1) > 96) && ((int)command.charAt(1) < 123) && (stack.getSize() > 0) && (variables.getValueFromVariable(command.charAt(1)) != null)){
                Operation subtraction = arithmeticalFactory.getOperation("SUBTRACTION", stack.removeLastNumber(), variables.getValueFromVariable(command.charAt(1)), DECIMAL_NUMBERS);
                ComplexNumber[] result = subtraction.execute();
                stack.insertNumber(result[0]);
                noticeLbl.setText("Last: subtracted the top of the stack from the value of the variable '" + command.charAt(1) + "'.");
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
                noticeLbl.setText("Last: Operation '"+  customArray[0] + "' created.");
            }
            else if((command.length() > 5) && (command.toLowerCase().substring(0, 6).equals("rename"))){
                String[] customArray = checkerOperation.checkRenameOperation(customizedOperations, command);
                customizedOperations.renameCustomOperation(customArray[0], customArray[1]);
                noticeLbl.setText("Last: Operation '"+  customArray[0] + "' renamed in '" + customArray[1] + "'.");
            }
            else if((command.length() > 2) && (command.toLowerCase().substring(0, 3).equals("set"))){
                String[] customArray = checkerOperation.checkSetOperation(customizedOperations, command);
                customizedOperations.insertCustomOperation(customArray[0], Arrays.copyOfRange(customArray, 1, customArray.length));   
                noticeLbl.setText("Last: Operation '"+  customArray[0] + "' set.");
            }
            else if((command.length() > 5) && (command.toLowerCase().substring(0, 6).equals("delete"))){
                String opToRemove = checkerOperation.checkDeleteOperation(customizedOperations, command);
                customizedOperations.deleteCustomOperation(opToRemove);
                noticeLbl.setText("Last: Operation '"+  opToRemove + "' deleted.");
            }
        }
        catch(NotDefinedNameOperationException ex1){
            noticeLbl.setText("It's necessary to define the name of the user-defined operation.\nClick 'Help' for more information.");
        }
        catch(NotDefinedValueOperationException ex2){
            noticeLbl.setText("It's necessary to define each parameter of the user-defined operation.\nClick 'Help' for more information.");
        }
        catch(NumberAsNameOperationException ex3){
            noticeLbl.setText("It's not allowed to use a real number or a complex number as the name of an user-defined operation.");
        }
        catch(ExistentOperationException ex4){
            noticeLbl.setText("The user-defined operation specified as input already exists.");
        }
        catch(NotCorrectValueOperationException ex5){
            noticeLbl.setText("The operations associated with the user-defined operation aren't correct.\nCheck the available user-defined operations in the first list on the left and the standard operations clicking on 'Help'.");
        }
        catch(BlankSpaceStringException ex6){
            noticeLbl.setText("The name of an user-defined operation can't contains blank spaces.");
        }
        catch(NotExistentOperationException ex7){
            noticeLbl.setText("The user-defined operation specified as input doesn't exist.");
        }
        catch(SameNameException ex8){
            noticeLbl.setText("The new name of the user-defined operation must be different from the old one.");
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
                    this.runArithmeticalOrTranscendentalOperation(operation);
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
        if((text.equalsIgnoreCase("save")) && (variables.getSize() > 0)){
            VariablesStackCommand command = new PushVariablesCommand(variablesStack, new Variables(variables.getVariablesMap()));
            executor.perform(command);
            variables.deleteVariables();
            noticeLbl.setText("Last: All the variables have been saved.");
        }
    }
    
    /**
    * Esegue l'operazione di ripristino delle variabili dalla struttura dati
    * VariablesStack in cui esse erano memorizzate.
    * @param    text    la stringa che identifica il comando in input
    */
    private void restoreVariables(String text){
        if((text.equalsIgnoreCase("restore")) && (variablesStack.getSize() > 0)){
            variables = executor.undoLast();
            noticeLbl.setText("Last: All the variables have been restored.");
        }
    }

    /**
    * Permette di aggiungere le variabili memorizzate all'interno della 
    * rispettiva Observable List.
    */
    private void showVariables(){
        obVariables.clear();
        if(variables.getSize() != 0){
            String s = variables.toString();
            String[] tmp = s.split("\n");
            saveBtn.setDisable(false);     
            for(String x : tmp){
                obVariables.add(x);
            }
        }
        else{
            saveBtn.setDisable(true);
        }
        if(variablesStack.getSize() == 0){
            restoreBtn.setDisable(true);
        }
        else{
            restoreBtn.setDisable(false);
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
    * Permette di visualizzare il pannello che contiene l'Help.
    */
    @FXML
    private void showHelpWindow(ActionEvent event){
        
        try{ 
            Parent root = FXMLLoader.load(getClass().getResource("Help.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("./CalculatorStyleSheet.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setHeight(500);
            stage.setWidth(735);
            stage.setResizable(false);
            stage.setTitle("Guide");
            stage.show();
        }
        catch(Exception ex){
            noticeLbl.setText("Error opening the guide.");
        }
        
    }

  

    /**
     * Inizializza la controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        stack = new ElementsStack();
        variables = new Variables();
        variablesStack = new VariablesStack();
        customizedOperations = new CustomizedOperationsMap();
        
        checkerNumber = new CheckerComplexNumber(DECIMAL_NUMBERS);
        checkerOperation = new CheckerOperation(DECIMAL_NUMBERS);
        arithmeticalFactory = FactoryProducer.getFactory(true);
        transcendentalFactory = FactoryProducer.getFactory(false);
        inputTxt.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER))
                insertBtn.fire();
        });
        drop = new DropCommand(stack);
        clear = new ClearCommand(stack);
        dup = new DupCommand(stack);
        swap = new SwapCommand(stack);
        over = new OverCommand(stack);
        executor = new CommandExecutor();
        noticeLbl.setText("");
        obList = FXCollections.observableArrayList();
        obVariables = FXCollections.observableArrayList();
        obOperations = FXCollections.observableArrayList();
        
        variablesList.setItems(obVariables);
        operationsList.setItems(obOperations);
        elementsList.setItems(obList);
        
        saveBtn.setDisable(true);
        restoreBtn.setDisable(true);
        clearBtn.setDisable(true);
        
        
       
        
    }    

    /**
    * Rimuove il contenuto della casella di testo in cui si inserisce un
    *  operando o un'operazione.
    */
    @FXML
    private void deleteText(ActionEvent event){
        inputTxt.setText("");
        noticeLbl.setText("");
        inputTxt.requestFocus();
    }

    /**
    * Esegue il comando "clear" sullo stack e resetta il contenuto della 
    * ObservableList.
    */
    @FXML
    private void clearStack(ActionEvent event){
        clear.perform();
        obList.clear();
        clearBtn.setDisable(true);
        noticeLbl.setText("Last: all the elements have been removed from the stack.");
        inputTxt.requestFocus();
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
        this.runArithmeticalOrTranscendentalOperation(text);
        this.runStackOperation(text);
        this.customOperation(text);
        this.runOperationOnVariables(text);
        this.runCustomizedOperation(text);
        this.saveVariables(text);
        this.restoreVariables(text);        
        this.showVariables();
        this.showOperations();
        obList.clear();
        if(stack.getSize() == 0){
            clearBtn.setDisable(true);
        }
        else{
            obList.addAll(stack.getFirst12Elements());
            clearBtn.setDisable(false);
        }
        elementsList.maxHeight(12);
        inputTxt.clear();
        inputTxt.requestFocus();
    }

    /**
    * Permette di salvare in un file di testo (scelto dall'utente)
    * le operazioni personalizzate definite.
    */
    @FXML
    private void saveFile(ActionEvent event) throws FileNotFoundException, IOException{
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File ("../"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files","*.txt"));
        File selectedFile = fc.showSaveDialog(null);
        PrintWriter printWriter = new PrintWriter(selectedFile);
        printWriter.write(customizedOperations.toString());
        printWriter.close();
        noticeLbl.setText("Last: the user-defined operations have been saved into '" + selectedFile.getName() + "'.");
        inputTxt.requestFocus();
    }
    
    /**
    * Permette di caricare le operazioni personalizzate salvate in un file di testo
    * Effettua il conseguente aggiornamento della ListView che mostra le operazioni personalizzate.
    */
    @FXML
    private void openFile(ActionEvent event) throws FileNotFoundException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File ("../"));
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
            this.showOperations();
        }
        noticeLbl.setText("Last: the user-defined operations into '" + selectedFile.getName() + "' have been restored.");
        inputTxt.requestFocus();
    }
    
    /**
    * Permette di salvare lo stato corrente delle variabili definite, 
    * in uno stack ausiliario (che si distrugge al momento della chiusura
    * dell'applicazione).
    */
    @FXML
    private void saveVariables(ActionEvent event) {
        if(variables.getSize() > 0){
            VariablesStackCommand command = new PushVariablesCommand(variablesStack, new Variables(variables.getVariablesMap()));
            executor.perform(command);
            variables.deleteVariables();
            this.showVariables();
            restoreBtn.setDisable(false);
            noticeLbl.setText("Last: All the variables have been saved.");
        }       
        inputTxt.requestFocus();
    }

    /**
    * Permette di ripristinare il precedente salvataggio delle variabili, 
    * prelevandolo dallo stack ausiliario.
    */
    @FXML
    private void restoreVariables(ActionEvent event){
        if(variablesStack.getSize() > 0){
            variables = executor.undoLast();
            this.showVariables();
            noticeLbl.setText("Last: All the variables have been restored.");
        }  
        inputTxt.requestFocus();
    }

}
