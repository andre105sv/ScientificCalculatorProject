package scientificcalculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anton
 */
public abstract class ElementsStackCommand{

    protected ElementsStack elementsStack;

    /**
    * Costruttore della classe astratta ElementsStackCommand.
    * Imposta l'attributo elementsStack.
    * @param    elemStack   l'istanza di stackPrincipale su cui il comando opera
    */
    public ElementsStackCommand(ElementsStack elemStack){
        this.elementsStack = elemStack;
    }
    
    /**
    * Esegue una certa azione sullo stack.
    * @return   un ComplexNumber o null
    */
    public abstract ComplexNumber perform();

}
