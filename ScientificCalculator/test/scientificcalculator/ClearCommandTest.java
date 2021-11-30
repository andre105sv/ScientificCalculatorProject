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
public class ClearCommandTest {
    ClearCommand instance;
    StackPrincipale stackOfTest;
    
    public ClearCommandTest() {
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
        instance = new ClearCommand(stackOfTest);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of perform method, of class ClearCommand.
     */
    @Test
    public void testPerform() {
        System.out.println("perform");
        stackOfTest.insertNumber(new ComplexNumber(1, 1));
        stackOfTest.insertNumber(new ComplexNumber(1, 1));
        stackOfTest.insertNumber(new ComplexNumber(1, 1));
        ComplexNumber result = instance.perform();
        assertEquals(stackOfTest.getSize(), 0);
        
    }
    
}
