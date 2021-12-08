/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.DivisionByZeroException;
import exceptions.NotDefinedArgumentException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class DivisionTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class Division.
     */
    @Test(expected = DivisionByZeroException.class)
    public void testExecute() throws DivisionByZeroException, NotDefinedArgumentException{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);  
        ComplexNumber expResult = new ComplexNumber(-12.898 , +2.232);     
        ArithmeticalOperations division = factory.getOperation("DIVISION", a, b, DECIMAL_NUMBERS);
        ComplexNumber result[] = division.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        ComplexNumber a1 = new ComplexNumber(-45.2, 0);
        ComplexNumber b1 = new ComplexNumber(0, 0);
        ArithmeticalOperations division1 = factory.getOperation("DIVISION", a1, b1, DECIMAL_NUMBERS);
        ComplexNumber result1[] = division1.execute();
        ComplexNumber a2 = new ComplexNumber(-32, +7.12);
        ComplexNumber b2 = new ComplexNumber(0, 0);
        ArithmeticalOperations division2 = factory.getOperation("DIVISION", a2, b2, DECIMAL_NUMBERS);
        ComplexNumber result2[] = division2.execute();
    }

}
