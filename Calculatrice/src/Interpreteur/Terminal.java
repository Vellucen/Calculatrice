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
public class Terminal extends Expression {

    /** Constructeur d'une Terminal
     * @param equation, String qui correspond toujours à un ou plusieurs chiffres, uniquement des chiffres
     */
    public Terminal(String equation){
        super(equation);
    }
    
    /** Interprete le String d'une Terminal en Double
    * @return la valeur du String parser en double
    */
    @Override
    public double interpreter() {
        return Double.parseDouble(valeur);
    }
}