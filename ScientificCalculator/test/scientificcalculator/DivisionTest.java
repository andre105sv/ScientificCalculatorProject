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
public class DivisionTest{

    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class Division.
     */
    @Test
    public void testExecute() throws Exception{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);  
        ComplexNumber expResult = new ComplexNumber(-12.8982 , +2.2324);     
        ArithmeticalOperations division = factory.getOperation("DIVISION", a, b, 0.0001);
        ComplexNumber result = division.execute();
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0.0001);
        assertEquals(expResult.getImmPart(), result.getImmPart(), 0.0001);
    }

}
