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
public class DropCommandTest{
    
    DropCommand instance;
    ElementsStack stackOfTest;
    
    
    public DropCommandTest(){
    }
    
    @Before
    public void setUp(){
        stackOfTest = new ElementsStack();
        instance = new DropCommand(stackOfTest);
    }
    
    @Test
    public void testPerform(){
        stackOfTest.insertNumber(new ComplexNumber(2, 2));
        int stackSize = stackOfTest.getSize();
        instance.perform();
        assertEquals(stackSize - 1, stackOfTest.getSize());
    }
    
}
