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
        assertEquals("", book.getTilulo());
    }

    @Test
    public void testGetTitulo() {
        Autoria book = new Autoria();
        book.setTilulo("titulo");
        assertEquals("titulo", book.getTilulo());
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



}
