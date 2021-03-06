/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

/**
 *
 * @author Andrea
 */
public class ComplexNumber{

    private double realPart;
    private double immPart;  

    /**
    * Costruisce un oggetto di tipo ComplexNumber generato a partire dalla 
    * sua parte reale e dalla sua parte immaginaria.
    * @param    realPart    la parte reale (double) di un numero complesso
    * @param    immPart     la parte immaginaria (double) di un numero complesso
    */
    public ComplexNumber(double realPart, double immPart){
        this.realPart = realPart;
        this.immPart = immPart;
    }

    /**
    * Restituisce la parte reale del numero complesso.
    * @return   la parte reale del numero complesso
    */
    public double getRealPart(){
        return this.realPart;
    }

    /**
    * Restituisce la parte immaginaria del numero complesso.
    * @return   la parte immaginaria del numero complesso
    */
    public double getImmPart(){
        return this.immPart;
    }

    /**
    * Restituisce la stringa che rappresenta il numero complesso nel formato 
    * "±a ±bj" oppure "a ±bj" con "a" e "b" numeri reali.
    * @return   la stringa che identifica il numero complesso
    */
    @Override
    public String toString(){
        String s;
        if(this.realPart < 0){
            s = "-" + Math.abs(this.realPart);
        }
        else{
            s = String.valueOf(this.realPart);
        }
        if(this.immPart == 0){
            return s;
        }
        else if(this.immPart < 0){
            return (s + " -" + Math.abs(this.immPart) + "j");
        }
        else{
            return (s + " +" + this.immPart + "j");
        }
    }
    
}
