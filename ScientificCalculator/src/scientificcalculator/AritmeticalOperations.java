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
    
    private static double DECIMAL_NUMBERS;

    public AritmeticalOperations(double decimal_number) {
        this.DECIMAL_NUMBERS = decimal_number;
    }
    
    /**
     * Restituisce la somma dei due numeri complessi.
     * @param a Primo ComplexNumber.
     * @param b Secondo ComplexNumber.
     * @return Somma di a e b.
     */
    public ComplexNumber addition(ComplexNumber a, ComplexNumber b){
        double realSum = ((a.getRealPart() + b.getRealPart())*DECIMAL_NUMBERS)/DECIMAL_NUMBERS;
        double immSum = ((a.getImmPart() + b.getImmPart())*DECIMAL_NUMBERS)/DECIMAL_NUMBERS;
        ComplexNumber c = new ComplexNumber(realSum, immSum);
        return c;
    }
    /**
     * Restituisce la differenza di due numeri complessi.
     * @param a Primo ComplexNumber.
     * @param b Secondo ComplexNumber.
     * @return Differenza di a e b.
     */
    public ComplexNumber substraction(ComplexNumber a, ComplexNumber b){
        double realDiff = ((a.getRealPart() - b.getRealPart())*DECIMAL_NUMBERS)/DECIMAL_NUMBERS;
        double immDiff = ((a.getImmPart() - b.getImmPart())*DECIMAL_NUMBERS)/DECIMAL_NUMBERS;
        ComplexNumber c = new ComplexNumber(realDiff, immDiff);
        return c;
    }
    /**
     * Restituisce il prodotto di due numeri complessi.
     * @param a Primo ComplexNumber.
     * @param b Secondo ComplexNumber.
     * @return Prodotto di a e b.
     */
    public ComplexNumber multiplication(ComplexNumber a, ComplexNumber b){
        ComplexNumber c = new ComplexNumber(((a.getRealPart() * b.getRealPart() - a.getImmPart() * b.getImmPart())*DECIMAL_NUMBERS)/DECIMAL_NUMBERS, ((a.getRealPart() * b.getImmPart() + a.getImmPart() * b.getRealPart())*DECIMAL_NUMBERS)/DECIMAL_NUMBERS);
        return c;
    }
    /**
     * Restituisce il rapporto di due numeri complessi.
     * @param a Primo ComplexNumber.
     * @param b Secondo ComplexNumber.
     * @return Rapporto di a e b.
     */
    public ComplexNumber division(ComplexNumber a, ComplexNumber b) throws Exception{
        if (b.getRealPart() == 0 && b.getImmPart() == 0)
            throw new Exception("Divisione per 0 non amessa");
        ComplexNumber c = new ComplexNumber((((a.getRealPart() * b.getRealPart() + a.getImmPart() * b.getImmPart()) / (Math.pow(b.getRealPart(), 2) + Math.pow(b.getImmPart(), 2)))*DECIMAL_NUMBERS)/DECIMAL_NUMBERS, (((a.getImmPart() * b.getRealPart() - a.getRealPart() * b.getImmPart()) / (Math.pow(b.getRealPart(),2) + Math.pow(b.getImmPart(), 2)))*DECIMAL_NUMBERS)/DECIMAL_NUMBERS);
        return c;
    }
    /**
     * Restituisce l'inverso di un numero complesso.
     * @param a ComplexNumber
     * @return L'inverso di a.
     */
    public ComplexNumber reversalSign(ComplexNumber a){
        ComplexNumber b = new ComplexNumber(((a.getRealPart() * (-1))*DECIMAL_NUMBERS)/DECIMAL_NUMBERS, ((a.getImmPart() * (-1))*DECIMAL_NUMBERS)/DECIMAL_NUMBERS);
        return b;
    }
    
    /**
     * Restituisce la radice quadrata di un numero complesso
     * @param a
     * @return Le due radici in forma algebrica di a.
     */
    public ComplexNumber[] squareRoot(ComplexNumber a) throws Exception{
        double modulo = Math.sqrt(Math.pow(a.getRealPart(), 2) + Math.pow(a.getImmPart(), 2));
        double radModulo = Math.sqrt(modulo);
        double fase = 0.0;
        
        if (a.getRealPart() == 0 && a.getImmPart() > 0)
            fase = 3.14/2;
        if (a.getRealPart() == 0 && a.getImmPart() < 0)
            fase = -3.14/2;
        if (a.getRealPart() == 0 && a.getImmPart() == 0)
            throw (new Exception ("Fase di 0 non ammessa"));
        if (a.getRealPart() > 0)
            fase = Math.atan2(a.getImmPart(), a.getRealPart());     
        if (a.getRealPart() < 0 && (a.getImmPart() > 0))
            fase = Math.atan2(a.getImmPart(), a.getRealPart()) + 3.14;
        if (a.getRealPart() < 0 && a.getImmPart() < 0)
            fase = Math.atan2(a.getImmPart(), a.getRealPart()) - 3.14;
        if (a.getRealPart() < 0 && a.getImmPart() == 0)
            return new ComplexNumber[]{new ComplexNumber(0,Math.sqrt(Math.abs(a.getRealPart())))};
        
        ComplexNumber b = new ComplexNumber(Math.round((radModulo * Math.cos(fase))*DECIMAL_NUMBERS)/DECIMAL_NUMBERS, Math.round((radModulo * Math.sin(fase))*DECIMAL_NUMBERS)/DECIMAL_NUMBERS);
        ComplexNumber c = new ComplexNumber(Math.round((radModulo * Math.cos((fase + 2 * 3.14) / 2))*DECIMAL_NUMBERS)/DECIMAL_NUMBERS, Math.round((radModulo * Math.sin((fase + 2 * 3.14) / 2))*DECIMAL_NUMBERS)/DECIMAL_NUMBERS);
        
        ComplexNumber[] s= new ComplexNumber[]{b, c};

        return s;
    }
    
}
