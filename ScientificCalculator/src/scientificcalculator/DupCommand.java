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
public class DupCommand extends ElementsStackCommand{

    /**
    * Crea un oggetto della classe DupCommand, che permette di effettuare 
    * l'operazione di dup sullo stack che gli viene passato.
    * Imposta l'attributo elementsStack. 
    * @param    elementsStack   l'istanza di elementsStack su cui il comando 
    *                           opera
    */
    public DupCommand(ElementsStack elementsStack){
        super(elementsStack);
    }

    /**
    * Esegue l'azione di dup sullo stack.
    * @return   null
    */
    @Override
    public ComplexNumber perform(){
        elementsStack.dup();
        return null;
    }
    
}
