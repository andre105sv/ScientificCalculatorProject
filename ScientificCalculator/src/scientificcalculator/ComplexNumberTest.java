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
public class ComplexNumberTest {
    
    public static void sintassTest(String s){
        ComplexNumber a = new ComplexNumber(s);
        System.out.println("Numero complesso creato da"+s+":"+a);
    }
    public static void sintassTest(double realpart,double immpart){
        ComplexNumber a = new ComplexNumber(realpart,immpart);
        System.out.println("Numero complesso creato dalla parte reale pari a "+realpart+"e parte immagginaria pari a "+immpart+":"+a);
    }
}
