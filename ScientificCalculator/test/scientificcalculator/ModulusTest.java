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
public class ModulusTest {
    
    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private AbstractFactory factory;

    @Before
    public void setUp(){
        factory = FactoryProducer.getFactory(false);
    }

    /**
     * Test of execute method, of class Modulus.
     */
    @Test(expected = NotDefinedArgumentException.class)
    public void testExecute() throws ArithmeticalException{
        ComplexNumber c;
        ComplexNumber result[];
        c = new ComplexNumber(4, 5);
        Operation modulus;
        ComplexNumber expResult = new ComplexNumber(6.403, 0);
        modulus = factory.getOperation("MODULUS", c, DECIMAL_NUMBERS);
        result = modulus.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        c = new ComplexNumber(0, 0);
        modulus = factory.getOperation("MODULUS", c, DECIMAL_NUMBERS);
        result = modulus.execute();
    }
    
}
