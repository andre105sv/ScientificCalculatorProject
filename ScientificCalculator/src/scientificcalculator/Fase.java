/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import exceptions.NotDefinedArgumentException;

/**
 *
 * @author filso
 */
public class Fase implements TranscendentalOperations{
    
    private ComplexNumber operand;
    private double decimals; 

    /**
    * Costruisce un oggetto di tipo Fase a partire da un numero 
    * complesso e dalla sua precisione.
    * @param    operand       l'operando di tipo ComplexNumber
    * @param    decimals     la precisione in formato double
    */
    public Fase(ComplexNumber operand, double decimals) {
        this.operand = operand;
        this.decimals = decimals;
    }
    /**
    * Restituisce la fase di un numero complesso. 
    * @return   un array di ComplexNumber contenente la fase del numero complesso.
     * @throws exceptions.NotDefinedArgumentException
    */
    @Override
    public ComplexNumber[] execute() throws NotDefinedArgumentException{
        double fase = 0.0;
       
        if((operand.getRealPart() == 0) && (operand.getImmPart() > 0)){
            fase = 3.14 / 2;
        }
        if((operand.getRealPart() == 0) && (operand.getImmPart() < 0)){
            fase = -3.14 / 2;
        }
        if((operand.getRealPart() == 0) && (operand.getImmPart() == 0)){
            throw new NotDefinedArgumentException();
        }
        if(operand.getRealPart() > 0){
            fase = Math.atan2(operand.getImmPart(), operand.getRealPart());
        }
        if((operand.getRealPart() < 0) && !(operand.getImmPart() < 0)){
            fase = Math.atan2(operand.getImmPart(), operand.getRealPart()) + 3.14;
        }
        if((operand.getRealPart() < 0) && (operand.getImmPart() < 0)){
            fase = Math.atan2(operand.getImmPart(), operand.getRealPart()) - 3.14;
        }
        return new ComplexNumber[]{new ComplexNumber(Math.round((fase)*decimals)/decimals,0)};
    }
}
