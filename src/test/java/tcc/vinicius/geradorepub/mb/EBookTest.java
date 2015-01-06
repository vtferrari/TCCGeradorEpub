package tcc.vinicius.geradorepub.mb;

import java.util.UUID;
import nl.siegmann.epublib.domain.Book;
import org.junit.Test;
import static org.junit.Assert.*;

public class EBookTest {

    @Test
    public void testPublicar() {
        Autoria book = new Autoria();
        book.setTilulo("titulo");
        book.setNomeAutor("Vinicius");
        book.setSobrenomeAutor("Ferrari");
        book.setEditora("VTFerrari");

        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.addCapitulo("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste" + UUID.randomUUID() + "</h3></body></html>");
        book.publicar("titulo Vinicius Ferrari");
    }

}
