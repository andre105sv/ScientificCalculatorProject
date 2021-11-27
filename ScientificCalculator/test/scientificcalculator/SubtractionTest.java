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
public class SubtractionTest{

    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class Subtraction.
     */
    @Test
    public void testExecute() throws Exception{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);  
        ComplexNumber expResult = new ComplexNumber(-34.5 , +7.11);     
        ArithmeticalOperations subtraction = factory.getOperation("SUBTRACTION", a, b, 0.0001);
        ComplexNumber result = subtraction.execute();
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0.0001);
        assertEquals(expResult.getImmPart(), result.getImmPart(), 0.0001);
    }

}
