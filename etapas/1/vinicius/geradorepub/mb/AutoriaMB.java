package tcc.vinicius.geradorepub.mb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;

@ManagedBean
@SessionScoped
public class AutoriaMB implements Serializable {

    private Book epub;

    public AutoriaMB() {
        epub = new Book();
//        try {
//            epub.setCoverImage(new Resource(Object.class.getResourceAsStream("/cover.png"), "cover.png"));
//            epub.addSection("asd",new Resource("<html><head><title>titulo : Capitulo 1</title></head><body><h3>Teste</h3></body></html>".getBytes(), "cover.xhtml"));
//        } catch (IOException ex) {
//            Logger.getLogger(AutoriaMB.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

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

    public void setCaptulo(String html) {
        epub.addSection("captulo" + epub.getContents().size(), new Resource(html.getBytes(), "captulo" + epub.getContents().size() + ".xhtml"));
    }

    public List<Resource> getCaptulos() {
        return epub.getContents();
    }

    public void publicar() {
        try {
            EpubWriter epubWriter = new EpubWriter();
            epubWriter.write(epub, new FileOutputStream(getTilulo() + " " + getNomeAutor() + " " + getSobrenomeAutor() + ".epub"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AutoriaMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AutoriaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Book getEpub() {
        return epub;
    }
    
    public String editor(){
        return "editor";
    }

}
