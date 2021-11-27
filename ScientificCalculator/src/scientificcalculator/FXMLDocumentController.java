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
    private Button Inserisci;
    @FXML
    private ListView<ComplexNumber> elementiStack;
    private ObservableList<ComplexNumber> obList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stackPrincipale = new StackPrincipale();
        input.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER))
                Inserisci.fire();
        });
        obList.addAll(stackPrincipale.getFirst12Elements());
       
        elementiStack.setItems(obList);
        
    }    


    @FXML
    private void Inserimento(ActionEvent event) throws Exception {
        
        String text = input.getText();
        CheckerString checker = new CheckerString();
        AritmeticalOperations operations = new AritmeticalOperations(DECIMAL_NUMBERS);
        String risultato_check = checker.checkString(text);
        ComplexNumber z = new ComplexNumber(Double.NaN,Double.NaN);
        if(risultato_check.equals("COMPLEX__NUMBER")){
            z = checker.createFromComplexNumber(text);
            stackPrincipale.insertNumber(z);
        }
        if(risultato_check.equals("SINGLENUMBER")){
            z = checker.createFromSingleNumber(text);
            stackPrincipale.insertNumber(z);
        }
        
            if(text.equals("+")){
                if(stackPrincipale.getSize()>1){
                    ComplexNumber result = operations.addition(stackPrincipale.removeLastNumber(),stackPrincipale.removeLastNumber());
                    stackPrincipale.insertNumber(result);
                }
            }
            if(text.equals("-")){
                if(stackPrincipale.getSize()>1){
                    ComplexNumber result = operations.substraction(stackPrincipale.removeLastNumber(),stackPrincipale.removeLastNumber());
                    stackPrincipale.insertNumber(result);
                }
            }
            if(text.equals("*")){
                if(stackPrincipale.getSize()>1){
                    ComplexNumber result = operations.multiplication(stackPrincipale.removeLastNumber(),stackPrincipale.removeLastNumber());
                    stackPrincipale.insertNumber(result);
                }
            }
            if(text.equals("/")){
                if(stackPrincipale.getSize()>1){
                    ComplexNumber result = operations.division(stackPrincipale.removeLastNumber(),stackPrincipale.removeLastNumber());
                    stackPrincipale.insertNumber(result);
                }
            }
            if(text.equals("sqrt")){
                if(stackPrincipale.getSize()>0){
                    ComplexNumber[] result = operations.squareRoot(stackPrincipale.removeLastNumber());    
                    for(ComplexNumber c : result)
                        stackPrincipale.insertNumber(c);
                }
            }
            if(text.equals("+-")){
                if(stackPrincipale.getSize()>0){
                ComplexNumber result = operations.reversalSign(stackPrincipale.removeLastNumber());
                stackPrincipale.insertNumber(result);
                }
            }
        obList.clear(); 
        obList.addAll(stackPrincipale.getFirst12Elements());
        elementiStack.maxHeight(12);
        input.clear();
    }  
}
