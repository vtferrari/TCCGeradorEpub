package tcc.vinicius.html.busca.tag.simbolo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void testDeveColocarTagPeEmListaDeLinhaDeTexto() {
        ParagrafoMarck transforma = new ParagrafoMarck();
        List<String> ps = new ArrayList<>();
        ps.add("a\n");
        ps.add(" b\n");
        ps.add("c \n");
        assertEquals("<p>a</p>", transforma.converteParaHTML(ps.get(0)));
        assertEquals("<p> b</p>", transforma.converteParaHTML(ps.get(1)));
        assertEquals("<p>c </p>", transforma.converteParaHTML(ps.get(2)));
    }

}
