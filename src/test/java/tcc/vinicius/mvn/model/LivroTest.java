package tcc.vinicius.mvn.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class LivroTest {


    @Test
    public void testSeCriaLivroCorretamente() {
        Livro livro = new Livro();
        livro.setTitulo("TDD");
        assertEquals("TDD", livro.getTitulo());
        livro.setNomeAutor("Vinicius");
        assertEquals("Vinicius", livro.getNomeAutor());
        livro.setSobrenomeAutor("Ferrari");
        assertEquals("Ferrari", livro.getSobrenomeAutor());
        livro.setEditora("TEDEDE");
        assertEquals("TEDEDE", livro.getEditora());
    }

}
