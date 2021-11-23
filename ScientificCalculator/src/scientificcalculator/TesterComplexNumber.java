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
public class TesterComplexNumber {

    public static void main(String[] args) {
        //String a ="4+j5"; QUESTO è COMMENTATO PERCHè IL CARATTERE + DA ERRORE : Dangling meta character '+'
        //VISTO CHE IL CARATTERE + è INUTILIZABILE AL MOMENTO HO CREATO UN ALTRO COSTRUTTORE DOVE SI PUò PASSARE I VALORI DIRETTAMENTE
        
        String b = "4";
        String c = "j7";

        ComplexNumber d = new ComplexNumber(4,5);
        ComplexNumber e = new ComplexNumber(b);
        ComplexNumber f = new ComplexNumber(c);

        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

    }

}
