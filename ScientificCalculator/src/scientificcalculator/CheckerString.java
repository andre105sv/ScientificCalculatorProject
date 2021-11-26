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
public class CheckerString {

    private final String complex_number = "COMPLEX__NUMBER";
    private final String single_number = "SINGLENUMBER";
    private final String invalid_insert = "INVALID";
    private final String continue_checking = "CHECKING";

    /**
     * Ritorna la stringa eliminando spazi bianchi ed eventuali segni inziali.
     *
     * @param text
     * @return Stringa ripulita.
     */
    public String clearString(String text) {
        text = text.replaceAll("\\n", "");
        if (text.startsWith("+") || text.startsWith("-")) {
            StringBuilder sb = new StringBuilder(text);
            sb.deleteCharAt(0);
            return sb.toString();
        }
        return text;
    }

    /**
     * Controlla se la stringa è un numero reale.
     *
     * @param text
     * @return True se trova un numero reale, false altrimenti.
     */
    public boolean checkPossibleRealPart(String text) {
        try {
            double real = Double.parseDouble(text);
            return true;
        } catch (Exception ex) {
            System.err.println("Parte reale non trovata");
            return false;
        }
    }

    /**
     * Controlla se la stringa è un numero immaginario.
     *
     * @param text
     * @return True se trova un numero immaginario, false altrimenti.
     */
    public boolean checkPossibleImmaginaryPart(String text) {
        if (text.contains("j")) {
            String image = text.replace("j", "");
            try {
                double image_finale = Double.parseDouble(image);
                return true;
            } catch (Exception e) {
                System.err.println("Parte immaginaria non trovata");
                return false;
            }
        }
        return false;
    }

    /**
     * Controlla se la stringa è composto solamente da un numero reale, solo da
     * un numero immaginario o se deve continuare il check.
     *
     * @param text
     * @return SINGLENUMBER se trova solo un numero reale o solo un numero
     * immaginario, CHECKING altrimenti.
     */
    public String checkPossibleOneNumber(String text) {
        if (this.checkPossibleRealPart(text)) {
            return single_number;
        }
        if (this.checkPossibleImmaginaryPart(text)) {
            return single_number;
        } else {
            return continue_checking;
        }

    }

    /**
     * Controlla se la stringa è un numero complesso, un inserimento invalido o
     * se deve continuare il check.
     *
     * @param text
     * @return COMPLEX_NUMBER se trova un numero complesso, INVALID se
     * l'inserimento non è valido, CHECKING altrimenti.
     */
    public String checkComplexNumber(String text) {
        if (text.contains("+") || text.contains("-")) {
            String replaceAll = text.replaceAll(" ", "");
            String[] scanner = replaceAll.split("\\+|\\-");
            if (scanner.length > 2) {
                return invalid_insert;
            }
            if (this.checkPossibleRealPart(scanner[0])) {
                if (this.checkPossibleImmaginaryPart(scanner[1])) {
                    return complex_number;
                } else {
                    return invalid_insert;
                }
            }
            if (this.checkPossibleImmaginaryPart(scanner[0])) {
                if (this.checkPossibleRealPart(scanner[1])) {
                    return complex_number;
                } else {
                    return invalid_insert;
                }
            }
            return invalid_insert;
        }
        return continue_checking;
    }

    /**
     * Controlla se la stringa è un numero complesso, se è un numero reale , se
     * è un numero immaginario o se l'inserimento non è valido.
     *
     * @param text
     * @return COMPLEX_NUMBER se è un numero complesso, se è un numero reale o
     * se è un numero immaginario, INVALID se l'inserimento non è valido.
     */
    public String checkerString(String text) {
        if (text.length() == 0) {
            return invalid_insert;
        }
        text = clearString(text);
        if (text.startsWith("+") || text.startsWith("-")) {
            return invalid_insert;
        }
        String return_value = checkComplexNumber(text);
        if (!(return_value.equals(continue_checking))) {
            return return_value;
        }
        return_value = checkPossibleOneNumber(text);
        if (!(return_value.equals(continue_checking))) {
            return return_value;
        }
        return invalid_insert;
    }
    /**
     * Rimuove il "\n" inserito dal controller se avviene l'inserimento tramite la prissione del tasto invio e il primo carattere se è un segno.
     * @param text
     * @return La stringa modificata.
     */
    public char checkFirstCharacter(String text) {
        text = text.replaceAll("\\n", "");
        if (text.startsWith("+") || text.startsWith("-")) {
            StringBuilder sb = new StringBuilder(text);
            return sb.charAt(0);
        }
        return ' ';
    }
    /**
     * Crea il ComplexNumber partendo da una striga avente un numero complesso.
     * @param text
     * @return ComplexNumber creato.
     */
    public ComplexNumber createFromComplexNumber(String text) {
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(replaceAll);
        char operator2 = ' ';
        if (text.contains("+")) {
            operator2 = '+';
        }
        if (text.contains("-")) {
            operator2 = '-';
        }
        String[] scanner = text.split("\\+|\\-");
        if (scanner[0].contains("j")) {
            String image = scanner[0].replace("j", "");
            return new ComplexNumber(Double.parseDouble(operator2 + scanner[1]), Double.parseDouble(operator1 + image));
        } else {
            double real = Double.parseDouble(operator1 + scanner[0]);
            String image = scanner[1].replace("j", "");
            return new ComplexNumber(real, Double.parseDouble(operator2 + image));
        }
    }
    /**
     * Crea il ComplexNumber dalla stringa composta da un numero reale o da un numero immaginario.
     * @param text
     * @return ComplexNumber Creato.
     */
    public ComplexNumber createFromSingleNumber(String text) {
        String replaceAll = text.replaceAll(" ", "");
        char operator1 = this.checkFirstCharacter(text);
        text = this.clearString(text);
        if (text.contains("j")) {
            String image = text.replace("j", "");
            return new ComplexNumber(0, Double.parseDouble(operator1 + image));
        } else {
            double real = Double.parseDouble(operator1 + text);
            return new ComplexNumber(real, 0);
        }
    }
}
