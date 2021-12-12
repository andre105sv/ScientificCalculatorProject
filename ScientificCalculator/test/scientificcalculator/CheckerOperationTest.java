/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.NotDefinedNameOperationException;
import exceptions.NotDefinedValueOperationException;
import exceptions.NumberAsNameOperationException;
import exceptions.ExistentOperationException;
import exceptions.NotCorrectValueOperationException;
import exceptions.BlankSpaceStringException;
import exceptions.NotExistentOperationException;
import exceptions.SameNameException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class CheckerOperationTest{

    private CheckerOperation checkerOp;
    private double DECIMAL_NUMBERS = 1000;
    private double PRECISION = 0.0001;

    @Before
    public void setUp(){
        checkerOp = new CheckerOperation(DECIMAL_NUMBERS);
    }

    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test
    public void testCheckCreateOperationOK() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> ok"); 
        String s;
        String[] result;
        String[] expResult;
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        s = "create op1 swap /";
        expResult = new String[]{"op1", "swap", "/"};
        result = checkerOp.checkCreateOperation(customizedOperations, s);
        Assert.assertArrayEquals(expResult, result);
        s = "create op2 save >b >a <a <a * <b <b * + sqrt restore";
        expResult = new String[]{"op2", "save", ">b", ">a", "<a", "<a", "*", "<b", "<b", "*", "+", "sqrt", "restore"};
        result = checkerOp.checkCreateOperation(customizedOperations, s);
        Assert.assertArrayEquals(expResult, result);
    }

    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test(expected = NotDefinedNameOperationException.class)
    public void testNotDefinedNameOperationCreatingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> NotDefinedNameOperationException");
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "create";
        String[] result = checkerOp.checkCreateOperation(customizedOperations, s);
    }

    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test(expected = NotDefinedValueOperationException.class)
    public void testNotDefinedValueOperationCreatingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> NotDefinedValueOperationException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "create test";
        String[] result = checkerOp.checkCreateOperation(customizedOperations, s);
    }

    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test(expected = NumberAsNameOperationException.class)
    public void testSingleNumberAsNameOperationCreatingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> NumberAsNameOperationException: single number"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "create +2 dup";
        String[] result = checkerOp.checkCreateOperation(customizedOperations, s);
    }

    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test(expected = NumberAsNameOperationException.class)
    public void testCartesianComplexNumberAsNameOperationCreatingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> NumberAsNameOperationException: cartesian complex number"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "create +2-3j swap";
        String[] result = checkerOp.checkCreateOperation(customizedOperations, s);
    }

    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test(expected = ExistentOperationException.class)
    public void testExistentArithmeticalOperationCreatingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> ExistentOperationException: arithmetical operation"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "create + dup swap";
        String[] result = checkerOp.checkCreateOperation(customizedOperations, s);
    }

    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test(expected = ExistentOperationException.class)
    public void testExistentStackOperationCreatingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> ExistentOperationException: stack operation"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "create dup * - swap";
        String[] result = checkerOp.checkCreateOperation(customizedOperations, s);
    }
        
    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test(expected = ExistentOperationException.class)
    public void testExistentOperationWithVariablesCreatingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> ExistentOperationException: operation with variables"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "create >f * over +";
        String[] result = checkerOp.checkCreateOperation(customizedOperations, s);
    }

    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test(expected = ExistentOperationException.class)
    public void testExistentCustomizedOperationCreatingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> ExistentOperationException: customized operation"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "triple_dup";
        String[] opArray = new String[]{"dup", "dup", "dup"};
        customizedOperations.insertCustomOperation(opName, opArray);
        String s = "create triple_dup swap swap swap";
        String[] result = checkerOp.checkCreateOperation(customizedOperations, s);
    }
    
    /**
    * Test of checkCreateOperation method, of class CheckerOperation.
    */
    @Test(expected = NotCorrectValueOperationException.class)
    public void testNotCorrectValueOperationCreatingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NumberAsNameOperationException, ExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkCreateOperation -> NotCorrectValueOperationException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "create op1 dup + wizard swap";
        String[] result = checkerOp.checkCreateOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test
    public void testCheckRenameOperationOK() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> ok"); 
        String s;
        String[] result;
        String[] expResult;
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "op1";
        String[] opArray = new String[]{"swap"};
        customizedOperations.insertCustomOperation(opName, opArray);
        s = "rename op1 op2";
        expResult = new String[]{"op1", "op2"};
        result = checkerOp.checkRenameOperation(customizedOperations, s);
        Assert.assertArrayEquals(expResult, result);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = NotDefinedNameOperationException.class)
    public void testNotDefinedNameOperationRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> NotDefinedNameOperationException");
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "rename";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = NotDefinedValueOperationException.class)
    public void testNotDefinedValueOperationRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> NotDefinedValueOperationException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "rename test";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = BlankSpaceStringException.class)
    public void testBlankSpaceStringRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> BlankSpaceStringException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "rename test op1 op2 op3";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = NumberAsNameOperationException.class)
    public void testSingleNumberAsNameOperationRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> NumberAsNameOperationException: single number"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "rename op1 +5";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = NumberAsNameOperationException.class)
    public void testCartesianComplexNumberAsNameOperationRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> NumberAsNameOperationException: cartesian complex number"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "rename op1 -2+3j";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = NotExistentOperationException.class)
    public void testNotExistentOperationRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> NotExistentOperationException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "rename hypotenuse hyp";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = SameNameException.class)
    public void testSameNameRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> SameNameException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "op1";
        String[] opArray = new String[]{"clear"};
        customizedOperations.insertCustomOperation(opName, opArray);
        String s = "rename op1 op1";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = ExistentOperationException.class)
    public void testExistentArithmeticalOperationRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> ExistentOperationException: arithmetical operation"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "op2";
        String[] opArray = new String[]{"+", "swap"};
        customizedOperations.insertCustomOperation(opName, opArray);
        String s = "rename op2 +";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = ExistentOperationException.class)
    public void testExistentStackOperationRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> ExistentOperationException: stack operation"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "op3";
        String[] opArray = new String[]{"-", "-", "-"};
        customizedOperations.insertCustomOperation(opName, opArray);
        String s = "rename op3 dup";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }
        
    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = ExistentOperationException.class)
    public void testExistentOperationWithVariablesRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> ExistentOperationException: operation with variables"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "op1";
        String[] opArray = new String[]{"+", "*", "dup"};
        customizedOperations.insertCustomOperation(opName, opArray);
        String s = "rename op1 >a";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkRenameOperation method, of class CheckerOperation.
    */
    @Test(expected = ExistentOperationException.class)
    public void testExistentCustomizedOperationRenamingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, BlankSpaceStringException, NumberAsNameOperationException, NotExistentOperationException, SameNameException, ExistentOperationException{
        System.out.println("checkRenameOperation -> ExistentOperationException: customized operation"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "triple_dup";
        String[] opArray = new String[]{"dup", "dup", "dup"};
        customizedOperations.insertCustomOperation(opName, opArray);
        opName = "hypotenuse";
        opArray = new String[]{"dup", "*", "swap", "dup", "*", "+", "sqrt"};
        customizedOperations.insertCustomOperation(opName, opArray);
        String s = "rename hypotenuse triple_dup";
        String[] result = checkerOp.checkRenameOperation(customizedOperations, s);
    }

    /**
    * Test of checkSetOperation method, of class CheckerOperation.
    */
    @Test
    public void testCheckSetOperationOK() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NotExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkSetOperation -> ok"); 
        String s;
        String[] result;
        String[] expResult;
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "op1";
        String[] opArray = new String[]{"swap"};
        customizedOperations.insertCustomOperation(opName, opArray);
        s = "set op1 dup + -";
        expResult = new String[]{"op1", "dup", "+", "-"};
        result = checkerOp.checkSetOperation(customizedOperations, s);
        Assert.assertArrayEquals(expResult, result);
    }

    /**
    * Test of checkSetOperation method, of class CheckerOperation.
    */
    @Test(expected = NotDefinedNameOperationException.class)
    public void testNotDefinedNameOperationSettingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NotExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkSetOperation -> NotDefinedNameOperationException");
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "set";
        String[] result = checkerOp.checkSetOperation(customizedOperations, s);
    }

    /**
    * Test of checkSetOperation method, of class CheckerOperation.
    */
    @Test(expected = NotDefinedValueOperationException.class)
    public void testNotDefinedValueOperationSettingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NotExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkSetOperation -> NotDefinedValueOperationException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "set test";
        String[] result = checkerOp.checkSetOperation(customizedOperations, s);
    }
    
    /**
    * Test of checkSetOperation method, of class CheckerOperation.
    */
    @Test(expected = NotExistentOperationException.class)
    public void testNotExistentOperationSettingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NotExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkSetOperation -> NotExistentOperationException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "set hypotenuse hyp";
        String[] result = checkerOp.checkSetOperation(customizedOperations, s);
    }

    /**
    * Test of checkSetOperation method, of class CheckerOperation.
    */
    @Test(expected = NotCorrectValueOperationException.class)
    public void testNotCorrectValueOperationSettingOp() throws NotDefinedNameOperationException, NotDefinedValueOperationException, NotExistentOperationException, NotCorrectValueOperationException{
        System.out.println("checkSetOperation -> NotCorrectValueOperationException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "op1";
        String[] opArray = new String[]{"clear", "+2", "+5", "dup"};
        customizedOperations.insertCustomOperation(opName, opArray);
        String s = "set op1 dup + wizard swap";
        String[] result = checkerOp.checkSetOperation(customizedOperations, s);
    }

    /**
    * Test of checkDeleteOperation method, of class CheckerOperation.
    */
    @Test
    public void testCheckDeleteOperationOK() throws NotDefinedNameOperationException, BlankSpaceStringException, NotExistentOperationException{
        System.out.println("checkDeleteOperation -> ok"); 
        String s;
        String result;
        String expResult;
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String opName = "op1";
        String[] opArray = new String[]{"swap"};
        customizedOperations.insertCustomOperation(opName, opArray);
        s = "delete op1";
        expResult = "op1";
        result = checkerOp.checkDeleteOperation(customizedOperations, s);
        assertEquals(expResult, result);
    }

    /**
    * Test of checkDeleteOperation method, of class CheckerOperation.
    */
    @Test(expected = NotDefinedNameOperationException.class)
    public void testNotDefinedNameOperationDeletingOp() throws NotDefinedNameOperationException, BlankSpaceStringException, NotExistentOperationException{
        System.out.println("checkDeleteOperation -> NotDefinedNameOperationException");
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "delete";
        String result = checkerOp.checkDeleteOperation(customizedOperations, s);
    }

    /**
    * Test of checkDeleteOperation method, of class CheckerOperation.
    */
    @Test(expected = BlankSpaceStringException.class)
    public void testBlankSpaceStringDelatingOp() throws NotDefinedNameOperationException, BlankSpaceStringException, NotExistentOperationException{
        System.out.println("checkDeleteOperation -> BlankSpaceStringException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "delete test op1 op2 op3";
        String result = checkerOp.checkDeleteOperation(customizedOperations, s);
    }

    /**
    * Test of checkDeleteOperation method, of class CheckerOperation.
    */
    @Test(expected = NotExistentOperationException.class)
    public void testNotExistentOperationDelatingOp() throws NotDefinedNameOperationException, BlankSpaceStringException, NotExistentOperationException{
        System.out.println("checkDeleteOperation -> NotExistentOperationException"); 
        CustomizedOperationsMap customizedOperations = new CustomizedOperationsMap();
        String s = "delete hypotenuse";
        String result = checkerOp.checkDeleteOperation(customizedOperations, s);
    }

}
