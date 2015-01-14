package tcc.vinicius.geradorepub.mb;

import java.util.List;
import nl.siegmann.epublib.domain.Resource;
import org.junit.Test;
import static org.junit.Assert.*;
import tcc.vinicius.geradorepub.model.Capitulo;
import tcc.vinicius.geradorepub.model.Livro;

public class LivroTest {

    @Test
    public void testSetLivro() {
        Livro livro = new Livro();
        livro.setTitulo("Teste de Livro");
        livro.setEditora("testador de livro");
        livro.setNome("Vinicius");
        livro.setSobrenome("Ferrari");

        Capitulo c1 = new Capitulo();
        c1.setTitulo("Capitulo1");
        c1.setConteudo("<html><head><title>Capitulo1</title></head><body></body></html>");
        livro.getCapitulo().add(c1);

        Capitulo c2 = new Capitulo();
        c2.setTitulo("Capitulo1");
        c2.setConteudo("<html><head><title>Capitulo1</title></head><body></body></html>");
        livro.getCapitulo().add(c2);

        Capitulo c3 = new Capitulo();
        c3.setTitulo("Capitulo1");
        c3.setConteudo("<html><head><title>Capitulo1</title></head><body></body></html>");
        livro.getCapitulo().add(c3);

        Capitulo c4 = new Capitulo();
        c4.setTitulo("Capitulo1");
        c4.setConteudo("<html><head><title>Capitulo1</title></head><body></body></html>");
        livro.getCapitulo().add(c4);

        Capitulo c5 = new Capitulo();
        c5.setTitulo("Capitulo1");
        c5.setConteudo("<html><head><title>Capitulo1</title></head><body></body></html>");
        livro.getCapitulo().add(c5);
        
        assertNotNull(livro.getCapitulo());
        assertNotNull(livro.getEditora());
        assertNotNull(livro.getNome());
        assertNotNull(livro.getSobrenome());
        assertNotNull(livro.getTitulo());
        assertNotNull(livro.getCapitulo().get(0));
    }

}
