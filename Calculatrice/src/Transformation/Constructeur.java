/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transformation;

import Interpreteur.Expression;
import Interpreteur.Terminal;
import Interpreteur.NonTerminal;

/**
 *
 * @author Gabriel Couroux
 */
public class Constructeur {
    private Expression Lisible;

    /** Constructeur d'un objet Constructeur
     * @param equation, String de l'équation que l'on transforme grâce à Constructeur
     */
    public Constructeur(String equation) {
        Lisible = Construction(equation);
    }
    
    /** Construction de l'attribut Lisible de Constructeur
    * @param equation, String de l'équation que l'on transforme grâce à Constructeur
    * @return une Expression contenant toute l'équation et respectant les priorités lors de son interprétation
    */
    private Expression Construction(String equation){
        while(equation.charAt(0) == '(' && passerParentheses(equation, 0, true) == equation.length() - 1){
            equation = equation.substring(1, equation.length() - 1);
        }
        if (queDesChiffres(equation)){
            return new Terminal(equation);
        }
        int i = operationLaMoinsImpotante(equation);
        if (i == 0){
            return new NonTerminal(equation.substring(i, i + 1), Construction("0"), Construction(equation.substring(i + 1)));
        }
        return new NonTerminal(equation.substring(i, i + 1), Construction(equation.substring(0, i)), Construction(equation.substring(i + 1)));   
    }

    /** Vérifie si une chaîne de caractères ne contient que des chiffres
    * @param equation, String corespondant à un morceau de l'équation que l'on transforme grâce à Constructeur
    * @return un boolean
    */
    private boolean queDesChiffres(String equation) {
        char caracteres[] = {'0','1','2','3','4','5','6','7','8','9'};
        boolean verifEquation = true;
        int i = 0;
        while (i < equation.length() && verifEquation){
            boolean verifCaractere = false;
            int j = 0;
            while (j < 10 && !verifCaractere){
                if (equation.charAt(i) == caracteres[j]){
                    verifCaractere = true;
                }
                j++;
            }
            if (!verifCaractere){
                verifEquation = false;
            }
            i++;
        }
        return verifEquation;
    }
    
    /** Permet de sauter le contenu d'une parenthèse
    * @param equation, String corespondant à un morceau de l'équation que l'on transforme grâce à Constructeur
    * @param debutParenthese, indice de la parenthèse ouvrante dont on cherche la parenthèse fermante
    * @param sens, vrai pour une recherche de gauche à droite, faux pour une recherche dans l'autre sens
    * @return l'indice de la parenthèse fermant
    */
    private int passerParentheses(String equation, int debutParenthese, boolean sens){
        int compteur;
        if (sens){
            compteur = 1;
        }
        else{
            compteur = -1;
        }
        while(compteur != 0){
            if (sens){
                debutParenthese++;
            }
            else{
                debutParenthese--;
            }
            if (equation.charAt(debutParenthese) == '('){
                compteur++;
            }
            if (equation.charAt(debutParenthese) == ')'){
                compteur--;
            }
        }
        return debutParenthese;
    }
    
    /** Trouve l'opération la moins important dans l'équation
    * @param equation, String corespondant à un morceau de l'équation que l'on transforme grâce à Constructeur
    * @return l'indice de l'opération la moins importante de l'équation
    */
    private int operationLaMoinsImpotante(String equation){
        int i = 0;
        int j = 0;
        char C[] = {'+','-','*','/'};
        boolean trouver = false;
        while(!trouver){
            if (i != 1){
                j = 0;
                while(!trouver && j < equation.length()){
                    if (equation.charAt(j) == '('){
                        j = passerParentheses(equation, j, true);
                    }
                    if(equation.charAt(j) == C[i]){
                        trouver = true;
                    }
                    j++;
                }
            }
            else{
                j = equation.length() - 1;
                while(!trouver && j >= 0){
                    if (equation.charAt(j) == ')'){
                        j = passerParentheses(equation, j, false);
                    }
                    if(equation.charAt(j) == C[i]){
                        trouver = true;
                    }
                    j--;
                }
            }
            i++;
        }
        if (i - 1 == 1){
            return j + 1;
        }
        return j - 1;
    }

    /** Accesseur de Lisible
    * @return Lisible
    */
    public Expression getLisible() {
        return Lisible;
    }
}