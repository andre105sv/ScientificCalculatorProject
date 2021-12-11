/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import exceptions.NotDefinedArgumentException;
import exceptions.ArithmeticalException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author filso
 */
public class PhaseTest {
    
    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private AbstractFactory factory;

    @Before
    public void setUp(){
        factory = FactoryProducer.getFactory(false);
    }
    /**
     * Test of execute method, of class Phase.
     */
    @Test(expected = NotDefinedArgumentException.class)
    public void testExecute() throws ArithmeticalException{
        ComplexNumber c;
        Operation phase;
        c = new ComplexNumber(4, 5);
        ComplexNumber expResult = new ComplexNumber(0.896, 0);
        phase = factory.getOperation("PHASE", c, DECIMAL_NUMBERS);
        ComplexNumber result[] = phase.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        c = new ComplexNumber(0, 0);
        phase = factory.getOperation("PHASE", c, DECIMAL_NUMBERS);
        result = phase.execute();
    }
    
}
