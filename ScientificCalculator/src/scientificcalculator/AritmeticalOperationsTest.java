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
public class AritmeticalOperationsTest {
    
    public static void additionTest(ComplexNumber a,ComplexNumber b){
        System.out.println("Somma di "+a+"+"+b+":"+AritmeticalOperations.addition(a, b));
    }
    public static void substrationTest(ComplexNumber a,ComplexNumber b){
        System.out.println("Differenza di "+a+"-"+b+":"+AritmeticalOperations.substraction(a, b));
    }
    public static void divisionTest(ComplexNumber a,ComplexNumber b){
        System.out.println("Rapporto di "+a+"/"+b+":"+AritmeticalOperations.division(a, b));
    }
    public static void multiplicationTest(ComplexNumber a,ComplexNumber b){
        System.out.println("Prodotto di "+a+"*"+b+":"+AritmeticalOperations.multiplication(a, b));
    }
    public static void reversalSignTest(ComplexNumber a){
        System.out.println("Inverso di "+a+":"+AritmeticalOperations.reversalSign(a));
    }
    public static void squareRootTest(ComplexNumber a){
        System.out.println("Prima radice:"+AritmeticalOperations.squareRoot(a)[0]);
        System.out.println("Seconda radice:"+AritmeticalOperations.squareRoot(a)[1]);
    }      
}
