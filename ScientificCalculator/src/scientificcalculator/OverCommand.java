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
public class OverCommand extends ElementsStackCommand{
    
    /**
    * Crea un oggetto della classe OverCommand, che permette di effettuare 
    * l'operazione di over sullo stack che gli viene passato.
    * Imposta l'attributo elementsStack.
    * @param    elementsStack   l'istanza di ElementsStack su cui il comando 
    *                           opera
    */
    public OverCommand(ElementsStack elementsStack){
        super(elementsStack);
    }

    /**
    * Esegue l'azione di over sullo stack.
    * @return   null
    */
    @Override
    public ComplexNumber perform(){
        this.elementsStack.over();
        return null;
    }
    
}
