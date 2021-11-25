/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private TextField output;
    
    private StackPrincipale stackPrincipale;
    @FXML
    private Button Inserisci;
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
        
    }    


    @FXML
    private void Inserimento(ActionEvent event) {
        String text = input.getText();
        ParserString parser = new ParserString();
        String check = parser.parserString(text);
        ComplexNumber z = new ComplexNumber(Double.NaN,Double.NaN);
        if(check.equals("__COMPLEX__NUMBER__"))
            z = parser.recognizeComplexNumber(text);
        if(check.equals("__SINGLENUMBER__"))
            z = parser.recognizeNumber(text);
        System.out.println(text + check + z.toString());
            
        input.clear();
    }

    private void Calcolo(ActionEvent event) throws Exception {
        output.clear();
    }
    
}
