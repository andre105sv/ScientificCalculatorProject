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
public class ReversalSignTest{

    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class ReversalSign.
     */
    @Test
    public void testExecute() throws Exception{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber expResult = new ComplexNumber(32, -7);     
        ArithmeticalOperations reverse = factory.getOperation("REVERSAL_SIGN", a, 0.0001);
        ComplexNumber result = reverse.execute();
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0.0001);
        assertEquals(expResult.getImmPart(), result.getImmPart(), 0.0001);
    }

}
