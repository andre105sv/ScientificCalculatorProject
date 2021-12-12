/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


/**
 * FXML Controller class
 *
 * @author filso
 */
public class HelpController implements Initializable {

    @FXML
    private Label nameOperationLbl;
    @FXML
    private Label descriptionOperationLbl;
    @FXML
    private ListView<String> helpList;
    private ObservableList<String> obHelpList;
    private StandardOperationsMap helpMap;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        helpMap = new StandardOperationsMap();
        obHelpList = FXCollections.observableArrayList();
        helpList.setItems(obHelpList.sorted());
        showHelpList();
        descriptionOperationLbl.setWrapText(true);
        helpList.getSelectionModel().select(0);
        showDetailsOperation();
        
    }    

      @FXML
    private void showDetailsOperation(){
        ObservableList<String> obSelected = helpList.getSelectionModel().getSelectedItems();
        String nameOperation = "";
        for(String x : obSelected){
            nameOperation += x + "\n";
        }
        nameOperation = nameOperation.trim();
        nameOperationLbl.setText(nameOperation);
        descriptionOperationLbl.setText(helpMap.getDescription(nameOperation));
    }
    /**
    * Permette di visualizzare la lista dei comandi all'interno della 
    * rispettiva Observable List.
    */
    private void showHelpList(){
        String s = helpMap.toString();
        String[] tmp = s.split("\n");
        for(String x : tmp){
            obHelpList.add(x);
        }
    }
    
}
