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
public class MultiplicationTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private AbstractFactory factory;

    @Before
    public void setUp(){
        factory = FactoryProducer.getFactory(true);
    }

    /**
     * Test of execute method, of class Multiplication.
     */
    @Test
    public void testExecute() throws ArithmeticalException{
        System.out.println("multiplication");
        // Definitions
        ComplexNumber a;
        ComplexNumber b;
        ComplexNumber expResult;
        ComplexNumber[] result;
        Operation multiplication;
        /**
        * Test 1.
        * Prodotto tra un numero reale positivo e un numero complesso a parte 
        * reale positiva e parte immaginaria positiva
        */
        a = new ComplexNumber(4, 5);
        b = new ComplexNumber(4, 0);
        expResult = new ComplexNumber(16, 20);     
        multiplication = factory.getOperation("MULTIPLICATION", a, b, DECIMAL_NUMBERS);
        result = multiplication.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 2.
        * Prodotto tra due numeri complessi a parte reale negativa e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(-4, 5);
        b = new ComplexNumber(-4, 5);
        expResult = new ComplexNumber(-9, -40);     
        multiplication = factory.getOperation("MULTIPLICATION", a, b, DECIMAL_NUMBERS);
        result = multiplication.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 3.
        * Prodotto tra due numeri complessi a parte reale positiva e parte 
        * immaginaria negativa
        */
        a = new ComplexNumber(4, -5);
        b = new ComplexNumber(4, -5);
        expResult = new ComplexNumber(-9, -40);     
        multiplication = factory.getOperation("MULTIPLICATION", a, b, DECIMAL_NUMBERS);
        result = multiplication.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 4.
        * Prodotto tra due numeri complessi a parte reale negativa e parte 
        * immaginaria negativa
        */
        a = new ComplexNumber(-4, -5);
        b = new ComplexNumber(-4, -5);
        expResult = new ComplexNumber(-9, 40);
        multiplication = factory.getOperation("MULTIPLICATION", a, b, DECIMAL_NUMBERS);
        result = multiplication.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 5.
        * Prodotto tra due numeri complessi con un numero di cifre dopo la 
        * virgola inferiore o uguale a log(DECIMAL_NUMBERS, 10)
        */
        a = new ComplexNumber(-32, +7);
        b = new ComplexNumber(+2.5, -0.11);  
        expResult = new ComplexNumber(-79.23, +21.02);
        multiplication = factory.getOperation("MULTIPLICATION", a, b, DECIMAL_NUMBERS);
        result = multiplication.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 6.
        * Prodotto tra due numeri complessi con un numero di cifre dopo la 
        * virgola maggiore di log(DECIMAL_NUMBERS, 10)
        */
        a = new ComplexNumber(-2.56, +3);
        b = new ComplexNumber(+4.8951, -11.56);  
        expResult = new ComplexNumber(22.149, 44.279);
        multiplication = factory.getOperation("MULTIPLICATION", a, b, DECIMAL_NUMBERS);
        result = multiplication.execute();
        assertEquals(expResult.getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult.getImmPart(), result[0].getImmPart(), PRECISION);
    }

}
