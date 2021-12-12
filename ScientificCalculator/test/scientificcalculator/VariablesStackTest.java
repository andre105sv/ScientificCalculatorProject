/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anton
 */
public class VariablesStackTest{
    
    private VariablesStack instance;
    private Variables variables;
    
    @Before
    public void setUp(){
        instance = new VariablesStack();
        variables = new Variables();
    }
    
    /**
     * Test of insertVariables method, of class VariablesStack.
     */
    @Test
    public void testInsertVariables(){
        System.out.println("insertVariables");
        int prevSize = instance.getSize();
        variables.insertVariable('a', new ComplexNumber(2,3));
        instance.insertVariables(variables);
        assertEquals(instance.getSize(),prevSize + 1);
    }

    /**
     * Test of getSize method, of class VariablesStack.
     */
    @Test
    public void testGetSize(){
        System.out.println("getSize");
        int expResult = 1;
        variables.insertVariable('a', new ComplexNumber(2,3));
        instance.insertVariables(variables);
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeLast method, of class VariablesStack.
     */
    @Test
    public void testRemoveLast(){
        System.out.println("removeLast");
        Variables expResult = variables;
        variables.insertVariable('a', new ComplexNumber(2,3));
        instance.insertVariables(variables);
        int prevSize = instance.getSize();
        Variables result = instance.removeLast();
        int actualSize =  instance.getSize();
        assertEquals(expResult, result);
        assertEquals(prevSize - 1, actualSize);
    }

}
