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
public class DropCommandTest {
    DropCommand instance;
    StackPrincipale stackOfTest;
    
    
    public DropCommandTest() {
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
        instance = new DropCommand(stackOfTest);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPerform() {
        stackOfTest.insertNumber(new ComplexNumber(2, 2));
        int stackSize = stackOfTest.getSize();
        instance.perform();
        assertEquals(stackSize - 1, stackOfTest.getSize());
    }
    
}
