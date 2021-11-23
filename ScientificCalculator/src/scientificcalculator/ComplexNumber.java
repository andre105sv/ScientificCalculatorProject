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
public class ComplexNumber {
    private double realPart;
    private double immPart;

    public ComplexNumber(String s) {
        if (s.contains("\\+")){
            String tmp[] = s.split("\\+");
            this.realPart = Double.parseDouble(tmp[0]);
            this.immPart = Double.parseDouble(tmp[1]);
        }
        if (s.contains("j")&&(!(s.contains("\\+")))){
            this.realPart=0;
            this.immPart=Double.parseDouble(s.replace("j",""));
            
        }
        if (!(s.contains("j"))&&(!(s.contains("\\+")))){
            this.realPart=Double.parseDouble(s);
            this.immPart=0;
        }
    }

    public ComplexNumber(double realPart, double immPart) {
        this.realPart = realPart;
        this.immPart = immPart;
    }
    

    public double getRealPart() {
        return realPart;
    }

    public double getImmPart() {
        return immPart;
    }

    @Override
    public String toString() {
        if (immPart<0)
            return "("+realPart + "-" + immPart + "j)";
        else
            return "("+realPart + "+" + immPart + "j)";
    }
    
    
}
