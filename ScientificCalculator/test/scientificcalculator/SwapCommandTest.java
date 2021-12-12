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
public class SwapCommandTest {
    SwapCommand instance;
    ElementsStack stackOfTest;
    
    public SwapCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stackOfTest = new ElementsStack();
        instance = new SwapCommand(stackOfTest);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPerform() {
        System.out.println("Swap");
        //StackPrincipale instance = new StackPrincipale();
        ComplexNumber z = new ComplexNumber(5,4);
        ComplexNumber x = new ComplexNumber(4,5);
        stackOfTest.insertNumber(x);
        stackOfTest.insertNumber(z);
        instance.perform();
        ComplexNumber last = stackOfTest.removeLastNumber();
        ComplexNumber second_last = stackOfTest.removeLastNumber();
        assertEquals(z.getRealPart(), second_last.getRealPart(),0.001);
        assertEquals(z.getImmPart(), second_last.getImmPart(),0.001); 
        assertEquals(x.getRealPart(), last.getRealPart(),0.001);
        assertEquals(x.getImmPart(), last.getImmPart(),0.001);
        
    }
    
}
