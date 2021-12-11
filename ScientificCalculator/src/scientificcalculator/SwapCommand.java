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
public class SwapCommand extends ElementsStackCommand{
    
    /**
    * Crea un oggetto della classe ElementsStackCommand, che permette di 
    * effettuare l'operazione di swap sullo stack che gli viene passato.
    * Imposta l'attributo elementsStack.
    * @param    elementsStack   l'istanza di elementsStack su cui il comando 
    *                           opera
    */
    public SwapCommand(ElementsStack elementsStack){
        super(elementsStack);
    }

    /**
    * Esegue l'azione di swap sullo stack.
    * @return   null
    */
    @Override
    public ComplexNumber perform(){
        this.elementsStack.swap();
        return null;
    }
    
}
