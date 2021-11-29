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
public class MultiplicationTest{

    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class Multiplication.
     */
    @Test
    public void testExecute() throws Exception{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);  
        ComplexNumber expResult = new ComplexNumber(-79.23 , +21.02);     
        ArithmeticalOperations multiplication = factory.getOperation("MULTIPLICATION", a, b, 1000);
        ComplexNumber result[] = multiplication.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), 0.0001);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), 0.0001);
    }

}
