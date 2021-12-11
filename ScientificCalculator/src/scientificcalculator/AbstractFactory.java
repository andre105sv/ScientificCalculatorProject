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
public abstract class AbstractFactory{
    
    public abstract Operation getOperation(String operation, ComplexNumber firstOp, ComplexNumber secondOp, double decimals);
    public abstract Operation getOperation(String operation, ComplexNumber operand, double decimals);

}
