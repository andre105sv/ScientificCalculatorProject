/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import exceptions.DivisionByZeroException;
import exceptions.NotDefinedArgumentException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author filso
 */
public class ModuloTest {
    
    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class Modulo.
     */
    @Test
    public void testExecute() throws DivisionByZeroException, NotDefinedArgumentException {
        
        ComplexNumber c = new ComplexNumber(4,5);
        ComplexNumber expResult = new ComplexNumber(6.403,0);
        ArithmeticalOperations modulo = factory.getOperation("MODULO", c, DECIMAL_NUMBERS);
        ComplexNumber result[] = modulo.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
    }
    
}
