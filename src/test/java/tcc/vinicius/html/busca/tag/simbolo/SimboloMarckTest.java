package tcc.vinicius.html.busca.tag.simbolo;

import java.util.regex.PatternSyntaxException;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimboloMarckTest {

    @Test
    public void testSeConverte__ParaTagU() {
        SimboloMarck transforma = new SimboloMarck("__", "u");
        String transformado = transforma.converteParaHTML("__teste__");
        assertEquals("<u>teste</u>", transformado);
    }

    @Test
    public void testSeConverteEcomercialEcomercialParaTagEm() {
        SimboloMarck transforma = new SimboloMarck("\\&\\&", "em");
        String transformado = transforma.converteParaHTML("&&teste&&");
        assertEquals("<em>teste</em>", transformado);
    }

    @Test(expected = PatternSyntaxException.class)
    public void testSeLancaExcecaoAsteriscoParaTagStrongSeOsimboloNaoForEscapado() {
        SimboloMarck transforma = new SimboloMarck("**", "strong");
        String transformado = transforma.converteParaHTML("*teste*");
        assertEquals("<strong>teste</strong>", transformado);
    }

    @Test
    public void testAdeveSerA() {
        SimboloMarck transforma = new SimboloMarck("@", "@");
        String transformado = transforma.converteParaHTML("a");
        assertEquals("a", transformado);
    }

    @Test(expected = PatternSyntaxException.class)
    public void testDeveLansarUmaExececaoSeIniciaOuTerminaEmCaracterDeTexto() {
        SimboloMarck transforma = new SimboloMarck("a", "a");
        String transformado = transforma.converteParaHTML("asa");
        assertEquals("asa", transformado);

    }

}
