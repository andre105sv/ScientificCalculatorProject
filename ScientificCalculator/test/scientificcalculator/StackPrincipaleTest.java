/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import java.util.LinkedList;
import java.util.List;
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
     private final int FIRST_NUMBERS = 2;
    
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

    /**
     * Test of getFirst12Elements method, of class StackPrincipale.
     */
    @Test
    public void testGetFirst12Elements() {
        System.out.println("getFirst12Elements");
        List<ComplexNumber> expResult = new LinkedList<>();
        for(int i=0;i<FIRST_NUMBERS;i++){
            expResult.add(new ComplexNumber(i,i));
            instance.insertNumber(new ComplexNumber(i,i));
        }
        List<ComplexNumber> result = instance.getFirst12Elements();
        for (int i=0;i<Math.max(instance.getSize(),expResult.size());i++){//MODIFICARE EXPRESULT E RESULT
            assertEquals(expResult.get(i).getRealPart(), result.get(i).getRealPart(),0.0001);
            assertEquals(expResult.get(i).getImmPart(), result.get(i).getImmPart(),0.0001);
        }
    }
    
}
