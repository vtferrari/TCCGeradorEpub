package tcc.vinicius.mvc.controler;

import org.junit.Test;
import static org.junit.Assert.*;
import tcc.vinicius.mvn.model.Livro;

public class LivroControlerTest {

    @Test
    public void testControleContinuarDevolveUmLink() {
        LivroController livroControler = new LivroController();
        Livro livro = new Livro();
        livro.setTitulo("TDD");
        String link = livroControler.continuar(livro);
        assertEquals("editor.xhtml", link);
    }

    @Test
    public void testControledContinuarVerificaVazioDeveFicarNaMesmaTela() {
        LivroController livroControler = new LivroController();
        Livro livro = new Livro();
        String link = livroControler.continuar(livro);
        assertNull(link);
    }

}
