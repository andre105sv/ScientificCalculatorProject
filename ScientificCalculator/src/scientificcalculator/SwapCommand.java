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
    
     /**
    * Crea un oggetto della classe SwapCommand, che permette di effettuare l'operazione di swap sullo stack che gli viene passato.
    * Setta l'attributo stackPrincipale 
    * @param    stackPrincipale    l'istanza di stackPrincipale su cui il comando opera
    */
    public SwapCommand(StackPrincipale stackPrincipale) {
        super(stackPrincipale);
    }
    /**
    * Esegue l'azione di swap sullo stack
    * @return   null
    */
    @Override
    public ComplexNumber perform() {
        this.stackPrincipale.swap();
        return null;
    }
    
}
