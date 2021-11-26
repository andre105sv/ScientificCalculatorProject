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

    /**
    * Restituisce la somma di due nomeri complessi.
    * @param    a   il primo operando di tipo ComplexNumber
    * @param    b   il secondo operando di tipo ComplexNumber
    * @return   l'oggetto di tipo ComplexNumber che si ottiene dalla somma dei 
    *           parametri in input
    */
    public static ComplexNumber addition(ComplexNumber a, ComplexNumber b){
        double realSum = a.getRealPart() + b.getRealPart();
        double immSum = a.getImmPart() + b.getImmPart();
        ComplexNumber c = new ComplexNumber(realSum, immSum);
        return c;
    }

    /**
    * Restituisce la differenza di due nomeri complessi.
    * @param    a   il minuendo di tipo ComplexNumber
    * @param    b   il sottraendo di tipo ComplexNumber
    * @return   l'oggetto di tipo ComplexNumber che si ottiene dalla differenza 
    *           dei parametri in input
    */
    public static ComplexNumber substraction(ComplexNumber a, ComplexNumber b){
        double realDiff = a.getRealPart() - b.getRealPart();
        double immDiff = a.getImmPart() - b.getImmPart();
        ComplexNumber c = new ComplexNumber(realDiff, immDiff);
        return c;
    }

    /**
    * Restituisce il prodotto di due nomeri complessi.
    * @param    a   il primo fattore di tipo ComplexNumber
    * @param    b   il secondo fattore di tipo ComplexNumber
    * @return   l'oggetto di tipo ComplexNumber che si ottiene dal prodotto dei 
    *           parametri in input
    */
    public static ComplexNumber multiplication(ComplexNumber a, ComplexNumber b){
        ComplexNumber c = new ComplexNumber(a.getRealPart() * b.getRealPart() - a.getImmPart() * b.getImmPart(), a.getRealPart() * b.getImmPart() + a.getImmPart() * b.getRealPart());
        return c;
    }

    /**
    * Restituisce il rapporto di due nomeri complessi.
    * @param    a   il divisore di tipo ComplexNumber
    * @param    b   il dividendo di tipo ComplexNumber
    * @return   l'oggetto di tipo ComplexNumber che si ottiene dal rapporto tra 
    *           i parametri in input
    */
    public static ComplexNumber division(ComplexNumber a, ComplexNumber b) throws Exception{
        if((b.getRealPart() == 0) && (b.getImmPart() == 0)){
            throw new Exception("Divisione per 0 non amessa");
        }
        ComplexNumber c = new ComplexNumber((a.getRealPart() * b.getRealPart() + a.getImmPart() * b.getImmPart()) / (Math.pow(b.getRealPart(), 2) + Math.pow(b.getImmPart(), 2)), (a.getImmPart() * b.getRealPart() - a.getRealPart() * b.getImmPart()) / (Math.pow(b.getRealPart(),2) + Math.pow(b.getImmPart(), 2)));
        return c;
    }

    /**
    * Restituisce l'opposto di un nomero complessi.
    * @param    a   un operando di tipo ComplexNumber
    * @return   l'oggetto di tipo ComplexNumber che si ottiene invertendo il 
    *           segno del numero complesso in input
    */
    public static ComplexNumber reversalSign(ComplexNumber a){
        ComplexNumber b = new ComplexNumber(a.getRealPart() * (-1), a.getImmPart() * (-1));
        return b;
    }
    
    /**
    * Restituisce la radice quadrata di un nomero complesso.
    * @param    a   un operando di tipo ComplexNumber
    * @return   un array di ComplexNumber contenente le due radici quadrate del
    *           parametro passato in input
    */
    public static ComplexNumber[] squareRoot(ComplexNumber a){
        if (a.getImmPart() == 0.0){
            return new ComplexNumber[]{new ComplexNumber(Math.sqrt(a.getRealPart()), 0)};
        }
        double modulo = Math.sqrt(Math.pow(a.getRealPart(), 2) + Math.pow(a.getImmPart(), 2));
        double radModulo = Math.sqrt(modulo);
        double fase = 0.0;
        if((a.getRealPart() == 0) && (a.getImmPart() > 0)){
            fase = 3.14/2;
        }
        if((a.getRealPart() == 0) && (a.getImmPart() < 0)){
            fase = -3.14/2;
        }
        if((a.getRealPart() == 0) && (a.getImmPart() == 0)){
            fase = Double.NaN;
        }
        if(a.getRealPart() > 0){
            fase = Math.atan2(a.getImmPart(), a.getRealPart());
        }
        if((a.getRealPart() < 0) && (!(a.getImmPart() < 0))){
            fase = Math.atan2(a.getImmPart(), a.getRealPart()) + 3.14;
        }
        if((a.getRealPart() < 0) && (a.getImmPart() < 0)){
            fase = Math.atan2(a.getImmPart(), a.getRealPart()) - 3.14;
        }
        ComplexNumber b = new ComplexNumber(radModulo * Math.cos(fase), radModulo * Math.sin(fase));
        ComplexNumber c = new ComplexNumber(radModulo * Math.cos((fase + 2 * 3.14) / 2), radModulo * Math.sin((fase + 2 * 3.14) / 2));
        ComplexNumber[] s = new ComplexNumber[]{b, c};
        return s;
    }
    
}
