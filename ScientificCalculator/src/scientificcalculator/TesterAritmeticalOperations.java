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
public class TesterAritmeticalOperations {
    public static void main(String[] args) {
        ComplexNumber a=new ComplexNumber(4,5);
        ComplexNumber b=new ComplexNumber("6");
        ComplexNumber c=new ComplexNumber("j7");
        
        System.out.println("Test con:"+ a + b);
        System.out.println(AritmeticalOperations.addition(a, b));
        System.out.println(AritmeticalOperations.division(a, b));
        System.out.println(AritmeticalOperations.substraction(a, b));
        System.out.println(AritmeticalOperations.multiplication(a, b));
        System.out.println("Test con:"+ a + c);
        System.out.println(AritmeticalOperations.addition(a, c));
        System.out.println(AritmeticalOperations.division(a, c));
        System.out.println(AritmeticalOperations.substraction(a, c));
        System.out.println(AritmeticalOperations.multiplication(a,c));
        System.out.println("Test con:"+ c + b);
        System.out.println(AritmeticalOperations.addition(c, b));
        System.out.println(AritmeticalOperations.division(c, b));
        System.out.println(AritmeticalOperations.substraction(c, b));
        System.out.println(AritmeticalOperations.multiplication(c, b));
        System.out.println("Test inverisione segno di:"+a+b+c);
        System.out.println(AritmeticalOperations.reversalSign(a));
        System.out.println(AritmeticalOperations.reversalSign(b));
        System.out.println(AritmeticalOperations.reversalSign(c));
        System.out.println("Test radice quadrata di:"+a+b+c);
        System.out.println(AritmeticalOperations.squareRoot(a)[0]+ "-" +AritmeticalOperations.squareRoot(a)[1]);
        System.out.println(AritmeticalOperations.squareRoot(b)[0]+ "-" +AritmeticalOperations.squareRoot(b)[1]);
        System.out.println(AritmeticalOperations.squareRoot(c)[0]+ "-" +AritmeticalOperations.squareRoot(c)[1]);
        }
}
