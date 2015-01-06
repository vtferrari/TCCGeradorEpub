package tcc.vinicius.geradorepub.mb;

import java.util.List;
import nl.siegmann.epublib.domain.Resource;
import org.junit.Test;
import static org.junit.Assert.*;

public class CapituloTest {
    
    public CapituloTest() {
    }

    @Test
    public void testGetCapituloSemSet() {
        Capitulo book = new Capitulo();
        List<Resource> capitulo = book.getCapitulos();
        assertEquals(0, capitulo.size());
    }

    @Test
    public void testGetCapitulo() {
        Capitulo book = new Capitulo();
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste</h3></body></html>");
        assertEquals(1,book.getCapitulos().size());
    }
    @Test
    public void testGetCapituloProcessandoHTML() {
        Capitulo book = new Capitulo();
        book.setTitulo("capitulo 1");
        book.setConteudo("Existe conteudo 1");
        book.addCapitulo();
        assertEquals(1,book.getCapitulos().size());
        book.publicar("capitulo 1");
    }

    
}
