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
public class PushVariablesCommandTest {

    private PushVariablesCommand instance;
    private VariablesStack variablesStack;
    private Variables variables;
    
    public PushVariablesCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        variables = new Variables();
        variablesStack = new VariablesStack();
        instance = new PushVariablesCommand(variablesStack);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of perform method, of class PushVariablesCommand.
     */
    @Test
    public void testPerform() {
        System.out.println("perform");
        int prevSize = variablesStack.getSize();
        variables.insertVariable('a', new ComplexNumber(2,3));
        instance.perform(variables);
        int result = variablesStack.getSize();
        assertEquals(prevSize + 1, result);
    }

    /**
     * Test of undo method, of class PushVariablesCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        variables.insertVariable('a', new ComplexNumber(2,3));
        instance.perform(variables);
        int prevSize = variablesStack.getSize();
        Variables result = instance.undo(null);
        assertEquals(prevSize - 1, variablesStack.getSize());
        assertEquals(variables, result);
    }
    
}
