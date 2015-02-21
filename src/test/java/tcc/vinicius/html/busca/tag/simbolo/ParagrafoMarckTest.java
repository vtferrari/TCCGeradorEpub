package tcc.vinicius.html.busca.tag.simbolo;

import org.junit.Test;
import static org.junit.Assert.*;
import tcc.vinicius.html.superlinguagem.MarckupChain;

public class ParagrafoMarckTest {
    
    public ParagrafoMarckTest() {
    }
    
    @Test
    public void testAdeveSerA() {
        ParagrafoMarck transforma = new ParagrafoMarck();
        String transformado = transforma.converteParaHTML("a");
        assertEquals("<p>a", transformado);
    }

    @Test
    public void testDeveColocarTagPeEmUmaLinhaDeTexto() {
        ParagrafoMarck transforma = new ParagrafoMarck();
        String transformado = transforma.converteParaHTML("a\n");
        assertEquals("<p>a</p>", transformado);
    }
    @Test
    public void testDeveColocarTagPeEmCadaNovaLinhaDeTexto() {
        ParagrafoMarck transforma = new ParagrafoMarck();
        String transformado = transforma.converteParaHTML("a\nb\nc\nd\n");
        assertEquals("<p>a</p><p>b</p><p>c</p><p>d</p>", transformado);
    }
    
}
