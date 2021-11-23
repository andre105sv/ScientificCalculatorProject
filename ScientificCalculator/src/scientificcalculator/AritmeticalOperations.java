/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;
import java.lang.Exception;
/**
 *
 * @author filso
 */
public class AritmeticalOperations{
    public static ComplexNumber addition(ComplexNumber a, ComplexNumber b){
        double realSum = a.getRealPart() + b.getRealPart();
        double immSum = a.getImmPart() + b.getImmPart();
        ComplexNumber c = new ComplexNumber(realSum,immSum);
        return c;
    }
    public static ComplexNumber substraction(ComplexNumber a,ComplexNumber b){
        double realDiff = a.getRealPart() - b.getRealPart();
        double immDiff = a.getImmPart() - b.getImmPart();
        ComplexNumber c = new ComplexNumber(realDiff,immDiff);
        return c;
    }
    public static ComplexNumber multiplication(ComplexNumber a,ComplexNumber b){
        ComplexNumber c = new ComplexNumber(a.getRealPart() * b.getRealPart() - a.getImmPart() * b.getImmPart(), a.getRealPart() * b.getImmPart() + a.getImmPart() * b.getRealPart());
        return c;
    }
    public static ComplexNumber division(ComplexNumber a, ComplexNumber b){
        ComplexNumber c = new ComplexNumber((a.getRealPart() * b.getRealPart() + a.getImmPart() * b.getImmPart()) / (Math.pow(b.getRealPart(), 2) + Math.pow(b.getImmPart(), 2)), (a.getImmPart() * b.getRealPart() - a.getRealPart() * b.getImmPart()) / (Math.pow(b.getRealPart(),2) + Math.pow(b.getImmPart(), 2)));
        return c;
    }
    public static ComplexNumber reversalSign(ComplexNumber a){
        ComplexNumber b = new ComplexNumber(a.getRealPart() * (-1), a.getImmPart() * (-1));
        return b;
    }
    public static ComplexNumber[] squareRoot(ComplexNumber a){
        if (a.getImmPart()==0.0)
            return new ComplexNumber[]{new ComplexNumber(Math.sqrt(a.getRealPart()),0)};
        double modulo = Math.sqrt(Math.pow(a.getRealPart(), 2) + Math.pow(a.getImmPart(), 2));
        double radModulo = Math.sqrt(modulo);
        double fase = 0.0;
        if (a.getRealPart() == 0 && a.getImmPart() > 0)
            fase = 3.14/2;
        if (a.getRealPart() == 0 && a.getImmPart() < 0)
            fase = -3.14/2;
        if (a.getRealPart() == 0 && a.getImmPart() == 0)
            fase = Double.NaN;            
        if (a.getRealPart() > 0)
            fase = Math.atan2(a.getImmPart(), a.getRealPart());     
        if (a.getRealPart() < 0 && (!(a.getImmPart() < 0)))
            fase = Math.atan2(a.getImmPart(), a.getRealPart()) + 3.14;
        if (a.getRealPart() < 0 && a.getImmPart() < 0)
            fase = Math.atan2(a.getImmPart(), a.getRealPart()) - 3.14;
        
        ComplexNumber b = new ComplexNumber(radModulo * Math.cos(fase), radModulo * Math.sin(fase));
        ComplexNumber c = new ComplexNumber(radModulo * Math.cos((fase + 2 * 3.14) / 2), radModulo * Math.sin((fase + 2 * 3.14) / 2));
        ComplexNumber[] s= new ComplexNumber[]{b, c};

        return s;
        
    }
    
}
