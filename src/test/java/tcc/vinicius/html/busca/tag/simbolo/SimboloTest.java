/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.vinicius.html.busca.tag.simbolo;

import java.util.regex.PatternSyntaxException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vinicius
 */
public class SimboloTest {

    public SimboloTest() {
    }

    @Test
    public void testSeConverte__ParaTagU() {
        Simbolo transforma = new Simbolo("__", "u");
        String transformado = transforma.converteParaHTML("__teste__");
        assertEquals("<u>teste</u>", transformado);
    }

    @Test
    public void testSeConverteEcomercialEcomercialParaTagEm() {
        Simbolo transforma = new Simbolo("\\&\\&", "em");
        String transformado = transforma.converteParaHTML("&&teste&&");
        assertEquals("<em>teste</em>", transformado);
    }

    @Test(expected = PatternSyntaxException.class)
    public void testSeLancaExcecaoAsteriscoParaTagStrongSeOsimboloNaoForEscapado() {
        Simbolo transforma = new Simbolo("**", "strong");
        String transformado = transforma.converteParaHTML("*teste*");
        assertEquals("<strong>teste</strong>", transformado);
    }


}
