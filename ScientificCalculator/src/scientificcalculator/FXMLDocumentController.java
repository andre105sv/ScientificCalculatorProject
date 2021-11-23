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
    @FXML
    private TextField operazione;
    private StackPrincipale stackPrincipale;
    @FXML
    private Button Inserisci;
    @FXML
    private Button Calcola;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stackPrincipale = new StackPrincipale();
    }    


    @FXML
    private void Inserimento(ActionEvent event) {
        ComplexNumber a = new ComplexNumber(input.getText());
        stackPrincipale.insertNumber(a);
        input.clear();
    }

    @FXML
    private void Calcolo(ActionEvent event) throws Exception {
        ComplexNumber risultato;
        ComplexNumber[] risultatiSqrt;
        String s="";
        
        if(operazione.getText().equals("+")){
            risultato = (AritmeticalOperations.addition(stackPrincipale.removeLastNumber(), stackPrincipale.removeLastNumber()));  
            stackPrincipale.insertNumber(risultato);
            output.setText(risultato.toString());
        }
        if(operazione.getText().equals("-")){
            risultato = (AritmeticalOperations.substraction(stackPrincipale.removeLastNumber(), stackPrincipale.removeLastNumber()));
            stackPrincipale.insertNumber(risultato);
            output.setText(risultato.toString());
        }
        if(operazione.getText().equals("*")){
            risultato = (AritmeticalOperations.multiplication(stackPrincipale.removeLastNumber(), stackPrincipale.removeLastNumber()));
            stackPrincipale.insertNumber(risultato);
            output.setText(risultato.toString());
        }
        if(operazione.getText().equals("/")){
            ComplexNumber op1 = stackPrincipale.removeLastNumber();
            ComplexNumber op2 = stackPrincipale.removeLastNumber();
            System.out.println(op2.toString());
            
            if(op2.getRealPart()==0.0 && op2.getImmPart()==0.0){
                output.setText("Divisione per 0 + 0j non valida");
                stackPrincipale.insertNumber(op1);
                stackPrincipale.insertNumber(op2);
            }
            else{
                risultato = (AritmeticalOperations.division(op1,op2));
                stackPrincipale.insertNumber(risultato);
                output.setText(risultato.toString());    
            }
        }
        if(operazione.getText().equals("-+")){
            risultato = (AritmeticalOperations.reversalSign(stackPrincipale.removeLastNumber()));
            stackPrincipale.insertNumber(risultato);
            output.setText(risultato.toString());
        }
        if(operazione.getText().equals("sqrt")){
            risultatiSqrt = (AritmeticalOperations.squareRoot(stackPrincipale.removeLastNumber()));
            for(ComplexNumber ris : risultatiSqrt){
                stackPrincipale.insertNumber(ris);
                s = s + ris.toString()+ "---";
            }    
            output.setText(s);
        }
        
        
        operazione.clear();
        output.clear();
    }
    
}
