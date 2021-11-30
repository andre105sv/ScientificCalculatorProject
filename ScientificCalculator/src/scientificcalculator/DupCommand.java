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
public class DupCommand extends StackPrincipaleCommand{

    public DupCommand(StackPrincipale stackPrincipale) {
        super(stackPrincipale);
    }
    /**
    * Esegue l'azione di dup sullo stack
    * @return   null
    */
    @Override
    public ComplexNumber perform() {
        stackPrincipale.Dup();
        return null;
    }
    
}
