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
public class DropCommand extends ElementsStackCommand{

    /**
    * Crea un oggetto della classe DropCommand, che permette di effettuare 
    * l'operazione di drop sullo stack che gli viene passato.
    * Imposta l'attributo elementsStack.
    * @param    elementsStack   l'istanza di ElementsStack su cui il comando 
    *                           opera
    */
    public DropCommand(ElementsStack elementsStack){
        super(elementsStack);
    }

    /**
    * Esegue l'azione di drop sullo stack.
    * @return   un ComplexNumber
    */
    @Override
    public ComplexNumber perform(){
        return elementsStack.removeLastNumber();
    }
    
}
