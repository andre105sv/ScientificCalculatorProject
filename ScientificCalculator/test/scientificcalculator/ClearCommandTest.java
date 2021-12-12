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
public class ClearCommandTest{
    ClearCommand instance;
    ElementsStack stackOfTest;
    
    public ClearCommandTest(){
    }
    @Before
    public void setUp(){
        stackOfTest = new ElementsStack();
        instance = new ClearCommand(stackOfTest);
    }

    /**
     * Test of perform method, of class ClearCommand.
     */
    @Test
    public void testPerform(){
        System.out.println("perform");
        stackOfTest.insertNumber(new ComplexNumber(1, 1));
        stackOfTest.insertNumber(new ComplexNumber(1, 1));
        stackOfTest.insertNumber(new ComplexNumber(1, 1));
        ComplexNumber result = instance.perform();
        assertEquals(stackOfTest.getSize(), 0);
        
    }
    
}
