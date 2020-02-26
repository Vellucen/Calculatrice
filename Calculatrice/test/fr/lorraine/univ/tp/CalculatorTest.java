/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.lorraine.univ.tp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class CalculatorTest {
    
    /**
     * Test of solve method, of class Calculator.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        String equation = "((1+1-4)*(5-8))/2";
        Calculator CalTest = new Calculator();
        double expResult = 3.0;
        double result = CalTest.solve(equation);
        assertEquals(expResult, result, 0.0);
    }
}
