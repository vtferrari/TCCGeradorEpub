package tcc.vinicius.html.busca.tag.simbolo;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListaMarckTest {

    @Test
    public void testeSeConverterTagFalsaUParaViniciusTagHTMLU() {
        ListaMarck transforma = new ListaMarck();
        assertEquals("<ul><li>Item 1</li><li>Item 2</li><li>Item 3</li></ul>", transforma.converteParaHTML("* Item 1 * Item 2 * Item 3"));
    }
    @Test
    public void testeSeConverterTagFalsaUParaViniciusTagHTMLUComQuebraDeLinha() {
        ListaMarck transforma = new ListaMarck();
        assertEquals("conteudo\n<ul><li>Item 1</li><li>Item 2</li><li>Item 3</li></ul>\nconteudo", transforma.converteParaHTML("conteudo\n* Item 1 * Item 2 * Item 3\nconteudo"));
    }
    
    @Test
    public void testeADeveSerA() {
        ListaMarck transforma = new ListaMarck();
        assertEquals("a", transforma.converteParaHTML("a"));
    }

}
