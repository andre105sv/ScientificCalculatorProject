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
        System.out.println(AritmeticalOperations.Addition(a, b));
        System.out.println(AritmeticalOperations.Division(a, b));
        System.out.println(AritmeticalOperations.Substraction(a, b));
        System.out.println(AritmeticalOperations.Multiplication(a, b));
        System.out.println("Test con:"+ a + c);
        System.out.println(AritmeticalOperations.Addition(a, c));
        System.out.println(AritmeticalOperations.Division(a, c));
        System.out.println(AritmeticalOperations.Substraction(a, c));
        System.out.println(AritmeticalOperations.Multiplication(a,c));
        System.out.println("Test con:"+ c + b);
        System.out.println(AritmeticalOperations.Addition(c, b));
        System.out.println(AritmeticalOperations.Division(c, b));
        System.out.println(AritmeticalOperations.Substraction(c, b));
        System.out.println(AritmeticalOperations.Multiplication(c, b));
        System.out.println("Test inverisione segno di:"+a+b+c);
        System.out.println(AritmeticalOperations.ReversalSign(a));
        System.out.println(AritmeticalOperations.ReversalSign(b));
        System.out.println(AritmeticalOperations.ReversalSign(c));
        System.out.println("Test radice quadrata di:"+a+b+c);
        System.out.println(AritmeticalOperations.SquareRoot(a)[0]+ "-" +AritmeticalOperations.SquareRoot(a)[1]);
        System.out.println(AritmeticalOperations.SquareRoot(b)[0]+ "-" +AritmeticalOperations.SquareRoot(b)[1]);
        System.out.println(AritmeticalOperations.SquareRoot(c)[0]+ "-" +AritmeticalOperations.SquareRoot(c)[1]);
        }
}
