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
public class CheckerComplexNumber{

    private final String complex_number = "COMPLEX__NUMBER";
    private final String single_number = "SINGLENUMBER";
    private final String invalid_insert = "INVALID";
    private final String continue_checking = "CHECKING";
    private double decimals;

    public CheckerComplexNumber(double dec){
        this.decimals = dec;
    }

    /**
    * Restituisce una stringa eliminando spazi bianchi ed eventuali segni "+" o
    * "-" inziali.
    * @param    text    la stringa da cui eliminare spazi bianchi
    * @return   la stringa senza spazi bianchi e segni
    */
    public String clearString(String text){
        text = text.replaceAll("\\n", "");
        if((text.startsWith("+")) || (text.startsWith("-"))){
            StringBuilder sb = new StringBuilder(text);
            sb.deleteCharAt(0);
            return sb.toString();
        }
        return text;
    }

    /**
    * Controlla se la stringa è convertibile in un numero reale.
    * @param    text    la stringa da verificare
    * @return   True    se la stringa è convertibile in un numero reale
    */
    public boolean checkPossibleRealPart(String text){
        try{
            double real = Double.parseDouble(text);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    /**
    * Controlla se la stringa è un numero immaginario.
    * @param   text    la stringa da verificare
    * @return  True    se è la parte immaginaria di un numero complesso
    */
    public boolean checkPossibleImaginaryPart(String text){
        if(text.equals("j")){
            return true;
        }
        if(text.contains("j")){
            String image = text.replace("j", "");
            try{
                double image_finale = Double.parseDouble(image);
                return true;
            }catch(Exception e){
                return false;
            }
        }
        return false;
    }

    /**
    * Controlla se la stringa è composta solamente da un numero reale, solo da
    * un numero immaginario o se deve continuare il check.
    * @param   text    la stringa da verificare
    * @return   la stringa "SINGLENUMBER" se trova solo un numero reale o solo 
    *           un numero immaginario, altrimenti restituisce "CHECKING"
    */
    public String checkPossibleOneNumber(String text){
        if(this.checkPossibleRealPart(text)){
            return single_number;
        }
        if(this.checkPossibleImaginaryPart(text)){
            return single_number;
        }
        else{
            return continue_checking;
        }
    }

    /**
    * Controlla se la stringa è un numero complesso, un inserimento invalido o
    * se deve continuare il check.
    * @param   text    la stringa da verificare
    * @return   la stringa "COMPLEX_NUMBER" se trova un numero complesso, 
    *           "INVALID" se l'inserimento non è valido, "CHECKING" negli altri 
    *           casi
    */
    public String checkComplexNumber(String text){
        if((text.contains("+")) || (text.contains("-"))){
            String replaceAll = text.replaceAll(" ", "");
            String[] scanner = replaceAll.split("\\+|\\-");
            if((scanner.length == 1) || (scanner.length > 2)){
                return invalid_insert;
            }
            if(this.checkPossibleRealPart(scanner[0])){
                if(this.checkPossibleImaginaryPart(scanner[1])){
                    return complex_number;
                }
                else{
                    return invalid_insert;
                }
            }
            if(this.checkPossibleImaginaryPart(scanner[0])){
                if(this.checkPossibleRealPart(scanner[1])){
                    return complex_number;
                }
                else{
                    return invalid_insert;
                }
            }
            return invalid_insert;
        }
        return continue_checking;
    }

    /**
    * Controlla se la stringa è un numero complesso, se è un numero reale, se
    * è un numero immaginario o se l'inserimento non è valido.
    *
    * @param   text    la stringa da verificare
    * @return   la stringa "COMPLEX_NUMBER" se è un numero complesso, se è un 
    *           numero reale o se è un numero immaginario, "INVALID" se 
    *           l'inserimento non è valido.
    */
    public String checkString(String text){
        if(text.length() == 0){
            return invalid_insert;
        }
        text = clearString(text);
        if((text.startsWith("+")) || (text.startsWith("-"))){
            return invalid_insert;
        }
        String return_value = checkComplexNumber(text);
        if(!(return_value.equals(continue_checking))){
            return return_value;
        }
        return_value = checkPossibleOneNumber(text);
        if(!(return_value.equals(continue_checking))){
            return return_value;
        }
        if(text.equals("j"))
            return single_number;
        return invalid_insert;
    }

    /**
    * Rimuove il "\n" inserito dal controller se avviene l'inserimento tramite
    * la prissione del tasto invio e il primo carattere se è un segno.
    * @param   text    la stringa da verificare
    * @return   la stringa modificata.
    */
    public char checkFirstCharacter(String text){
        text = text.replaceAll("\\n", "");
        if (text.startsWith("+") || text.startsWith("-")) {
            StringBuilder sb = new StringBuilder(text);
            return sb.charAt(0);
        }
        return ' ';
    }

    /**
    * Crea il ComplexNumber partendo da una striga avente un numero complesso.
    * @param   text    la stringa da verificare
    * @return   il ComplexNumber creato
    */
    public ComplexNumber createFromComplexNumber(String text){
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(replaceAll);
        char operator2 = ' ';
        if(text.contains("+")){
            operator2 = '+';
        }
        if(text.contains("-")){
            operator2 = '-';
        }
        String[] scanner = text.split("\\+|\\-");
        if(scanner[0].equals("j")){
            return new ComplexNumber(Math.round(Double.parseDouble(operator2 + scanner[1]) * decimals) / decimals, Math.round(Double.parseDouble(operator1 + "1") * decimals) / decimals);
        }
        if(scanner[1].equals("j")){
            double real = Double.parseDouble(operator1 + scanner[0]);
            return new ComplexNumber(Math.round(real * decimals) / decimals, Math.round(Double.parseDouble(operator2 + "1") * decimals) / decimals);
        }
        if(scanner[0].contains("j")){
            String image = scanner[0].replace("j", "");
            return new ComplexNumber(Math.round(Double.parseDouble(operator2 + scanner[1]) * decimals) / decimals, Math.round(Double.parseDouble(operator1 + image) * decimals) / decimals);
        }
        else{
            double real = Double.parseDouble(operator1 + scanner[0]);
            String image = scanner[1].replace("j", "");
            return new ComplexNumber(Math.round(real * decimals) / decimals, Math.round(Double.parseDouble(operator2 + image) * decimals) / decimals);
        }
    }

    /**
    * Crea il ComplexNumber dalla stringa composta da un numero reale o da un 
    * numero immaginario.
    * @param   text    la stringa da verificare
    * @return  il ComplexNumber creato
    */
    public ComplexNumber createFromSingleNumber(String text){
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(text);
        if(text.equals("j"))
            return new ComplexNumber(0, 1);
        if(text.contains("j")){
            String image = text.replace("j", "");
            return new ComplexNumber(0, Math.round(Double.parseDouble(operator1 + image) * decimals) / decimals);
        }
        else{
            double real = Double.parseDouble(operator1 + text);
            return new ComplexNumber(Math.round(real * decimals) / decimals, 0);
        }
    }

    /**
    * Restituisce "true" se la stringa specificata in input indica un numero
    * senza parte reale o senza parte immaginaria.
    * @param    number      la stringa che identifica il numero
    * @return   true    se la stringa specificata in input indica un numero
    *                   reale o un numero complesso a parte reale nulla
    */
    public boolean isSingleNumber(String number){
        String checkResult = this.checkString(number);
        if(checkResult.equals("SINGLENUMBER")){
            return true;
        }
        return false;
    }

    /**
    * Restituisce "true" se la stringa specificata in input indica un numero
    * complesso in notazione cartesiana.
    * @param    number      la stringa che identifica il numero
    * @return   true    se la stringa specificata in input indica un numero 
    *                   complesso espresso in notazione cartesiana
    */
    public boolean isCartesianComplexNumber(String number){
        String checkResult = this.checkString(number);
        if(checkResult.equals("COMPLEX__NUMBER")){
            return true;
        }
        return false;
    }

}
