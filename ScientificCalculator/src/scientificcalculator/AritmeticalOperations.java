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
public class AritmeticalOperations {
    public static ComplexNumber Addition (ComplexNumber a, ComplexNumber b){
        double realSum= a.getRealPart()+b.getRealPart();
        double immSum= a.getImmPart()+b.getImmPart();
        ComplexNumber c = new ComplexNumber(realSum,immSum);
        return c;
    }
    public static ComplexNumber Substraction (ComplexNumber a,ComplexNumber b){
        double realDiff= a.getRealPart()-b.getRealPart();
        double immDiff= a.getImmPart()-b.getImmPart();
        ComplexNumber c = new ComplexNumber(realDiff,immDiff);
        return c;
    }
    public static ComplexNumber Multiplication (ComplexNumber a,ComplexNumber b){
        ComplexNumber c = new ComplexNumber(a.getRealPart()*b.getRealPart()-a.getImmPart()*b.getImmPart(),a.getRealPart()*b.getImmPart()+a.getImmPart()*b.getRealPart());
        return c;
    }
    public static ComplexNumber Division (ComplexNumber a, ComplexNumber b){
        ComplexNumber c=new ComplexNumber((a.getRealPart()*b.getRealPart()+a.getImmPart()*b.getImmPart())/(Math.pow(b.getRealPart(),2)+Math.pow(b.getImmPart(),2)),(a.getImmPart()*b.getRealPart()-a.getRealPart()*b.getImmPart())/(Math.pow(b.getRealPart(),2)+Math.pow(b.getImmPart(),2)));
        return c;
    }
}
