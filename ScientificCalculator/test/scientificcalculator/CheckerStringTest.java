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
 * @author filso
 */
public class CheckerStringTest{

    private final String single_number = "SINGLENUMBER";
    private final String complex_number = "COMPLEX__NUMBER";
    private final String invalid_insert = "INVALID";
    private final String continue_checking = "CHECKING";
    private CheckerString checker;
    
    @Before
    public void setUp() {
         checker = new CheckerString();
    }

    /**
    * Test of clearString method, of class ParserString.
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
    * Test of checkOperation method, of class ParserString.
    */    
    @Test
    public void testCheckPossibleRealPart() {
        System.out.println("checkPossibilePartReal");
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
    * Test of checkPossiblePartImmaginary method, of class ParserString.
    */
    @Test
    public void testCheckPossibleImmaginaryPart() {
        System.out.println("checkPossibilePartImaginary");
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
    * Test of checkPossibleOneNumber method, of class ParserString.
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
    * Test of checkComplexNumber method, of class ParserString.
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
    * Test of parserString_ method, of class ParserString.
    */
    @Test
    public void testCheckerString() {
        System.out.println("parserString_");
        String text = "";
        String expResult = invalid_insert;
        String result = checker.checkString(text);
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
    }

    /**
    * Test of checkFirstCharacter method, of class CheckerString.
    */
    @Test
    public void testCheckFirstCharacter() {
        System.out.println("checkFirstCharacter");
        String text = "+2";
        CheckerString instance = new CheckerString();
        char expResult = '+';
        char result = instance.checkFirstCharacter(text);
        assertEquals(expResult, result);
        text = "-2";
        result = instance.checkFirstCharacter(text);
        expResult = '-';
        assertEquals(expResult, result);
    }

    /**
    * Test of createFromComplexNumber method, of class CheckerString.
    */
    @Test
    public void testCreateFromComplexNumber() {
        System.out.println("createFromComplexNumber");
        String text = "4+5j";
        CheckerString instance = new CheckerString();
        ComplexNumber expResult = new ComplexNumber(4,5);
        ComplexNumber result = instance.createFromComplexNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(),0.001);
        assertEquals(expResult.getImmPart(), result.getImmPart(),0.001);
    }

    /**
    * Test of createFromSingleNumber method, of class CheckerString.
    */
    @Test
    public void testCreateFromSingleNumber() {
        System.out.println("createFromSingleNumber");
        String text = "4";
        CheckerString instance = new CheckerString();
        ComplexNumber expResult = new ComplexNumber(4,0);
        ComplexNumber result = instance.createFromSingleNumber(text);
        assertEquals(expResult.getRealPart(), result.getRealPart(),0.001);
        text = "5j";
        expResult = new ComplexNumber(0,5);
        result = instance.createFromSingleNumber(text);
        assertEquals(expResult.getImmPart(), result.getImmPart(),0.001);
    }

}
