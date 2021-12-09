/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.DivisionByZeroException;
import exceptions.NotDefinedArgumentException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class MultiplicationTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class Multiplication.
     */
    @Test
    public void testExecute() throws DivisionByZeroException, NotDefinedArgumentException{
        ComplexNumber a = new ComplexNumber(-32, +7);
        ComplexNumber b = new ComplexNumber(+2.5, -0.11);  
        ComplexNumber expResultAB = new ComplexNumber(-79.23, +21.02);     
        ArithmeticalOperations multiplicationAB = factory.getArithmeticalOperations("MULTIPLICATION", a, b, DECIMAL_NUMBERS);
        ComplexNumber resultAB[] = multiplicationAB.execute();
        assertEquals(expResultAB.getRealPart(), resultAB[0].getRealPart(), PRECISION);
        assertEquals(expResultAB.getImmPart(), resultAB[0].getImmPart(), PRECISION);
        ComplexNumber c = new ComplexNumber(-2.56, +3);
        ComplexNumber d = new ComplexNumber(+4.8951, -11.56);  
        ComplexNumber expResultCD = new ComplexNumber(22.149, 44.279);     
        ArithmeticalOperations multiplicationCD = factory.getArithmeticalOperations("MULTIPLICATION", c, d, DECIMAL_NUMBERS);
        ComplexNumber resultCD[] = multiplicationCD.execute();
        assertEquals(expResultCD.getRealPart(), resultCD[0].getRealPart(), PRECISION);
        assertEquals(expResultCD.getImmPart(), resultCD[0].getImmPart(), PRECISION);
    }

}
