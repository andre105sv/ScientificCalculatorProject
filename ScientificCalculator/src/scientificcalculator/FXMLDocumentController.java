/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;


import java.net.URL;
import java.util.Arrays;
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
    private StackPrincipale stack;
    @FXML
    private Button inserisci;
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
    private CustomizedOperationsMap customizedOperations;
    private OperationFactory factory;
    private CheckerString checker;
    @FXML
    private ListView<String> listVariables;


    private boolean isArithmeticalOperation(String op){
        if((op.equals("+")) || (op.equals("-")) || (op.equals("*")) || (op.equals("/")) || (op.equals("+-"))){
            return true;
        }
        if((op.equalsIgnoreCase("sqrt"))){
            return true;
        }
        return false;
    }

    private boolean isStackOperation(String op){
        if((op.equalsIgnoreCase("drop")) || (op.equalsIgnoreCase("dup")) || (op.equalsIgnoreCase("swap")) || (op.equalsIgnoreCase("over")) || (op.equalsIgnoreCase("clear"))){
            return true;
        }
        return false;
    }

    private boolean isCustomizedOperation(String op){
        if(customizedOperations.getCustomizedOperationsMap().containsKey(op)){
            return true;
        }
        return false;
    }

    private boolean isOperation(String operationString){
        if(isArithmeticalOperation(operationString)){
            return true;
        }
        if(isStackOperation(operationString)){
            return true;
        }
        if(isCustomizedOperation(operationString)){
            return true;
        }
        return false;
    }

    private boolean isRealNumber(String number){
        String checkResult = checker.checkString(number);
        if(checkResult.equals("SINGLENUMBER")){
            return true;
        }
        return false;
    }

    private boolean isComplexNumber(String number){
        String checkResult = checker.checkString(number);
        if(checkResult.equals("COMPLEX__NUMBER")){
            return true;
        }
        return false;
    }

    private void runPushOperation(String singleOp) throws Exception{
        if(isComplexNumber(singleOp)){
            ComplexNumber zComplex = checker.createFromComplexNumber(singleOp);
            stack.insertNumber(zComplex);
        }
        else if(isRealNumber(singleOp)){
            ComplexNumber zReal = checker.createFromSingleNumber(singleOp);
            stack.insertNumber(zReal);
        }
    }

    private void runArithmeticalOperation(String singleOp) throws Exception{
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

    private void runStackOperation(String singleOp) throws Exception{
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
    
    private void runOperationOnVariables(String command) throws Exception{
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

    private void customOperation(String command) throws Exception{
        if((command.length() > 5) && (command.toLowerCase().substring(0, 6).equals("create"))){
            String[] tmpArray = command.split("\\s+");
            if(tmpArray.length == 1){
                System.out.println("Devi specificare quale operazione personalizzata vuoi creare!");
            }
            else if(tmpArray.length == 2){
                System.out.println("Devi specificare le operazioni da associare al nuovo alias!");
            }
            else{
                if(this.isOperation(tmpArray[1])){
                    System.out.println("Quest'operazione esiste già!");
                }
                else{
                    for(int k = 2; k < tmpArray.length; k++){
                        if((!this.isOperation(tmpArray[k])) && (!this.isRealNumber(tmpArray[k])) && (!this.isComplexNumber(tmpArray[k]))){
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
                if((this.isCustomizedOperation(tmpArray[1])) && (!this.isOperation(tmpArray[2]))){
                    customizedOperations.renameCustomOperation(tmpArray[1], tmpArray[2]);
                }
                else{
                    System.out.println("Quest'operazione non è presente in memoria oppure hai inserito un nome non valido!");
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
                        if((!this.isOperation(tmpArray[k])) && (!this.isRealNumber(tmpArray[k])) && (!this.isComplexNumber(tmpArray[k]))){
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

    private void runCustomizedOperation(String stringOp) throws Exception{
        if(customizedOperations.getCustomizedOperationsMap().containsKey(stringOp)){
            for(String operation : customizedOperations.getCustomizedOperationsMap().get(stringOp)){
                if(customizedOperations.getCustomizedOperationsMap().containsKey(operation)){
                    this.runCustomizedOperation(operation);
                }
                else{
                    this.runPushOperation(operation);
                    this.runArithmeticalOperation(operation);
                    this.runStackOperation(operation);
                }
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        stack = new StackPrincipale();
        variables = new Variables();
        customizedOperations = new CustomizedOperationsMap();
        checker = new CheckerString(DECIMAL_NUMBERS);
        factory = new OperationFactory();
        input.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().equals(KeyCode.ENTER))
                inserisci.fire();
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

    @FXML
    private void deleteText(ActionEvent event){
        input.setText("");
    }

    @FXML
    private void clearStack(ActionEvent event){
        clear.perform();
        obList.clear();
    }

    @FXML
    private void inserimento(ActionEvent event) throws Exception{
        String text = input.getText();
        this.runPushOperation(text);
        this.runArithmeticalOperation(text);
        this.runStackOperation(text);
        this.customOperation(text);
        this.runOperationOnVariables(text);
        this.runCustomizedOperation(text);
        //Mostrare Variabili
        obVariables.clear();
        String s = variables.toString();
        String[] tmp = s.split("\n");
        for(String x : tmp)
            obVariables.add(x);
        obList.clear(); 
        obList.addAll(stack.getFirst12Elements());
        elementiStack.maxHeight(12);
        input.clear();
    }


}
