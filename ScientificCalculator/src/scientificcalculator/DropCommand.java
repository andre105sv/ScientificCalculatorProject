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
public class DropCommand extends StackPrincipaleCommand{

     /**
    * Crea un oggetto della classe DropCommand, che permette di effettuare l'operazione di drop sullo stack che gli viene passato.
    * Setta l'attributo stackPrincipale 
    * @param    stackPrincipale    l'istanza di stackPrincipale su cui il comando opera
    */
    public DropCommand(StackPrincipale stackPrincipale){
        super(stackPrincipale);
    }

    /**
    * Esegue l'azione di drop sullo stack
    * @return   un ComplexNumber
    */
    @Override
    public ComplexNumber perform(){
        return stackPrincipale.removeLastNumber();
    }
    
}
