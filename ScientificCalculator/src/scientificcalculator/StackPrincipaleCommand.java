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
public abstract class StackPrincipaleCommand{
    protected StackPrincipale stackPrincipale;
     /**
    * Costruttore della classe astratta StackPrincipaleCommand.
    * Setta l'attributo stackPrincipale 
    * @param    stackPrincipale    l'istanza di stackPrincipale su cui il comando opera
    */
    public StackPrincipaleCommand(StackPrincipale stackPrincipale){
        this.stackPrincipale = stackPrincipale;
    }
    
    /**
    * esegue una certa azione sullo stack
    * @return   un ComplexNumber o null
    */
    public abstract ComplexNumber perform();
}
