/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;



/**
 *
 * @author filso
 */
public class ParserString {
    private final String operation  = "__OPERATION__";
    private final String complex_number = "__COMPLEX__NUMBER__";
    private final String single_number = "__SINGLENUMBER__";
    private final String invalid_insert = "__INVALID__";
    private final String continue_checking = "__CHECKING__";
    

    public String clearString(String text){
        text = text.replaceAll("\\n", "");
        if(text.startsWith("+") || text.startsWith("-")){
            StringBuilder sb = new StringBuilder(text);
            // Removing the first character
            // of a string
            sb.deleteCharAt(0);
            
            // Converting StringBuilder into a string
            // and return the modified string
            return sb.toString();
          }
        return text;
    }
    

    

    public boolean checkPossiblePartReal(String text){
        try {
            double real = Double.parseDouble(text);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }

    public boolean checkPossiblePartImaginary(String text){
        if(text.contains("j")){
            String image = text.replace("j","");
            try {
                 double image_finale = Double.parseDouble(image);
                 return true;
            } catch (Exception e) {
                return false;
            }
           
        }
        return false;
        
    }

    public String checkPossibleOneNumber(String text){
        if(this.checkPossiblePartReal(text)) return single_number;
        return this.checkPossiblePartImaginary(text) ? single_number : continue_checking;
        
    }

    public String checkComplexNumber(String text){
        if(text.contains("+") || text.contains("-")){
            String replaceAll = text.replaceAll(" ", "");
            String [] scanner = replaceAll.split("\\+|\\-");
            if(scanner.length > 2) return invalid_insert;
            if(this.checkPossiblePartReal(scanner[0]))
                return this.checkPossiblePartImaginary(scanner[1]) ? complex_number: invalid_insert;
            if(this.checkPossiblePartImaginary(scanner[0]))
                 return this.checkPossiblePartReal(scanner[1]) ? complex_number: invalid_insert;
            return invalid_insert;
                 }
        return continue_checking;
    }

    public String parserString(String text){
        if(text.length() == 0) return invalid_insert;
        text = clearString(text);
        if(text.startsWith("+") || text.startsWith("-")) 
            return invalid_insert;
        String return_value = checkComplexNumber(text);
        if (!(return_value.equals(continue_checking)))
            return return_value;
        return_value = checkPossibleOneNumber(text);
        if(!(return_value.equals(continue_checking)))
            return return_value;
        return invalid_insert;
    
    }
    
    
        public char checkFirstCharacter(String text){
            text = text.replaceAll("\\n", "");
        if(text.startsWith("+") || text.startsWith("-")){
            StringBuilder sb = new StringBuilder(text);
            
            return sb.charAt(0);
            
          }
        return ' ';
    }
        
      
    public ComplexNumber recognizeComplexNumber(String text){
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(replaceAll);
        char operator2 = ' ';
        if(text.contains("+")) operator2 = '+';
        if(text.contains("-")) operator2 = '-';
        String [] scanner = text.split("\\+|\\-");
        if(scanner[0].contains("j")){
            String image = scanner[0].replace("j","");
            return new ComplexNumber(Double.parseDouble( operator2 + scanner[1]), Double.parseDouble(operator1 + image));
        }
        else {
            double real = Double.parseDouble(operator1 + scanner[0]);
            String image = scanner[1].replace("j","");
            return new ComplexNumber(real , Double.parseDouble(operator2 + image));
            
            
        }
    }
    public ComplexNumber recognizeNumber(String text){
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(text);
        if(text.contains("j")){
            String image = text.replace("j","");
            return new ComplexNumber(0, Double.parseDouble(operator1 + image));
        }
        else {
            double real = Double.parseDouble(operator1 + text);
            return new ComplexNumber(real , 0);
        
    }

    }
}

