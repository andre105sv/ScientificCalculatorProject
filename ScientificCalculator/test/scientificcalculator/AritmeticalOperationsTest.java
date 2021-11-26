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
 * @author filso
 */
public class AritmeticalOperationsTest {
    
    public AritmeticalOperationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addition method, of class AritmeticalOperations.
     */
    @Test
    public void testAddition() {
        System.out.println("addition");
        ComplexNumber a = new ComplexNumber(4,5);
        ComplexNumber b = new ComplexNumber(4,5);
        ComplexNumber expResult = new ComplexNumber(8,10);
        ComplexNumber result = AritmeticalOperations.addition(a, b);
        assertEquals(expResult.getRealPart(), result.getRealPart(),0.0001);
        assertEquals(expResult.getImmPart(),result.getImmPart(),0.0001);
        
    }

    /**
     * Test of substraction method, of class AritmeticalOperations.
     */
    @Test
    public void testSubstraction() {
        System.out.println("substraction");
        ComplexNumber a = new ComplexNumber(4,5);
        ComplexNumber b = new ComplexNumber(4,5);
        ComplexNumber expResult = new ComplexNumber(0,0);
        ComplexNumber result = AritmeticalOperations.substraction(a, b);
        assertEquals(expResult.getRealPart(), result.getRealPart(),0.0001);
        assertEquals(expResult.getImmPart(),result.getImmPart(),0.0001);
        
    }

    /**
     * Test of multiplication method, of class AritmeticalOperations.
     */
    @Test
    public void testMultiplication() {
        System.out.println("multiplication");
        ComplexNumber a = new ComplexNumber(4,5);
        ComplexNumber b = new ComplexNumber(4,0);
        ComplexNumber expResult = new ComplexNumber(16,20);
        ComplexNumber result = AritmeticalOperations.multiplication(a, b);
        assertEquals(expResult.getRealPart(), result.getRealPart(),0.0001);
        assertEquals(expResult.getImmPart(),result.getImmPart(),0.0001);
        
    }

    /**
     * Test of division method, of class AritmeticalOperations.
     */
    @Test
    public void testDivision() throws Exception {
        System.out.println("division");
        ComplexNumber a = new ComplexNumber(4,5);
        ComplexNumber b = new ComplexNumber(4,0);
        ComplexNumber expResult = new ComplexNumber(1,1.25);
        ComplexNumber result = AritmeticalOperations.division(a, b);
        assertEquals(expResult.getRealPart(), result.getRealPart(),0.0001);
        assertEquals(expResult.getImmPart(),result.getImmPart(),0.0001);

    }

    /**
     * Test of reversalSign method, of class AritmeticalOperations.
     */
    @Test
    public void testReversalSign() {
        System.out.println("reversalSign");
        ComplexNumber a =new ComplexNumber(-4,-5);
        ComplexNumber expResult = new ComplexNumber(4,5);
        ComplexNumber result = AritmeticalOperations.reversalSign(a);
        assertEquals(expResult.getRealPart(), result.getRealPart(),0.0001);
        assertEquals(expResult.getImmPart(),result.getImmPart(),0.0001);
        
    }

    /**
     * Test of squareRoot method, of class AritmeticalOperations.
     */
    @Test
    public void testSquareRoot() {
        System.out.println("squareRoot");
        ComplexNumber a = new ComplexNumber(4, 5);
        ComplexNumber b = new ComplexNumber(1.5807, 1.9759);
        ComplexNumber c = new ComplexNumber(-2.2824, -1.0925);
        ComplexNumber[] expResult = new ComplexNumber[]{b, c};
        ComplexNumber[] result = AritmeticalOperations.squareRoot(a);
        assertEquals(expResult[0].getRealPart(), result[0].getRealPart(),0.0001);
        assertEquals(expResult[0].getImmPart(), result[0].getImmPart(),0.0001);
        assertEquals(expResult[1].getRealPart(), result[1].getRealPart(),0.0001);
        assertEquals(expResult[1].getImmPart(), result[1].getImmPart(),0.0001);
        
    }
    
}
