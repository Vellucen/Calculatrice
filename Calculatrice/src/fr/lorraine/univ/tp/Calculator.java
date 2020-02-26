/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.lorraine.univ.tp;

import Analyse.Analyse;
import Transformation.Constructeur;

/**
 *
 * @author Gabriel Couroux
 */
public class Calculator {
    
    /** Résoud l'équation passée en paramètre
    * @param equation, équation mathématique sous forme d'un String
    * @return la solution de l'équation soula forme d'un double
    */
    public double solve(String equation){
        Analyse A = new Analyse();
        A.analyse(equation);
        Constructeur C = new Constructeur(equation);
        return C.getLisible().interpreter();
    }
}