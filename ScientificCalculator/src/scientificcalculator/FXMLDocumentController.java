/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;


import java.net.URL;
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
 * @author filso
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField input;
    private final double DECIMAL_NUMBERS = 1000.0;
    private final int MAX_VIEW_SIZE = 12;
    private StackPrincipale stackPrincipale;
    @FXML
    private Button inserisci;
    @FXML
    private ListView<ComplexNumber> elementiStack;
    private ObservableList<ComplexNumber> obList; 
    private ObservableList<String> obVariables;
    private DropCommand dropForStackPrincipale; //oggetto che esegue tutte le drop su stackPrincipale
    private ClearCommand clearForStackPrincipale;// -- tutte le clear
    private DupCommand dupForStackPrincipale;// -- tutte le dup
    private SwapCommand swapForStackPrincipale;// -- tutte le swap
    private OverCommand overForStackPrincipale;// -- tutte le overù
    private Variables variables;
    CheckerString checker;
    OperationFactory factory;
    @FXML
    private ListView<String> listVariables;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        stackPrincipale = new StackPrincipale();
        variables = new Variables();
        checker = new CheckerString(DECIMAL_NUMBERS);
        factory = new OperationFactory();
        input.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER))
                inserisci.fire();
        });
        dropForStackPrincipale = new DropCommand(stackPrincipale);
        clearForStackPrincipale = new ClearCommand(stackPrincipale);
        dupForStackPrincipale = new DupCommand(stackPrincipale);
        swapForStackPrincipale = new SwapCommand(stackPrincipale);
        overForStackPrincipale = new OverCommand(stackPrincipale);
        obList = FXCollections.observableArrayList();
        obVariables = FXCollections.observableArrayList();
        obList.addAll(stackPrincipale.getFirst12Elements());
        listVariables.setItems(obVariables);
        elementiStack.setItems(obList);  
    }    

    @FXML
    private void inserimento(ActionEvent event) throws Exception{
        String text = input.getText();
        
        String risultato_check = checker.checkString(text);
        ComplexNumber z;
        if(risultato_check.equals("COMPLEX__NUMBER")){
            z = checker.createFromComplexNumber(text);
            stackPrincipale.insertNumber(z);
        }
        if(risultato_check.equals("SINGLENUMBER")){
            z = checker.createFromSingleNumber(text);
            stackPrincipale.insertNumber(z);
        }
        if(text.equals("+")){
            if(stackPrincipale.getSize() > 1){
                ArithmeticalOperations addition = factory.getOperation("ADDITION", stackPrincipale.removeLastNumber(), stackPrincipale.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = addition.execute();
                stackPrincipale.insertNumber(result[0]);
            }
        }
        if(text.equals("-")){
            if(stackPrincipale.getSize() > 1){
                ArithmeticalOperations subtraction = factory.getOperation("SUBTRACTION", stackPrincipale.removeLastNumber(), stackPrincipale.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = subtraction.execute();
                stackPrincipale.insertNumber(result[0]);
            }
        }
        if(text.equals("*")){
            if(stackPrincipale.getSize() > 1){
                ArithmeticalOperations multiplication = factory.getOperation("MULTIPLICATION", stackPrincipale.removeLastNumber(), stackPrincipale.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = multiplication.execute();
                stackPrincipale.insertNumber(result[0]);
            }
        }
        if(text.equals("/")){
            if(stackPrincipale.getSize() > 1){
                ArithmeticalOperations division = factory.getOperation("DIVISION", stackPrincipale.removeLastNumber(), stackPrincipale.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = division.execute();
                stackPrincipale.insertNumber(result[0]);
            }
        }
        if(text.equals("sqrt")){
            if(stackPrincipale.getSize() > 0){
                ArithmeticalOperations squareRoot = factory.getOperation("SQUARE_ROOT", stackPrincipale.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = squareRoot.execute(); 
                for(ComplexNumber c : result)
                    stackPrincipale.insertNumber(c);
            }
        }
        if(text.equals("+-")){
            if(stackPrincipale.getSize() > 0){
                ArithmeticalOperations reverse = factory.getOperation("REVERSAL_SIGN", stackPrincipale.removeLastNumber(), DECIMAL_NUMBERS);
                ComplexNumber[] result = reverse.execute();
                stackPrincipale.insertNumber(result[0]);
            }
        }
        if(text.toLowerCase().equals("swap")){
                swapForStackPrincipale.perform();
        }
        if(text.toLowerCase().equals("over")){
            overForStackPrincipale.perform();
        }
        
        if(text.toLowerCase().equals("dup")){
            dupForStackPrincipale.perform();
        }
        if(text.toLowerCase().equals("clear")){
            clearForStackPrincipale.perform();
        }
        if(text.toLowerCase().equals("drop")){
            dropForStackPrincipale.perform();
        }
        
        if(text.length() == 2 && text.charAt(0) == '>' && (int)text.charAt(1) > 96 && (int)text.charAt(1) < 123){
            variables.getVariablesMap().put(text.charAt(1),stackPrincipale.removeLastNumber());
        }
        if(text.length() == 2 && text.charAt(0) == '<'){
            stackPrincipale.insertNumber(variables.getVariablesMap().get(text.charAt(1)));
        }
        if(text.length() == 2 && text.charAt(0) == '+'){
            ArithmeticalOperations addition = factory.getOperation("ADDITION", stackPrincipale.removeLastNumber(), variables.getVariablesMap().get(text.charAt(1)), DECIMAL_NUMBERS);
            ComplexNumber[] result = addition.execute();
            stackPrincipale.insertNumber(result[0]); 
        }
        if(text.length() == 2 && text.charAt(0) == '-'){
            ArithmeticalOperations subtraction = factory.getOperation("SUBTRACTION", stackPrincipale.removeLastNumber(), variables.getVariablesMap().get(text.charAt(1)), DECIMAL_NUMBERS);
            ComplexNumber[] result = subtraction.execute();
            stackPrincipale.insertNumber(result[0]); 
        }
        //Mostrare Variabili
        obVariables.clear();
        String s = variables.toString();
        String[] tmp = s.split("SPLITTA_QUA");
        for(String x : tmp)
            obVariables.add(x);
        obList.clear(); 
        obList.addAll(stackPrincipale.getFirst12Elements());
        elementiStack.maxHeight(12);
        input.clear();
    }

}
