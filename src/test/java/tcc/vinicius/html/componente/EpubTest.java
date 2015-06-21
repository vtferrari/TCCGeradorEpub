package tcc.vinicius.html.componente;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import tcc.vinicius.mvn.model.Capitulo;

public class EpubTest {

    public EpubTest() {
    }

    @After
    public void depois() {
        List<File> files = new ArrayList<>();
        files.add(new File("C:\\temp\\epub.epub"));
        files.add(new File("C:\\temp\\epub.html"));
        files.add(new File("C:\\temp\\nome.epub"));
        files.add(new File("C:\\temp\\nome_1.html"));
        files.add(new File("C:\\temp\\nome_2.html"));
        files.add(new File("C:\\temp\\nome_titulo.html"));
        files.add(new File("C:\\temp\\livro.epub"));
        files.add(new File("C:\\temp\\livro_titulo.html"));
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
            
        }
    }

    @Test
    public void testDeveCriarUmEpubVazio() throws Exception {
        Epub epub = new Epub("epub");
        epub.addCapitulos(new ArrayList<Capitulo>());
        epub.processarConteudo();
        assertTrue(new File("C:\\temp\\epub.epub").exists());
    }

    @Test
    public void testDeveCriarEpubComMetaInformacoes() throws Exception {
        Epub epub = new Epub("nome");
        epub.addTitulo("titulo");
        epub.addAutor("nome", "sobrenome");
        epub.addEditora("editora");
        assertEquals("titulo", epub.metaDados().getTitles().get(0));
        assertEquals("nome", epub.metaDados().getAuthors().get(0).getFirstname());
        assertEquals("sobrenome", epub.metaDados().getAuthors().get(0).getLastname());
        assertEquals("editora", epub.metaDados().getPublishers().get(0));
    }

    @Test
    public void testDeveCriarEbookComConteuDoEseusMetas() throws Exception {
        Epub epub = new Epub("nome");
        epub.criarConteudo("titulo", "<p>conteudo</p>");
        assertFalse(epub.getEBook().getTableOfContents().size() < 1);
        assertEquals(15, epub.getEBook().getTableOfContents().getAllUniqueResources().get(0).getSize());
    }

    @Test
    public void testDeveCriarEbookComConteuDoEseusMetasEUmArquivo() throws Exception {
        Epub epub = new Epub("livro");
        epub.criarConteudo("titulo", "<p>conteudo</p>");
        assertFalse(epub.getEBook().getTableOfContents().size() < 1);
        assertEquals(15, epub.getEBook().getTableOfContents().getAllUniqueResources().get(0).getSize());
        epub.processarConteudo();
        assertTrue(new File("C:\\temp\\livro.epub").exists());
    }
    @Test
    public void testDeveCriarEbookComListaDeConteuDoEseusMetasEUmArquivo() throws Exception {
        ArrayList<Capitulo> toc = new ArrayList<>();
        Capitulo c1 = new Capitulo();
        c1.setTitulo("1");
        c1.setConteudo("<h1>1</h1>");
        Capitulo c2 = new Capitulo();
        c2.setTitulo("2");
        c2.setConteudo("2");
        toc.add(c1);
        toc.add(c2);
        Epub epub = new Epub("nome");
        epub.addTitulo("titulo");
        epub.addAutor("nome", "sobrenome");
        epub.addEditora("editora");
        epub.addCapitulos(toc);
        epub.processarConteudo();
        assertEquals(2,epub.getEBook().getTableOfContents().size());
        String str = new String(epub.getEBook().getTableOfContents().getTocReferences().get(0).getResource().getData(), "UTF-8");
        assertEquals("<html><header><title>1</title><header/><body><h1>1</h1></body></html>",str);
        assertTrue(new File("C:\\temp\\nome.epub").exists());
    }

}
