package tcc.vinicius.geradorepub.mb;

import java.util.List;
import java.util.UUID;
import nl.siegmann.epublib.domain.Resource;
import org.junit.Test;
import static org.junit.Assert.*;

public class AutoriaMBTest {

    @Test
    public void testGetTituloSemSet() {
        AutoriaMB book = new AutoriaMB();
        assertEquals("", book.getTilulo());
    }

    @Test
    public void testGetTitulo() {
        AutoriaMB book = new AutoriaMB();
        book.setTilulo("titulo");
        assertEquals("titulo", book.getTilulo());
    }

    @Test
    public void testGetNomeDoAutorSemSet() {
        AutoriaMB book = new AutoriaMB();
        assertEquals("", book.getNomeAutor());
    }

    @Test
    public void testGetNomeDoAutor() {
        AutoriaMB book = new AutoriaMB();
        book.setNomeAutor("Vinicius");
        assertEquals("Vinicius", book.getNomeAutor());
    }

    @Test
    public void testGetSobrenomeDoAutorSemSet() {
        AutoriaMB book = new AutoriaMB();
        assertEquals("", book.getSobrenomeAutor());
    }

    @Test
    public void testGetSobrenomeDoAutor() {
        AutoriaMB book = new AutoriaMB();
        book.setSobrenomeAutor("Ferrari");
        assertEquals("Ferrari", book.getSobrenomeAutor());
    }

    @Test
    public void testGetNomeCompletoDoAutorSemSet() {
        AutoriaMB book = new AutoriaMB();
        assertEquals(" ", book.getNomeAutor() + " " + book.getSobrenomeAutor());
    }

    @Test
    public void testGetNomeCompletoDoAutor() {
        AutoriaMB book = new AutoriaMB();
        book.setNomeAutor("Vinicius");
        book.setSobrenomeAutor("Ferrari");
        assertEquals("Vinicius Ferrari", book.getNomeAutor() + " " + book.getSobrenomeAutor());
    }

    @Test
    public void testGetCapituloSemSet() {
        AutoriaMB book = new AutoriaMB();
        List<Resource> capitulo = book.getCaptulos();
        assertEquals(0, capitulo.size());
    }

    @Test
    public void testGetCapitulo() {
        AutoriaMB book = new AutoriaMB();
        book.setCaptulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste</h3></body></html>");
        assertEquals("Vinicius Ferrari", book.getNomeAutor() + " " + book.getSobrenomeAutor());
    }

    @Test
    public void testPublicar() {
        AutoriaMB book = new AutoriaMB();
        book.setTilulo("titulo");
        book.setNomeAutor("Vinicius");
        book.setSobrenomeAutor("Ferrari");
        book.setCaptulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCaptulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCaptulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCaptulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCaptulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCaptulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCaptulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.setCaptulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.publicar();
    }

}
