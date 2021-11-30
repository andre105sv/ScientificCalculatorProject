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
public class OverCommand extends StackPrincipaleCommand{

    public OverCommand(StackPrincipale stackPrincipale) {
        super(stackPrincipale);
    }
    /**
    * Esegue l'azione di over sullo stack
    * @return   null
    */
    @Override
    public ComplexNumber perform() {
        this.stackPrincipale.Over();
        return null;
    }
    
}
