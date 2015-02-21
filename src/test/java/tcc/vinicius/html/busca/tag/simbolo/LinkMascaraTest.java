package tcc.vinicius.html.busca.tag.simbolo;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkMascaraTest {

    @Test
    public void testeSeCriaTagslinkComMascara() {
        LinkMascara edit = new LinkMascara();
        String transformado = edit.converteParaHTML("[http://www.google.com](Google)");
        assertEquals("<a href=\"http://www.google.com\">Google</a>", transformado);
    }

}