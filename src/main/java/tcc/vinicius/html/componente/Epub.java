package tcc.vinicius.html.componente;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Metadata;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;
import tcc.vinicius.mvn.model.Capitulo;

public class Epub {

    private final EpubWriter epubWriter;
    private final Metadata metadata;
    private final Book book;
    private List<Capitulo> tabelaDeConteudo;
    private final String nomeArquivo;
    private static final String PRE_HTML = "<html><header><title>#{Titulo}</title><header/><body>";
    private static final String POS_HTML = "</body></html>";

    public Epub(String nomeArquivo) {
        this.book = new Book();
        this.metadata = book.getMetadata();
        this.epubWriter = new EpubWriter();
        this.nomeArquivo = nomeArquivo;
        this.tabelaDeConteudo = new ArrayList<>();
    }

    public void processarConteudo() throws FileNotFoundException, IOException {
        for (Capitulo toc : tabelaDeConteudo) {
            String conteudoHTML = PRE_HTML.replace("#{Titulo}", toc.getTitulo()) + toc.getConteudo() + POS_HTML;
            this.criarConteudo(toc.getTitulo(), conteudoHTML);
        }
        epubWriter.write(book, new FileOutputStream("C:\\temp\\" + nomeArquivo + ".epub"));
    }

    public void addTitulo(String titulo) {
        metadata.addTitle(titulo);
    }

    public void addAutor(String nome, String sobrenome) {
        metadata.addAuthor(new Author(nome, sobrenome));
    }

    public void addEditora(String editora) {
        metadata.addPublisher(editora);
    }

    public Metadata metaDados() {
        return metadata;
    }

    public void addCapitulos(List<Capitulo> tabelaDeConteudo) {
        this.tabelaDeConteudo = tabelaDeConteudo;
    }

    public void criarConteudo(String titulo, String conteudo) throws IOException {
        Resource resource = new Resource("id" + conteudo.hashCode(),
                conteudo.getBytes(),"teste/"+ titulo + ".html", MediatypeService.XHTML);
        book.getTableOfContents().addSection(resource, titulo);
    }

    public Book getEBook() {
        return book;
    }

}
