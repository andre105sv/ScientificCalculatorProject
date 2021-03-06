/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class ComplexNumberTest{

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testCartesianNotation(){
        ComplexNumber c1 = new ComplexNumber(+63, -12);
        assertEquals("63.0 -12.0j", c1.toString());
        ComplexNumber c2 = new ComplexNumber(42, -35); 
        assertEquals("42.0 -35.0j", c2.toString());
        ComplexNumber c3 = new ComplexNumber(47.84, -443.98); 
        assertEquals("47.84 -443.98j", c3.toString());
        ComplexNumber c4 = new ComplexNumber(7.8, +12.112); 
        assertEquals("7.8 +12.112j", c4.toString());
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testRealNegativeNotation(){
        ComplexNumber c1 = new ComplexNumber(-34, 0);
        assertEquals("-34.0", c1.toString());
        ComplexNumber c2 = new ComplexNumber(-72.56, 0);
        assertEquals("-72.56", c2.toString());
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testRealPositiveNotation(){
        ComplexNumber c1 = new ComplexNumber(+56, 0);
        assertEquals("56.0", c1.toString());
        ComplexNumber c2 = new ComplexNumber(+81.78, 0);
        assertEquals("81.78", c2.toString());
        ComplexNumber c3 = new ComplexNumber(0.5, 0);
        assertEquals("0.5", c3.toString());
    }

}
