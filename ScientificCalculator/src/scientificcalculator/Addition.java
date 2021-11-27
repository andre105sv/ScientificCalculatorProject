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
public class Addition implements ArithmeticalOperations{

    private ComplexNumber firstOp;
    private ComplexNumber secondOp;

    public Addition(ComplexNumber c1, ComplexNumber c2){
        this.firstOp = c1;
        this.secondOp = c2;
    }

    public ComplexNumber execute(){
        double realSum = firstOp.getRealPart() + secondOp.getRealPart();
        double immSum = firstOp.getImmPart() + secondOp.getImmPart();
        return new ComplexNumber(realSum, immSum);
    }

}
