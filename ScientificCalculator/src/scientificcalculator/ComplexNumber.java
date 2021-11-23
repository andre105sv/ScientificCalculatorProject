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

    public ComplexNumber(String s){

        String tmp[] = s.split(" ");

        if(s.contains("j")){
            //+ 42 - 35j oppure 42 - 35j oppure - 42 - 35j oppure + 43 oppure - 34 oppure 56
            if((tmp[0].equals("+")) || (tmp[0].equals("-"))){
                this.realPart = Double.parseDouble(tmp[0] + tmp[1]);
                this.immPart = Double.parseDouble(tmp[2] + tmp[3].replace("j", ""));
            }
            else{
                this.realPart = Double.parseDouble(tmp[0]);
                this.immPart = Double.parseDouble(tmp[1] + tmp[2].replace("j", ""));
            }
        }
        else{
            if((tmp[0].equals("+")) || (tmp[0].equals("-"))){
                this.realPart = Double.parseDouble(tmp[0] + tmp[1]); 
            }
            else{
                this.realPart = Double.parseDouble(tmp[0]);
            }
            this.immPart = 0;
        }
    }

    public ComplexNumber(double realPart, double immPart){
        this.realPart = realPart;
        this.immPart = immPart;
    }

    public double getRealPart(){
        return this.realPart;
    }

    public double getImmPart(){
        return this.immPart;
    }

    @Override
    public String toString(){
        String s;
        if(this.realPart < 0){
            s = "- " + Math.abs(this.realPart);
        }
        else{
            s = String.valueOf(this.realPart);
        }
        if(this.immPart < 0){
            return (s + " - " + Math.abs(this.immPart) + "j");
        }
        else{
            return (s + " + " + this.immPart + "j");
        }
    }
    
    
}
