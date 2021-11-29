/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class SquareRootTest{

    private OperationFactory factory;
    private double DECIMAL_NUMBERS;

    @Before
    public void setUp(){
        factory = new OperationFactory();
        DECIMAL_NUMBERS = 1000.0;
    }

    /**
     * Test of execute method, of class SquareRoot.
     */
    @Test
    public void testExecute() throws Exception{
        ComplexNumber a = new ComplexNumber(3, 6);
        ComplexNumber[] expResult = new ComplexNumber[2];
        expResult[0] = new ComplexNumber(1.1583, 2.3166);
        expResult[1] = new ComplexNumber(-2.2054, -1.3581);
        ArithmeticalOperations sqrt = factory.getOperation("SQUARE_ROOT", a, DECIMAL_NUMBERS);
        ComplexNumber[] result = sqrt.execute();
        assertEquals(expResult[0].getRealPart(), result[0].getRealPart(), 0.001);
        assertEquals(expResult[0].getImmPart(), result[0].getImmPart(), 0.001);
        assertEquals(expResult[1].getRealPart(), result[1].getRealPart(), 0.001);
        assertEquals(expResult[1].getImmPart(), result[1].getImmPart(), 0.001);
    }

}
