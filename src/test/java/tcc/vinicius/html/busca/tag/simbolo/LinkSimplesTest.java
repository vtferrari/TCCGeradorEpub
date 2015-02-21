package tcc.vinicius.html.busca.tag.simbolo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import tcc.vinicius.html.busca.tag.simbolo.Marck;
import tcc.vinicius.html.busca.tag.simbolo.LinkMascaraMarck;
import tcc.vinicius.html.busca.tag.simbolo.LinkSimplesMarck;

public class LinkSimplesTest {

    @Test
    public void testeSeCriaTagslink() {
        LinkSimplesMarck transforma = new LinkSimplesMarck();
        String transformado = transforma.converteParaHTML("http://www.google.com");
        assertEquals("<a href=\"http://www.google.com\">http://www.google.com</a>", transformado);
    }

    @Test
    public void testeSeCriaTagslinkSeguro() {
        LinkSimplesMarck transforma = new LinkSimplesMarck();
        String transformado = transforma.converteParaHTML("https://www.google.com");
        assertEquals("<a href=\"https://www.google.com\">https://www.google.com</a>", transformado);
    }

    @Test
    public void testeSeCriaTagslinkFTP() {
        LinkSimplesMarck transforma = new LinkSimplesMarck();
        String transformado = transforma.converteParaHTML("ftp://www.google.com");
        assertEquals("<a href=\"ftp://www.google.com\">ftp://www.google.com</a>", transformado);
    }

    
}
