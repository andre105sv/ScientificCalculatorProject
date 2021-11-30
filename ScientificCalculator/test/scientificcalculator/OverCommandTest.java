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
public class OverCommandTest {
    OverCommand instance;
    StackPrincipale stackOfTest;
    
    public OverCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stackOfTest = new StackPrincipale();
        instance = new OverCommand(stackOfTest);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of perform method, of class OverCommand.
     */
    @Test
    public void testPerform() {
        System.out.println("perform");
        stackOfTest.insertNumber(new ComplexNumber(4,5));
        stackOfTest.insertNumber(new ComplexNumber(5,4));
        instance.perform();
        ComplexNumber last = stackOfTest.removeLastNumber();
        ComplexNumber z = new ComplexNumber(4,5);
        assertEquals(z.getRealPart(), last.getRealPart(),0.001);
        assertEquals(z.getImmPart(), last.getImmPart(),0.001);
    }
    
}
