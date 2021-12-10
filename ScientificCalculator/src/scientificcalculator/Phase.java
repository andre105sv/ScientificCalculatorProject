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
public class Phase implements TranscendentalOperations{
    
    private ComplexNumber operand;
    private double decimals; 

    /**
    * Costruisce un oggetto di tipo Phase a partire da un numero 
    * complesso e dalla sua precisione.
    * @param    operand         l'operando di tipo ComplexNumber
    * @param    decimals        la precisione in formato double
    */
    public Phase(ComplexNumber operand, double decimals){
        this.operand = operand;
        this.decimals = decimals;
    }

    /**
    * Restituisce la fase di un numero complesso.
    * @throws NotDefinedArgumentException   se si calcola la fase di 0
    * @return   un array di ComplexNumber contenente la fase del numero complesso.
    */
    @Override
    public ComplexNumber[] execute() throws NotDefinedArgumentException{
        double phase = 0.0;
        if((operand.getRealPart() == 0) && (operand.getImmPart() > 0)){
            phase = 3.14 / 2;
        }
        if((operand.getRealPart() == 0) && (operand.getImmPart() < 0)){
            phase = -3.14 / 2;
        }
        if((operand.getRealPart() == 0) && (operand.getImmPart() == 0)){
            throw new NotDefinedArgumentException();
        }
        if(operand.getRealPart() > 0){
            phase = Math.atan2(operand.getImmPart(), operand.getRealPart());
        }
        if((operand.getRealPart() < 0) && !(operand.getImmPart() < 0)){
            phase = Math.atan2(operand.getImmPart(), operand.getRealPart()) + 3.14;
        }
        if((operand.getRealPart() < 0) && (operand.getImmPart() < 0)){
            phase = Math.atan2(operand.getImmPart(), operand.getRealPart()) - 3.14;
        }
        return new ComplexNumber[]{new ComplexNumber(Math.round((phase) * decimals) / decimals, 0)};
    }

}
