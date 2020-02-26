package fr.lorraine.univ.tp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel Couroux
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator CA = new Calculator();
        System.out.println(CA.solve("((9+(5+6*9)/4)+(5-9+4/2)-1)*(8*(4+5/9))/(9-(5+6)-(5*2)*3)+(15-(8*(7-5)+3)/1)"));

        //((9+(5+6*9)/4)+(5-9+4/2)-1)*(8*(4+5/9))/(9-(5+6)-(5*2)*3)+(15-(8*(7-5)+3)/1)
        //résultat -27.631944444444443
    }
}