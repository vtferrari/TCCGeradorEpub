package tcc.vinicius.html.busca.tag.simbolo;

import org.junit.Test;
import static org.junit.Assert.*;
import tcc.vinicius.html.superlinguagem.MarckupChain;

public class ParagrafoMarckTest {
    
    public ParagrafoMarckTest() {
    }

    @Test
    public void testDeveColocarTagPeEmCadaNovaLinhaDeTexto() {
        ParagrafoMarck transforma = new ParagrafoMarck();
        String transformado = transforma.converteParaHTML("a");
        assertEquals("<p>a</p>", transformado);
    }
    
}
