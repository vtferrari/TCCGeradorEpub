package tcc.vinicius.geradorepub.mb;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Resource;

@ManagedBean
@SessionScoped
public class Autoria extends EBook{

    public void setTilulo(String titulo) {
        epub.getMetadata().addTitle(titulo);
    }

    public String getTilulo() {
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

    public void addCapitulo(String html) {
        epub.addSection("captulo" + epub.getContents().size(), new Resource(html.getBytes(), "captulo" + epub.getContents().size() + ".xhtml"));
    }

    public List<Resource> getCapitulos() {
        return epub.getContents();
    }

    public String continuar() {
        return "editor";
    }
}
