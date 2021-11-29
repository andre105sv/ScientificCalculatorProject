/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import java.lang.Exception;

/**
 *
 * @author Andrea
 */
public class SquareRoot implements ArithmeticalOperations{

    private ComplexNumber operand;
    private double decimals;

    public SquareRoot(ComplexNumber c, double dec){
        this.operand = c;
        this.decimals = dec;
    }

    /**
    * Restituisce le radici quadrate di un nomero complesso o la radice quadrata
    * di un numero reale.
    * @return   un array di ComplexNumber contenente le due radici quadrate di
    *           un numero complesso o la radice quadrata di un numero reale
    */
    @Override
    public ComplexNumber[] executeSqrt() throws Exception{
        double modulo = Math.sqrt(Math.pow(operand.getRealPart(), 2) + Math.pow(operand.getImmPart(), 2));
        double radModulo = Math.sqrt(modulo);
        double fase = 0.0;
        if((operand.getRealPart() > 0) && (operand.getImmPart() == 0)){
            return new ComplexNumber[]{new ComplexNumber(Math.sqrt(Math.abs(operand.getRealPart())),0)};
        }
        if((operand.getRealPart() == 0) && (operand.getImmPart() > 0)){
            fase = 3.14 / 2;
        }
        if((operand.getRealPart() == 0) && (operand.getImmPart() < 0)){
            fase = -3.14 / 2;
        }
        if((operand.getRealPart() == 0) && (operand.getImmPart() == 0)){
            throw (new Exception ("Fase di 0 non ammessa"));
        }
        if(operand.getRealPart() > 0){
            fase = Math.atan2(operand.getImmPart(), operand.getRealPart());
        }
        if((operand.getRealPart() < 0) && (operand.getImmPart() > 0)){
            fase = Math.atan2(operand.getImmPart(), operand.getRealPart()) + 3.14;
        }
        if((operand.getRealPart() < 0) && (operand.getImmPart() < 0)){
            fase = Math.atan2(operand.getImmPart(), operand.getRealPart()) - 3.14;
        }
        if((operand.getRealPart() < 0) && (operand.getImmPart() == 0)){
            return new ComplexNumber[]{new ComplexNumber(0, Math.sqrt(Math.abs(operand.getRealPart())))};
        }
        ComplexNumber b = new ComplexNumber(Math.round((radModulo * Math.cos(fase)) * decimals) / decimals, Math.round((radModulo * Math.sin(fase)) * decimals) / decimals);
        ComplexNumber c = new ComplexNumber(Math.round((radModulo * Math.cos((fase + 2 * 3.14) / 2)) * decimals) / decimals, Math.round((radModulo * Math.sin((fase + 2 * 3.14) / 2)) * decimals) / decimals);
        ComplexNumber[] s = new ComplexNumber[]{b, c};
        return s;
    }

    @Override
    public ComplexNumber execute() throws Exception{
        return null;
    }

}
