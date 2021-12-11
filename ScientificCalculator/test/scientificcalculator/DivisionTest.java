/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.DivisionByZeroException;
import exceptions.ArithmeticalException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class DivisionTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private AbstractFactory factory;

    @Before
    public void setUp(){
        factory = FactoryProducer.getFactory(true);
    }

    /**
     * Test of execute method, of class Division.
     */
    @Test(expected = DivisionByZeroException.class)
    public void testExecute() throws ArithmeticalException{
        System.out.println("division");
        // Definitions
        ComplexNumber a;
        ComplexNumber b;
        ComplexNumber expResult;
        ComplexNumber[] result;
        Operation division;
        /**
        * Test 1.
        * Rapporto tra un numero complesso (con parte reale positiva e parte 
        * immaginaria positiva) e un numero reale positivo
        */
        a = new ComplexNumber(4, 5);
        b = new ComplexNumber(4, 0);
        expResult = new ComplexNumber(1, 1.25);     
        division = factory.getOperation("DIVISION", a, b, DECIMAL_NUMBERS);
        result = division.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 2.
        * Rapporto tra due numeri complessi uguali
        */
        a = new ComplexNumber(-4, 5);
        b = new ComplexNumber(-4, 5);
        expResult = new ComplexNumber(1, 0);     
        division = factory.getOperation("DIVISION", a, b, DECIMAL_NUMBERS);
        result = division.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 2.
        * Rapporto tra due numeri complessi a parte reale positiva e parte
        * immaginaria negativa
        */
        a = new ComplexNumber(4, -5);
        b = new ComplexNumber(4, -52);
        expResult = new ComplexNumber(0.101, 0.069);     
        division = factory.getOperation("DIVISION", a, b, DECIMAL_NUMBERS);
        result = division.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 3.
        * Rapporto tra due numeri complessi a parte reale negativa e parte
        * immaginaria negativa
        */
        a = new ComplexNumber(-4, -5);
        b = new ComplexNumber(-4, -53);
        expResult = new ComplexNumber(0.099, -0.068);     
        division = factory.getOperation("DIVISION", a, b, DECIMAL_NUMBERS);
        result = division.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 4.
        * Rapporto tra due numeri complessi con un numero di cifre dopo la 
        * virgola inferiore o uguale a log(DECIMAL_NUMBERS, 10)
        */
        a = new ComplexNumber(-32, +7);
        b = new ComplexNumber(+2.5, -0.11);  
        expResult = new ComplexNumber(-12.898 , +2.232);     
        division = factory.getOperation("DIVISION", a, b, DECIMAL_NUMBERS);
        result = division.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 5.
        * Rapporto tra un numero reale e 0 (DivisionByZeroException)
        */
        a = new ComplexNumber(-45.2, 0);
        b = new ComplexNumber(0, 0);
        division = factory.getOperation("DIVISION", a, b, DECIMAL_NUMBERS);
        result = division.execute();
        /**
        * Test 6.
        * Rapporto tra un numero complesso e 0 (DivisionByZeroException)
        */
        a = new ComplexNumber(-32, +7.12);
        b = new ComplexNumber(0, 0);
        division = factory.getOperation("DIVISION", a, b, DECIMAL_NUMBERS);
        result = division.execute();
    }

}
