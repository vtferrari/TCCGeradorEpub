package tcc.vinicius.html.busca.tag.simbolo;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkSimplesMarckTest {

    @Test
    public void testeSeCriaTagslinkComMascara() {
        LinkMascaraMarck edit = new LinkMascaraMarck();
        String transformado = edit.converteParaHTML("[http://www.google.com](Google)");
        assertEquals("<a href=\"http://www.google.com\">Google</a>", transformado);
    }

    @Test
    public void testAdeveSerA() {
        LinkMascaraMarck transforma = new LinkMascaraMarck();
        String transformado = transforma.converteParaHTML("a");
        assertEquals("a", transformado);
    }

}
