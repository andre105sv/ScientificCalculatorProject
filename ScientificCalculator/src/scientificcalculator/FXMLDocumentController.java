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
        String check = checker.parserString(text);
        ComplexNumber z = new ComplexNumber(Double.NaN,Double.NaN);
        if(check.equals("__COMPLEX__NUMBER__")){
            z = checker.recognizeComplexNumber(text);
            stackPrincipale.insertNumber(z);
        }
        if(check.equals("__SINGLENUMBER__")){
            z = checker.recognizeNumber(text);
            stackPrincipale.insertNumber(z);
        }
        
            if(text.equals("+")){
                ComplexNumber result = AritmeticalOperations.addition(stackPrincipale.removeLastNumber(),stackPrincipale.removeLastNumber());
                stackPrincipale.insertNumber(result);
            }
            if(text.equals("-")){
                ComplexNumber result = AritmeticalOperations.substraction(stackPrincipale.removeLastNumber(),stackPrincipale.removeLastNumber());
                stackPrincipale.insertNumber(result);
            }
            if(text.equals("*")){
                ComplexNumber result = AritmeticalOperations.multiplication(stackPrincipale.removeLastNumber(),stackPrincipale.removeLastNumber());
                stackPrincipale.insertNumber(result);
            }
            if(text.equals("/")){
                ComplexNumber result = AritmeticalOperations.division(stackPrincipale.removeLastNumber(),stackPrincipale.removeLastNumber());
                stackPrincipale.insertNumber(result);
            }
            if(text.equals("sqrt")){
                ComplexNumber[] result = AritmeticalOperations.squareRoot(stackPrincipale.removeLastNumber());
                for(ComplexNumber c : result)
                    stackPrincipale.insertNumber(c);
            }
            if(text.equals("+-")){
                ComplexNumber result = AritmeticalOperations.reversalSign(stackPrincipale.removeLastNumber());
                stackPrincipale.insertNumber(result);
            }
        
            
        obList.clear();    
        System.out.println(text + check + z.toString());
        obList.addAll(stackPrincipale.getFirst12Elements());
        System.out.println(obList.toString());
        elementiStack.maxHeight(12);      
        input.clear();
    }

    
    
}
