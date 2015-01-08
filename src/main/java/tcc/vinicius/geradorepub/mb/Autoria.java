package tcc.vinicius.geradorepub.mb;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;

@ManagedBean
@SessionScoped
public class Autoria {

    private final Book epub;
    private String capitulo;
    private String conteudo;

    public Autoria() {
        this.epub = new Book();
    }

    public void setTitulo(String titulo) {
        epub.getMetadata().addTitle(titulo);
    }

    public String getTitulo() {
        List<String> titles = epub.getMetadata().getTitles();
        if (!titles.isEmpty()) {
            return titles.get(0);
        }
        return "";
    }

    public void setEditora(String editora) {
        epub.getMetadata().addPublisher(editora);
    }

    public String getEditora() {
        List<String> editora = epub.getMetadata().getPublishers();
        if (!editora.isEmpty()) {
            return editora.get(0);
        }
        return "";
    }

    public String getNomeAutor() {
        List<Author> autor = epub.getMetadata().getAuthors();
        if (!autor.isEmpty()) {
            return autor.get(0).getFirstname();
        }
        return "";
    }

    public void setNomeAutor(String nome) {
        List<Author> autor = epub.getMetadata().getAuthors();
        if (!autor.isEmpty()) {
            autor.add(0, new Author(nome, autor.get(0).getLastname()));
        } else {
            autor.add(new Author(nome, null));
        }
    }

    public String getSobrenomeAutor() {
        List<Author> autor = epub.getMetadata().getAuthors();
        if (!autor.isEmpty()) {
            return autor.get(0).getLastname();
        }
        return "";
    }

    public void setSobrenomeAutor(String sobrenome) {
        List<Author> autor = epub.getMetadata().getAuthors();
        if (!autor.isEmpty()) {
            autor.add(0, new Author(autor.get(0).getFirstname(), sobrenome));
        } else {
            autor.add(new Author(null, sobrenome));
        }
    }

    public List<Resource> getCapitulos() {
        return epub.getContents();
    }

    public String continuar() {
        return "editor";
    }

    public void addCapitulo(String html) {
        epub.addSection(capitulo, new Resource(html.getBytes(), "capitulo" + epub.getContents().size() + ".xhtml"));
    }

    public void addCapitulo() {
        addCapitulo(processConteudo());
    }

    private String processConteudo() {

        String html
                = "<?xml version='1.0' encoding='utf-8'?>\n"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "  <head>\n"
                + "    <title>" + capitulo + "</title>\n"
                + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    <div>" + conteudo + "</div>\n"
                + "  </body>"
                + "</html>";
        return html;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void publicar() {
        EBook eBook = new EBook(epub);
        eBook.publicar(this.getNomeAutor() + " " + this.getSobrenomeAutor() + " " + this.getTitulo());
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

}
