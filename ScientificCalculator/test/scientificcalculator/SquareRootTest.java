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
public class SquareRootTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class SquareRoot.
     */
    @Test(expected = NotDefinedArgumentException.class)
    public void testExecute() throws DivisionByZeroException, NotDefinedArgumentException{
        ComplexNumber a = new ComplexNumber(3, 6);
        ComplexNumber[] expResult = new ComplexNumber[2];
        expResult[0] = new ComplexNumber(1.158, 2.317);
        expResult[1] = new ComplexNumber(-2.205, -1.358);
        ArithmeticalOperations sqrt = factory.getArithmeticalOperations("SQUARE_ROOT", a, DECIMAL_NUMBERS);
        ComplexNumber[] result = sqrt.execute();
        assertEquals(expResult[0].getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult[0].getImmPart(), result[0].getImmPart(), PRECISION);
        assertEquals(expResult[1].getRealPart(), result[1].getRealPart(), PRECISION);
        assertEquals(expResult[1].getImmPart(), result[1].getImmPart(), PRECISION);
        ComplexNumber zero = new ComplexNumber(0, 0);
        ArithmeticalOperations sqrtOfZero = factory.getArithmeticalOperations("SQUARE_ROOT", zero, DECIMAL_NUMBERS);
        ComplexNumber[] resultSqrtOfZero = sqrtOfZero.execute();
    }

}
