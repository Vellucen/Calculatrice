/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analyse;

/**
 *
 * @author Gabriel Couroux
 */
public class Analyse {
    
    /** Analyse une chaîne de caractères
    * @param S, est la chaîne de caractère que l'on analyse
    */
    public void analyse(String S){
        S = suppEspaces(S);
        verifEquation(S);
        verifParenthese(S);
        verifOperations(S);
    }
   
    /** Vérifie si le String n'est pas null ou si il contient un caractère indésirable
    * @param S, est la chaîne de caractère que l'on vérifie
    */
    private void verifEquation(String S) throws ArithmeticException{
        if (S.length() == 0){
            throw new ArithmeticException();
        }
        char caracteres[] = {'0','1','2','3','4','5','6','7','8','9','+','-','*','/','(',')'};
        for (int i = 0; i < S.length();i++){
            int j = 0;
            boolean verif = false;
            while (j < 16 && !verif){
                if (S.charAt(i) == caracteres[j]){
                    verif = true;
                }
                j++;
            }
            if (!verif){
                throw new ArithmeticException();
            }
        }
    }
    
    /** Supprime tous les espaces présent dans une chaîne de caractères
    * @param S, est la chaîne de caractère dont on enlève les espaces
    * @return une autre chaîne de caractères sans aucun espace
    */
    private String suppEspaces(String S){
        return S.replaceAll(" ", "");
    }

    /** Vérifie les règles liées aux parenthèses
    * @param S, est la chaîne de caractère que l'on vérifie
    */
    private void verifParenthese(String S) throws ArithmeticException{
        int nbo = 0;
        int nbf = 0;
        for (int i = 0; i < S.length();i++){
            if (S.charAt(i) == '('){
                nbo++;
                if (i != S.length() - 1){
                    if (S.charAt(i + 1) == ')'){
                        throw new ArithmeticException();
                    }
                }
                if (i != 0){
                    if (!estOperation(S.charAt(i - 1)) && S.charAt(i - 1) != '('){
                        throw new ArithmeticException();
                    }
                }
            }
            if (S.charAt(i) == ')'){
                nbf++;
                if (i != S.length() - 1){
                    if (S.charAt(i + 1) == '('){
                        throw new ArithmeticException();
                    }
                }
                if (i != 0){
                    if (estOperation(S.charAt(i - 1))){
                        throw new ArithmeticException();
                    }
                }
            }
            if (nbf > nbo){
                throw new ArithmeticException();
            }
        }
        if (nbo != nbf){
            throw new ArithmeticException();
        }
    }

    /** Vérifie les règles liées aux opérations
    * @param S, est la chaîne de caractère que l'on vérifie
    */
    private void verifOperations(String S) throws ArithmeticException{
        for (int i = 0; i < S.length();i++){
            if (estOperation(S.charAt(i))){
                if (S.charAt(i) == '*' || S.charAt(i) == '/'){
                    if (i == 0){
                        throw new ArithmeticException();
                    }
                    else{
                        if ((int)S.charAt(i - 1) == 40){
                            throw new ArithmeticException();
                        }
                    }
                }
                if (i != S.length() - 1){
                    if (estOperation(S.charAt(i + 1)) || S.charAt(i + 1) == ')'){
                        throw new ArithmeticException();
                    }
                }
                else{
                    throw new ArithmeticException();
                }
            }
        }
    }

    /** Permet de vérifier si un caractère est bien une oération
    * @param C, est le caractère dont on cherche la nature
    * @return un boolean
    */
    private boolean estOperation(char C){
        char operation[] = {'+','-','*','/'};
        boolean verif = false;
        for (int i = 0; i < operation.length; i++){
            if (C == operation[i]){
                verif = true;
            }
        }
        return verif;
    }
}