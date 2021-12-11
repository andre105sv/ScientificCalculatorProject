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
public class AdditionTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private AbstractFactory factory;

    @Before
    public void setUp(){
        factory = FactoryProducer.getFactory(true);
    }

    /**
     * Test of execute method, of class Addition.
     */
    @Test
    public void testExecute() throws ArithmeticalException{
        System.out.println("addition");
        // Definitions
        ComplexNumber a;
        ComplexNumber b;
        ComplexNumber expResult;
        ComplexNumber[] result;
        Operation addition;
        /**
        * Test 1.
        * Somma di due numeri complessi a parte reale positiva e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(4, 5);
        b = new ComplexNumber(3, 7);
        expResult = new ComplexNumber(7, 12);
        addition = factory.getOperation("ADDITION", a, b, DECIMAL_NUMBERS);
        result = addition.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 2.
        * Somma di due numeri complessi a parte reale negativa e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(-4, 5);
        b = new ComplexNumber(-3, 7);
        expResult = new ComplexNumber(-7, 12);
        addition = factory.getOperation("ADDITION", a, b, DECIMAL_NUMBERS);
        result = addition.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 3.
        * Somma di due numeri complessi a parte reale positiva e parte 
        * immaginaria negativa
        */
        a = new ComplexNumber(4, -5);
        b = new ComplexNumber(3, -7);
        expResult = new ComplexNumber(7, -12);
        addition = factory.getOperation("ADDITION", a, b, DECIMAL_NUMBERS);
        result = addition.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 4.
        * Somma di due numeri complessi a parte reale negativa e parte 
        * immaginaria negativa
        */
        a = new ComplexNumber(-4, -5);
        b = new ComplexNumber(-3, -7);
        expResult = new ComplexNumber(-7, -12);
        addition = factory.getOperation("ADDITION", a, b, DECIMAL_NUMBERS);
        result = addition.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 5.
        * Somma di due numeri complessi opposti
        */
        a = new ComplexNumber(-4, -5);
        b = new ComplexNumber(4, 5);
        expResult = new ComplexNumber(0, 0);
        addition = factory.getOperation("ADDITION", a, b, DECIMAL_NUMBERS);
        result = addition.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 6.
        * Somma di due numeri complessi con un numero di cifre dopo la virgola
        * inferiore o uguale a log(DECIMAL_NUMBERS, 10)
        */
        a = new ComplexNumber(-32, +7);
        b = new ComplexNumber(+2.5, -0.11);  
        expResult = new ComplexNumber(-29.5, +6.89);     
        addition = factory.getOperation("ADDITION", a, b, DECIMAL_NUMBERS);
        result = addition.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 7.
        * Somma di due numeri complessi con un numero di cifre dopo la virgola
        * maggiore di log(DECIMAL_NUMBERS, 10)
        */
        a = new ComplexNumber(1, +3);
        b = new ComplexNumber(+2.55555, -0.35);  
        expResult = new ComplexNumber(3.556, 2.65);     
        addition = factory.getOperation("ADDITION", a, b, DECIMAL_NUMBERS);
        result = addition.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(),PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
    }
    
}
