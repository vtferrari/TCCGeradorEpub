package tcc.vinicius.geradorepub.mb;

import java.util.List;
import java.util.UUID;
import nl.siegmann.epublib.domain.Resource;
import org.junit.Test;
import static org.junit.Assert.*;

public class AutoriaMBTest {

    @Test
    public void testGetTituloSemSet() {
        Autoria book = new Autoria();
        assertEquals("", book.getTitulo());
    }

    @Test
    public void testGetTitulo() {
        Autoria book = new Autoria();
        book.setTitulo("titulo");
        assertEquals("titulo", book.getTitulo());
    }
    @Test
    public void testGetEditoraSemSet() {
        Autoria book = new Autoria();
        assertEquals("", book.getEditora());
    }

    @Test
    public void testGetEditora() {
        Autoria book = new Autoria();
        book.setEditora("editora");
        assertEquals("editora", book.getEditora());
    }

    @Test
    public void testGetNomeDoAutorSemSet() {
        Autoria book = new Autoria();
        assertEquals("", book.getNomeAutor());
    }

    @Test
    public void testGetNomeDoAutor() {
        Autoria book = new Autoria();
        book.setNomeAutor("Vinicius");
        assertEquals("Vinicius", book.getNomeAutor());
    }

    @Test
    public void testGetSobrenomeDoAutorSemSet() {
        Autoria book = new Autoria();
        assertEquals("", book.getSobrenomeAutor());
    }

    @Test
    public void testGetSobrenomeDoAutor() {
        Autoria book = new Autoria();
        book.setSobrenomeAutor("Ferrari");
        assertEquals("Ferrari", book.getSobrenomeAutor());
    }

    @Test
    public void testGetNomeCompletoDoAutorSemSet() {
        Autoria book = new Autoria();
        assertEquals(" ", book.getNomeAutor() + " " + book.getSobrenomeAutor());
    }

    @Test
    public void testGetNomeCompletoDoAutor() {
        Autoria book = new Autoria();
        book.setNomeAutor("Vinicius");
        book.setSobrenomeAutor("Ferrari");
        assertEquals("Vinicius Ferrari", book.getNomeAutor() + " " + book.getSobrenomeAutor());
    }

     @Test
    public void testGetCapituloSemSet() {
        Autoria book = new Autoria();
        List<Resource> capitulo = book.getCapitulos();
        assertEquals(0, capitulo.size());
    }

    @Test
    public void testGetCapitulo() {
        Autoria book = new Autoria();
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste</h3></body></html>");
        assertEquals(1,book.getCapitulos().size());
    }
    @Test
    public void testGetCapituloProcessandoHTML() {
        Autoria book = new Autoria();
        book.setCapitulo("Capitulo 1");
        book.setConteudo("Existe conteudo 1");
        book.addCapitulo();
        assertEquals(1,book.getCapitulos().size());
        book.publicar();
    }
    
    @Test
    public void testPublicar() {
        Autoria book = new Autoria();
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
        book.publicar();
    }


}
