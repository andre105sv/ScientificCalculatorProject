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
public class StackPrincipaleTest{

    StackPrincipale instance;
    private final int FIRST_NUMBERS = 2;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp(){
        instance = new StackPrincipale();   
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of insertNumber method, of class StackPrincipale.
     */
    @Test
    public void testInsertNumber(){
        System.out.println("insertNumber");
        ComplexNumber number = new ComplexNumber(4,5);
        int prevSize = instance.getSize();
        instance.insertNumber(number);
        assertEquals(prevSize+1, instance.getSize());
    }

    /**
     * Test of getSize method, of class StackPrincipale.
     */
    @Test
    public void testGetSize(){
        System.out.println("getSize");
        int expResult = 1;
        instance.insertNumber(new ComplexNumber(5, 5));
        int result = instance.getSize();
        assertEquals(expResult, result);
        expResult = 0;
        instance.removeLastNumber();
        result = instance.getSize();
        assertEquals(expResult,result);
    }

    /**
     * Test of removeLastNumber method, of class StackPrincipale.
     */
    @Test
    public void testRemoveLastNumber(){
        System.out.println("removeLastNumber");
        ComplexNumber expResult = new ComplexNumber(5,5);
        instance.insertNumber(expResult);
        ComplexNumber result = instance.removeLastNumber();
        assertEquals(expResult, result);
        instance.insertNumber(result);
        int size = instance.getSize();
        instance.removeLastNumber();
        assertEquals(size - 1, instance.getSize());
    }

    /**
     * Test of getFirst12Elements method, of class StackPrincipale.
     */
    @Test
    public void testGetFirst12Elements(){
        System.out.println("getFirst12Elements");
        List<ComplexNumber> expResult = new LinkedList<>();
        for(int i = 0; i < FIRST_NUMBERS; i++){
            expResult.add(new ComplexNumber(i, i));
            instance.insertNumber(new ComplexNumber(i, i));
        }
        List<ComplexNumber> result = instance.getFirst12Elements();
        for (int i = 0 ; i < Math.max(instance.getSize(), expResult.size()); i++){//MODIFICARE EXPRESULT E RESULT
            assertEquals(expResult.get(i).getRealPart(), result.get(i).getRealPart(), 0.0001);
            assertEquals(expResult.get(i).getImmPart(), result.get(i).getImmPart(), 0.0001);
        }
    }

    /**
     * Test of Swap method, of class StackPrincipale.
     */
    @Test
    public void testSwap() {
        System.out.println("Swap");
        //StackPrincipale instance = new StackPrincipale();
        instance.insertNumber(new ComplexNumber(4,5));
        instance.insertNumber(new ComplexNumber(5,4));
        instance.Swap();
        ComplexNumber z = new ComplexNumber(5,4);
        ComplexNumber last = instance.removeLastNumber();
        ComplexNumber second_last = instance.removeLastNumber();
        assertEquals(z.getRealPart(), second_last.getRealPart(),0.001);
        assertEquals(z.getImmPart(), second_last.getImmPart(),0.001);
        
    }

    /**
     * Test of Over method, of class StackPrincipale.
     */
    @Test
    public void testOver() {
        System.out.println("Over");
        //StackPrincipale instance = new StackPrincipale();
        instance.insertNumber(new ComplexNumber(4,5));
        instance.insertNumber(new ComplexNumber(5,4));
        instance.Over();
        ComplexNumber last = instance.removeLastNumber();
        ComplexNumber z = new ComplexNumber(4,5);
        assertEquals(z.getRealPart(), last.getRealPart(),0.001);
        assertEquals(z.getImmPart(), last.getImmPart(),0.001);
        
    }

    /**
     * Test of Dup method, of class StackPrincipale.
     */
    @Test
    public void testDup() {
        System.out.println("Dup");
        //StackPrincipale instance = new StackPrincipale();
        ComplexNumber z = new ComplexNumber(4,5);
        instance.insertNumber(z);
        instance.Dup();
        ComplexNumber last = instance.removeLastNumber();
        ComplexNumber second_last = instance.removeLastNumber();
        assertEquals(z.getRealPart(), last.getRealPart(),0.001);
        assertEquals(z.getImmPart(), last.getImmPart(),0.001);
        assertEquals(z.getRealPart(), second_last.getRealPart(),0.001);
        assertEquals(z.getImmPart(), second_last.getImmPart(),0.001);
    }

    /**
     * Test of clear method, of class StackPrincipale.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        //StackPrincipale instance = new StackPrincipale();
        instance.insertNumber(new ComplexNumber(2.0, 3.6));
        instance.insertNumber(new ComplexNumber(2.4, 3.2));
        instance.insertNumber(new ComplexNumber(2.8, 2.8));
        instance.clear();
        assertEquals(0,instance.getSize());
        instance.clear();
        assertEquals(0,instance.getSize());
    }
    
}
