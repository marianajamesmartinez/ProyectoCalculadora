/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package proycalc;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

/**
 *
 */
public class FuncionalidadCalculadoraTest {
    
    public FuncionalidadCalculadoraTest() {
    }

    /**
     * Test of parentesis method, of class FuncionalidadCalculadora.
     */
    @Test
    public void testParentesis() {
        System.out.println("parentesis");
        String cad = "(5*10)";
        boolean expResult = true;
        boolean result = FuncionalidadCalculadora.parentesis(cad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of esOperador method, of class FuncionalidadCalculadora.
     */
    @Test
    public void testEsOperador() {
        System.out.println("esOperador");
        Character c = '+';
        boolean expResult = true;
        boolean result = FuncionalidadCalculadora.esOperador(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of operadoresSeguidos method, of class FuncionalidadCalculadora.
     */
    @Test
    public void testOperadoresSeguidos() {
        System.out.println("operadoresSeguidos");
        String cad = "+ +";
        boolean expResult = true;
        boolean result = FuncionalidadCalculadora.operadoresSeguidos(cad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of expresionCorrecta method, of class FuncionalidadCalculadora.
     */
    @Test
    public void testExpresionCorrecta() {
        System.out.println("expresionCorrecta");
        String cad = " 9 + 8 / * 4 ";
        boolean expResult = false;
        boolean result = FuncionalidadCalculadora.expresionCorrecta(cad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of nivelPorOp method, of class FuncionalidadCalculadora.
     */
    @Test
    public void testNivelPorOp() {
        System.out.println("nivelPorOp");
        char c = '*';
        int expResult = 2;
        int result = FuncionalidadCalculadora.nivelPorOp(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of infijaAPostfija method, of class FuncionalidadCalculadora.
     */
    @Test
    public void testInfijaAPostfija() {
        System.out.println("infijaAPostfija");
        String expresion = "( 2 + 3 )";
        String expResult = "2 3 +";
        String result = FuncionalidadCalculadora.infijaAPostfija(expresion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of resolverPosfija method, of class FuncionalidadCalculadora.
     */
    @Test
    public void testResolverPosfija() {
        System.out.println("resolverPosfija");
        String ex = "2 3 +";
        double expResult = 5.0;
        double result = FuncionalidadCalculadora.resolverPosfija(ex);
        assertEquals(expResult, result, 5.0);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of respuestaCalculadora method, of class FuncionalidadCalculadora.
     */
    @Test
    public void testRespuestaCalculadora() {
        System.out.println("respuestaCalculadora");
        String cad = "(2 + 3)";
        String expResult = "5.0";
        String result = FuncionalidadCalculadora.respuestaCalculadora(cad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class FuncionalidadCalculadora.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FuncionalidadCalculadora.main(args);
        // TODO review the generated test code and remove the default call to fail.
    
    }
    
}
