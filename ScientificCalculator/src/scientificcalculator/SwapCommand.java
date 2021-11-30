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
public class SwapCommand extends StackPrincipaleCommand{

    public SwapCommand(StackPrincipale stackPrincipale) {
        super(stackPrincipale);
    }
    /**
    * Esegue l'azione di swap sullo stack
    * @return   null
    */
    @Override
    public ComplexNumber perform() {
        this.stackPrincipale.Swap();
        return null;
    }
    
}