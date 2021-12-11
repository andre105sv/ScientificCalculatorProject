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
public class SubtractionTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private AbstractFactory factory;

    @Before
    public void setUp(){
        factory = FactoryProducer.getFactory(true);
    }

    /**
     * Test of execute method, of class Subtraction.
     */
    @Test
    public void testExecute() throws ArithmeticalException{
        System.out.println("subtraction");
        // Definitions
        ComplexNumber a;
        ComplexNumber b;
        ComplexNumber expResult;
        ComplexNumber[] result;
        Operation subtraction;
        /**
        * Test 1.
        * Differenza tra due numeri complessi a parte reale positiva e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(4, 5);
        b = new ComplexNumber(3, 7);
        expResult = new ComplexNumber(1, -2);
        subtraction = factory.getOperation("SUBTRACTION", a, b, DECIMAL_NUMBERS);
        result = subtraction.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 2.
        * Differenza tra due numeri complessi a parte reale negativa e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(-4, 5);
        b = new ComplexNumber(-3, 7);
        expResult = new ComplexNumber(-1, -2);
        subtraction = factory.getOperation("SUBTRACTION", a, b, DECIMAL_NUMBERS);
        result = subtraction.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 3.
        * Somma di due numeri complessi a parte reale positiva e parte 
        * immaginaria negativa
        */
        a = new ComplexNumber(4, -5);
        b = new ComplexNumber(3, -7);
        expResult = new ComplexNumber(1, 2);
        subtraction = factory.getOperation("SUBTRACTION", a, b, DECIMAL_NUMBERS);
        result = subtraction.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 4.
        * Somma di due numeri complessi a parte reale negativa e parte 
        * immaginaria negativa
        */
        a = new ComplexNumber(-4, -5);
        b = new ComplexNumber(-3, -7);
        expResult = new ComplexNumber(-1, 2);
        subtraction = factory.getOperation("SUBTRACTION", a, b, DECIMAL_NUMBERS);
        result = subtraction.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 5.
        * Differenza tra due numeri complessi a parte reale positiva uguali
        */
        a = new ComplexNumber(4, 5);
        b = new ComplexNumber(4, 5);
        expResult = new ComplexNumber(0, 0);
        subtraction = factory.getOperation("SUBTRACTION", a, b, DECIMAL_NUMBERS);
        result = subtraction.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 6.
        * Differenza tra due numeri complessi con un numero di cifre dopo la 
        * virgola inferiore a log(DECIMAL_NUMBERS, 10)
        */
        a = new ComplexNumber(-32, +7);
        b = new ComplexNumber(+2.5, -0.11);  
        expResult = new ComplexNumber(-34.5, +7.11); 
        subtraction = factory.getOperation("SUBTRACTION", a, b, DECIMAL_NUMBERS);
        result = subtraction.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 7.
        * Differenza tra due numeri complessi con un numero di cifre dopo la 
        * virgola maggiore di log(DECIMAL_NUMBERS, 10)
        */
        a = new ComplexNumber(-50, 12);
        b = new ComplexNumber(-0.0001, -0.0000000001);  
        expResult = new ComplexNumber(-50, 12);
        subtraction = factory.getOperation("SUBTRACTION", a, b, DECIMAL_NUMBERS);
        result = subtraction.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
    }

}
