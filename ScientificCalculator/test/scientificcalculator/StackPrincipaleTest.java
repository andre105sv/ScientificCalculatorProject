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
public class StackPrincipaleTest {
     StackPrincipale instance;
    
    public StackPrincipaleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new StackPrincipale();   
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertNumber method, of class StackPrincipale.
     */
    @Test
    public void testInsertNumber() {
        System.out.println("insertNumber");
        ComplexNumber number = new ComplexNumber(4,5);
        //StackPrincipale instance = new StackPrincipale();
        int prevSize = instance.getSize();
        instance.insertNumber(number);
        assertEquals(prevSize+1,instance.getSize());
    }

    /**
     * Test of getSize method, of class StackPrincipale.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        //StackPrincipale instance = new StackPrincipale();
        int expResult = 1;
        instance.insertNumber(new ComplexNumber(5,5));
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeLastNumber method, of class StackPrincipale.
     */
    @Test
    public void testRemoveLastNumber() {
        System.out.println("removeLastNumber");
        //StackPrincipale instance = new StackPrincipale();
        ComplexNumber expResult = new ComplexNumber(5,5);
        instance.insertNumber(expResult);
        ComplexNumber result = instance.removeLastNumber();
        assertEquals(expResult, result);
        
    }
    
}
