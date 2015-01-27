package tcc.vinicius.geradorepub.mb;

import java.util.List;
import java.util.UUID;
import nl.siegmann.epublib.domain.Resource;
import org.junit.Test;
import static org.junit.Assert.*;

public class EBookMBTest {

    @Test
    public void testGetTituloSemSet() {
        EBook book = new EBook();
        assertEquals("", book.getTitulo());
    }

    @Test
    public void testGetTitulo() {
        EBook book = new EBook();
        book.setTitulo("titulo");
        assertEquals("titulo", book.getTitulo());
    }
    @Test
    public void testGetEditoraSemSet() {
        EBook book = new EBook();
        assertEquals("", book.getEditora());
    }

    @Test
    public void testGetEditora() {
        EBook book = new EBook();
        book.setEditora("editora");
        assertEquals("editora", book.getEditora());
    }

    @Test
    public void testGetNomeDoAutorSemSet() {
        EBook book = new EBook();
        assertEquals("", book.getNomeAutor());
    }

    @Test
    public void testGetNomeDoAutor() {
        EBook book = new EBook();
        book.setNomeAutor("Vinicius");
        assertEquals("Vinicius", book.getNomeAutor());
    }

    @Test
    public void testGetSobrenomeDoAutorSemSet() {
        EBook book = new EBook();
        assertEquals("", book.getSobrenomeAutor());
    }

    @Test
    public void testGetSobrenomeDoAutor() {
        EBook book = new EBook();
        book.setSobrenomeAutor("Ferrari");
        assertEquals("Ferrari", book.getSobrenomeAutor());
    }

    @Test
    public void testGetNomeCompletoDoAutorSemSet() {
        EBook book = new EBook();
        assertEquals(" ", book.getNomeAutor() + " " + book.getSobrenomeAutor());
    }

    @Test
    public void testGetNomeCompletoDoAutor() {
        EBook book = new EBook();
        book.setNomeAutor("Vinicius");
        book.setSobrenomeAutor("Ferrari");
        assertEquals("Vinicius Ferrari", book.getNomeAutor() + " " + book.getSobrenomeAutor());
    }

     @Test
    public void testGetCapituloSemSet() {
        EBook book = new EBook();
        List<Resource> capitulo = book.getCapitulos();
        assertEquals(0, capitulo.size());
    }

    @Test
    public void testGetCapitulo() {
        EBook book = new EBook();
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste</h3></body></html>");
        assertEquals(1,book.getCapitulos().size());
    }
    @Test
    public void testGetCapituloProcessandoHTML() {
        EBook book = new EBook();
        book.setCapitulo("Capitulo 1");
        book.setConteudo("Existe conteudo 1");
        book.addCapitulo();
        assertEquals(1,book.getCapitulos().size());
        book.publicar("teste");
    }
    
    @Test
    public void testPublicar() {
        EBook book = new EBook();
        book.setTitulo("titulo");
        book.setNomeAutor("Vinicius");
        book.setSobrenomeAutor("Ferrari");
        book.setEditora("VTFerrari");

        book.setCapitulo("capitulo 1");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCapitulo("capitulo 2");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCapitulo("capitulo 3");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCapitulo("capitulo 4");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCapitulo("capitulo 5");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCapitulo("capitulo 6");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCapitulo("capitulo 7");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCapitulo("capitulo 8");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.publicar("teste");
    }


}
