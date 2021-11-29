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
public class AdditionTest{

    private OperationFactory factory;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of execute method, of class Addition.
     */
    @Test
    public void testExecute() throws Exception{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);  
        ComplexNumber expResult = new ComplexNumber(-29.5 , +6.89);     
        ArithmeticalOperations addition = factory.getOperation("ADDITION", a, b, 1000);
        ComplexNumber result[] = addition.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),0.0001);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), 0.0001);
    }

    

}
