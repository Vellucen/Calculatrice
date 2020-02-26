/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interpreteur;

/**
 *
 * @author Gabriel Couroux
 */
public class NonTerminal extends Expression {
    private Expression FG;
    private Expression FD;

    /** Constructeur d'une NonTerminal
     * @param equation, String qui correspond toujours à une opération +, -, * ou /
     * @param FG, Expression qui correspond au fils gauche de NonTerminal
     * @param FD, Expression qui correspond au fils droit de NonTerminal
     */
    public NonTerminal(String equation, Expression FG, Expression FD) {
        super(equation);
        this.FG = FG;
        this.FD = FD;
    }
    
    /** Interprete le String d'une NonTerminal en Double
    * @return l'interpretation en double de NonTerminal
    */
    @Override
    public double interpreter() {
        if (valeur.equals("+")){
            return FG.interpreter() + FD.interpreter();
        }
        if (valeur.equals("-")){
            return FG.interpreter() - FD.interpreter();
        }
        if (valeur.equals("*")){
            return FG.interpreter() * FD.interpreter();
        }
        return FG.interpreter() / FD.interpreter();
    }
}
