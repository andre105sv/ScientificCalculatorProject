/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.ArithmeticalException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class SubtractionTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class Subtraction.
     */
    @Test
    public void testExecute() throws ArithmeticalException{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);  
        ComplexNumber expResultAB = new ComplexNumber(-34.5, +7.11);     
        ArithmeticalOperations subtractionAB = factory.getOperation("SUBTRACTION", a, b, DECIMAL_NUMBERS);
        ComplexNumber resultAB[] = subtractionAB.execute();
        assertEquals(expResultAB.getRealPart(), resultAB[0].getRealPart(), PRECISION);
        assertEquals(expResultAB.getImmPart(), resultAB[0].getImmPart(), PRECISION);
        ComplexNumber c = new ComplexNumber(-50, 12);
        ComplexNumber d = new ComplexNumber(-0.0001, -0.0000000001);  
        ComplexNumber expResultCD = new ComplexNumber(-50, 12);     
        ArithmeticalOperations subtractionCD = factory.getOperation("SUBTRACTION", c, d, DECIMAL_NUMBERS);
        ComplexNumber resultCD[] = subtractionCD.execute();
        assertEquals(expResultCD.getRealPart(), resultCD[0].getRealPart(), PRECISION);
        assertEquals(expResultCD.getImmPart(), resultCD[0].getImmPart(), PRECISION);
    }

}
