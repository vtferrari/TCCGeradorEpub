package tcc.vinicius.html.busca.tag.simbolo;

import org.junit.Test;
import static org.junit.Assert.*;

public class TagAtributadaTest {

    @Test
    public void testSeCriaUmaImagemComSeusAtribusstosInalterados() {
        TagAtributoMarck tagAtributada = new TagAtributoMarck("image", "img");
        String transformado = tagAtributada.converteParaHTML("[image src=\"caminho/qualquer\" alt=\"titulo\"]");
        assertEquals("<img src=\"caminho/qualquer\" alt=\"titulo\" />", transformado);
    }

    @Test
    public void testSeCriaUmaMetaComSeusAtribusstosInalterados() {
        TagAtributoMarck tagAtributada = new TagAtributoMarck("mTag", "meta");
        String transformado = tagAtributada.converteParaHTML("[mTag charset=\"UTF-8\"]");
        assertEquals("<meta charset=\"UTF-8\" />", transformado);
    }

    @Test
    public void testeSeCriaTagslink() {
        Marck transforma = new TagAtributoMarck("link", "link");
        String transformado = transforma.converteParaHTML("[link rel=\"profile\" href=\"http://google.com\"]");
        assertEquals("<link rel=\"profile\" href=\"http://google.com\" />", transformado);
    }
    
    @Test
    public void testeAdeveSerA() {
        Marck transforma = new TagAtributoMarck("link", "link");
        String transformado = transforma.converteParaHTML("a");
        assertEquals("a", transformado);
    }

}
