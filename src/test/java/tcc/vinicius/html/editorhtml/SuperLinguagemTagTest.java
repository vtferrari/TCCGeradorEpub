
package tcc.vinicius.html.editorhtml;

import org.junit.Test;
import static org.junit.Assert.*;
import tcc.vinicius.html.busca.tag.simbolo.BuscaTagSPL;
import tcc.vinicius.html.busca.tag.simbolo.TagAtributada;


public class SuperLinguagemTagTest {
    
     @Test
    public void testeSeCriaTagsMeta() {
        BuscaTagSPL transforma = new TagAtributada("meta", "meta");
        String transformado = transforma.converteParaHTML("[meta charset=\"UTF-8\"]");
        assertEquals("<meta charset=\"UTF-8\" />", transformado);
    }

    @Test
    public void testeSeCriaTagslink() {
        BuscaTagSPL transforma = new TagAtributada("link", "link");
        String transformado = transforma.converteParaHTML("[link rel=\"profile\" href=\"http://google.com\"]");
        assertEquals("<link rel=\"profile\" href=\"http://google.com\" />", transformado);
    }
    
}
