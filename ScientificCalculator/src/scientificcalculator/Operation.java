/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scientificcalculator;

import exceptions.DivisionByZeroException;
import exceptions.NotDefinedArgumentException;

/**
 *
 * @author Andrea
 */
public interface Operation{

    public ComplexNumber[] execute() throws DivisionByZeroException, NotDefinedArgumentException;

}
