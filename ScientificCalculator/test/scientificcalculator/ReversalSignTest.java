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
public class ReversalSignTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class ReversalSign.
     */
    @Test
    public void testExecute() throws DivisionByZeroException, NotDefinedArgumentException{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber expResult = new ComplexNumber(32, -7);     
        ArithmeticalOperations reverse = factory.getOperation("REVERSAL_SIGN", a, DECIMAL_NUMBERS);
        ComplexNumber result[] = reverse.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        ComplexNumber realValue = new ComplexNumber(15, 0);
        ComplexNumber expRealResult = new ComplexNumber(-15, 0);     
        ArithmeticalOperations reverseReal = factory.getOperation("REVERSAL_SIGN", realValue, DECIMAL_NUMBERS);
        ComplexNumber resultReal[] = reverseReal.execute();
        assertEquals(expRealResult.getRealPart(), resultReal[0].getRealPart(), PRECISION);
        assertEquals(expRealResult.getImmPart(), resultReal[0].getImmPart(), PRECISION);
    }

}
