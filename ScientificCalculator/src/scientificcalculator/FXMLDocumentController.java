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
    private ObservableList<ComplexNumber> obList = FXCollections.observableArrayList();
    private DropCommand dropForStackPrincipale; //oggetto che esegue tutte le drop su stackPrincipale
    private ClearCommand clearForStackPrincipale;// -- tutte le clear
    private DupCommand dupForStackPrincipale;// -- tutte le dup
    private SwapCommand swapForStackPrincipale;// -- tutte le swap
    private OverCommand overForStackPrincipale;// -- tutte le over

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        stackPrincipale = new StackPrincipale();
        input.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER))
                inserisci.fire();
        });
        dropForStackPrincipale = new DropCommand(stackPrincipale);
        clearForStackPrincipale = new ClearCommand(stackPrincipale);
        dupForStackPrincipale = new DupCommand(stackPrincipale);
        swapForStackPrincipale = new SwapCommand(stackPrincipale);
        overForStackPrincipale = new OverCommand(stackPrincipale);
        obList.addAll(stackPrincipale.getFirst12Elements());
        elementiStack.setItems(obList);  
    }    

    @FXML
    private void inserimento(ActionEvent event) throws Exception{
        String text = input.getText();
        CheckerString checker = new CheckerString(DECIMAL_NUMBERS);
        OperationFactory factory = new OperationFactory();
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
            if(stackPrincipale.getSize()>1){
                //stackPrincipale.Swap();
                swapForStackPrincipale.perform();
            }
        }
        if(text.toLowerCase().equals("over")){
            if(stackPrincipale.getSize()>1){
                //stackPrincipale.Over();
                overForStackPrincipale.perform();
            }
        }
        
        if(text.toLowerCase().equals("dup")){
            if(stackPrincipale.getSize()>0){
                //stackPrincipale.Dup();
                dupForStackPrincipale.perform();
            }
        }
        if(text.toLowerCase().equals("clear")){
            //stackPrincipale.clear();
            clearForStackPrincipale.perform();
        }
        if(text.toLowerCase().equals("drop")){
            //stackPrincipale.removeLastNumber();
            dropForStackPrincipale.perform();
        }
        obList.clear(); 
        obList.addAll(stackPrincipale.getFirst12Elements());
        elementiStack.maxHeight(12);
        input.clear();
    }

}
