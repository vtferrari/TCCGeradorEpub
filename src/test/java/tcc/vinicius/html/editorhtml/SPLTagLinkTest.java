package tcc.vinicius.html.editorhtml;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import tcc.vinicius.html.busca.tag.simbolo.BuscaTagSPL;
import tcc.vinicius.html.busca.tag.simbolo.LinkMascara;
import tcc.vinicius.html.busca.tag.simbolo.LinkSimples;

public class SPLTagLinkTest {

    @Test
    public void testeSeCriaTagslink() {
        BuscaTagSPL transforma = new LinkSimples();
        String transformado = transforma.converteParaHTML("http://www.google.com");
        assertEquals("<a href=\"http://www.google.com\">http://www.google.com</a>", transformado);
    }

    @Test
    public void testeSeCriaTagslinkSeguro() {
        BuscaTagSPL transforma = new LinkSimples();
        String transformado = transforma.converteParaHTML("https://www.google.com");
        assertEquals("<a href=\"https://www.google.com\">https://www.google.com</a>", transformado);
    }

    @Test
    public void testeSeCriaTagslinkFTP() {
        BuscaTagSPL transforma = new LinkSimples();
        String transformado = transforma.converteParaHTML("ftp://www.google.com");
        assertEquals("<a href=\"ftp://www.google.com\">ftp://www.google.com</a>", transformado);
    }

    @Test
    public void testeSeCriaTagslinkComMascara() {
        BuscaTagSPL edit = new LinkMascara();
        String transformado = edit.converteParaHTML("[http://www.google.com](Google)");
        assertEquals("<a href=\"http://www.google.com\">Google</a>", transformado);
    }
}
