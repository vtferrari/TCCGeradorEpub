package tcc.vinicius.mvc.controler;

import org.junit.Test;
import static org.junit.Assert.*;
import tcc.vinicius.mvn.model.Livro;

public class LivroControlerTest {
    

    @Test
    public void testControleDeveValidarDadosIniciaisDoLivroEntaoRetornarLink() {
        LivroControler livroControler = new LivroControler();
        String link = livroControler.continuar(new Livro());
        assertEquals("editor.xhtml", link);
    }
    
}
