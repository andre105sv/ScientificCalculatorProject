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
 * @author filso
 */
public class CheckerComplexNumberTest{

    private final String single_number = "SINGLENUMBER";
    private final String complex_number = "COMPLEX__NUMBER";
    private final String invalid_insert = "INVALID";
    private final String continue_checking = "CHECKING";
    private CheckerComplexNumber checker;
    
    @Before
    public void setUp(){
         checker = new CheckerComplexNumber();
    }

    /**
    * Test of clearString method, of class CheckerComplexNumber.
    */
    @Test
    public void testClearString(){
        System.out.println("clearString");
        String text = "+3 -3j";
        String expResult = "3 -3j";
        String result = checker.clearString(text);
        assertEquals(expResult, result);
        text = "3 +3j";
        expResult = "3 +3j";
        result = checker.clearString(text);
        assertEquals(expResult, result);
        text = "\n3 +3j";
        expResult = "3 +3j";
        result = checker.clearString(text);
        assertEquals(expResult, result);
        text = "\n+3 +3j";
        expResult = "3 +3j";
        result = checker.clearString(text);
        assertEquals(expResult, result);
    }

    /**
    * Test of checkPossibleRealPart method, of class CheckerComplexNumber.
    */    
    @Test
    public void testCheckPossibleRealPart() {
        System.out.println("checkPossiblePartReal");
        String text = "+3";
        boolean expResult = true;
        boolean result = checker.checkPossibleRealPart(text);
        assertEquals(expResult, result);
        text = "+3helloword";
        expResult = false;
        result = checker.checkPossibleRealPart(text);
        assertEquals(expResult, result);
    }

    /**
    * Test of checkPossiblePartImmaginary method, of class CheckerComplexNumber.
    */
    @Test
    public void testCheckPossibleImmaginaryPart() {
        System.out.println("checkPossiblePartImaginary");
        String text = "+3j";
        boolean expResult = true;
        boolean result = checker.checkPossibleImmaginaryPart(text);
        assertEquals(expResult, result);
        text = "+3helloword";
        expResult = false;
        result = checker.checkPossibleImmaginaryPart(text);
        assertEquals(expResult, result);
    }

    /**
    * Test of checkPossibleOneNumber method, of class CheckerComplexNumber.
    */
    @Test
    public void testCheckPossibleOneNumber() {
        System.out.println("checkPossibleOneNumber");
        String text = "4j";
        String expResult = single_number;
        String result = checker.checkPossibleOneNumber(text);
        assertEquals(expResult, result);
        text = "+4";
        result = checker.checkPossibleOneNumber(text);
        assertEquals(expResult, result);
        text = "4hello";
        expResult = continue_checking;
        result = checker.checkPossibleOneNumber(text);
        assertEquals(expResult, result);
    }

    /**
    * Test of checkComplexNumber method, of class CheckerComplexNumber.
    */
    @Test
    public void testCheckComplexNumber() {
        System.out.println("checkComplexNumber");
        //se la condizione fallisce del primo if
        String text = "4";
        String expResult = continue_checking;
        String result = checker.checkComplexNumber(text);
        assertEquals(expResult, result);
        // se la condizione si verifica nel secondo if
        text = "4 +4j + 3";
        result = checker.checkComplexNumber(text);
        expResult = invalid_insert;
        assertEquals(expResult, result);
        //se viene catturata l'eccezione
        text = "+4,ld +4j";
        result = checker.checkComplexNumber(text);
        assertEquals(expResult, result);
        // se il secondo valore non contiene j 
        text = "+4 +7";
        result = checker.checkComplexNumber(text);
        assertEquals(expResult, result);
        // se contiene più j 
        text = "+4 +3j hello";
        result = checker.checkComplexNumber(text);
        assertEquals(expResult, result);
        text = "4 +3j";
        expResult = complex_number;
        result = checker.checkComplexNumber(text);
        assertEquals(expResult, result);
        text = "+4 +dkdkdj";
        expResult = invalid_insert;
        result = checker.checkComplexNumber(text);
        assertEquals(expResult, result);       
    }

