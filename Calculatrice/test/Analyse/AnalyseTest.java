/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analyse;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class AnalyseTest {

    /**
     * Test of analyse method, of class Analyse.
     */
    @Test
    public void testAnalyse() {
        System.out.println("analyse");
        try{
            String STest = "((1+1-4)*(5-8))/2";
            Analyse anaTest = new Analyse();
            anaTest.analyse(STest);
        }
        catch (ArithmeticException e){
            fail("ArithmeticException");
        }
    }
}
