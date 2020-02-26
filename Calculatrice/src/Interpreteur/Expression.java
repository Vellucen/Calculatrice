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
public abstract class Expression {
    protected String valeur;
    
    /** Constructeur d'une Expression
     * @param equation, String qui correspond à la valeur de l'expression
     */
    public Expression(String equation){
        valeur = equation;
    }
    
    public abstract double interpreter();
}