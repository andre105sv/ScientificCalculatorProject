/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.ArithmeticalException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class ReversalSignTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class ReversalSign.
     */
    @Test
    public void testExecute() throws ArithmeticalException{
        System.out.println("reversalSign");
        // Definitions
        ComplexNumber a;
        ComplexNumber expResult;
        ComplexNumber[] result;
        ArithmeticalOperations reverse;
        /**
        * Test 1.
        * Opposto di un numero complesso a parte reale negativa e parte 
        * immaginaria negativa
        */
        a = new ComplexNumber(-4, -5);
        expResult = new ComplexNumber(4, 5);    
        reverse = factory.getArithmeticalOperations("REVERSAL_SIGN", a, DECIMAL_NUMBERS);
        result = reverse.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 2.
        * Opposto di un numero complesso a parte reale positiva e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(4, 5);
        expResult = new ComplexNumber(-4, -5);    
        reverse = factory.getArithmeticalOperations("REVERSAL_SIGN", a, DECIMAL_NUMBERS);
        result = reverse.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 3.
        * Opposto di un numero complesso a parte reale negativa e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(-4, 5);
        expResult = new ComplexNumber(4, -5);    
        reverse = factory.getArithmeticalOperations("REVERSAL_SIGN", a, DECIMAL_NUMBERS);
        result = reverse.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 4.
        * Opposto di un numero complesso a parte reale positiva e parte 
        * immaginaria negativa
        */
        a = new ComplexNumber(4, -5);
        expResult = new ComplexNumber(-4, 5);    
        reverse = factory.getArithmeticalOperations("REVERSAL_SIGN", a, DECIMAL_NUMBERS);
        result = reverse.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 5.
        * Opposto di un numero complesso con un numero di cifre dopo la virgola
        * inferiore o uguale a log(DECIMAL_NUMBERS, 10)
        */
        a = new ComplexNumber(-32.12, +7.3);
        expResult = new ComplexNumber(32.12, -7.3);     
        reverse = factory.getArithmeticalOperations("REVERSAL_SIGN", a, DECIMAL_NUMBERS);
        result = reverse.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 6.
        * Opposto di un numero complesso con un numero di cifre dopo la virgola
        * inferiore o uguale a log(DECIMAL_NUMBERS, 10)
        */
        a = new ComplexNumber(-32.125887, +7.31212);
        expResult = new ComplexNumber(32.126, -7.312);     
        reverse = factory.getArithmeticalOperations("REVERSAL_SIGN", a, DECIMAL_NUMBERS);
        result = reverse.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 7.
        * Opposto di un numero reale
        */
        a = new ComplexNumber(15, 0);
        expResult = new ComplexNumber(-15, 0);     
        reverse = factory.getArithmeticalOperations("REVERSAL_SIGN", a, DECIMAL_NUMBERS);
        result = reverse.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
    }

}
