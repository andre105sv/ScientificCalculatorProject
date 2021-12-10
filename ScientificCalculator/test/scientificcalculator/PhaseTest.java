/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import exceptions.NotDefinedArgumentException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author filso
 */
public class PhaseTest {
    
    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }
    /**
     * Test of execute method, of class Fase.
     */
    @Test
    public void testExecute() throws NotDefinedArgumentException{
        ComplexNumber c = new ComplexNumber(4, 5);
        ComplexNumber expResult = new ComplexNumber(0.896, 0);
        TranscendentalOperations fase = factory.getTranscendentalOperations("PHASE", c, DECIMAL_NUMBERS);
        ComplexNumber result[] = fase.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
    }
    
}
