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
public class VariablesTest {

    private Variables variablesMap;
    
    @Before
    public void setUp(){
        variablesMap = new Variables();   
    }

    /**
     * Test of insertVariable method, of class Variables.
     */
    @Test
    public void testInsertVariable(){
        System.out.println("insertVariable");
        Character character = new Character('a');
        ComplexNumber number = new ComplexNumber(10, 7);
        int prevSize = variablesMap.getSize();
        variablesMap.insertVariable(character, number);
        assertEquals(prevSize + 1, variablesMap.getSize());
        assertTrue(variablesMap.getVariablesMap().containsKey(character));
        assertEquals(number, variablesMap.getVariablesMap().get(character));
    }
    
    @Test
    public void testDeleteVariables(){
        System.out.println("deleteVariables");
        Character character = new Character('a');
        ComplexNumber number = new ComplexNumber(10, 7);
        int prevSize = variablesMap.getSize();
        variablesMap.insertVariable(character, number);
        variablesMap.deleteVariables();
        assertEquals(0,variablesMap.getSize());
    }

}
