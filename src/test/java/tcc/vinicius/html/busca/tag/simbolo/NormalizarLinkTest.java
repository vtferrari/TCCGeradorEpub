package tcc.vinicius.html.busca.tag.simbolo;

import org.junit.Test;
import static org.junit.Assert.*;

public class NormalizarLinkTest {

    public NormalizarLinkTest() {
    }

    @Test
    public void testSeConsegueNormalizarLinksComTagsI() {
        String normalizar = "<a href=\"http:<i>site.com/site\" />";
        NormalizarLinkMarck transforma = new NormalizarLinkMarck();
        assertEquals("<a href=\"http://site.com/site\" />", transforma.converteParaHTML(normalizar));
    }
    
    @Test
    public void testSeConsegueNormalizarLinksComTagDiferente() {
        String normalizar = "<a href=\"http:<strong>site.com/site\" />";
        NormalizarLinkMarck transforma = new NormalizarLinkMarck();
        assertEquals("<a href=\"http://site.com/site\" />", transforma.converteParaHTML(normalizar));
    }
    @Test
    public void testNaoDeConseguerNormalizarTagDiferenteDeLink() {
        String normalizar = "<a></a>";
        NormalizarLinkMarck transforma = new NormalizarLinkMarck();
        assertEquals("<a></a>", transforma.converteParaHTML(normalizar));
    }

}
