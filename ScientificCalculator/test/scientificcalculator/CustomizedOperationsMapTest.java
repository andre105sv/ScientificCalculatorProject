/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class CustomizedOperationsMapTest {

    private CustomizedOperationsMap customizedOperations;
    
    @Before
    public void setUp(){
        customizedOperations = new CustomizedOperationsMap();   
    }

    /**
     * Test of insertCustomOperation method, of class CustomizedOperationsMap.
     */
    @Test
    public void testInsertCustomOperation(){
        System.out.println("insertCustomOperation");
        String opName = "hypotenuse";
        String[] opArray = new String[]{"dup", "*", "swap", "dup", "*", "+", "sqrt"};
        int prevSize = customizedOperations.getSize();
        customizedOperations.insertCustomOperation(opName, opArray);
        assertEquals(prevSize + 1, customizedOperations.getSize());
        assertTrue(customizedOperations.getCustomizedOperationsMap().containsKey(opName));
        assertEquals(opArray, customizedOperations.getCustomizedOperationsMap().get(opName));
    }

    /**
     * Test of renameCustomOperation method, of class CustomizedOperationsMap.
     */
    @Test
    public void testRenameCustomOperation(){
        System.out.println("renameCustomOperation");
        String opName = "hypotenuse";
        String[] opArray = new String[]{"dup", "*", "swap", "dup", "*", "+", "sqrt"};
        customizedOperations.insertCustomOperation(opName, opArray);
        int prevSize = customizedOperations.getSize();
        String newName = "ipotenusa";
        customizedOperations.renameCustomOperation(opName, newName);
        assertEquals(prevSize, customizedOperations.getSize());
        assertTrue(customizedOperations.getCustomizedOperationsMap().containsKey(newName));
        assertFalse(customizedOperations.getCustomizedOperationsMap().containsKey(opName));
        assertEquals(opArray, customizedOperations.getCustomizedOperationsMap().get(newName));
    }

    /**
     * Test of deleteCustomOperation method, of class CustomizedOperationsMap.
     */
    @Test
    public void testDeleteCustomOperation(){
        System.out.println("deleteCustomOperation");
        String opName = "hypotenuse";
        String[] opArray = new String[]{"dup", "*", "swap", "dup", "*", "+", "sqrt"};   
        customizedOperations.insertCustomOperation(opName, opArray);
        int prevSize = customizedOperations.getSize();
        customizedOperations.deleteCustomOperation(opName);
        assertEquals(prevSize - 1, customizedOperations.getSize());
        assertFalse(customizedOperations.getCustomizedOperationsMap().containsKey(opName));
    }

}
