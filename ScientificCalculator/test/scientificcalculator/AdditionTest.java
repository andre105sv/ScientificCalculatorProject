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
public class AdditionTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class Addition.
     */
    @Test
    public void testExecute() throws ArithmeticalException{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);  
        ComplexNumber expResultAB = new ComplexNumber(-29.5, +6.89);     
        ArithmeticalOperations additionAB = factory.getOperation("ADDITION", a, b, DECIMAL_NUMBERS);
        ComplexNumber resultAB[] = additionAB.execute();
        assertEquals(expResultAB.getRealPart(), resultAB[0].getRealPart(),PRECISION);
        assertEquals(expResultAB.getImmPart(), resultAB[0].getImmPart(), PRECISION);
        ComplexNumber c = new ComplexNumber(1, +3);
        ComplexNumber d = new ComplexNumber(+2.55555, -0.35);  
        ComplexNumber expResultCD = new ComplexNumber(3.556, 2.65);     
        ArithmeticalOperations additionCD = factory.getOperation("ADDITION", c, d, DECIMAL_NUMBERS);
        ComplexNumber resultCD[] = additionCD.execute();
        assertEquals(expResultCD.getRealPart(), resultCD[0].getRealPart(),PRECISION);
        assertEquals(expResultCD.getImmPart(), resultCD[0].getImmPart(), PRECISION);
    }
    
}
