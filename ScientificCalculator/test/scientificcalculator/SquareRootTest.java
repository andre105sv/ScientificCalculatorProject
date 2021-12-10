/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.ArithmeticalException;
import exceptions.NotDefinedArgumentException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class SquareRootTest{

    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;
    private OperationFactory factory;

    @Before
    public void setUp(){
        factory = new OperationFactory();
    }

    /**
     * Test of execute method, of class SquareRoot.
     */
    @Test(expected = NotDefinedArgumentException.class)
    public void testExecute() throws ArithmeticalException{
        System.out.println("sqrt");
        // Definitions
        ComplexNumber a;
        ComplexNumber exp1;
        ComplexNumber exp2;
        ComplexNumber[] expResult;
        ComplexNumber[] result;
        ArithmeticalOperations sqrt;
        /**
        * Test 1.
        * Radice quadrata di un numero complesso a parte reale positiva e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(4, 5);
        exp1 = new ComplexNumber(1.581, 1.976);
        exp2 = new ComplexNumber(-2.282, -1.093);
        expResult = new ComplexNumber[]{exp1, exp2};
        sqrt = factory.getArithmeticalOperations("SQUARE_ROOT", a, DECIMAL_NUMBERS);
        result = sqrt.execute();
        assertEquals(expResult[0].getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult[0].getImmPart(), result[0].getImmPart(), PRECISION);
        assertEquals(expResult[1].getRealPart(), result[1].getRealPart(), PRECISION);
        assertEquals(expResult[1].getImmPart(), result[1].getImmPart(), PRECISION);
        /**
        * Test 2.
        * Radice quadrata di un numero reale positivo
        */
        a = new ComplexNumber(4, 0);
        expResult = new ComplexNumber[]{new ComplexNumber(2, 0)};
        sqrt = factory.getArithmeticalOperations("SQUARE_ROOT", a, DECIMAL_NUMBERS);
        result = sqrt.execute();
        assertEquals(expResult[0].getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult[0].getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 3.
        * Radice quadrata di un numero complesso a parte reale nulla e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(0, 4);
        exp1 = new ComplexNumber(0.002, 2);
        exp2 = new ComplexNumber(-1.417, -1.411);
        expResult = new ComplexNumber[]{exp1, exp2};
        sqrt = factory.getArithmeticalOperations("SQUARE_ROOT", a, DECIMAL_NUMBERS);
        result = sqrt.execute();
        assertEquals(expResult[0].getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult[0].getImmPart(), result[0].getImmPart(), PRECISION);
        assertEquals(expResult[1].getRealPart(), result[1].getRealPart(), PRECISION);
        assertEquals(expResult[1].getImmPart(), result[1].getImmPart(), PRECISION);
        /**
        * Test 4.
        * Radice quadrata di un numero reale negativo
        */
        a = new ComplexNumber(-4, 0);
        expResult = new ComplexNumber[]{new ComplexNumber(0, 2)};
        sqrt = factory.getArithmeticalOperations("SQUARE_ROOT", a, DECIMAL_NUMBERS);
        result = sqrt.execute();
        assertEquals(expResult[0].getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult[0].getImmPart(), result[0].getImmPart(), PRECISION);
        /**
        * Test 5.
        * Radice quadrata di un numero complesso a parte reale negativa e parte 
        * immaginaria negativa
        */
        a = new ComplexNumber(-2, -2);
        exp1 = new ComplexNumber(1.187, 1.191);
        exp2 = new ComplexNumber(1.554, 0.642);
        expResult = new ComplexNumber[]{exp1, exp2};
        sqrt = factory.getArithmeticalOperations("SQUARE_ROOT", a, DECIMAL_NUMBERS);
        result = sqrt.execute();
        assertEquals(expResult[0].getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult[0].getImmPart(), result[0].getImmPart(), PRECISION);
        assertEquals(expResult[1].getRealPart(), result[1].getRealPart(), PRECISION);
        assertEquals(expResult[1].getImmPart(), result[1].getImmPart(), PRECISION);
        /**
        * Test 6.
        * Radice quadrata di un numero complesso a parte reale negativa e parte 
        * immaginaria positiva
        */
        a = new ComplexNumber(-2, 2);
        exp1 = new ComplexNumber(1.187, -1.191);
        exp2 = new ComplexNumber(1.552, -0.647);
        expResult = new ComplexNumber[]{exp1, exp2};
        sqrt = factory.getArithmeticalOperations("SQUARE_ROOT", a, DECIMAL_NUMBERS);
        result = sqrt.execute();
        assertEquals(expResult[0].getRealPart(), result[0].getRealPart(), PRECISION);
        assertEquals(expResult[0].getImmPart(), result[0].getImmPart(), PRECISION);
        assertEquals(expResult[1].getRealPart(), result[1].getRealPart(), PRECISION);
        assertEquals(expResult[1].getImmPart(), result[1].getImmPart(), PRECISION);
        /**
        * Test 7.
        * Radice quadrata di zero (NotDefinedArgumentException)
        */
        a = new ComplexNumber(0, 0);
        sqrt = factory.getArithmeticalOperations("SQUARE_ROOT", a, DECIMAL_NUMBERS);
        result = sqrt.execute();
    }

}