    /**
    * Test of checkFirstCharacter method, of class CheckerComplexNumber.
    */
    @Test
    public void testCheckFirstCharacter() {
        System.out.println("checkFirstCharacter");
        String text = "+2";
        char expResult = '+';
        char result = checker.checkFirstCharacter(text);
        assertEquals(expResult, result);
        text = "-2";
        result = checker.checkFirstCharacter(text);
        expResult = '-';
        assertEquals(expResult, result);
    }

    /**
    * Test of createFromComplexNumber method, of class CheckerComplexNumber.
    */
    @Test
    public void testCreateFromComplexNumber() {
        System.out.println("createFromComplexNumber");
        String text = "4+5j";
        ComplexNumber expResult = new ComplexNumber(4, 5);
        ComplexNumber result = checker.createFromComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0.001);
        assertEquals(expResult.getImmPart(), result.getImmPart(), 0.001);
    }

    /**
    * Test of createFromSingleNumber method, of class CheckerComplexNumber.
    */
    @Test
    public void testCreateFromSingleNumber() {
        System.out.println("createFromSingleNumber");
        String text = "4";
        ComplexNumber expResult = new ComplexNumber(4, 0);
        ComplexNumber result = checker.createFromSingleNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(), 0.001);
        text = "5j";
        expResult = new ComplexNumber(0, 5);
        result = checker.createFromSingleNumber(text);
        assertEquals(expResult.getImmPart(), result.getImmPart(), 0.001);
        text = "j";
        expResult = new ComplexNumber(0, 1);
        result = checker.createFromSingleNumber(text);
        assertEquals(expResult.getImmPart(), result.getImmPart(), 0.001);
    }

    /**
     * Test of checkString method, of class CheckerComplexNumber.
     */
    @Test
    public void testCheckString(){
        System.out.println("checkString");

        String text = "";
        String expResult = invalid_insert;
        String result = checker.checkString(text);
        assertEquals(expResult, result);

        text = "+2";
        result = checker.checkString(text);
        expResult = single_number;
        assertEquals(expResult, result);

        text = "2+3j";
        result = checker.checkString(text);
        expResult = complex_number;
        assertEquals(expResult, result);

        text = "3";
        result = checker.checkString(text);
        expResult = single_number;
        assertEquals(expResult, result);

        text = "++4";
        expResult = invalid_insert;
        result = checker.checkString(text);
        assertEquals(expResult, result);

        text = "+4 +3j";
        expResult = complex_number;
        result = checker.checkString(text);
        assertEquals(expResult, result);

        text = "+4j";
        expResult = single_number;
        result = checker.checkString(text);
        assertEquals(expResult, result);

        text = "j";
        expResult = single_number;
        result = checker.checkString(text);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isSingleNumber method, of class CheckerComplexNumber.
     */
    @Test
    public void testIsSingleNumber(){
        String a = "+3";
        String b = "-2j";
        String c = "-3+2j";
        String d = "test";
        assertTrue(checker.isSingleNumber(a));
        assertTrue(checker.isSingleNumber(b));
        assertFalse(checker.isSingleNumber(c));
        assertFalse(checker.isSingleNumber(c));
    }

    /**
     * Test of isCartesianComplexNumber method, of class CheckerComplexNumber.
     */
    @Test
    public void testIsCartesianComplexNumber(){
        String a = "+3";
        String b = "-2j";
        String c = "-3+2j";
        String d = "test";
        assertFalse(checker.isCartesianComplexNumber(a));
        assertFalse(checker.isCartesianComplexNumber(b));
        assertTrue(checker.isCartesianComplexNumber(c));
        assertFalse(checker.isCartesianComplexNumber(d));
    }

}
