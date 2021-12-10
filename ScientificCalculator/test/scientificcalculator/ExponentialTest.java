/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    
    @Before
    public void setUp() {
        instance1 = new Exponential(new ComplexNumber(3,0));
        instance2 = new Exponential(new ComplexNumber(3,3));
        
    }
    
    

    /**
     * Test of execute method, of class Exponential.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        //test fatto considerando solo la parte reale
        ComplexNumber expResult1 = new ComplexNumber(20.085536923187668,0);
        ComplexNumber[] resultArray1 = instance1.execute();
        ComplexNumber result1 = resultArray1[0];
        assertEquals(expResult1.getRealPart(), result1.getRealPart(), decimals);
        assertEquals(expResult1.getImmPart(), result1.getImmPart(), decimals);
        //test fatto considerando sia parte reale che parte immaginaria
        ComplexNumber expResult2 = new ComplexNumber(-19.8845308, 2.83447113);
        ComplexNumber[] resultArray2 = instance2.execute();
        ComplexNumber result2 = resultArray2[0];
        assertEquals(expResult2.getRealPart(), result2.getRealPart(), decimals);
        assertEquals(expResult2.getImmPart(), result2.getImmPart(), decimals);
    }
    
    
}
