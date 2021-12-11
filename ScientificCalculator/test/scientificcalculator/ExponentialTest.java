/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anton
 */
public class ExponentialTest {
    
    Exponential instance1;
    Exponential instance2;
    private double decimals = 0.0001;
    private double DECIMAL_NUMBERS = 1000;
    private AbstractFactory factory;
    
    @Before
    public void setUp(){
        factory = FactoryProducer.getFactory(false);
    }
    
    /**
     * Test of execute method, of class Exponential.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        //test fatto considerando solo la parte reale
        ComplexNumber expResult1 = new ComplexNumber(20.086,0);
        Operation exponential1 = factory.getOperation("EXPONENTIAL", new ComplexNumber(3, 0), DECIMAL_NUMBERS);
        ComplexNumber[] resultArray1 = exponential1.execute();
        ComplexNumber result1 = resultArray1[0];
        assertEquals(expResult1.getRealPart(), result1.getRealPart(), decimals);
        assertEquals(expResult1.getImmPart(), result1.getImmPart(), decimals);
        //test fatto considerando sia parte reale che parte immaginaria
        ComplexNumber expResult2 = new ComplexNumber(-19.885, 2.834);
        Operation exponential2 = factory.getOperation("EXPONENTIAL", new ComplexNumber(3, 3), DECIMAL_NUMBERS);
        ComplexNumber[] resultArray2 = exponential2.execute();
        ComplexNumber result2 = resultArray2[0];
        assertEquals(expResult2.getRealPart(), result2.getRealPart(), decimals);
        assertEquals(expResult2.getImmPart(), result2.getImmPart(), decimals);
    }
    
}
