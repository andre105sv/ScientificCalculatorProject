/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientificcalculator;

/**
 *
 * @author anton
 */
public class ClearCommand extends StackPrincipaleCommand{

    public ClearCommand(StackPrincipale stackPrincipale) {
        super(stackPrincipale);
    }

    /**
    * Esegue l'azione di clear sullo stack
    * @return   null
    */
    @Override
    public ComplexNumber perform() {
        stackPrincipale.clear();
        return null;
    }
    
}
